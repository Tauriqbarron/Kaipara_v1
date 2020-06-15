package com.example.kaipara_v1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<ServiceJob> serviceJobs;
    public Adapter(Context ctx, List<ServiceJob> serviceJobs){
        this.inflater = LayoutInflater.from(ctx);
        this.serviceJobs = serviceJobs;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.service_jobs_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title.setText(serviceJobs.get(i).getTitle());
        viewHolder.description.setText(serviceJobs.get(i).getDescription());
        viewHolder.price.setText(serviceJobs.get(i).getPrice());
        viewHolder.date.setText(serviceJobs.get(i).getDate());
        viewHolder.starttime.setText(serviceJobs.get(i).getStarttime());
        viewHolder.finishtime.setText(serviceJobs.get(i).getFinishtime());
        viewHolder.street.setText(serviceJobs.get(i).getStreet());
        viewHolder.suburb.setText(serviceJobs.get(i).getSuburb());
        viewHolder.postcode.setText(serviceJobs.get(i).getPostcode());
        Picasso.get().load(serviceJobs.get(i).getImagePath()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,description,price,date,starttime,finishtime,street,suburb,postcode;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.jobTitle);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            date = itemView.findViewById(R.id.date);
            starttime = itemView.findViewById(R.id.starttime);
            finishtime = itemView.findViewById(R.id.finishtime);
            street = itemView.findViewById(R.id.street);
            suburb = itemView.findViewById(R.id.suburb);
            postcode = itemView.findViewById(R.id.postcode);
        }
    }
}
