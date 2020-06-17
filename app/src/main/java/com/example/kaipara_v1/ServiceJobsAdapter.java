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

public class ServiceJobsAdapter extends RecyclerView.Adapter<ServiceJobsAdapter.ViewHolder> {
    List<ServiceJob> serviceJobs;
    Context mContext;
    public ServiceJobsAdapter(Context ctx, List<ServiceJob> serviceJobs){
        this.mContext = ctx;
        this.serviceJobs = serviceJobs;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.service_jobs_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title.setText(serviceJobs.get(i).getTitle());
        viewHolder.description.setText(serviceJobs.get(i).getDescription());
        viewHolder.status.setText(serviceJobs.get(i).getStatus());
        viewHolder.price.setText(serviceJobs.get(i).getPrice());
        viewHolder.date.setText(serviceJobs.get(i).getDate());
        viewHolder.end_date.setText(serviceJobs.get(i).getEnd_date());
        viewHolder.street.setText(serviceJobs.get(i).getStreet());
        viewHolder.suburb.setText(serviceJobs.get(i).getSuburb());
        viewHolder.city.setText(serviceJobs.get(i).getCity());
        viewHolder.postcode.setText(serviceJobs.get(i).getPostcode());
        Picasso.get().load(serviceJobs.get(i).getImagePath()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return  serviceJobs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,description,price,date,end_date,street,suburb,city,postcode,status;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.jobTitle);
            description = itemView.findViewById(R.id.description);
            status = itemView.findViewById(R.id.status);
            price = itemView.findViewById(R.id.price);
            date = itemView.findViewById(R.id.date);
            end_date = itemView.findViewById(R.id.end_date);
            street = itemView.findViewById(R.id.street);
            suburb = itemView.findViewById(R.id.suburb);
            city = itemView.findViewById(R.id.city);
            postcode = itemView.findViewById(R.id.postcode);
            img = itemView.findViewById(R.id.serviceJobImage);
        }
    }
}
