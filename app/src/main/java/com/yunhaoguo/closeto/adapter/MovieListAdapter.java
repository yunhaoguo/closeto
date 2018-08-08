package com.yunhaoguo.closeto.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.bean.MovieBean;

import java.util.List;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.adapter
 * 文件名:     MoiveListAdapter
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/8 下午3:21
 * 描述:      主页电影列表适配器
 */


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<MovieBean> movieBeanList;

    private OnItemClickListener listener;

    public MovieListAdapter(Context context, List<MovieBean> movieBeanList) {
        this.context = context;
        this.movieBeanList = movieBeanList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_home_movie_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        MovieBean bean = movieBeanList.get(position);
        holder.tvTitle.setText(bean.getTitle());
        Glide.with(context).load(bean.getPicUrl()).into(holder.ivPic);
        holder.tvContent.setText(bean.getContent());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieBeanList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private ImageView ivPic;
        private TextView tvContent;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_movie_item_title);
            ivPic = itemView.findViewById(R.id.iv_movie_item_pic);
            tvContent = itemView.findViewById(R.id.tv_movie_item_content);
        }
    }
}
