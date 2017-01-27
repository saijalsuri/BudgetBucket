package com.apps.saijestudio.bucketbudget.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.apps.saijestudio.bucketbudget.R;

//ResultListAdapter sets the listView of the results
public class BucketListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] values;

    static class ViewHolder {
        public TextView title;
        public TextView desc;

    }

    //constructor to initialize arrays of result data
    public BucketListAdapter(Activity context, String[] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
        values[values.length] = "Add Bucket List Item";

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.list_item, null);

            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.title = (TextView) rowView.findViewById(R.id.title);
            viewHolder.desc = (TextView) rowView.findViewById(R.id.desc);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        String t = values[position];
        holder.title.setText(t);

        String s = values[position];
        holder.desc.setText(s);


        return rowView;
    }

}