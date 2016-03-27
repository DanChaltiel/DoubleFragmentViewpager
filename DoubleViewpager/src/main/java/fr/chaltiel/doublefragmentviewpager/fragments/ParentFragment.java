package fr.chaltiel.doublefragmentviewpager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Method;
import java.util.ArrayList;

import fr.chaltiel.doublefragmentviewpager.R;
import fr.chaltiel.doublefragmentviewpager.adapters.VerticalPagerAdapter;
import fr.chaltiel.doublefragmentviewpager.pagers.VerticalViewPager;


/**
 * Parent Fragment, horizontal movements only, holds the Child Fragment inside {@link fr.chaltiel.doublefragmentviewpager.pagers.VerticalViewPager a vertical Viewpager}
 */
public class ParentFragment extends Fragment {
    public final static String TAG = "PARENT_FRAGMENT";
    private final static String MODULO_HORIZ = "modulo_horiz";
    private final static String CHILD_CLASS = "child_class";

    public static ParentFragment newInstance(int horiz, Class<? extends Fragment> childClass) {
        ParentFragment rtn = new ParentFragment();
        Bundle args = new Bundle();
        args.putString(TAG, "ParentFragment : H=" + horiz);
        args.putSerializable(CHILD_CLASS, childClass);
        args.putInt(MODULO_HORIZ, horiz);
        rtn.setArguments(args);
        return rtn;
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View layout = inflater.inflate(R.layout.child_viewpager, container, false);
        final VerticalViewPager childVP = (VerticalViewPager) layout.findViewById(R.id.vvp);
        int position = getArguments().getInt(MODULO_HORIZ);
        Class childClass = (Class) getArguments().getSerializable(CHILD_CLASS);

        try {
            assert childClass != null;//just remove the warning
            Method m = childClass.getDeclaredMethod("getVerticalPagerAdapterList", FragmentManager.class);
            ArrayList<VerticalPagerAdapter> adapterList = (ArrayList<VerticalPagerAdapter>) m.invoke(null, getChildFragmentManager());
            final VerticalPagerAdapter adapter = adapterList.get(position);
            childVP.setAdapter(adapter);
        } catch (Exception e) {//actually NoSuchMethodException, InvocationTargetException or IllegalAccessException, but multicatch require API19
            Log.d("Dan", "VerticalPagerAdapter onCreateView : ", e);
        }

        childVP.setTag(TAG + "_" + position);
        return layout;
    }
}
