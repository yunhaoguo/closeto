package com.yunhaoguo.closeto.adapter;
/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.adapter
 * 文件名:     LifestyleListAdapter
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/10 上午11:06
 * 描述:      生活指数适配器
 */


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.bean.LifestyleBean;

import java.util.List;



public class LifestyleListAdapter extends RecyclerView.Adapter<LifestyleListAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<LifestyleBean> lsbList;

    public LifestyleListAdapter(Context context, List<LifestyleBean> lsbList) {
        this.context = context;
        this.lsbList = lsbList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_lifestyle_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LifestyleBean lifestyle = lsbList.get(position);
        holder.tvType.setText(lifestyle.getType());
        holder.tvBrf.setText(lifestyle.getBrf());
        holder.tvTxt.setText(lifestyle.getTxt());
    }

    @Override
    public int getItemCount() {
        return lsbList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvType;
        private TextView tvBrf;
        private TextView tvTxt;

        public ViewHolder(View itemView) {
            super(itemView);
            tvType = itemView.findViewById(R.id.tv_lifestyle_type);
            tvBrf = itemView.findViewById(R.id.tv_lifestyle_brf);
            tvTxt = itemView.findViewById(R.id.tv_lifestyle_txt);

        }
    }
}
