package com.biswa.cognizantsoftvisiontest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.biswa.cognizantsoftvisiontest.model.DataResponse;
import com.squareup.picasso.Picasso;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private Context mContext;
    private DataResponse mDataResponse;


    public DataAdapter(Context context, DataResponse dataResponse) {
        this.mContext = context;
        this.mDataResponse = dataResponse;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.data_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, final int position) {
        holder.title.setText(mDataResponse.getRows().get(position).getTitle());
        holder.description.setText(mDataResponse.getRows().get(position).getDescription());
        Picasso.with(mContext)
                .load(mDataResponse.getRows().get(position).getImageUrl())
                .resize(100, 100)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.thumbnail);
        holder.card.setOnClickListener(view ->
                Toast.makeText(view.getContext(), "click on item: " +
                        mDataResponse.getRows().get(position).getTitle(), Toast.LENGTH_LONG).show());
    }


    @Override
    public int getItemCount() {
        Log.d("adapter", "getItemCount: ="+mDataResponse.getRows().size());
        return mDataResponse.getRows().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        public TextView title, description;
        public RelativeLayout card;

        public ViewHolder(View itemView) {
            super(itemView);
            this.thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            this.title = (TextView) itemView.findViewById(R.id._title);
            this.description = (TextView) itemView.findViewById(R.id.description);
            this.card = (RelativeLayout) itemView.findViewById(R.id.card_rel);
        }
    }
}