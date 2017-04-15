package com.example.hp.main.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hp.main.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Form extends AppCompatActivity implements Validator.ValidationListener {

    private static final int IMAGE_CAPTURE = 101;
    private static final String TAG = Form.class.getSimpleName();
    private static Uri mImageUri;
    private static String mCurrentPhotoPath;
    @BindView(R.id.user_name)
    EditText userName;
    @NotEmpty
    @Email
    @BindView(R.id.user_email)
    EditText userEmail;
    @BindView(R.id.user_phone_number)
    EditText userPhoneNumber;
    @BindView(R.id.user_button)
    Button userButton;
    Validator validator;
    @BindView(R.id.user_profile_image)
    ImageView userProfileImage;
    @BindView(R.id.user_cgpa)
    EditText userCgpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ButterKnife.bind(this);
        validator = new Validator(this);
        validator.setValidationListener(this);
        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.validate();

            }
        });
        userProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasCamera()){
                    saveImage();
                }
            }
        });

    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "Yay! we got it right!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }

        }
    }

    private boolean hasCamera() {
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }

    private void saveImage() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            //Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                ex.printStackTrace();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = Uri.fromFile(photoFile);
                Log.i(TAG, "Image saved at " + photoURI);
                mImageUri = photoURI;
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, IMAGE_CAPTURE);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("photopath", mCurrentPhotoPath);


        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("photopath")) {
                mCurrentPhotoPath = savedInstanceState.getString("photopath");
            }
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG, "it's getting called");
        if(requestCode == IMAGE_CAPTURE && data!=null){
            if (resultCode == RESULT_OK){
                Toast.makeText(this, "Image saved at "+ mImageUri, Toast.LENGTH_LONG).show();
//                Picasso.with(getApplicationContext()).load(mCurrentPhotoPath).into(imageView);
                userProfileImage = (ImageView)findViewById(R.id.user_profile_image);
                Glide.with(this).load(mCurrentPhotoPath).into(userProfileImage);


            }
            else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Failed to save image", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "Error in saving image", Toast.LENGTH_LONG).show();

            }
        }
    }
}
