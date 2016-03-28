package fr.chaltiel.doubleviewpagersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import fr.chaltiel.doublefragmentviewpager.adapters.DoubleFragmentPagerAdapter;
import fr.chaltiel.doublefragmentviewpager.pagers.DoubleViewPager;

public class SampleActivity extends AppCompatActivity implements OnClickListener {

    private DoubleViewPager doubleViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        //setting the DoubleViewPager
        doubleViewPager = (DoubleViewPager) findViewById(R.id.pager);
        DoubleFragmentPagerAdapter doubleViewPagerAdapter = new DoubleFragmentPagerAdapter(
                getSupportFragmentManager(),
                SampleFragment.class
        );
        doubleViewPager.setAdapter(doubleViewPagerAdapter);

        //convenience buttons
        final Button buttons[] = {(Button) findViewById(R.id.buttonE), (Button) findViewById(R.id.buttonN), (Button) findViewById(R.id.buttonS), (Button) findViewById(R.id.buttonW)};
        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonE:
                doubleViewPager.goEast(false);
                break;
            case R.id.buttonW:
                doubleViewPager.goWest(false);
                break;
            case R.id.buttonN:
                doubleViewPager.goNorth();
                break;
            case R.id.buttonS:
                doubleViewPager.goSouth();
                break;
        }
    }
}
