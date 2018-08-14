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
import com.yunhaoguo.closeto.model.AppModel;

import java.util.List;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.adapter
 * 文件名:     AppListAdapter
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/13 下午7:43
 * 描述:      应用列表适配器
 */


public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<AppModel> appModelList;

    private OnItemClickListener listener;

    public AppListAdapter(Context context, List<AppModel> appModelList) {
        this.context = context;
        this.appModelList = appModelList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_applist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        AppModel appModel = appModelList.get(position);
        holder.ivAppIcon.setImageDrawable(appModel.getIcon());
        holder.tvAppName.setText(appModel.getAppName());
        holder.tvAppPackage.setText(appModel.getPackageName());
        holder.tvAppSize.setText(appModel.getAppSize());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return appModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivAppIcon;
        private TextView tvAppName;
        private TextView tvAppPackage;
        private TextView tvAppSize;

        public ViewHolder(View itemView) {
            super(itemView);
            ivAppIcon = itemView.findViewById(R.id.iv_app_item_icon);
            tvAppName = itemView.findViewById(R.id.tv_app_item_name);
            tvAppPackage = itemView.findViewById(R.id.tv_app_item_package);
            tvAppSize = itemView.findViewById(R.id.tv_app_item_size);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
