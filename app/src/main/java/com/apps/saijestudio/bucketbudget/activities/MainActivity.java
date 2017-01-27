package com.apps.saijestudio.bucketbudget.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.apps.saijestudio.bucketbudget.R;
import com.apps.saijestudio.bucketbudget.adapters.BucketListAdapter;
import com.apps.saijestudio.bucketbudget.utils.LoggingActivity;

//Activity that displays the search query results
public class MainActivity extends LoggingActivity {

    private String[] values;





    //Custom FragmentPagerAdapter to display the category tabs
    BucketListAdapter mListAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);
        final BucketListAdapter adapter = new BucketListAdapter(this,values);
        listView.setAdapter(adapter);

        Log.d(TAG, "Set custom adapter for bucketlist");

        //set OnItemClickListener for each entry in listView
        //if clicked extract the result info from existing textViews and store in new intent
        //launch intent to start the ResultItemDetailWebActivity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(id == values.length){
                    
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }


}


