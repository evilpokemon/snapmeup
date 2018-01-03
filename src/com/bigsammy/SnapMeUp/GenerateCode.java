package com.bigsammy.SnapMeUp;

import com.google.zxing.WriterException; 

//Imports from sample

import com.google.zxing.BarcodeFormat;

import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import android.graphics.Bitmap;
import android.util.Log;

public class GenerateCode {
private static final String LOGTAG = "GenerateCode";
private static final int WHITE = 0xFFFFFFFF;
private static final int BLACK = 0xFF000000;
	
	public static Bitmap encodeQR(int width, int height, String toEncode)
	{
		MultiFormatWriter mfwWriter = new MultiFormatWriter();
        BitMatrix bmResult = new BitMatrix(width,height);
    	
        try{
    	bmResult = mfwWriter.encode(toEncode, BarcodeFormat.QR_CODE, width, height);
        }
        catch(WriterException e)
        {
    		Log.v(LOGTAG, "RESULT:" +e.getMessage() );
        }
    	
        
        int[] pixels = new int[width * height];
        
        // All are 0, or black, by default
        for (int y = 0; y < height; y++) {
          int offset = y * width;
          for (int x = 0; x < width; x++) {
            pixels[offset + x] = bmResult.get(x, y) ? BLACK : WHITE;
          }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        
        return bitmap;
		
	}
	
}
