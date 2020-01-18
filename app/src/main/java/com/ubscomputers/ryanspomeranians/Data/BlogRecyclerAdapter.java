package com.ubscomputers.ryanspomeranians.Data;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ubscomputers.ryanspomeranians.Model.Blog;
import com.ubscomputers.ryanspomeranians.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by paulodichone on 4/17/17.
 */

public class BlogRecyclerAdapter extends RecyclerView.Adapter<BlogRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Blog> blogList;

    public BlogRecyclerAdapter(Context context, List<Blog> blogList) {
        this.context = context;
        this.blogList = blogList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_row, parent, false);


        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Blog blog = blogList.get(position);
        String imageUrl;

        holder.title.setText(blog.getTitle());
        holder.desc.setText(blog.getDesc());


        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
        String formattedDate = dateFormat.format(new Date(Long.valueOf(blog.getTimestamp())).getTime());



        holder.timestamp.setText(formattedDate);

        imageUrl = blog.getImage();


        //TODO: Use Picasso library to load image
        Picasso.with(context)
                .load(imageUrl)
                .into(holder.image);



    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView desc;
        public TextView timestamp;
        public ImageView image;
        String userid;

        public ViewHolder(View view, Context ctx) {
            super(view);

            context = ctx;

            title = view.findViewById(R.id.postTitleList);
            desc = view.findViewById(R.id.postTextList);
            image = view.findViewById(R.id.postImageList);
            timestamp = view.findViewById(R.id.timestampList);

            userid = null;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // we can go to the next activity...

                }
            });

        }
    }
}