package adam.drees.gloomhavenmodifiersdeck;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public Deck playerDeck = new Deck();

    private static final String TAG = "MainActivity";

    //Fragment Stuff
    MainFragment frag1 = new  MainFragment();
    HistoryFragment frag2 = new  HistoryFragment();
    ModifyFragment frag3 = new  ModifyFragment();
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        //setup the pager
        setupViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(frag2, "Fragment2");
        adapter.addFragment(frag1, "Fragment1");
        adapter.addFragment(frag3, "Fragment3");
        viewPager.setAdapter(adapter);
        setViewPager(1);
    }

    public void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
    }


    public void sendEvent(String message){
        frag2.insertSingleItem(message);
    }








}



