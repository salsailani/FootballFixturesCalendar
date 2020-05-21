package com.example.sportsappnav;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;


public class FirstFragment extends Fragment {

    PremierLeague premierLeague;
    Bundesliga bundesliga;
    Eredivisie eredivisie;
    LaLiga laLiga;
    LigaMX ligaMX;
    MajorLeagueSoccer majorLeagueSoccer;
    SerieA serieA;

    public FirstFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_first, container, false);

        //fill spinner from string.xml
        Spinner spinner = (Spinner) view.findViewById(R.id.teams_spinner);

        premierLeague = new PremierLeague();
        bundesliga = new Bundesliga();
        eredivisie = new Eredivisie();
        laLiga = new LaLiga();
        ligaMX = new LigaMX();
        majorLeagueSoccer = new MajorLeagueSoccer();
        serieA = new SerieA();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.teams_array));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        setFragment(premierLeague);
                        break;
                    case 1:
                        setFragment(bundesliga);
                        break;
                    case 2:
                        setFragment(laLiga);
                        break;
                    case 3:
                        setFragment(eredivisie);
                        break;
                    case 4:
                        setFragment(serieA);
                        break;
                    case 5:
                        setFragment(majorLeagueSoccer);
                        break;
                    case 6:
                        setFragment(ligaMX);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        return view;
    }

   public void setFragment(Fragment fragment){
       FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
       fragmentTransaction.replace(R.id.main_frame, fragment);
       fragmentTransaction.commit();
   }

}
