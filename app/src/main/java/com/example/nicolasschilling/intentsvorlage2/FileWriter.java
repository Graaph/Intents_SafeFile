package com.example.nicolasschilling.intentsvorlage2;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.content.ContentValues.TAG;

/**
 * Created by nicolasschilling on 28.12.17.
 */

public class FileWriter {
    final static String fileName ="file1.txt";
    final static String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/directory";



    public static boolean saveFile(String filedata){
try{
    new File(path).mkdir();
    File file = new File (path+fileName);
    if(!file.exists())
    {
        file.createNewFile();
    }
    FileOutputStream fileOutputStream = new FileOutputStream(file, true);
    fileOutputStream.write((filedata+System.getProperty("line.seperator")).getBytes());
    return true;
    }catch (FileNotFoundException ex) {
    Log.d(TAG, ex.getMessage());
} catch (IOException ex){
    Log.d(TAG, ex.getMessage());
}
return false;
    }
}
