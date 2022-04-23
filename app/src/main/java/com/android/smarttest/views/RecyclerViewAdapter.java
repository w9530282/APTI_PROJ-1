package com.android.smarttest.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.smarttest.R;
import com.android.smarttest.model.TechnologyObj;

import java.util.List;


class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    View view1;
    ViewHolder viewHolder1;
    TextView textView;
    List<TechnologyObj> mList;

    public RecyclerViewAdapter(Context context1, List<TechnologyObj> list) {

        this.mList = list;
        this.context = context1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView image;
        public LinearLayout linearLayout;

        public ViewHolder(View v) {

            super(v);

            textView = (TextView) v.findViewById(R.id.subject_textview);
            image = (ImageView) v.findViewById(R.id.image_tech);
            linearLayout = (LinearLayout) v.findViewById(R.id.card_layout);
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view1 = LayoutInflater.from(context).inflate(R.layout.recyclerview_items, parent, false);

        viewHolder1 = new ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(mList.get(position).getName());
        holder.image.setBackgroundResource(mList.get(position).getId());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,
                        QuestionActivity1.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }
}