package com.printhub.printhub.collab;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.printhub.printhub.R;
import com.printhub.printhub.clubEvents.EventsClass;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

import static com.printhub.printhub.HomeScreen.MainnewActivity.cityName;
import static com.printhub.printhub.HomeScreen.MainnewActivity.collegeName;


public class collabAdapter extends RecyclerView.Adapter<collabAdapter.ViewHolder> {

    List<collabClass> collab_list;
    Context context;
    private FirebaseFirestore db;
    public collabAdapter( List<collabClass> collab_list,Context context) {
        this.collab_list=collab_list;
        this.context= context;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.club_events_cardlayout,parent,false);
        db= FirebaseFirestore.getInstance();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       // String desc_data=blog_list.get(position).getDescription();
       // holder.setDescText(desc_data);

        String user_id=collab_list.get(position).getUserid();
        db.collection(cityName).document(collegeName).collection("users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    String userName=task.getResult().getString("name");
                    holder.setName(userName);
                }
            }
        });

        long milliseconds=collab_list.get(position).getTimestamp().getTime();
        String dateString= DateFormat.format("MM/dd/yyyy",new Date(milliseconds)).toString();
        holder.setTime(dateString);

    }

    @Override
    public int getItemCount() {
        return collab_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private MultiAutoCompleteTextView descView;
        ImageView clubEventPost;
        private TextView blogDate,authorName;
        public ViewHolder(@NonNull  View itemView) {

            super(itemView);
            mView=itemView;
            clubEventPost= mView.findViewById(R.id.clubEventPost);
            //descView=mView.findViewById(R.id.blog_desc);
        }

        public void setDescText(String descText){
            descView=mView.findViewById(R.id.blog_desc);
            descView.setText(descText);
        }
        public void setTime(String date){
            blogDate=mView.findViewById(R.id.blogdate);
            blogDate.setText(date);
        }

        public void setName(String name){
            authorName=mView.findViewById(R.id.authorName);
            authorName.setText(name);
        }
    }
}