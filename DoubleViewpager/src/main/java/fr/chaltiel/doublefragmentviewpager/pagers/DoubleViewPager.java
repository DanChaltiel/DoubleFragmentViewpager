package fr.chaltiel.doublefragmentviewpager.pagers;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import fr.chaltiel.doublefragmentviewpager.fragments.ParentFragment;

/**
 * Normal horizontal ViewPager, with some handy custom methods
 */
public class DoubleViewPager extends ViewPager {

    public DoubleViewPager(Context context) {
        super(context);
    }

    public DoubleViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Programmatically do a vertical swipe to the top
     */
    public void goNorth(){
        getVerticalViewPager().setCurrentItem(getVerticalViewPager().getCurrentItem()-1);
    }

    /**
     * Programmatically do a vertical swipe to the bottom
     */
    public void goSouth(){
        getVerticalViewPager().setCurrentItem(getVerticalViewPager().getCurrentItem()+1);
    }


    /**
     * Programmatically do an horizontal swipe to the right
     * @param resetVertical set true if you want the vertical viewpager to rest to zero when you swipe horizontally
     */
    public void goEast(boolean resetVertical){
        // TODO: no vertical animation if reset (else it causes a weird diagonal animation)
        // TODO: implement the resetVertical on swipe !
        int vertCurrent = getVerticalViewPager().getCurrentItem();
        setCurrentItem(getCurrentItem()+1);
        if (!resetVertical) {
            getVerticalViewPager().setCurrentItem(vertCurrent);
        }
    }


    /**
     * Programmatically do an horizontal swipe to the left
     * @param resetVertical set true if you want the vertical viewpager to rest to zero when you swipe horizontally
     */
    public void goWest(boolean resetVertical){
        int vertCurrent = getVerticalViewPager().getCurrentItem();
        setCurrentItem(getCurrentItem()-1);
        if (!resetVertical) {
            getVerticalViewPager().setCurrentItem(vertCurrent);
        }
    }

    public VerticalViewPager getVerticalViewPager() {
        return (VerticalViewPager) this.findViewWithTag(ParentFragment.TAG + "_" + this.getCurrentItem());
    }
}