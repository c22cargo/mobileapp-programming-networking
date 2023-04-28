package com.example.networking;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "HTTPS_URL_TO_JSON_DATA_CHANGE_THIS_URL";
    private final String JSON_FILE = "mountains.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Mountain> items = new ArrayList<>(Arrays.asList(
                new Mountain("Coolt Berg", "Skövde", 1234),
                new Mountain("Tufft Berg", "Falköping", 2345),
                new Mountain("Trist Berg", "Hjo", 3456)
        ));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(Mountain item) {
                Toast.makeText(MainActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView view = findViewById(R.id.recycler_view);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setAdapter(adapter);

        new JsonFile(this, this).execute(JSON_FILE);
    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
    }

}
