package com.proyecto.proyecto_clase;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

public class MainSprint extends AppCompatActivity {


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sprint);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }



    public static class frgev1 extends Fragment {

        Button boton1, btcalent1;
        private static final String ARG_SECTION_NUMBER = "section_number";

        public frgev1() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static frgev1 newInstance(int sectionNumber) {
            frgev1 fragment = new frgev1();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frgev1, container, false);
            boton1 =(Button)rootView.findViewById(R.id.btempezarev1);
            boton1.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent i= new Intent(getActivity(), MainEv1.class);
                    startActivity(i);
                }
            });
            btcalent1 =(Button)rootView.findViewById(R.id.butcalen1);
            btcalent1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Creamos el Intent
                    Intent inte = new Intent(getActivity(), MainCalentamiento.class);
                    //Iniciamos la nueva actividad
                    startActivity(inte);
                }
            });

            return rootView;
        }
    }
    public static class frgev2 extends Fragment {
        Button boton, btcalent2;

        private static final String ARG_SECTION_NUMBER = "section_number";

        public frgev2() {
        }

        public static frgev2 newInstance(int sectionNumber) {
            frgev2 fragment = new frgev2();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frgev2, container, false);
            boton =(Button)rootView.findViewById(R.id.btempezarev2);
            boton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent i= new Intent(getActivity(), MainEv2.class);
                    startActivity(i);
                }
            });
            btcalent2 =(Button)rootView.findViewById(R.id.butcalen2);
            btcalent2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Creamos el Intent
                    Intent inte = new Intent(getActivity(), MainCalentamiento.class);
                    //Iniciamos la nueva actividad
                    startActivity(inte);
                }
            });

            return rootView;
        }
    }
    public static class frgev3 extends Fragment {
        Button boton3, btcalent3;

        private static final String ARG_SECTION_NUMBER = "section_number";

        public frgev3() {
        }

        public static frgev3 newInstance(int sectionNumber) {
            frgev3 fragment = new frgev3();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.frgev3, container, false);
            boton3 =(Button)rootView.findViewById(R.id.btempezarev3);
            boton3.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent i= new Intent(getActivity(), MainEv3.class);
                    startActivity(i);
                }
            });
            btcalent3 =(Button)rootView.findViewById(R.id.butcalen3);
            btcalent3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Creamos el Intent
                    Intent inte = new Intent(getActivity(), MainCalentamiento.class);
                    //Iniciamos la nueva actividad
                    startActivity(inte);
                }
            });

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return frgev1.newInstance(position + 1);
                case 1:
                    return frgev2.newInstance(position + 1);
                case 2:
                    return frgev3.newInstance(position + 1);
            }
            return null;

        }

        @Override
        public int getCount() {

            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Ejercicios de velocidad 1";
                case 1:
                    return "Ejercicios de velocidad 2";
                case 2:
                    return "Ejercicios de velocidad 3";
            }
            return null;
        }
    }
}
