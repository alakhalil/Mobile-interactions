package com.example.moodtracker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.moodtracker.R;
import com.example.moodtracker.models.Entry;

import java.util.ArrayList;

public class EntriesListAdapter extends ArrayAdapter<Entry> {

    public EntriesListAdapter(Context context, ArrayList<Entry> reasonArrayList) {
        super(context, R.layout.entry_item, reasonArrayList);
    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Entry entry = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.entry_item, parent, false);
        }

        ImageView feeling_emoji = convertView.findViewById(R.id.feeling_emoji);
        TextView feeling_description = convertView.findViewById(R.id.feeling_description);
        TextView feeling_reason = convertView.findViewById(R.id.feeling_reason);
        TextView entry_time = convertView.findViewById(R.id.entry_time);
        ImageView attached_image = convertView.findViewById(R.id.attached_image);

        feeling_emoji.setImageResource(entry.feeling_emoji_id);
        feeling_description.setText(entry.feeling_description);
        feeling_reason.setText(entry.feeling_reason);
        entry_time.setText(entry.entry_time);
        if (entry.attached_image_id != 0) {
            attached_image.setImageResource(entry.attached_image_id);
        } else
            attached_image.setVisibility(attached_image.GONE);

        return convertView;
    }
}
