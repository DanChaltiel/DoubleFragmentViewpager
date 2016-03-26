package fr.chaltiel.doublefragmentviewpager.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class VerticalPagerAdapter extends FragmentStatePagerAdapter {
    private final Class<? extends Fragment> mFragmentClass;
    private int mParent;
    private int mChilds;

    public VerticalPagerAdapter(FragmentManager fm, int parent, int childs, Class<? extends Fragment> fragmentClass){
        super(fm);
        mParent = parent;
        mChilds = childs;
        mFragmentClass = fragmentClass;
    }

    @Override
    public int getCount() {
        return mChilds;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("Dan", "VerticalPagerAdapter (35) - getItem: position=" + position);
        try {
            Method m = mFragmentClass.getDeclaredMethod("newInstance", int.class, int.class);
            return (Fragment) m.invoke(null, mParent, position);
        } catch (NoSuchMethodException e) {
            Log.d("Dan", "VerticalPagerAdapter (51) - getItem : ", e);
        } catch (InvocationTargetException e) {
            Log.d("Dan", "VerticalPagerAdapter (53) - getItem : ", e);
        } catch (IllegalAccessException e) {
            Log.d("Dan", "VerticalPagerAdapter (55) - getItem : ", e);
        }
        throw new NullPointerException("Oups...");
    }
}