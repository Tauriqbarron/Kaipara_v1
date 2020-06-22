package com.example.kaipara_v1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ApplicationsAdapter extends RecyclerView.Adapter<ApplicationsAdapter.ViewHolder> {
    List<Application> applications;
    Context mContext;

    public ApplicationsAdapter(Context ctx,List<Application> applications ){
        this.mContext = ctx;
        this.applications = applications;
    }
    @NonNull
    @Override
    public ApplicationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.application_item,viewGroup,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ApplicationsAdapter.ViewHolder viewHolder, int i) {
        Log.e("Setup: ","Setting fields for item: "+i);
        Application application = applications.get(i);
        viewHolder.title.setText(application.getTitle());
        viewHolder.type.setText(application.getType());
        viewHolder.description.setText(application.getDescription());
        viewHolder.price.setText(application.getPrice());
        if (!application.getPrice().equals("QUOTABLE")){
            viewHolder.btn.setText("Accept");
        }
        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(viewHolder.price.getText().toString()){
                    case "QUOTABLE":
                        if(viewHolder.bottom.getVisibility() == View.GONE){
                            TransitionManager.beginDelayedTransition(viewHolder.top, new AutoTransition());
                            viewHolder.bottom.setVisibility(View.VISIBLE);
                        }else{
                            TransitionManager.beginDelayedTransition(viewHolder.top, new AutoTransition());
                            viewHolder.bottom.setVisibility(View.GONE);
                        }
                        break;
                    default:

                }

            }
        });
        viewHolder.name.setText(application.getName());
        viewHolder.number.setText(application.getNumber());
        viewHolder.address.setText(application.getAddress());
        if(application.getImgPath() == "null"){
            Log.e("No img path: ","Setting visibility to Gone for img: "+i);
            viewHolder.img.setVisibility(View.GONE);
        }else {
            Picasso.get().load(application.getImgPath()).into(viewHolder.img);
        }
    }
    @Override
    public int getItemCount() {
        return applications.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,price,name,number,description,address,type;
        ImageView img;
        Button btn;
        ConstraintLayout bottom;
        CardView top;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.App_title);
            description = itemView.findViewById(R.id.App_description);
            price = itemView.findViewById(R.id.App_price);
            name = itemView.findViewById(R.id.App_name);
            number = itemView.findViewById(R.id.App_number);
            address = itemView.findViewById(R.id.App_address);
            type = itemView.findViewById(R.id.App_type);
            img = itemView.findViewById(R.id.App_image);
            btn = itemView.findViewById(R.id.btnQuote);
            bottom = itemView.findViewById(R.id.App_bottom);
            top = itemView.findViewById(R.id.App_card);
        }
    }

}
