package com.androidwithshiv.carousel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidwithshiv.carousel.R;
import com.androidwithshiv.carousel.model.BatDetails;
import com.bumptech.glide.Glide;

import java.util.List;

public class BatDetailsAdapter extends RecyclerView.Adapter<BatDetailsAdapter.BatDetailsHolder>{


    private Context context;
    private List<BatDetails> batDetailsList;

    public BatDetailsAdapter(Context context, List<BatDetails> batDetailsList) {
        this.context = context;
        this.batDetailsList = batDetailsList;
    }

    @NonNull
    @Override
    public BatDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_rv, parent, false);
        return new BatDetailsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BatDetailsHolder holder, int position) {
        holder.batName.setText(batDetailsList.get(position).getName());
        Glide.with(holder.batImage).load(batDetailsList.get(position).getId()).into(holder.batImage);
    }

    @Override
    public int getItemCount() {
        return batDetailsList.size();
    }

    public class BatDetailsHolder extends RecyclerView.ViewHolder{

        private TextView batName;
        private ImageView batImage;
        public BatDetailsHolder(@NonNull View itemView) {
            super(itemView);
            batImage = itemView.findViewById(R.id.bat_img);
            batName = itemView.findViewById(R.id.bat_name);
        }
    }
}
