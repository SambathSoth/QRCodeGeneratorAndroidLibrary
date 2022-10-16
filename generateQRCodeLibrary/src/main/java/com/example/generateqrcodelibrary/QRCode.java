package com.example.generateqrcodelibrary;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRCode {
    public static Bitmap generateQRCode(String text){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Bitmap bitmap;

        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 400, 400);

            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            // getting our qrcode in the form of bitmap.
            bitmap = barcodeEncoder.createBitmap(bitMatrix);
            // return the bitmap that is set inside our image
            return bitmap;

        } catch (WriterException e) {
            // this method is called for
            // exception handling.
            Log.e("Tag", e.toString());
        }
        return null;
    }
}
