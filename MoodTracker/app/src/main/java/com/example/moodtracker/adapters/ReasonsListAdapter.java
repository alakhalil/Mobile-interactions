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
import com.example.moodtracker.models.Reason;

import java.util.ArrayList;

public class ReasonsListAdapter extends ArrayAdapter<Reason> {

    public ReasonsListAdapter(Context context, ArrayList<Reason> reasonArrayList) {
        super(context, R.layout.reason_item, reasonArrayList);
    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Reason reason = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.reason_item, parent, false);
        }

        ImageView reason_icon = convertView.findViewById(R.id.iconId);
        TextView reason_title = convertView.findViewById(R.id.reasonText);

        reason_icon.setImageResource(reason.iconId);
        reason_title.setText(reason.reason);

        return convertView;
    }
}
