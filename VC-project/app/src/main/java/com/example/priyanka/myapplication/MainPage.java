package com.example.priyanka.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {
    private static final int REQUEST_ADDEVENT = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button volunteer =(Button) findViewById(R.id.Volunteer);
        volunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VolunteerHomePage.class);
                intent.putExtra("hi", "login");
                startActivity(intent);//.startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
        });

        Button organizer = (Button) findViewById(R.id.Organizer);
        organizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity1.class);
                intent.putExtra("hi", "login");
                startActivity(intent);//.startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
        });;
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.addevent:
                // Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();
                //add event

                        // Start the Signup activity
                        Intent intent = new Intent(getApplicationContext(), AddEventActivity.class);
                        startActivityForResult(intent,REQUEST_ADDEVENT);



                break;
            case R.id.about:
                break;


        }
        return true;
    }


}
