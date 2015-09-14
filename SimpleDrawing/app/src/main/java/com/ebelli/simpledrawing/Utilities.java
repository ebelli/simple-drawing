package com.ebelli.simpledrawing;

import android.os.Environment;

import java.io.File;

/**
 * Created by ebelli on 10/09/15.
 */
public class Utilities {
    public static final String STORAGE_DIR = "SimpleDrawing";

    public static String getStorageDir() {
        return STORAGE_DIR;
    }



    public static String getPath(){
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES),STORAGE_DIR);
        return file.getAbsolutePath();
    }

   public static File getDir(){
        return new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES),STORAGE_DIR);
    }
}
