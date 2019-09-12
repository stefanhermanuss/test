package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class PenyimpanNilaiDisplay {
    protected SharedPreferences sharedPref;
    protected final static String NAMA_SHARED_PREF="sp_nilai_display";
    protected final static String KEY_BARANG="BARANG";
    protected final static String KEY_HARGA="HARGA";
    protected final static String KEY_KETERANGAN="KETERANGAN";

    public PenyimpanNilaiDisplay(Context context){
        this.sharedPref = context.getSharedPreferences(NAMA_SHARED_PREF,0);
    }

    public void saveBarang(String barang){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_BARANG, barang);
        editor.commit();
    }

    public String getBarang(){
        return sharedPref.getString(KEY_BARANG,"");
    }

    public void saveHarga(String barang){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_HARGA, barang);
        editor.commit();
    }

    public String getHarga(){
        return sharedPref.getString(KEY_HARGA,"");
    }

    public void saveKeterangan(String barang){
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_KETERANGAN, barang);
        editor.commit();
    }

    public String getKeterangan(){
        return sharedPref.getString(KEY_KETERANGAN,"");
    }

}
