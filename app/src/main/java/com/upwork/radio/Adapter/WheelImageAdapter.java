package com.upwork.radio.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.upwork.radio.Data.ImageData;
import com.upwork.radio.R;

import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

/**
 * Created by KeMoOo on 4/12/2017.
 */

public class WheelImageAdapter extends CursorWheelLayout.CycleWheelAdapter {

    Context c ;
    List<ImageData> menuItems;
    LayoutInflater inflater;


    public WheelImageAdapter(Context c, List<ImageData> menuItems) {
        this.c = c;
        this.menuItems = menuItems;
        inflater= LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public View getView(View parent, int position) {
        ImageData data = getItem(position);
        View Root= inflater.inflate(R.layout.wheel_image_layout  , null , false);
        ImageView imageView = (ImageView)Root.findViewById(R.id.Wheel_image_menu_item);
        imageView.setImageResource(data.ImageRecourse);
        return  Root;
    }

    @Override
    public ImageData getItem(int position) {
        return menuItems.get(position);
    }
}
