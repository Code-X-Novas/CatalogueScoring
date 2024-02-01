package com.example.cataloguescoring;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.provider.MediaStore;


import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class uploadimg extends AppCompatActivity {

    private static int Request_img_cap = 1;
    private static int Request_img_pick = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_uploadimg);

        Button btnUpload = findViewById(R.id.btnUp);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileInput();


            }
        });

    }

    private void openFileInput() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, Request_img_pick);

    }

    protected void onActivityRes(int requestCode, int Resultcode, @Nullable Intent data) {
        super.onActivityResult(requestCode,Resultcode,data);

        if (Resultcode == RESULT_OK) {
            if (requestCode == Request_img_pick) {
                Bitmap selectedImage = getSelectedImage(data);
                // Display the selected image in the ImageView

                // Now, you can send this image for OCR processing
                performOcr(selectedImage);
            }
        }

    }

    private void performOcr(Bitmap selectedImage) {
        String ocrResult = OCRHelper.performOcr(selectedImage, "eng");

        sendOCRResulttobeckend(ocrResult);



    }

    private void sendOCRResulttobeckend(String ocrResult) {


    }


    private Bitmap getSelectedImage(Intent data) {
        Uri selectedImageUri = data.getData();
        try {
            // Use content resolver to get Bitmap from Uri
            return MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }







    }
}



