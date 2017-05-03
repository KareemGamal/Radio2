package com.upwork.radio;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.upwork.radio.Adapter.WheelImageAdapter;
import com.upwork.radio.Data.ImageData;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import github.hellocsl.cursorwheel.CursorWheelLayout;

/**
 * Created by KeMoOo on 4/19/2017.
 */



public class First extends AppCompatActivity{

    TextView tv , Continents , Label;
    CursorWheelLayout WheelImage_ForFeatures;
    CursorWheelLayout WheelImage_ForContinent;
    List<ImageData> lstImage_ForFeatures;
    List<ImageData> lstImage_ForContinent;

    static int ContinentID=0;
    int ThemeID= Setting.ThemeID;
    int LanguageID=Setting.Language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);


        Label=(TextView)findViewById(R.id.textView2);
        Continents = (TextView)findViewById(R.id.Continent);
        tv = (TextView)findViewById(R.id.done);

        if(LanguageID==1)
        {
            String languageToLoad  = "en"; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());

            Label.setText(getString(R.string.Label));
            Continents.setText(getString(R.string.Selection));
            tv.setText(getString(R.string.Done));
        }

        else
        {
            String languageToLoad  = "ar"; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
            Label.setText(getString(R.string.Label));
            Continents.setText(getString(R.string.Selection));
            tv.setText(getString(R.string.Done));
        }



        initViews();
        loadData();

        ConstraintLayout cs = (ConstraintLayout)findViewById(R.id.activity_first);

        if(ThemeID==1)
        {
            cs.setBackgroundResource(R.drawable.help_main_bg);
        }
        else
        {
            cs.setBackgroundResource(R.drawable.bgg);
        }



        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(First.this , Stations.class);
                startActivity(i);

            }
        });




                WheelImage_ForFeatures.setOnMenuItemClickListener(new CursorWheelLayout.OnMenuItemClickListener() {
                    @Override
                    public void onItemClick(View view, int pos) {
                        if(pos==0)
                        {
                            RelativeLayout rv= (RelativeLayout)findViewById(R.id.Rcontinent);
                            rv.setAlpha(1);
                            tv.setAlpha(1);
                        }
                        if(pos==1)
                        {
                            RelativeLayout rv= (RelativeLayout)findViewById(R.id.Rcontinent);
                            rv.setAlpha(0);
                            tv.setAlpha(0);

                          Intent i = new Intent(First.this , com.upwork.radio.Setting.class);
                            startActivity(i);
                        }
                        if(pos==2)
                        {

                            RelativeLayout rv= (RelativeLayout)findViewById(R.id.Rcontinent);
                            rv.setAlpha(0);
                            tv.setAlpha(0);
                            Intent i = new Intent(First.this , com.upwork.radio.About.class);
                            startActivity(i);
                        }
                    }
                });


        WheelImage_ForContinent.setOnMenuSelectedListener(new CursorWheelLayout.OnMenuSelectedListener() {
            @Override
            public void onItemSelected(CursorWheelLayout parent, View view, int pos) {
                if(pos==0)
                {
                    tv.setEnabled(false);
                    Continents.setText(getString(R.string.Selection));
                }

                if(pos==1){
                    ContinentID=1;
                    Continents.setText(getString(R.string.Selected_Continent_Africa));
                    tv.setEnabled(true);
                }
                if(pos==2){
                    ContinentID=2;
                    Continents.setText(getString(R.string.Selected_Continent_Asia));
                    tv.setEnabled(true);
                }
                if(pos==3){
                    ContinentID=3;
                    Continents.setText(getString(R.string.Selected_Continent_Europe));
                    tv.setEnabled(true);
                }
                if(pos==4){
                    ContinentID=4;
                    Continents.setText(getString(R.string.Selected_Continent_SouthAmerica));
                    tv.setEnabled(true);
                }
                if(pos==5){
                    ContinentID=5;
                    Continents.setText(getString(R.string.Selected_Continent_NorthAmerica));
                    tv.setEnabled(true);
                }

            }
        });




    }

    private void loadData() {

        lstImage_ForFeatures = new ArrayList<ImageData>();
        lstImage_ForFeatures.add(new ImageData(R.drawable.station_icon , "Stations"));
        lstImage_ForFeatures.add(new ImageData(R.drawable.setting_icon , "Setting"));
        lstImage_ForFeatures.add(new ImageData(R.drawable.about_us , "About"));



        lstImage_ForContinent = new ArrayList<ImageData>();
        lstImage_ForContinent.add(new ImageData(R.drawable.pyramids , "Africa"));
        lstImage_ForContinent.add(new ImageData(R.drawable.indian , "Asia"));
        lstImage_ForContinent.add(new ImageData(R.drawable.eiffel_tower , "Europe"));
        lstImage_ForContinent.add(new ImageData(R.drawable.brazil , "South America"));
        lstImage_ForContinent.add(new ImageData(R.drawable.usa , "North America"));

        WheelImageAdapter imageAdapter_ForFeatures = new WheelImageAdapter(getBaseContext() , lstImage_ForFeatures);
        WheelImage_ForFeatures.setAdapter(imageAdapter_ForFeatures);

        WheelImageAdapter imageAdapter_ForContinent = new WheelImageAdapter(getBaseContext() , lstImage_ForContinent);
        WheelImage_ForContinent.setAdapter(imageAdapter_ForContinent);

    }

    private void initViews() {
        WheelImage_ForFeatures = (CursorWheelLayout)findViewById(R.id.test_circle_menu_right);
        WheelImage_ForContinent = (CursorWheelLayout)findViewById(R.id.test_circle_menu_right1);
    }






}




















//public class First extends AppCompatActivity implements View.OnClickListener {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.first);
//
//
//        Button local = (Button)findViewById(R.id.local);
//        local.setOnClickListener(this);
//        Button inter = (Button)findViewById(R.id.inter);
//        inter.setOnClickListener(this);
//
//
////        TabHost tab = getTabHost();
////        tab.addTab(tab.newTabSpec("main").setIndicator("Local Stations").setContent(new Intent(this , Local.class)));
////        tab.addTab(tab.newTabSpec("main").setIndicator("international").setContent(new Intent(this , international.class)));
////        tab.setCurrentTab(0);
//
//    }
//
//    @Override
//    public void onClick(View view) {
//        int id = view.getId();
//        if(id==R.id.local)
//        {
//            Intent i = new Intent(First.this , Local.class);
//            startActivity(i);
//        }
//        if(id==R.id.inter)
//        {
//            Intent i = new Intent(First.this , international.class);
//            startActivity(i);
//        }
//    }
//}
