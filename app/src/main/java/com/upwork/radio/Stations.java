package com.upwork.radio;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Stations extends AppCompatActivity implements ExpandableListView.OnChildClickListener {

    int continent = First.ContinentID;
    public static   String URL=null;
    ExpandableListAdapter listAdapter ;
    ExpandableListView expListView ;

    int themeid=Setting.ThemeID;

    int LanguageID=Setting.Language;

    List<String> listDataHeader ;
    HashMap<String, List<String>> listDataChild ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(LanguageID==1)
        {
            String languageToLoad  = "en"; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());

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

        }
        setContentView(R.layout.activity_stations);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.ex);

        ConstraintLayout cl = (ConstraintLayout)findViewById(R.id.activity_stations);

        if(themeid==1)
        {
            cl.setBackgroundResource(R.drawable.help_main_bg);
        }
        else
        {
            cl.setBackgroundResource(R.drawable.bgg);
        }



        // preparing list data
        if (continent==1){
            prepareListDataForAfrica();
        }
        else if(continent==2){
            prepareListDataForAsia();
        }
        else if(continent==3){
            prepareListDataForEurope();
        }
        else if(continent==4){
            prepareListDataForSouthAmerica();
        }
        else if(continent==5){
            prepareListDataForNorthAmerica();
        }

        // preparing list Adapters
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild ,themeid);

        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(this);

    }



//////////////  List Setup For Continents //////////////
    private void prepareListDataForEurope() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(getString(R.string.Europe_List_header1));
        listDataHeader.add(getString(R.string.Europe_List_header2));
        listDataHeader.add(getString(R.string.Europe_List_header3));
        listDataHeader.add(getString(R.string.Europe_List_header4));
        listDataHeader.add(getString(R.string.Europe_List_header5));

        // Adding child data
        List<String> SectionOne = new ArrayList<String>();
        SectionOne.add(getString(R.string.Europe_List_child1_subject1)  + "Music");
        SectionOne.add(getString(R.string.Europe_List_child1_subject2) +" Music");
        SectionOne.add(getString(R.string.Europe_List_child1_subject3) +" News/Talk/Sport");



        List<String> SectionTwo = new ArrayList<String>();
        SectionTwo.add(getString(R.string.Europe_List_child2_subject1)  + "- Classical ");
        SectionTwo.add(getString(R.string.Europe_List_child2_subject2)  + " - News/talk/sports");
        SectionTwo.add(getString(R.string.Europe_List_child2_subject3)  + "  - Sports/News");
        SectionTwo.add(getString(R.string.Europe_List_child2_subject4)  + " - News/music/features");


        List<String> SectionThree = new ArrayList<String>();
        SectionThree.add(getString(R.string.Europe_List_child3_subject1)  + " - Music");
        SectionThree.add(getString(R.string.Europe_List_child3_subject2)  + " - News");
        SectionThree.add(getString(R.string.Europe_List_child3_subject3)  + " - News/Music");

        List<String> SectionFour = new ArrayList<String>();
        SectionFour.add(getString(R.string.Europe_List_child4_subject1)  + " - Jazz");
        SectionFour.add(getString(R.string.Europe_List_child4_subject2)  + " - News");
        SectionFour.add(getString(R.string.Europe_List_child4_subject3)  + " - Sports/News");

        List<String> SectionFive = new ArrayList<String>();
        SectionFive.add(getString(R.string.Europe_List_child5_subject1)  + " - Music");
        SectionFive.add(getString(R.string.Europe_List_child5_subject2)  + " - News ");
        SectionFive.add(getString(R.string.Europe_List_child5_subject3)  + " - Pop");

        listDataChild.put(listDataHeader.get(0), SectionOne); // Header, Child data
        listDataChild.put(listDataHeader.get(1), SectionTwo);
        listDataChild.put(listDataHeader.get(2), SectionThree);
        listDataChild.put(listDataHeader.get(3), SectionFour);
        listDataChild.put(listDataHeader.get(4), SectionFive);
    }        //
    private void prepareListDataForAfrica() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(getString(R.string.Africa_List_header1));
        listDataHeader.add(getString(R.string.Africa_List_header2));
        listDataHeader.add(getString(R.string.Africa_List_header3));
        listDataHeader.add(getString(R.string.Africa_List_header4));
        listDataHeader.add(getString(R.string.Africa_List_header5));

        // Adding child data
        List<String> SectionOne = new ArrayList<String>();
        SectionOne.add(getString(R.string.Africa_List_child1_subject1)+ " - Music");
        SectionOne.add(getString(R.string.Africa_List_child1_subject1)+" -  Mix");
        SectionOne.add(getString(R.string.Africa_List_child1_subject1)+" - Aures");


        List<String> SectionTwo = new ArrayList<String>();
        SectionTwo.add(getString(R.string.Africa_List_child2_subject1)+"  - Mix");
        SectionTwo.add(getString(R.string.Africa_List_child2_subject2)+" - Music");
        SectionTwo.add(getString(R.string.Africa_List_child2_subject3)+" - old Music");
        SectionTwo.add(getString(R.string.Africa_List_child2_subject4)+" - Music");
        SectionTwo.add(getString(R.string.Africa_List_child2_subject5)+" - Music");
        SectionTwo.add(getString(R.string.Africa_List_child2_subject6)+" - Mix");
        SectionTwo.add(getString(R.string.Africa_List_child2_subject7)+" - Religion");


        List<String> SectionThree = new ArrayList<String>();
        SectionThree.add(getString(R.string.Africa_List_child3_subject1)+" - Mix");
        SectionThree.add(getString(R.string.Africa_List_child3_subject2)+" - Music");



        List<String> SectionFour = new ArrayList<String>();
        SectionFour.add(getString(R.string.Africa_List_child4_subject1)+" - Mix");
        SectionFour.add(getString(R.string.Africa_List_child4_subject2)+" - Music");


        List<String> SectionFive = new ArrayList<String>();
        SectionFive.add(getString(R.string.Africa_List_child5_subject1)+" - Music");
        SectionFive.add(getString(R.string.Africa_List_child5_subject2)+"  - Music");
        SectionFive.add(getString(R.string.Africa_List_child5_subject3)+" - Mix");

        listDataChild.put(listDataHeader.get(0), SectionOne); // Header, Child data
        listDataChild.put(listDataHeader.get(1), SectionTwo);
        listDataChild.put(listDataHeader.get(2), SectionThree);
        listDataChild.put(listDataHeader.get(3), SectionFour);
        listDataChild.put(listDataHeader.get(4), SectionFive);
    }        //
    private void prepareListDataForAsia() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(getString(R.string.Asia_List_header1));
        listDataHeader.add(getString(R.string.Asia_List_header2));
        listDataHeader.add(getString(R.string.Asia_List_header3));
        listDataHeader.add(getString(R.string.Asia_List_header4));
        listDataHeader.add(getString(R.string.Asia_List_header5));

        // Adding child data
        List<String> SectionOne = new ArrayList<String>();
        SectionOne.add(getString(R.string.Asia_List_child1_subject1) + " - Music");
        SectionOne.add(getString(R.string.Asia_List_child1_subject2) +" - Mix");




        List<String> SectionTwo = new ArrayList<String>();
        SectionTwo.add(getString(R.string.Asia_List_child2_subject1) +"  - Music");
        SectionTwo.add(getString(R.string.Asia_List_child2_subject2) +" - Mix");


        List<String> SectionThree = new ArrayList<String>();
        SectionThree.add(getString(R.string.Asia_List_child3_subject1) +" - Music");
        SectionThree.add(getString(R.string.Asia_List_child3_subject2) +" - Mix");


        List<String> SectionFour = new ArrayList<String>();
        SectionFour.add(getString(R.string.Asia_List_child4_subject1) +" - Music");
        SectionFour.add(getString(R.string.Asia_List_child4_subject2) +" - Mix");


        List<String> SectionFive = new ArrayList<String>();
        SectionFive.add(getString(R.string.Asia_List_child5_subject1) +" - Mix");
        SectionFive.add(getString(R.string.Asia_List_child5_subject2) +" - Mix");


        listDataChild.put(listDataHeader.get(0), SectionOne); // Header, Child data
        listDataChild.put(listDataHeader.get(1), SectionTwo);
        listDataChild.put(listDataHeader.get(2), SectionThree);
        listDataChild.put(listDataHeader.get(3), SectionFour);
        listDataChild.put(listDataHeader.get(4), SectionFive);
    }          //
    private void prepareListDataForSouthAmerica() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(getString(R.string.SouthAmerica_List_header1));
        listDataHeader.add(getString(R.string.SouthAmerica_List_header2));
        listDataHeader.add(getString(R.string.SouthAmerica_List_header3));
        listDataHeader.add(getString(R.string.SouthAmerica_List_header4));


        // Adding child data
        List<String> SectionOne = new ArrayList<String>();
        SectionOne.add(getString(R.string.SouthAmerica_List_child1_subject1)+" - Music");
        SectionOne.add(getString(R.string.SouthAmerica_List_child1_subject2)+" - News");
        SectionOne.add(getString(R.string.SouthAmerica_List_child1_subject3)+" - Sport");



        List<String> SectionTwo = new ArrayList<String>();
        SectionTwo.add(getString(R.string.SouthAmerica_List_child2_subject1)+" - Mix");
        SectionTwo.add(getString(R.string.SouthAmerica_List_child2_subject2)+" - Music");
        SectionTwo.add(getString(R.string.SouthAmerica_List_child2_subject3)+" - Mix ");



        List<String> SectionThree = new ArrayList<String>();
        SectionThree.add(getString(R.string.SouthAmerica_List_child3_subject1)+" - Music");
        SectionThree.add(getString(R.string.SouthAmerica_List_child3_subject2)+" - Mix");
        SectionThree.add(getString(R.string.SouthAmerica_List_child3_subject3)+" - Music");

        List<String> SectionFour = new ArrayList<String>();
        SectionFour.add(getString(R.string.SouthAmerica_List_child4_subject1)+" - Mix ");
        SectionFour.add(getString(R.string.SouthAmerica_List_child4_subject2)+" - sport");




        listDataChild.put(listDataHeader.get(0), SectionOne); // Header, Child data
        listDataChild.put(listDataHeader.get(1), SectionTwo);
        listDataChild.put(listDataHeader.get(2), SectionThree);
        listDataChild.put(listDataHeader.get(3), SectionFour);

    }  //
    private void prepareListDataForNorthAmerica() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add(getString(R.string.NorthAmerica_List_header1));
        listDataHeader.add(getString(R.string.NorthAmerica_List_header2));
        listDataHeader.add(getString(R.string.NorthAmerica_List_header3));



        // Adding child data
        List<String> SectionOne = new ArrayList<String>();
        SectionOne.add(getString(R.string.NorthAmerica_List_child1_subject1)+" - Music");
        SectionOne.add(getString(R.string.NorthAmerica_List_child1_subject2)+" - News");
        SectionOne.add(getString(R.string.NorthAmerica_List_child1_subject3)+" - Sports");



        List<String> SectionTwo = new ArrayList<String>();
        SectionTwo.add(getString(R.string.NorthAmerica_List_child2_subject1)+" - Mix");



        List<String> SectionThree = new ArrayList<String>();
        SectionThree.add(getString(R.string.NorthAmerica_List_child3_subject1)+" - News  ");
        SectionThree.add(getString(R.string.NorthAmerica_List_child3_subject2)+" - Mix");




        listDataChild.put(listDataHeader.get(0), SectionOne); // Header, Child data
        listDataChild.put(listDataHeader.get(1), SectionTwo);
        listDataChild.put(listDataHeader.get(2), SectionThree);

    }  //
///////////////////////////////////////////////////////////


// Set URL's When List Child Item is Clicked //////////////////////////////////////////////////////////////////
    @Override                                                                                                 //
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
        if (continent == 3)
        {
            if (i == 0 && i1 == 0) {
                URL = "http://media-the.musicradio.com:80/CapitalMP3";

            } else if (i == 0 && i1 == 1) {
                URL = "http://bbcmedia.ic.llnwd.net/stream/bbcmedia_radio3_mf_p";
            } else if (i == 0 && i1 == 2) {
                URL = "http://bbcmedia.ic.llnwd.net/stream/bbcmedia_radio5live_mf_p";
            } else if (i == 1 && i1 == 0) {
                URL = "http://catclassica.ccma.audioemotion.stream.flumotion.com/ccma/catclassica.mp3";
            } else if (i == 1 && i1 == 1) {
                URL = "http://19393.live.streamtheworld.com:80/CADENASER_SC";
            } else if (i == 1 && i1 == 2) {
                URL = "http://195.55.74.206/cope/net1.mp3";
            } else if (i == 1 && i1 == 3) {
                URL = "http://radio4.rtveradio.cires21.com/radio4/mp3/icecast.audio";
            } else if (i == 2 && i1 == 0) {
                URL = "http://138.201.252.60/alsterradio_128";
            } else if (i == 2 && i1 == 1) {
                URL = "http://br-mp3-b5aktuell-s.akacast.akamaistream.net/7/773/142694/v1/gnl.akacast.akamaistream.net/br_mp3_b5aktuell_s";
            } else if (i == 2 && i1 == 2) {
                URL = "http://wdr-5.akacast.akamaistream.net/7/41/119439/v1/gnl.akacast.akamaistream.net/wdr-5";
            } else if (i == 3 && i1 == 0) {
                URL = "http://jazzradio.ice.infomaniak.ch/jazzradio-high.mp3";
            } else if (i == 3 && i1 == 1) {
                URL = "http://chai5she.cdn.dvmr.fr/franceinfo-midfi.mp3?ID=f9fbk29m84";
            } else if (i == 3 && i1 == 2) {
                URL = "http://icepe12.infomaniak.ch/start-sud-high.mp3";
            } else if (i == 4 && i1 == 0) {
                URL = "http://icy.unitedradio.it/VirginRock80.mp3";
            } else if (i == 4 && i1 == 1) {
                URL = "http://icestreaming.rai.it/1.mp3";
            } else if (i == 4 && i1 == 2) {
                URL = "http://wradio.msf.ticdn.it/r101_mp3";
            }
        }



        else if(continent==1)
        {
            if (i == 0 && i1 == 0) {
                URL = "http://radio-dzair.net:8000/stream/1/";
            } else if (i == 0 && i1 == 1) {
                URL = "http://streaming.radionomy.com/chaabi-fm";
            } else if (i == 0 && i1 == 1) {
                URL = "http://streaming.radionomy.com/chaabi-fm";
            } else if (i == 1 && i1 == 0) {
                URL = "http://178.214.74.22:8000/steam";
            } else if (i == 1 && i1 == 1) {
                URL = "http://192.184.9.81:8416/;stream/1";
            } else if (i == 1 && i1 == 2) {
                URL = "http://192.184.9.81:8204/;stream/1";
            } else if (i == 1 && i1 == 3) {
                URL = "http://192.184.9.81:8246/;stream/1";
            } else if (i == 1 && i1 == 4) {
                URL = "http://ice33.securenetsystems.net/NOGOUM";
            } else if (i == 1 && i1 == 5) {
                URL = "http://live.alhayafm.com:8000";
            } else if (i == 1 && i1 == 6) {
                URL = "http://images.listenarabic.com/asx/jebril_radio.ram";
            } else if (i == 2 && i1 == 0) {
                URL = "http://broadcaster.infomaniak.ch/aswat-high.mp3";
            } else if (i == 2 && i1 == 1) {
                URL = "http://hitradio-maroc.ice.infomaniak.ch/hitradio-maroc-128.mp3";
            } else if (i == 3 && i1 == 0) {
                URL = "http://197.234.80.70:8000/stream";
            } else if (i == 3 && i1 == 1) {
                URL = "http://capeant.antfarm.co.za:8000/ClassicFM";
            } else if (i == 4 && i1 == 0) {
                URL = "http://193.95.93.29:8080/";
            } else if (i == 4 && i1 == 1) {
                URL = "http://streaming2.toutech.net:8000/jawharafm";
            } else if (i == 4 && i1 == 2) {
                URL = "http://stream8.tanitweb.com/capfm";
            }
        }



        if (continent == 2) {
            if (i == 0 && i1 == 0) {
                URL = "http://sc.apple-fm.net:9020";
            } else if (i == 0 && i1 == 1) {
                URL = "http://gfm.rastream.com/gfm-asiahitz";
            } else if (i == 1 && i1 == 0) {
                URL = "http://radio.dj-gaurav.com:8035";
            } else if (i == 1 && i1 == 1) {
                URL = "http://72.167.40.178:8211";
            } else if (i == 2 && i1 == 0) {
                URL = "http://itori.animenfo.com:443";
            } else if (i == 2 && i1 == 1) {
                URL = "http://tokyofmworld.leanstream.co/JOAUFM-MP3";
            } else if (i == 3 && i1 == 0) {
                URL = "http://audiostreaming.itworkscdn.com:9030/stream";
            } else if (i == 3 && i1 == 1) {
                URL = "http://209.133.216.3:7003/live";
            } else if (i == 4 && i1 == 0) {
                URL = "http://playerservices.streamtheworld.com/api/livestream-redirect/ADCFM.mp3";
            } else if (i == 4 && i1 == 1) {
                URL = "http://208.80.52.96/ABU_DHABI.mp3";
            }

        }

            if(continent==4)
            {
                if (i == 0 & i1 == 0) {
                    URL = "http://streaming.radiolinksmedia.com:8484";
                } else if (i == 0 && i1 == 1) {
                    URL = "http://200.58.101.247:8190";
                } else if (i == 0 && i1 == 2) {
                    URL = "http://radio.bvconline.com.ar:8008";
                } else if (i == 1 & i1 == 0) {
                    URL = "http://st7.radiola.mobi:8008/128kbps/67E311D0JF5HM18182L1AD";
                } else if (i == 1 && i1 == 1) {
                    URL = "http://192.198.204.194:9020/stream";
                } else if (i == 1 && i1 == 2) {
                    URL = "http://midia.ac.gov.br/aldeiafm";
                } else if (i == 2 & i1 == 0) {
                    URL = "http://stream5.eltelon.com/alborada.aac";
                } else if (i == 2 && i1 == 1) {
                    URL = "http://stream5.eltelon.com/centro.aac";
                } else if (i == 2 && i1 == 2) {
                    URL = "http://stream5.eltelon.com/el-conquistador-santiago.aac";
                } else if (i == 3 & i1 == 0) {
                    URL = "http://195.154.217.185:9982/";
                } else if (i == 3 && i1 == 1) {
                    URL = "http://streaming.espectador.com/envivo";
                }



            }


            if(continent==5) {

                if (i == 0 && i1 == 0) {
                    URL = "http://5.152.208.98:8058/";
                } else if (i == 0 && i1 == 1) {
                    URL = "http://newcap.leanstream.co/CFCBAM-MP3";
                } else if (i == 0 && i1 == 2) {
                    URL = "http://icecast-cklx.rncm.ca/cklx.mp3";
                }


                if (i == 1 && i1 == 0) {
                    URL = "http://ice21.securenetsystems.net/F21AAC";

                }


                if (i == 2 && i1 == 0) {
                    URL = "http://wnycam.streamguys.com/wnycam.aac";
                } else if (i == 2 && i1 == 1) {
                    URL = "http://wber-ice-encoder.monroe.edu:80/wber-high.mp3";
                }

            }


        Intent intent = new Intent(Stations.this , RadioMediaPlayer.class);
        startActivity(intent);
        return false;
    }//
}                                                                                                             //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
