package com.example.marco.burroundsmanagement;

/**
 * Created by marco on 13/08/2016.
 */
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TorneoDetail extends ActionBarActivity implements android.view.View.OnClickListener {

    Button btnSave2, btnDelete2;
    Button btnClose2;
    EditText editTextName2;
    private int _Torneo_Id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torneo_detail);

        btnSave2 = (Button) findViewById(R.id.btnSave2);
        btnDelete2 = (Button) findViewById(R.id.btnDelete2);
        btnClose2 = (Button) findViewById(R.id.btnClose2);

        editTextName2 = (EditText) findViewById(R.id.editTextName2);


        btnSave2.setOnClickListener(this);
        btnDelete2.setOnClickListener(this);
        btnClose2.setOnClickListener(this);


        _Torneo_Id = 0;
        Intent intent = getIntent();
        _Torneo_Id = intent.getIntExtra("torneo_Id", 0);
        TorneoRepo repo2 = new TorneoRepo(this);
        Torneo torneo = new Torneo();
        torneo = repo2.getTorneoById(_Torneo_Id);

        editTextName2.setText(torneo.name_TORNEO);
    }


    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave2)) {
            TorneoRepo repo2 = new TorneoRepo(this);
            Torneo torneo = new Torneo();
            torneo.name_TORNEO = editTextName2.getText().toString();
            torneo.torneo_ID = _Torneo_Id;

            if (_Torneo_Id == 0) {
                _Torneo_Id = repo2.insert(torneo);

                Toast.makeText(this, "Nuovo Torneo Inserito", Toast.LENGTH_SHORT).show();
            } else {

                repo2.update(torneo);
                Toast.makeText(this, "Torneo Modificato", Toast.LENGTH_SHORT).show();
            }
        } else if (view == findViewById(R.id.btnDelete2)) {
            TorneoRepo repo2 = new TorneoRepo(this);
            repo2.delete(_Torneo_Id);
            Toast.makeText(this, "Torneo Cancellato", Toast.LENGTH_SHORT).show();
            finish();
        } else if (view == findViewById(R.id.btnClose2)) {
            finish();
        }


    }
}


