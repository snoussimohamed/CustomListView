package com.mohamedsnoussi.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ListView malist;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        malist = findViewById(R.id.listviewperso);
        ArrayList<HashMap<String, String>> Listitems = new ArrayList<>();
        HashMap<String, String> map;
        map = new HashMap<>();
        map.put("titre", "word");
        map.put("description", "Editeur de texte");
        map.put("img", String.valueOf(R.drawable.word));
        Listitems.add(map);


        map = new HashMap<>();
        map.put("titre", "excel");
        map.put("description", "tableur");
        map.put("img", String.valueOf(R.drawable.excel));
        Listitems.add(map);


        map = new HashMap<>();
        map.put("titre", "PawerPoint");
        map.put("description", "Logiciel dePresentation");
        map.put("img", String.valueOf(R.drawable.powerpoint));

        Listitems.add(map);


        map = new HashMap<>();
        map.put("titre", "outlook");
        map.put("description", "client de courrier electronique");
        map.put("img", String.valueOf(R.drawable.outlook));
        Listitems.add(map);

        SimpleAdapter adapter = new SimpleAdapter(this,
                Listitems,
                R.layout.activity_list_item,
                new String[]{"img", "titre", "description"},
                new int[]{R.id.img, R.id.titre, R.id.description});
        malist.setAdapter(adapter);
        malist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String ,String> map1 =(HashMap<String, String>) malist.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,map1.get("titre"),Toast.LENGTH_LONG).show();

            }
        });
        malist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String ,String> map2 =(HashMap<String, String>) malist.getItemAtPosition(position);
                AlertDialog.Builder adb =new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("selection item");
                adb.setMessage("votre choix : "+map2.get("titre"));
                adb.setPositiveButton("ok",null);
                adb.show();
                return true;
            }
        });
    }
}
