package com.printhub.printhub.prodcutscategory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.printhub.printhub.Cart;
import com.printhub.printhub.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


public class Bags extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mLayoutManager;
    private LottieAnimationView tv_no_item;

    //Getting reference to Firebase Database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = database.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //check Internet Connection
        //new CheckInternetConnection(this).checkConnection();

        //Initializing our Recyclerview
        mRecyclerView = findViewById(R.id.my_recycler_view);
        tv_no_item = findViewById(R.id.tv_no_cards);


        if (mRecyclerView != null) {
            //to enable optimization of recyclerview
            mRecyclerView.setHasFixedSize(true);
        }
        //using staggered grid pattern in recyclerview
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

//        //Say Hello to our new FirebaseUI android Element, i.e., FirebaseRecyclerAdapter
//        final FirebaseRecyclerAdapter<GenericProductModel, Cards.MovieViewHolder> adapter = new FirebaseRecyclerAdapter<GenericProductModel, Cards.MovieViewHolder>(
//                GenericProductModel.class,
//                R.layout.cards_cardview_layout,
//                Cards.MovieViewHolder.class,
//                //referencing the node where we want the database to store the data from our Object
//                mDatabaseReference.child("Products").child("Bags").getRef()
//        ) {
//            @Override
//            protected void populateViewHolder(final Cards.MovieViewHolder viewHolder, final GenericProductModel model, final int position) {
//                if (tv_no_item.getVisibility() == View.VISIBLE) {
//                    tv_no_item.setVisibility(View.GONE);
//                }
//                viewHolder.cardname.setText(model.getCardname());
//                viewHolder.cardprice.setText("₹ " + Float.toString(model.getCardprice()));
//                Picasso.with(Bags.this).load(model.getCardimage()).into(viewHolder.cardimage);
//
//                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(Bags.this, IndividualProduct.class);
//                        intent.putExtra("product", getItem(position));
//                        startActivity(intent);
//                    }
//                });
//            }
//        };
//
//
//        mRecyclerView.setAdapter(adapter);

    }

    public void viewCart(View view) {
        startActivity(new Intent(Bags.this, Cart.class));
        finish();
    }


    //viewHolder for our Firebase UI
    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView cardname;
        ImageView cardimage;
        TextView cardprice;

        View mView;

        public MovieViewHolder(View v) {
           super(v);
            mView = v;
//            cardname = v.findViewById(R.id.cardcategory);
//            cardimage = v.findViewById(R.id.cardimage);
//            cardprice = v.findViewById(R.id.cardprice);
        }
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();

        //check Internet Connection
        //new CheckInternetConnection(this).checkConnection();
    }
}
