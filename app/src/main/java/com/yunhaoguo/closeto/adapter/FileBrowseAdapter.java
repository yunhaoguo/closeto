package com.yunhaoguo.closeto.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.model.FileBrowseModel;

import java.util.List;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.adapter
 * 文件名:     FileBrowseAdapter
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/15 上午10:43
 * 描述:      文件浏览适配器
 */


public class FileBrowseAdapter extends RecyclerView.Adapter<FileBrowseAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<FileBrowseModel> fileList;

    private OnItemClickListener listener;

    public FileBrowseAdapter(Context context, List<FileBrowseModel> fileBrowseModelList) {
        this.context = context;
        this.fileList = fileBrowseModelList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_file_browse_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        FileBrowseModel model = fileList.get(position);
        holder.tvFileTitle.setText(model.getTitle());
        holder.tvFilePath.setText(model.getPath());
        holder.ivFileIcon.setImageDrawable(model.getIcon());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvFileTitle;
        private TextView tvFilePath;
        private ImageView ivFileIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            tvFileTitle = itemView.findViewById(R.id.tv_file_browse_item_title);
            tvFilePath = itemView.findViewById(R.id.tv_file_browse_item_path);
            ivFileIcon = itemView.findViewById(R.id.iv_file_browse_item_icon);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
