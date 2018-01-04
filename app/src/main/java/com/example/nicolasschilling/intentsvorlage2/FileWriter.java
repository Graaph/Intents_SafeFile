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
    final static String fileName ="file2.txt";

    //Das problem mit pfaden in java ist das man nie weis wie sie aufhören, ich würde empfehlen nur
    // das "sub_directory" zu speichern und den pfad dann dynamisch (siehe unten) genereieren zu lassen :)
    final static String path = "directory";



    public boolean saveFile(String filedata){

        try{
            //Dynamisch "file" generieren :)
            //new File(path).mkdir();

            //Holen uns ein "File" Object das den Pfad in das directory darstellt, merke man kann ein File auch erstellen mit
            // new File(Pfad_irgendwo_hin, von_dort_dann_hier_hin)... damit lässt sich schön einfach, aber garantiert richtig ein pfad zum anderen "addieren"
            File directory = new File(Environment.getExternalStorageDirectory(), this.path);


            //Jetzt, falls das directory noch nicht da ist selbiges erstellen
            if(!directory.mkdirs()) //achtung s nicht vergessen, sonst erstellt es dir nicht bei bedarf die parent ordner und könnte failen
            {
                //Jetzt ist auf alle fälle da, aber man kann sich ja ne schöne nachricht anzeigen lassen :D
                System.out.println("Created a Directory ...");
            }


            File file = new File (directory, this.fileName);
            //Create File if needed
            try {
                file.createNewFile();
                System.out.println("Created File!");
            }catch (Exception e){
                System.out.println("Failed to create correct file: " + e);
            }




            System.out.println("Opening file stream");
            //Jut... ich weis zwar nicht was drin stehen soll, aber ich denke du willst "filedata" einfach in ne neue Zeile schreiben :D
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            System.out.println("Writing bytes");
            fileOutputStream.write((filedata + "\n").getBytes());
            System.out.println("Closing");
            //Nicht vergessen das FIle wieder zu zu machen :)
            fileOutputStream.close();


            System.out.println("Wrote the file");

        }catch (FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
            return false;
        } catch (IOException ex){
            Log.d(TAG, ex.getMessage());
            return false;
        }
        return true;
    }
}
