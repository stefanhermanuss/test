package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText et_barang;
    protected EditText et_harga;
    protected EditText et_keterangan;
    protected PenyimpanNilaiDisplay pencatatBarang;
    protected PenyimpanNilaiDisplay pencatatHarga;
    protected PenyimpanNilaiDisplay pencatatKeterangan;
    protected Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.pencatatBarang = new PenyimpanNilaiDisplay(this);
        this.pencatatHarga = new PenyimpanNilaiDisplay(this);
        this.pencatatKeterangan = new PenyimpanNilaiDisplay(this);
        this.btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        this.et_barang = findViewById(R.id.et_barang);
        this.et_harga = findViewById(R.id.et_harga);
        this.et_keterangan = findViewById(R.id.et_keterangan);
    }

    @Override
    protected void onPause(){
        super.onPause();
        this.pencatatBarang.saveBarang(et_barang.getText().toString());
        this.pencatatHarga.saveHarga(et_harga.getText().toString());
        this.pencatatKeterangan.saveKeterangan(et_keterangan.getText().toString());
    }



    @Override
    protected void onResume(){
        super.onResume();
        this.et_barang.setText(this.pencatatBarang.getBarang());
        this.et_harga.setText(this.pencatatHarga.getHarga());
        this.et_keterangan.setText(this.pencatatKeterangan.getKeterangan());
    }

    @Override
    public void onClick(View view){
        if(view == this.btn_add){
            this.saveText();
        }
    }

    public void saveText(){
        FileOutputStream fop = null;
        File file;
        String content = et_barang.getText().toString() + et_harga.getText().toString() + et_keterangan.getText().toString();

        try{

            file= new File(this.getFilesDir(), "test.txt");
            fop = new FileOutputStream(file);

            if(!file.exists()){
                file.createNewFile();
            }

            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();
            Log.d("asdf", file.exists()+"");

        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(fop != null){
                    fop.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
