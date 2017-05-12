package com.upreckless.support.hashtagswall.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.upreckless.support.hashtagswall.R;
import com.upreckless.support.hashtagswall.ui.model.PostModel;
import com.upreckless.support.hashtagswall.util.CircleTransform;
import com.upreckless.support.hashtagswall.util.CustomTextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by @mistreckless on 12.05.2017. !
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<PostModel> postModels;
    private Context context;
    private PostAdapterListener listener;

    public PostAdapter(Context context, PostAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        postModels = new ArrayList<>();
    }

    public void setPostModels(List<PostModel> postModels) {
        this.postModels = postModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostModel postModel = postModels.get(position);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("EEE, HH:mm ");
        Picasso.with(context).load(R.drawable.drujko).transform(new CircleTransform()).into(holder.imgThumb);
        holder.txtName.setText(postModel.getAuthorName());
        holder.txtDate.setText(simpleDateFormat.format(postModel.getDate()));
        holder.txtTitle.setText(postModel.getTitle());
        holder.txtText.removeAllTags();
        holder.txtText.setWords(postModel.getText());
        holder.txtText.setListenerOnWordClickListener(listener::wordClicked);
    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.img_thumb)
        ImageView imgThumb;
        @Bind(R.id.txt_name)
        TextView txtName;
        @Bind(R.id.txt_title)
        TextView txtTitle;
        @Bind(R.id.txt_text)
        CustomTextView txtText;
        @Bind(R.id.txt_date)
        TextView txtDate;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
