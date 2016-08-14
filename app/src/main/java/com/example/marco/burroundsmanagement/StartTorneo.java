package com.example.marco.burroundsmanagement;

/**
 * Created by marco on 13/08/2016.
 */
import android.app.ListActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ListActivity;
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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;






public class StartTorneo extends ListActivity implements android.view.View.OnClickListener {

    TextView torneo_Id;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserimento_torneo);


        TorneoRepo repo2 = new TorneoRepo(this);

        ArrayList<HashMap<String, String>> torneoList = repo2.getTorneoList();


        if (torneoList.size() != 0) {
            ListView lv2 = getListView();
            lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    torneo_Id = (TextView) view.findViewById(R.id.torneo_Id);
                    String torneoId = torneo_Id.getText().toString();
                    Intent objIndent1 = new Intent(getApplicationContext(), Gestisci.class);
                    objIndent1.putExtra("torneo_Id", Integer.parseInt(torneoId));
                    startActivity(objIndent1);
                }
            });
            ListAdapter adapter1 = new SimpleAdapter(StartTorneo.this, torneoList, R.layout.view_torneo_entry, new String[]{"id", "name"}, new int[]{R.id.torneo_Id, R.id.torneo_name});
            setListAdapter(adapter1);
        } else {
            Toast.makeText(this, "Nessun Torneo Registrato!", Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void onClick(View v) {

    }
}