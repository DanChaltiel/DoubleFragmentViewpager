package fr.chaltiel.doublefragmentviewpager.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import fr.chaltiel.doublefragmentviewpager.adapters.VerticalPagerAdapter;


/**
 * Base class, you have to hide its 2 static methods for the DoubleViewPager to work.
 */
public abstract class BaseChildFragment extends Fragment {

    protected final static String MODULO_VERT = "modulo_vert";
    protected final static String MODULO_HORIZ = "modulo_horiz";

    /**
     * You HAVE TO hide (override) this method !
     * @param horiz the horizontal position of the fragment
     * @param vert the vertical position of the fragment
     * @return the fragment at this position
     */
    @SuppressWarnings("unused")
    public static Fragment newInstance(int horiz, int vert){
        throw new IllegalStateException(
                "\n ------ You have to hide (override) newInstance(int horiz, int vert) in your child class ! ------"
        );}
//

    /**
     * You HAVE TO hide (override) this method !
     * @param fm getChildFragmentManager() or getFragmentManager()
     * @return an arrayList of all the VerticalPagerAdapter
     */
    @SuppressWarnings("unused")
    public static List<VerticalPagerAdapter> getVerticalPagerAdapterList(FragmentManager fm){
        throw new IllegalStateException(
                "\n ------ You have to hide (override) getVerticalPagerAdapterList(Context ctx, FragmentManager fm) in your child class ! ------"
        );}
}
