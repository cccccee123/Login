package com.example.login.Pro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.login.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aws on 28/01/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Product> mData ;
    private List<Product>mData1;



    public RecyclerViewAdapter(Context mContext, List<Product> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mData1=mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardveiw_item_book,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(mData.get(position).getTitle());
        holder.tv_book_price.setText(mData.get(position).getPrice());


        holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Product_Activity.class);

                // passing data to the book activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("Price",mData.get(position).getPrice());
                intent.putExtra("Catergory",mData.get(position).getCategory());


                intent.putExtra("Description",mData.get(position).getDescription());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                // start the activity
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();

    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title,tv_book_price,txtCat;
        ImageView img_book_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.title_id) ;
            tv_book_price = (TextView) itemView.findViewById(R.id.price) ;
            txtCat = (TextView) itemView.findViewById(R.id.txtCat) ;



            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String string = constraint.toString();

                if (string.isEmpty()) {
                    mData = mData1;
                } else {
                    List<Product> filterList = new ArrayList<>();
                    for (Product data : mData1) {
                        if (data.getTitle().toLowerCase().contains(string)) {
                            filterList.add(data);
                        }
                        mData = filterList;

                    }



                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mData;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mData = (List<Product>) results.values;
                notifyDataSetChanged();
            }
        };
    }


}
