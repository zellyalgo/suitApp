package com.zellyalgo.suitapp.controllers;

import android.net.Uri;
import android.os.Environment;

import java.io.File;

/**
 * Created by zellyalgo on 29/1/16.
 */
public class FileAccess {

    private static final String APP_FILE = "SuitApp";

    public Uri getUriAppOfAFile(String fileName){
        File externalFile = getDirectory();
        File directory = new File(externalFile.getAbsolutePath(), fileName);
        return Uri.fromFile(directory);
    }

    public File getDirectory(){
        File externalFile = new File(Environment.getExternalStorageDirectory(), APP_FILE);
        externalFile.mkdir();
        return externalFile;
    }

}
