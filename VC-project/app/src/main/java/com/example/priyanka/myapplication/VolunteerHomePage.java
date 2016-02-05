package com.example.priyanka.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class VolunteerHomePage extends Activity implements AdapterView.OnItemClickListener {
    GridView gridview;
    Integer[] smallImages = {
            R.drawable.children,R.drawable.disabled,R.drawable.education,
            R.drawable.envi,R.drawable.homeless,R.drawable.community
    };
    Integer[] largeImages = { R.drawable.butterfly};

    Bundle myOriginalMemoryBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_home_page);

        myOriginalMemoryBundle = savedInstanceState;
        // setup GridView with its custom adapter and listener
        gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new GridViewAdapter(this, smallImages));
        gridview.setOnItemClickListener(this);

        Spinner spinner = (Spinner) findViewById(R.id.location_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.location, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


    }
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
      //  showBigScreen(position);
        Toast toast = Toast.makeText(getApplicationContext(),"You clicked",Toast.LENGTH_SHORT);
        toast.show();

        Intent loginIntent = new Intent(this,LoginActivity1.class);
        startActivity(loginIntent);
      //  showBigScreen(position);
    }//onItemClick

    private void showBigScreen(int position) {
        // show the selected picture as a single frame
        setContentView(R.layout.detaillayout);
       TextView txtSoloMsg = (TextView) findViewById(R.id.txtSoloMsg);
       ImageView imgSoloPhoto = (ImageView) findViewById(R.id.imgSoloPhoto);
        txtSoloMsg.setText("image " + position);

        imgSoloPhoto.setImageResource( largeImages[position] );

     /*  Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // redraw the main screen showing the GridView
                onCreate(myOriginalMemoryBundle);
            }
        });*/

    }// showBigScreen

}
