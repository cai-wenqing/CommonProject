package com.example.qiany.commonproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qiany.commonproject.R;

import java.util.List;

/**
 * @author caiwenqing
 * @data 2018/7/23
 * description:
 */
public class StringAdapter extends RecyclerView.Adapter<StringAdapter.StringViewHolder> {
    private Context mContext;
    private List<String> mList;

    public StringAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public StringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_home, parent, false);
        return new StringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StringViewHolder holder, int position) {
        holder.tv.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class StringViewHolder extends RecyclerView.ViewHolder {

        private TextView tv;

        public StringViewHolder(View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.item_home_tv);
        }
    }

}
