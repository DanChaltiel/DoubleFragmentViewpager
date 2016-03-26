package fr.chaltiel.doublefragmentviewpager.pagers;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import fr.chaltiel.doublefragmentviewpager.fragments.ParentFragment;


public class HorizontalViewPager extends ViewPager {

    public HorizontalViewPager(Context context) {
        super(context);
    }

    public HorizontalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void goNorth(){
        getVerticalViewPager().setCurrentItem(getVerticalViewPager().getCurrentItem()-1);
    }
    public void goSouth(){
        getVerticalViewPager().setCurrentItem(getVerticalViewPager().getCurrentItem()+1);
    }
    public void goEast(boolean reset){
        int vertCurrent = getVerticalViewPager().getCurrentItem();
        setCurrentItem(getCurrentItem()+1);
        if (!reset) {
            getVerticalViewPager().setCurrentItem(vertCurrent);
        }// TODO: 25/03/2016 no vertical animation if reset (else it causes a weird diagonal animation)
    }
    public void goWest(boolean reset){
        int vertCurrent = getVerticalViewPager().getCurrentItem();
        setCurrentItem(getCurrentItem()-1);
        if (!reset) {
            getVerticalViewPager().setCurrentItem(vertCurrent);
        }
    }

    private VerticalViewPager getVerticalViewPager() {
        return (VerticalViewPager) this.findViewWithTag(ParentFragment.TAG +"_"+ this.getCurrentItem());
    }
}