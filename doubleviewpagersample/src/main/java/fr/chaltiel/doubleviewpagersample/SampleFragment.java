package fr.chaltiel.doubleviewpagersample;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.chaltiel.doublefragmentviewpager.adapters.VerticalPagerAdapter;
import fr.chaltiel.doublefragmentviewpager.fragments.BaseChildFragment;

/**
 * Fragment Enfant = mouvement vertical
 */
public class SampleFragment extends BaseChildFragment {
    public final static String TAG = "CHILD_FRAGMENT";
    private final static String MODULO_VERT = "modulo_vert";
    private final static String MODULO_HORIZ = "modulo_horiz";

    private static List<VerticalPagerAdapter> verticalAdapters;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rtn = inflater.inflate(R.layout.sample_fragment, container, false);
//            View rtn = inflater.inflate(R.layout.dummy_fragment, null, true); //TODO fait la même chose, à voir qui consomme le moins
        TextView tv = (TextView) rtn.findViewById(R.id.dummy1);
        TextView tv2 = (TextView) rtn.findViewById(R.id.dummy2);
        Bundle args = getArguments();
//        GraphModel model = new GraphModel();
//        model.get
        int modulohorizs = args.getInt(MODULO_HORIZ);
        int moduloVERT = args.getInt(MODULO_VERT);
        tv.setText("horizontal = " + modulohorizs);
        tv2.setText("vertical = " + moduloVERT);
        return rtn;
    }


    public static Fragment newInstance(int horiz, int vert) {
        SampleFragment rtn = new SampleFragment();
        Bundle args = new Bundle();
        args.putString(TAG, "GraphFragment : H="+horiz+", V="+vert);
        args.putInt(MODULO_HORIZ, horiz);
        args.putInt(MODULO_VERT, vert);
        rtn.setArguments(args);
        return rtn;
    }

    public static List<VerticalPagerAdapter> getVerticalPagerAdapterList(Context ctx, FragmentManager fm) {
//        if (verticalAdapters == null) {
        Class<SampleFragment> fragClass = SampleFragment.class;
        verticalAdapters = new ArrayList<>();
//            List<VerticalPagerAdapter> verticalAdapters = new ArrayList<>();
        verticalAdapters.add(new VerticalPagerAdapter(fm, 0, 3, fragClass));
        verticalAdapters.add(new VerticalPagerAdapter(fm, 1, 2, fragClass));
        verticalAdapters.add(new VerticalPagerAdapter(fm, 2, 3, fragClass));
        verticalAdapters.add(new VerticalPagerAdapter(fm, 3, 2, fragClass));
        verticalAdapters.add(new VerticalPagerAdapter(fm, 4, 2, fragClass));
//            Log.d("Dan", "Model (23) - getVerticalPagerAdapterList: verticalAdapters null =" + verticalAdapters.size());
//        }else
//            Log.d("Dan", "Model (23) - getVerticalPagerAdapterList: verticalAdapters not null =" + verticalAdapters.size());
        return verticalAdapters;
    }
}
