package com.codetrack.bscitians.adapter;

import com.codetrack.bscitians.R;
import com.codetrack.bscitians.app.AppController;
import com.codetrack.bscitians.model.Subjects;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class SubjectsListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Subjects> subjectsItem;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public SubjectsListAdapter(Activity activity, List<Subjects> subjectsItem) {
        this.activity = activity;
        this.subjectsItem = subjectsItem;
    }

    @Override
    public int getCount() {
        return subjectsItem.size();
    }

    @Override
    public Object getItem(int location) {
        return subjectsItem.get(location);
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
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView genre = (TextView) convertView.findViewById(R.id.description);

        // getting movie data for the row
        Subjects m = subjectsItem.get(position);
        convertView.setTag(m.getId());
        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);
        thumbNail.setContentDescription(m.getLink());

        // title
        title.setText(m.getTitle());


        // genre
        genre.setText(m.getDescription());


        return convertView;
    }

}