package com.example.kaipara_v1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
        switch (serviceJobs.get(i).getStatus()){
            case "Unaccepted":
                viewHolder.status.setBackgroundResource(R.drawable.rounded_unaccepted);
                break;
            case "Accepted":
                viewHolder.status.setBackgroundResource(R.drawable.rounded_assigned);
                break;
            case "Started":
                viewHolder.status.setBackgroundResource(R.drawable.rounded_started);
                break;
            case "Complete":
                viewHolder.status.setBackgroundResource(R.drawable.rounded_complete);
                break;
        }
        viewHolder.price.setText(serviceJobs.get(i).getPrice());
        viewHolder.date.setText(serviceJobs.get(i).getDate());
        viewHolder.month.setText(serviceJobs.get(i).getMonth());
        viewHolder.street.setText(serviceJobs.get(i).getStreet());
        viewHolder.suburb.setText(serviceJobs.get(i).getSuburb());
        viewHolder.city.setText(serviceJobs.get(i).getCity());
        if(serviceJobs.get(i).getImagePath() == "null"){
            Log.e("No img path: ","Setting visibility to Gone");
            viewHolder.img.setVisibility(View.GONE);
        }else{
            Picasso.get().load(serviceJobs.get(i).getImagePath()).into(viewHolder.img);
        }
    }

    @Override
    public int getItemCount() {
        return  serviceJobs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,description,price,date,month,street,suburb,city,status;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.SJ_title);
            description = itemView.findViewById(R.id.SJ_description);
            status = itemView.findViewById(R.id.SJ_status);
            price = itemView.findViewById(R.id.SJ_price);
            date = itemView.findViewById(R.id.SJ_date);
            street = itemView.findViewById(R.id.SJ_street);
            suburb = itemView.findViewById(R.id.SJ_suburb);
            city = itemView.findViewById(R.id.SJ_city);
            img = itemView.findViewById(R.id.SJ_image);
            month = itemView.findViewById(R.id.SJ_month);
        }
    }
}
