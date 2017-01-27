package com.apps.saijestudio.bucketbudget.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.apps.saijestudio.bucketbudget.R;


//Handles UI of ResultsActivity i.e. extracting and displaying the search query results in a clickable listView
public class ResultFragment extends Fragment {

    private String TAG = getClass().getSimpleName();
    //initialize arrays for data info of each search result
    private String[] resultValues = null;
    private String[] resultTitles = null;
    private String[] resultSnippets = null;
    private String[] resultLinks = null;
    private String[] resultUrls = null;


    public static Fragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_results, container, false);

        //use listview and tab id to create new ResultListAdapter (see viewAdapters pkg), passing in all the result data arrays created above
        ListView listView = (ListView) v.findViewById(R.id.listView);
        int resultTab = (int) getArguments().get(Constants.FRAG_ARGS_POSTION);
        //only populates the RECIPES category since that is located at a page position of 1 (see adapter)
        //TODO: populate other tabs i.e. if resultTab = (any other int from 2-4) then launch database and asyncTask accordingly and display search icon meanwhile
        if (resultTab == Constants.RECIPE_ID) {
            final ResultListAdapter adapter = new ResultListAdapter(getActivity(), resultValues, resultTitles, resultSnippets, resultLinks, resultUrls);
            listView.setAdapter(adapter);
            Log.d(TAG, "Recipe pager tab: set list Adapter with result bundle data values ");
        }

        //set OnItemClickListener for each entry in listView
        //if clicked extract the result info from existing textViews and store in new intent
        //launch intent to start the ResultItemDetailWebActivity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "OnClickListener for Result Listview item:");
                String resultTitle = (String)((TextView)view.findViewById(R.id.title)).getText();
                String resultLink = (String)((TextView)view.findViewById(R.id.link)).getText();
                String resultUrl = (String)((TextView)view.findViewById(R.id.url)).getText();

                Log.d(TAG, "Creating Intent for ResultItemDetailWebActivity");
                Intent intent = new Intent(getActivity(), ResultItemDetailWebActivity.class);
                Log.d(TAG, "StartActivity launching intent for ResultItemDetailWebActivity...");
                startActivity(intent);
            }
        });

        return v;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}