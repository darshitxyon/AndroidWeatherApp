package com.darshit.androidweatherapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.darshit.androidweatherapp.entity.ListJsonObject;
import com.darshit.androidweatherapp.R;

import java.util.ArrayList;
import java.util.List;

public class TextSuggestAdapter extends BaseAdapter implements Filterable {

    private LayoutInflater lInflater;

    private List<ListJsonObject> jsonObject;

    private List<ListJsonObject> suggestions = new ArrayList<>();

    private Filter filter = new CustomFilter();


    public TextSuggestAdapter(Context context, List<ListJsonObject> jsonObject) {
        lInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.jsonObject = jsonObject;
    }

    @Override
    public int getCount() {
        return suggestions.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holders;
        if(convertView == null){
            holders = new ViewHolder();
            convertView = lInflater.inflate(R.layout.city_list, parent, false);
            holders.textSuggestion = (TextView)convertView.findViewById(R.id.text_suggestion);
            convertView.setTag(holders);
        }else{
            holders = (ViewHolder)convertView.getTag();
        }
        String cityCountry = suggestions.get(position).getName() + suggestions.get(position).getCountry();
        holders.textSuggestion.setText(cityCountry);
        return convertView;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private class CustomFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            suggestions.clear();

            if (jsonObject != null && constraint != null) {
                for (int i = 0; i < jsonObject.size(); i++) {
                    if (jsonObject.get(i).getName().toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                        suggestions.add(jsonObject.get(i));
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = suggestions;
            results.count = suggestions.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    }

    static class ViewHolder{

        TextView textSuggestion;
    }
}

