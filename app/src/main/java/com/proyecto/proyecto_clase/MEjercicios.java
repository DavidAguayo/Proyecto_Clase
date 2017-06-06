package com.proyecto.proyecto_clase;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

public class MEjercicios extends AppCompatActivity {

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
        setContentView(R.layout.activity_mejercicios);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);



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
            switch (position) {
                case 0:
                    TabAbdomen frej_abdomen=new TabAbdomen();
                    return frej_abdomen;
                case 1:
                    TabBrazos frej_brazos=new TabBrazos();
                    return frej_brazos;
                case 2:
                    TabPiernas frej_piernas=new TabPiernas();
                    return frej_piernas;
                case 3:
                    TabEspalda frej_espalda=new TabEspalda();
                    return frej_espalda;
                case 4:
                    TabPectorales frej_pectorales=new TabPectorales();
                    return frej_pectorales;
                case 5:
                    TabPectorales frej2_pectorales=new TabPectorales();
                    return frej2_pectorales;
            }
            return null;
        }

        @Override
        public int getCount() {
            // cantidad de fragments
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Abdomen";
                case 1:
                    return "Brazos";
                case 2:
                    return "Piernas";
                case 3:
                    return "Espalda";
                case 4:
                    return "peee";
                case 5:
                    return "peee";
            }
            return null;
        }
    }
}
