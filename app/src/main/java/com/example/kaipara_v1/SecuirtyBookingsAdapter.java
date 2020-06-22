package com.example.kaipara_v1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class SecuirtyBookingsAdapter extends RecyclerView.Adapter<SecuirtyBookingsAdapter.ViewHolder> {
    List<SecurityBookings> securityBookings;
    Context mContext;
    public SecuirtyBookingsAdapter(Context ctx, List<SecurityBookings> securityBookings){
        this.mContext = ctx;
        this.securityBookings = securityBookings;
    }
    @NonNull
    @Override
    public SecuirtyBookingsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.security_booking_item,
                viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SecuirtyBookingsAdapter.ViewHolder viewHolder, int i) {
        SecurityBookings booking = securityBookings.get(i);
        viewHolder.description.setText(booking.getDescription());
        viewHolder.price.setText(booking.getPrice());
        viewHolder.status.setText(booking.getStatus());
        if(booking.getStatus() == "ASSIGNED"){
            viewHolder.status.setBackgroundResource(R.drawable.rounded_assigned);
        }
        viewHolder.street.setText(booking.getStreet());
        viewHolder.suburb.setText(booking.getSuburb());
        viewHolder.city.setText(booking.getCity());
        viewHolder.day.setText(booking.getStart_date());
        viewHolder.start_time.setText(booking.getStart_time());
        viewHolder.end_time.setText(booking.getEnd_time());
        viewHolder.month.setText(booking.getMonth());
        viewHolder.date.setText(booking.getDay_num());
    }

    @Override
    public int getItemCount() {
        return securityBookings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView description,price,status,street,suburb,city,day,date,start_time,end_time,month;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.SB_description);
            price = itemView.findViewById(R.id.SB_price);
            status = itemView.findViewById(R.id.SB_status);
            street = itemView.findViewById(R.id.SB_street);
            suburb = itemView.findViewById(R.id.SB_suburb);
            city = itemView.findViewById(R.id.SB_city);
            day = itemView.findViewById(R.id.SB_day);
            date = itemView.findViewById(R.id.SB_date);
            month = itemView.findViewById(R.id.SB_month);
            start_time = itemView.findViewById(R.id.SB_start_time);
            end_time = itemView.findViewById(R.id.SB_time_end);
        }
    }
}
