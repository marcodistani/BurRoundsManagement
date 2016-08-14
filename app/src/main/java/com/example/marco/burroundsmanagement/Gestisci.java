package com.example.marco.burroundsmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by marco on 14/08/2016.
 */
public class Gestisci extends AppCompatActivity implements View.OnClickListener {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestisci);


        Button gestisci_squadre = (Button) findViewById(R.id.gestisci_squadre);
        gestisci_squadre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu1= new Intent(Gestisci.this, StartInserimento.class);
                startActivity(menu1);
            }
        });


        Button gestisci_torneo = (Button) findViewById(R.id.gestisci_torneo);
        gestisci_torneo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu= new Intent(Gestisci.this, MainActivity.class);
                startActivity(menu);
            }
        });





    }

    @Override
    public void onClick(View v) {

    }
}
