package com.jiataocheng.solsticeevalproject;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;


public class MainActivity extends Activity {
    ExpandableListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get List View object from xml
        listView = (ExpandableListView)findViewById(R.id.list);

        //Define values to show in list view
        String[] displayValues = new String[]{"Android List View",
                                              "Adapter implementations",
                                               "Simple List View in Android"};
        //Define new Adapter
        //First Param - Context
        //Second Param - Layout
        //Third Param - ID of the TextView
        //Forth - the Array of Data

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, displayValues);

        //Assign adapter to ListView
        listView.setAdapter(adapter);

        //ListView item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //ListView clicked item index
                int itemPosition = i;

                //ListView Clicked item value
                String itemValue = (String)listView.getItemAtPosition(i);

                //Show Alert
                Toast.makeText(getApplicationContext(),"Position:"+itemPosition+"ListItem :" +itemValue, Toast.LENGTH_LONG).show();

            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
