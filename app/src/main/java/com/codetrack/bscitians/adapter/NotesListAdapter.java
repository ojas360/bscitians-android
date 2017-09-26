package com.codetrack.bscitians.adapter;

import com.codetrack.bscitians.R;
import com.codetrack.bscitians.app.AppController;
import com.codetrack.bscitians.model.Notes;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

public class NotesListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Notes> notesItem;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public NotesListAdapter(Activity activity, List<Notes> papersItem) {
        this.activity = activity;
        this.notesItem = papersItem;
    }

    @Override
    public int getCount() {
        return notesItem.size();
    }

    @Override
    public Object getItem(int location) {
        return notesItem.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row1, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        TextView title = (TextView) convertView.findViewById(R.id.titlepapers);
        //TextView link = (TextView) convertView.findViewById(R.id.link);
        ImageButton content_download = (ImageButton)convertView.findViewById(R.id.content_download);

        // getting movie data for the row
        Notes m = notesItem.get(position);


        TextView e = (TextView) convertView.findViewById(R.id.txt_simple_list_number);

        //Increment number
        e.setText(String.valueOf(position+1));

        // title
        title.setText(m.getTitle());

        // link
        content_download.setContentDescription(m.getLink());
        convertView.setTag(m.getLink());

        // year
        //genre.setText(m.getYear());


        return convertView;
    }

}