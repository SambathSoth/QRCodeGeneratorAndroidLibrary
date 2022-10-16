package com.example.qrcodescannerandgenerator;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.generateqrcodelibrary.QRCode;

public class MainActivity extends AppCompatActivity {

    // variables for imageview, edittext,
    // button, bitmap
    private ImageView qrCodeIV;
    private EditText dataEdt;
    private Button generateQrBtn;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all variables.
        qrCodeIV = findViewById(R.id.idIVQrcode);
        dataEdt = findViewById(R.id.idEdt);
        generateQrBtn = findViewById(R.id.idBtnGenerateQR);

        // initializing onclick listener for button.
        generateQrBtn.setOnClickListener(v -> {
            if (TextUtils.isEmpty(dataEdt.getText().toString())) {

                // if the edittext inputs are empty then execute
                // this method showing a toast message.
                Toast.makeText(MainActivity.this, "Enter some text to generate QR Code", Toast.LENGTH_SHORT).show();
            } else {
                // getting our qrcode in the form of bitmap.
                bitmap = QRCode.generateQRCode(dataEdt.getText().toString());
                // the bitmap is set inside our image
                // view using .setImageBitmap method.
                qrCodeIV.setImageBitmap(bitmap);
            }
        });
    }
}
