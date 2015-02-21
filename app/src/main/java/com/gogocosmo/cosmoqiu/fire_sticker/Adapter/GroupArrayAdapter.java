package com.gogocosmo.cosmoqiu.fire_sticker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gogocosmo.cosmoqiu.fire_sticker.Acitivty.LaunchActivity;
import com.gogocosmo.cosmoqiu.fire_sticker.Model.Item;
import com.gogocosmo.cosmoqiu.fire_sticker.Model.ItemFactory;
import com.gogocosmo.cosmoqiu.fire_sticker.R;

import java.util.ArrayList;


public class GroupArrayAdapter extends ArrayAdapter<String> {
    private final Context _context;
    private final ArrayList<String> _values;
    final private String TAG = "MEMORY-ACC";


    public class ViewHolder {
        public TextView _groupName;
        public TextView _groupSize;
    }

    public GroupArrayAdapter(Context context, ArrayList<String> values) {
        super(context, R.layout.improved_group_list_rowlayout, values);
        this._context = context;
        this._values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        ViewHolder viewHolder;
        //reuse views
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(_context);
            rowView = inflater.inflate(R.layout.improved_group_list_rowlayout, null);
            // configure view holder
            viewHolder = new ViewHolder();
            viewHolder._groupName = (TextView) rowView.findViewById(R.id.group_name);
            viewHolder._groupSize = (TextView) rowView.findViewById(R.id.group_size);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        if (position == ItemFactory.getSelectedItemIndex()) {
            LaunchActivity._selectedView = rowView;
        }

        viewHolder._groupName.setText(_values.get(position));
        viewHolder._groupSize.setText(String.valueOf(ItemFactory.getItemList().size()));

        return rowView;
    }
}