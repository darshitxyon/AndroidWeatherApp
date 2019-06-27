package com.darshit.androidweatherapp.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.darshit.androidweatherapp.R;
import com.darshit.androidweatherapp.entity.LocationObject;

import java.util.List;

public class LocationHolders extends RecyclerView.ViewHolder{

    private static final String TAG = LocationHolders.class.getSimpleName();

    public TextView locationCity;

    public TextView weatherInformation;

    public TextView deleteText;

    public RadioButton selectableRadioButton;

    public LocationHolders(final View itemView, final List<LocationObject> locationObject) {
        super(itemView);
        locationCity = (TextView) itemView.findViewById(R.id.city_location);
        weatherInformation = (TextView)itemView.findViewById(R.id.temp_info);
        selectableRadioButton = (RadioButton)itemView.findViewById(R.id.radio_button);
        deleteText = (TextView)itemView.findViewById(R.id.delete_row);
        deleteText.setTextColor(Color.RED);

    }
}
