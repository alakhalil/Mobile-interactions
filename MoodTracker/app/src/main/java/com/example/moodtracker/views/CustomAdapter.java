package com.example.moodtracker.views;

import android.app.Activity;
import android.content.Intent;
import com.example.moodtracker.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private Activity activity;
    private ArrayList<RV> rv;


    public CustomAdapter(Activity activity, ArrayList<RV> rv) {
        this.activity = activity;
        this.rv = rv;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.rv_model, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.textView.setText(rv.get(position).getName());
            holder.imageView.setImageResource(rv.get(position).getPhoto());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(view.getContext(), page10.class);
                    i.putExtra("namee",rv.get(position).getName());
                    i.putExtra("emaill",rv.get(position).getEmail());
                    i.putExtra("photoo",rv.get(position).getPhoto());
                    view.getContext().startActivity(i);
                }
            });
    }

    @Override
    public int getItemCount() {
        return rv.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        textView = itemView.findViewById(R.id.textView1);
        cardView= itemView.findViewById(R.id.card_view);
        imageView = itemView.findViewById(R.id.imagess);
        }
    }
}
