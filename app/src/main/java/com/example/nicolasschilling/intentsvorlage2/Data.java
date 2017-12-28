package com.example.nicolasschilling.intentsvorlage2;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by nicolasschilling on 27.12.17.
 */

public class Data implements Parcelable {

    private String daten;


    protected Data (Parcel in ) {
        daten = in.readString(); //this must be readInt for int etc.
    }





//Konstruktor
    public Data(String data){
        this.daten =data;
    }


    public static final Creator<Data>CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel (Parcel in) {
        return new Data(in);
        }


        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };



        @Override
    public int describeContents() {
        return 0;
        }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(daten);
    }




    public String getDaten(){
        return daten;
    }
}


