package com.example.nicolasschilling.intentsvorlage2;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by nicolasschilling on 27.12.17.
 */


//Zum senden reicht "Serializable" und nen cast auf das object...
public class Data implements Serializable {

    private String daten;

//Konstruktor
    Data(String data){
        this.daten = data;
    }



    //Overwrites brauchst du nur wenn du auch wirklich ne andere funktion überschreiben willst. Zb wenn man ne klasse
    // mit der funktion "do_stuff" extended, die funktion "do_stuff" in der neuen klasse aber was anderes machen soll :)
    // @Override
    public String describeContents() {
        return daten;
        }

    public String getDaten(){
        return daten;
    }
}


