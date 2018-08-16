package com.yunhaoguo.closeto.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.yunhaoguo.closeto.R;
import com.yunhaoguo.closeto.entity.Type;
import com.yunhaoguo.closeto.model.SystemInfoModel;

import java.util.List;

/*
 * 项目名:     CloseTo
 * 包名:      com.yunhaoguo.closeto.adapter
 * 文件名:     SystemInfoAdapter
 * 创建者:     yunhaoguo
 * 创建时间:    2018/8/16 下午4:00
 * 描述:      系统信息列表适配器
 */


public class SystemInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<SystemInfoModel> systemInfoList;


    private OnButtonClickListener listener;

    public SystemInfoAdapter(Context context, List<SystemInfoModel> systemInfoList) {
        this.context = context;
        this.systemInfoList = systemInfoList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Type.SYSTEM_LIST_TITLE) {
            View view = inflater.inflate(R.layout.layout_system_info_item_title, parent, false);
            return new TitleViewHolder(view);
        } else if (viewType == Type.SYSTEM_LIST_CONTENT_TEXT) {
            View view = inflater.inflate(R.layout.layout_system_info_item_text, parent, false);
            return new TextViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.layout_system_info_item_button, parent, false);
            return new ButtonViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TitleViewHolder) {
            if (position == 0) {
                ((TitleViewHolder) holder).vLine.setVisibility(View.GONE);
            }
            ((TitleViewHolder) holder).tvTitle.setText(systemInfoList.get(position).getTitle());
        } else if (holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).tvTextKey.setText(systemInfoList.get(position).getTextKey());
            ((TextViewHolder) holder).tvTextValue.setText(systemInfoList.get(position).getTextValue());
        } else {
            ((ButtonViewHolder)holder).tvButtonKey.setText(systemInfoList.get(position).getButtonKey());
            ((ButtonViewHolder)holder).btnButtonValue.setText(systemInfoList.get(position).getButtonValue());
            ((ButtonViewHolder)holder).btnButtonValue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onButtonClick(holder.getAdapterPosition());
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return systemInfoList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return systemInfoList.get(position).getType();
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private View vLine;

        public TitleViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_system_info_title);
            vLine = itemView.findViewById(R.id.v_line);
        }

    }

    class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTextKey;
        private TextView tvTextValue;

        public TextViewHolder(View itemView) {
            super(itemView);
            tvTextKey = itemView.findViewById(R.id.tv_system_info_text_key);
            tvTextValue = itemView.findViewById(R.id.tv_system_info_text_value);
        }
    }

    class ButtonViewHolder extends RecyclerView.ViewHolder {

        private TextView tvButtonKey;
        private Button btnButtonValue;

        public ButtonViewHolder(View itemView) {
            super(itemView);
            tvButtonKey = itemView.findViewById(R.id.tv_system_info_button_key);
            btnButtonValue = itemView.findViewById(R.id.tv_system_info_button_value);
        }
    }

    public void setOnButtonClickListener(OnButtonClickListener listener) {
        this.listener = listener;
    }

    public interface OnButtonClickListener {
        void onButtonClick(int position);
    }

}
