package fr.chaltiel.doublefragmentviewpager.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.lang.reflect.Method;
import java.util.List;

import fr.chaltiel.doublefragmentviewpager.fragments.BaseChildFragment;
import fr.chaltiel.doublefragmentviewpager.fragments.ParentFragment;


/**
 * Adapter Parent = mouvement horizontal
 */
public class DoubleFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private final Class<?extends BaseChildFragment> mChildFragmentClass;
    private final int size;
//    private Context mContext;
    private List<VerticalPagerAdapter> mAdapters;

    public DoubleFragmentPagerAdapter(FragmentManager fm, Context ctx, Class<?extends BaseChildFragment> childFragmentClass) {
        super(fm);
        mChildFragmentClass = childFragmentClass;
        int tSize = -1;
        try {
            Method m = mChildFragmentClass.getDeclaredMethod("getVerticalPagerAdapterList", Context.class, FragmentManager.class);
            List<VerticalPagerAdapter> adapterList = (List<VerticalPagerAdapter>) m.invoke(null, ctx, fm);
            tSize = adapterList.size();
        } catch (Exception e) {
            Log.d("DoubleViewPager", "Exception when invoking getVerticalPagerAdapterList()", e);
        }
        size=tSize;
    }

    @Override
    public Fragment getItem(int hPosition) {
        return ParentFragment.newInstance(hPosition, mChildFragmentClass);
    }

    @Override
    public int getCount() {
        return size;
    }


}