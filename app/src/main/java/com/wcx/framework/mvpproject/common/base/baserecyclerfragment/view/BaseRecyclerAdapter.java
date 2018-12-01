package com.wcx.framework.mvpproject.common.base.baserecyclerfragment.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.wcx.framework.mvpproject.common.base.baserecyclerfragment.recyclerinterface.RecyclerViewOnItemClickListener;

import java.util.ArrayList;

/**
 * @author wangchenxing
 * @data 1/12/2018 4:07 PM
 */
public abstract class BaseRecyclerAdapter<DataType, ItemView extends BaseItemView<DataType>> extends RecyclerView.Adapter<BaseRecyclerAdapter<DataType, ItemView>.ViewHolder> {

    public abstract ItemView getItemView(Context context);

    public ArrayList<DataType> dataSet = new ArrayList<DataType>();

    private RecyclerViewOnItemClickListener<DataType> listener;

    public abstract void setDataSet(ArrayList<DataType> dataSet);

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(getItemView(viewGroup.getContext()));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        if (viewHolder.itemView != null) {
            final ItemView itemView = (ItemView) viewHolder.itemView;
            final int layoutPosition = viewHolder.getLayoutPosition();
            final DataType dataType = dataSet.get(layoutPosition);
            itemView.bindCell(dataType, layoutPosition);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onClick(dataType);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void setOnItemClickListener(RecyclerViewOnItemClickListener<DataType> listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
