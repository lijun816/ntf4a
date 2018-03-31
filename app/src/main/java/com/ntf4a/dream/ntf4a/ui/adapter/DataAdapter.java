package com.ntf4a.dream.ntf4a.ui.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.ntf4a.dream.ntf4a.R;
import com.ntf4a.dream.ntf4a.db.pojo.PasswordInfo;
import com.ntf4a.dream.ntf4a.ui.activity.DataActivity;

import java.util.List;
import java.util.Map;


public class DataAdapter implements ListAdapter {

    List<PasswordInfo> dataSource;
    Context context;

    public DataAdapter(Context context, List<PasswordInfo> dataSource) {
        this.dataSource = dataSource;
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            View view = View.inflate(context, R.layout.data_item_my, null);
            viewHolder = new ViewHolder();
            viewHolder.btnDelete = view.findViewById(R.id.btn_delete);
            viewHolder.btnUpdate = view.findViewById(R.id.btn_update);
            viewHolder.title = view.findViewById(R.id.show_title);

            viewHolder.btnDelete.setVisibility(View.GONE);
            viewHolder.btnUpdate.setVisibility(View.GONE);

            viewHolder.title.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (viewHolder.btnDelete.getVisibility() == View.GONE) {
                        viewHolder.btnDelete.setVisibility(View.VISIBLE);
                        viewHolder.btnUpdate.setVisibility(View.VISIBLE);
                    } else {
                        viewHolder.btnDelete.setVisibility(View.GONE);
                        viewHolder.btnUpdate.setVisibility(View.GONE);
                    }
                    return true;
                }
            });
            view.setTag(viewHolder);
            convertView = view;
        }
        viewHolder.title.setText(dataSource.get(position).getPwdDescription());
        return convertView;
    }

    class ViewHolder {
        Button btnDelete;
        Button btnUpdate;
        TextView title;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return dataSource.size();
    }

    @Override
    public boolean isEmpty() {
        return dataSource.isEmpty();
    }
}
