package com.example.cataloguescoring;

import android.graphics.Bitmap;
import com.googlecode.tesseract.android.TessBaseAPI;


public class OCRHelper {
    public static String performOcr(Bitmap bitmap, String language){
        TessBaseAPI tessBaseAPI = new TessBaseAPI();
        tessBaseAPI.init("/path/to/tessdata", language);
        tessBaseAPI.setImage(bitmap);

        String result = tessBaseAPI.getUTF8Text();
        tessBaseAPI.end();

        return result;

    }
}
