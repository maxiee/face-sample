package com.example.maxiee.face_sample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.maxiee.face_sample.api.DetectionApi;
import com.example.maxiee.face_sample.model.Face;
import com.example.maxiee.face_sample.model.FaceInfo;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.RequestBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_IMAGE = 1127;
    private static final int IMAGE_WIDTH = 480;
    private static final int IMAGE_HEIGHT = 640;

    private static final String BASE_URL = "http://apicn.faceplusplus.com";
    private static final String KEY = "bfa8a398fd3ad8ef1078e1ee83d97dea";
    private static final String SECRET = "uo-FHaVvXfmIIQqngpWw8fSnmeyw2lNV";

    private static final String MALE = "♂";
    private static final String FEMALE = "♀";

    private TextView mEmptyText;
    private ImageView mFaceImage;
    private Bitmap mFaceBitmap;

    private DetectionApi mDectectionApi;

    private Paint mTextPaint;
    private Paint mRectPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEmptyText = (TextView) findViewById(R.id.text_empty);
        mFaceImage = (ImageView) findViewById(R.id.image);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mDectectionApi = retrofit.create(DetectionApi.class);

        mRectPaint = new Paint();
        mRectPaint.setAntiAlias(true);
        mRectPaint.setStyle(Paint.Style.STROKE);
        mRectPaint.setColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
        mRectPaint.setStrokeWidth(3f);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
        mTextPaint.setStrokeWidth(1f);
        mTextPaint.setTextSize(getResources().getDimension(R.dimen.image_text_size));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.add_image) {
            addImage();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addImage() {
        if (Build.VERSION.SDK_INT < 19) {
            Intent i = new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(
                    Intent.createChooser(i, getString(R.string.add_image)),
                    ADD_IMAGE);
        } else {
            Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType("image/*");
            startActivityForResult(
                    Intent.createChooser(i, getString(R.string.add_image)),
                    ADD_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_IMAGE && resultCode == RESULT_OK) {
            mEmptyText.setVisibility(View.GONE);
            mFaceImage.setVisibility(View.VISIBLE);
            new FaceDetectTask().execute(data.getData());
        }
    }

    private class FaceDetectTask extends AsyncTask<Uri, Void, FaceInfo> {
        private ProgressDialog mProgressDialog;

        @Override
        protected void onPreExecute() {
            mProgressDialog = new ProgressDialog(MainActivity.this, R.style.AppTheme_Dialog);
            mProgressDialog.setMessage(getString(R.string.detecting));
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected FaceInfo doInBackground(Uri... params) {
            Uri uri = params[0];
            try {
                mFaceBitmap = Glide.with(MainActivity.this)
                        .load(uri)
                        .asBitmap()
                        .into(IMAGE_WIDTH, IMAGE_HEIGHT)
                        .get();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                mFaceBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                RequestBody requestBody = new MultipartBuilder()
                        .type(MultipartBuilder.FORM)
                        .addPart(
                                Headers.of("Content-Disposition", "form-data; name=\"img\"; filename=\"noname\""),
                                RequestBody.create(MediaType.parse("application/octet-stream;"), stream.toByteArray())
                        )
                        .addPart(
                                Headers.of("Content-Disposition", "form-data; name=\"api_key\""),
                                RequestBody.create(MediaType.parse("text/plain; charset=US-ASCII"), KEY))
                        .addPart(
                                Headers.of("Content-Disposition", "form-data; name=\"api_secret\""),
                                RequestBody.create(MediaType.parse("text/plain; charset=US-ASCII"), SECRET))
                        .build();
                Call<FaceInfo> call = mDectectionApi.detect(requestBody);
                return call.execute().body();
            } catch (ExecutionException | InterruptedException | IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(FaceInfo faceInfo) {
            mProgressDialog.cancel();
            if (faceInfo == null) {
                buildDialog(getString(R.string.error_network));
                showEmptyLayout();
            } else if (faceInfo.getFace().isEmpty()) {
                buildDialog(getString(R.string.error_detection));
                showEmptyLayout();
            } else if (mFaceBitmap == null) {
                buildDialog(getString(R.string.error_image));
                showEmptyLayout();
            } else {
                Face face = faceInfo.getFace().get(0);
                float bitmapWidth = mFaceBitmap.getWidth() / 100;
                float bitmapHeight = mFaceBitmap.getHeight() / 100;
                float width = face.getPosition().getWidth().floatValue() * bitmapWidth;
                float height = face.getPosition().getHeight().floatValue() * bitmapHeight;
                float centerX = face.getPosition().getCenter().getX().floatValue() * bitmapWidth;
                float centerY = face.getPosition().getCenter().getY().floatValue() * bitmapHeight;
                String gender = face.getAttribute().getGender().getValue().equals("Male") ? MALE : FEMALE;
                String age = face.getAttribute().getAge().getValue().toString();

                Canvas canvas = new Canvas(mFaceBitmap);
                canvas.drawRect(
                        centerX - width / 2,
                        centerY - height / 2,
                        centerX + width / 2,
                        centerY + height / 2,
                        mRectPaint
                );

                String text = gender + " " + age;
                float textWidth = mTextPaint.measureText(text);
                canvas.drawText(text, centerX - textWidth / 2, centerY - height / 2 - 20, mTextPaint);
                mFaceImage.setImageBitmap(mFaceBitmap);
            }
        }

        private void buildDialog(String message) {
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(MainActivity.this, R.style.AppTheme_Dialog);
            builder.setTitle(getString(R.string.error));
            builder.setMessage(message);
            builder.setPositiveButton(getString(R.string.ok), null);
            builder.show();
        }

        private void showEmptyLayout() {
            mFaceImage.setVisibility(View.GONE);
            mEmptyText.setVisibility(View.VISIBLE);
        }
    }
}
