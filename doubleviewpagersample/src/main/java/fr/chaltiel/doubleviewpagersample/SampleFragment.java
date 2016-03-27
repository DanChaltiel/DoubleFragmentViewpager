package fr.chaltiel.doubleviewpagersample;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.chaltiel.doublefragmentviewpager.adapters.VerticalPagerAdapter;
import fr.chaltiel.doublefragmentviewpager.fragments.BaseChildFragment;

/**
 * Child Fragment, vertical movement inside horizontal movement
 */
public class SampleFragment extends BaseChildFragment {

    private static List<VerticalPagerAdapter> verticalAdapters;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rtn = inflater.inflate(R.layout.sample_fragment, container, false);
        TextView tv = (TextView) rtn.findViewById(R.id.dummy1);
        TextView tv2 = (TextView) rtn.findViewById(R.id.dummy2);
        Bundle args = getArguments();
        int modulohorizs = args.getInt(MODULO_HORIZ);
        int moduloVERT = args.getInt(MODULO_VERT);
        tv.setText(String.format("horizontal = %d", modulohorizs));
        tv2.setText(String.format("vertical = %d", moduloVERT));
        return rtn;
    }


    /**
     * This method hides the one of mother class {@link fr.chaltiel.doublefragmentviewpager.fragments.BaseChildFragment BaseChildFragment}. <br/>
     * Not implementing it would result in an IllegalStateException. <br/>
     * It is static and is called inside {@link fr.chaltiel.doublefragmentviewpager.adapters.VerticalPagerAdapter VerticalPagerAdapter} using reflection, hence the absence of Override and the Unused warning
     *
     * @param horiz the horizontal position in the horizontal adapter
     * @param vert the vertical position in the vertical adapter
     * @return the resulting SampleFragment
     */
    @SuppressWarnings("Unused")
    @SuppressLint("Unused")
    public static Fragment newInstance(int horiz, int vert) {
        SampleFragment rtn = new SampleFragment();
        Bundle args = new Bundle();
        args.putInt(MODULO_HORIZ, horiz);
        args.putInt(MODULO_VERT, vert);
        rtn.setArguments(args);
        return rtn;
    }

    /**
     *
     * This method hides the one of mother class {@link fr.chaltiel.doublefragmentviewpager.fragments.BaseChildFragment BaseChildFragment}. <br/>
     * Not implementing it would result in an IllegalStateException. <br/>
     * It is static and is called inside {@link fr.chaltiel.doublefragmentviewpager.fragments.ParentFragment ParentFragment} using reflection, hence the absence of Override and the Unused warning
     *
     * @param fm getChildFragmentManager()
     * @return the list of {@link VerticalPagerAdapter}s that will build the
     */
    @SuppressWarnings("Unused")
    @SuppressLint("Unused")
    public static List<VerticalPagerAdapter> getVerticalPagerAdapterList(FragmentManager fm) {
        //TODO loading from a static variable doesn't seem to work...
//        if (verticalAdapters == null) {
        Class<SampleFragment> fragClass = SampleFragment.class;
        verticalAdapters = new ArrayList<>();
//        List<VerticalPagerAdapter> verticalAdapters = new ArrayList<>();
        verticalAdapters.add(new VerticalPagerAdapter(fm, 0, 3, fragClass));
        verticalAdapters.add(new VerticalPagerAdapter(fm, 1, 2, fragClass));
        verticalAdapters.add(new VerticalPagerAdapter(fm, 2, 3, fragClass));
        verticalAdapters.add(new VerticalPagerAdapter(fm, 3, 2, fragClass));
        verticalAdapters.add(new VerticalPagerAdapter(fm, 4, 2, fragClass));
            Log.d("Dan", "Model (23) - getVerticalPagerAdapterList: verticalAdapters null =" + verticalAdapters.size());
//        }else
//            Log.d("Dan", "Model (23) - getVerticalPagerAdapterList: verticalAdapters not null =" + verticalAdapters.size());
        return verticalAdapters;
    }
}
