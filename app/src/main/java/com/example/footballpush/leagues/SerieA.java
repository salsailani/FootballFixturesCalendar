package com.example.footballpush.leagues;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Color;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.footballpush.R;
import com.example.footballpush.calendarDialog;
import com.example.footballpush.calendarPush;
import com.example.footballpush.viewNextFixtures;
import com.example.footballpush.viewNextFixturesParams;
import com.squareup.picasso.Picasso;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;


public class SerieA extends Fragment {

    GridLayout mainGrid;
    Integer teamID;
    TextView data;
    View view;
    calendarDialog radio = new calendarDialog();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_serie_a, container, false);



        mainGrid = (GridLayout) view.findViewById(R.id.mainGrid);
        //data = (TextView) view2.findViewById(R.id.textView2);

        setPictures(view);

        //Set Event
        setSingleEvent(mainGrid);



        return view;
    }



    private void setPictures(View view) {
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Logo_of_AC_Milan.svg/1024px-Logo_of_AC_Milan.svg.png").into((ImageView) view.findViewById(R.id.acmilan));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/6/6c/Genoa_C.F.C._logo.svg/1024px-Genoa_C.F.C._logo.svg.png").into((ImageView) view.findViewById(R.id.genoa));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/6/66/AtalantaBC.svg/1024px-AtalantaBC.svg.png").into((ImageView) view.findViewById(R.id.atlanta));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/0/0b/Frosinone_Calcio_logo.svg/1024px-Frosinone_Calcio_logo.svg.png").into((ImageView) view.findViewById(R.id.frosinone));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/5/5b/Bologna_F.C._1909_logo.svg/1024px-Bologna_F.C._1909_logo.svg.png").into((ImageView) view.findViewById(R.id.bologna));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/3/3c/Spal2013_logo.svg/1024px-Spal2013_logo.svg.png").into((ImageView) view.findViewById(R.id.spal));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/f/f0/A.C._ChievoVerona_logo.svg/1024px-A.C._ChievoVerona_logo.svg.png").into((ImageView) view.findViewById(R.id.chievo));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Juventus_FC_2017_logo.svg/1024px-Juventus_FC_2017_logo.svg.png").into((ImageView) view.findViewById(R.id.juventus));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/6/68/Empoli_F.C._logo.svg/1024px-Empoli_F.C._logo.svg.png").into((ImageView) view.findViewById(R.id.empoli));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/6/61/Cagliari_Calcio_1920.svg/1024px-Cagliari_Calcio_1920.svg.png").into((ImageView) view.findViewById(R.id.cagliari));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/c/ce/S.S._Lazio_badge.svg/1024px-S.S._Lazio_badge.svg.png").into((ImageView) view.findViewById(R.id.lazio));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/SSC_Neapel.svg/1024px-SSC_Neapel.svg.png").into((ImageView) view.findViewById(R.id.napoli));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/1/1c/Parma_Calcio_1913_logo.svg/1024px-Parma_Calcio_1913_logo.svg.png").into((ImageView) view.findViewById(R.id.parma));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/c/ce/Udinese_Calcio_logo.svg/1024px-Udinese_Calcio_logo.svg.png").into((ImageView) view.findViewById(R.id.udinese));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/d/d2/U.C._Sampdoria_logo.svg/1024px-U.C._Sampdoria_logo.svg.png").into((ImageView) view.findViewById(R.id.sampdoria));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/ACF_Fiorentina_2.svg/1024px-ACF_Fiorentina_2.svg.png").into((ImageView) view.findViewById(R.id.fiorentina));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/1/1c/US_Sassuolo_Calcio_logo.svg/1024px-US_Sassuolo_Calcio_logo.svg.png").into((ImageView) view.findViewById(R.id.sassuolo));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/FC_Internazionale_Milano_2014.svg/1024px-FC_Internazionale_Milano_2014.svg.png").into((ImageView) view.findViewById(R.id.inter));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/2/2e/Torino_FC_Logo.svg/1024px-Torino_FC_Logo.svg.png").into((ImageView) view.findViewById(R.id.torino));
        Picasso.get().load("https://upload.wikimedia.org/wikipedia/en/thumb/f/f7/AS_Roma_logo_%282017%29.svg/1024px-AS_Roma_logo_%282017%29.svg.png").into((ImageView) view.findViewById(R.id.roma));


    }



    private void setSingleEvent(GridLayout mainGrid) {

        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int[] finalI = {i};
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    final viewNextFixtures viewNextFixtures = new viewNextFixtures();
                    final calendarPush calendar = new calendarPush();
                    int final2;
                    final2 = fetchData(finalI);
                    final Dialog fbDialogue = new Dialog(getContext());
                    //fbDialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(100, 0, 0, 0)));
                    fbDialogue.setContentView(R.layout.add_page);
                    data = fbDialogue.findViewById(R.id.textView2);
                    data.setTextColor(Color.rgb(0,0,0));
                    fbDialogue.show();
                    fbDialogue.setCancelable(true);
                    fbDialogue.setCanceledOnTouchOutside(true);
                    viewNextFixturesParams params = new viewNextFixturesParams(getContext(), final2, data);
                    viewNextFixtures.execute(params);
                    Button btnsubmit = (Button) fbDialogue.findViewById(R.id.btn_submit);
                    btnsubmit.setOnClickListener(new View.OnClickListener() {

                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void onClick(View v) {
                            String[] PERMISSIONS = {
                                    Manifest.permission.READ_CALENDAR,
                                    Manifest.permission.WRITE_CALENDAR,
                            };

                            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED ) {
                                ActivityCompat.requestPermissions(getActivity(), PERMISSIONS, 1);
                            }
                            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED ){
                                fbDialogue.dismiss();
                                radio.dialogCreate(getContext(), view, viewNextFixtures.returnResultArray(), viewNextFixtures.returnTimeStampArray(), viewNextFixtures.returnVenueArray());
                            }

                        }
                    });
                }
            });

        }
    }

    private int fetchData(int [] finalI){

        Resources r = getResources();

        //card index to teamID (teamID number from APIFootball)

        //ac milan
        if (finalI[0] == 0) {
            return 489;}
        //genoa
        else if (finalI[0] == 1) {
            return 495;}
        //atlanta
        else if (finalI[0] == 2) {
            return 499;}
        //frosinone
        else if (finalI[0] == 3) {
            return 512;}
        //bologna
        else if (finalI[0] == 4) {
            return 500;}
        //spal
        else if (finalI[0] == 5) {
            return 493;}
        //chievo
        else if (finalI[0] == 6) {
            return 491;}
        //juventus
        else if (finalI[0] == 7) {
            return 496;}
        //empoli
        else if (finalI[0] == 8) {
            return  511;}
        //cagliari
        else if (finalI[0] == 9) {
            return 490;}
        //lazio
        else if (finalI[0] == 10) {
            return 487;}
        //napoli
        else if (finalI[0] == 11) {
            return  492;}
        //parma
        else if (finalI[0] == 12) {
            return 523;}
        //udinese
        else if (finalI[0] == 13) {
            return 494;}
        //sampdoria
        else if (finalI[0] == 14) {
            return  498;}
        //fiorentina
        else if (finalI[0] == 15) {
            return 502;}
        //sassuolo
        else if (finalI[0] == 16) {
            return  488;}
        //inter
        else if (finalI[0] == 17) {
            return 505;}
        //torino
        else if (finalI[0] == 18) {
            return  503;}
        //roma
        else if (finalI[0] == 19) {
            return  497;}

        return 100;
    }


}