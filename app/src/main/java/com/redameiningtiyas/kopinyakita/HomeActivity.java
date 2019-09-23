package com.redameiningtiyas.kopinyakita;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;



public class HomeActivity extends AppCompatActivity {



    private String[] dataName;

    private String[] dataDescription;

    private TypedArray dataPhoto;

    private KopiAdapter adapter;

    private ArrayList<Kopi> kopinyakita;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);



        adapter = new KopiAdapter(this);



        ListView listView = findViewById(R.id.lv_list);

        listView.setAdapter(adapter);



        //Menyipakan data dari resource

        prepare();



        //Menambahkan data dari resource ke adapter

        addItem();



        //Memberi aksi pada listView

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(HomeActivity.this, kopinyakita.get(i).getName(), Toast.LENGTH_SHORT).show();

            }

        });

    }



    private void prepare() {

        dataName = getResources().getStringArray(R.array.data_name);

        dataDescription = getResources().getStringArray(R.array.data_description);

        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

    }



    private void addItem() {

        kopinyakita = new ArrayList<>();



        for (int i = 0; i < dataName.length; i++) {

            Kopi kopi = new Kopi();

            kopi.setPhoto(dataPhoto.getResourceId(i, -1));

            kopi.setName(dataName[i]);

            kopi.setDescription(dataDescription[i]);

            kopinyakita.add(kopi);

        }



        adapter.setKopinyakita(kopinyakita);

    }

}
