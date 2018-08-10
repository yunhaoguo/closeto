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
import com.yunhaoguo.closeto.bean.MusicBean;

import java.util.List;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.adapter
 * 文件名:     MusicListAdapter
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/6 下午3:59
 * 描述:      主页音乐列表适配器
 */


public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<MusicBean> musicBeanList;

    private OnItemClickListener listener;

    public MusicListAdapter(Context context, List<MusicBean> musicBeanList) {
        this.context = context;
        this.musicBeanList = musicBeanList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_home_music_item, null);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return musicBeanList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        String title = musicBeanList.get(position).getTitle();
        String picUrl = musicBeanList.get(position).getPicUrl();
        holder.tvTitle.setText(title);
        Glide.with(context).load(picUrl).into(holder.ivPic);
        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(holder.getAdapterPosition());
                }
            });
        }
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivPic;
        private TextView tvTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            ivPic = itemView.findViewById(R.id.iv_music_item_pic);
            tvTitle = itemView.findViewById(R.id.tv_music_item_title);
        }
    }

}
