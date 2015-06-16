package com.exia.puydufou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import com.exia.puydufou.Adapter.ViewPagerAdapter;
import com.exia.puydufou.BusinessObject.*;
import com.exia.puydufou.Helper.LayoutHelper;
import com.exia.puydufou.Helper.ViewEnum;
import com.exia.puydufou.Messenger.MessageQueue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CardDetail extends FragmentActivity
{
    private LayoutHelper _layoutHelper = null;
    private ViewPagerAdapter pagerAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ViewEnum typeView = MessageQueue.Instance().RetrievingLastMessage(ViewEnum.class);

        List<Fragment> fragments = null;
        _layoutHelper = new LayoutHelper(this, R.layout.activity_show);

        switch (typeView)
        {
            case Show:
                fragments = new ArrayList<Fragment>();

                fragments.add(CardFragment.newInstance(new SpectacleBU(1, "CardDetail 1", "Petite description 1", "C:/test.png", 7, new Date(1999, 06, 16), 5, new ArrayList<PerformanceBU>(), new ArrayList<RateBU>())));
                fragments.add(CardFragment.newInstance(new SpectacleBU(2, "CardDetail 2", "Petite description 2", "C:/test.png", 25, new Date(1999, 06, 16), 10, new ArrayList<PerformanceBU>(), new ArrayList<RateBU>())));
                fragments.add(CardFragment.newInstance(new SpectacleBU(3, "CardDetail 3", "Petite description 3", "C:/test.png", 10, new Date(1999, 06, 16), 15, new ArrayList<PerformanceBU>(), new ArrayList<RateBU>())));
                break;
            case Restaurant:
                fragments = new ArrayList<Fragment>();

                fragments.add(CardFragment.newInstance(new RestaurantBU(1, "Le petit resto", "Très bon resto !", "3", new ArrayList<MenuBU>())));
                fragments.add(CardFragment.newInstance(new RestaurantBU(2, "Auberge de l'Ill", "Très bon resto !", "4", new ArrayList<MenuBU>())));
                fragments.add(CardFragment.newInstance(new RestaurantBU(3, "Le grand resto", "Très bon resto !", "5", new ArrayList<MenuBU>())));
                break;
            case Shop:
                fragments = new ArrayList<Fragment>();

                fragments.add(CardFragment.newInstance(new ShopBU(1, "L'arnacoeur", "Arnaque sous les yeux", "1", new ArrayList<RateBU>())));
                fragments.add(CardFragment.newInstance(new ShopBU(2, "Le bon plan", "Très réputé", "2", new ArrayList<RateBU>())));
                fragments.add(CardFragment.newInstance(new ShopBU(3, "Guess", "Try it", "7", new ArrayList<RateBU>())));
                break;
        }

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        _layoutHelper.<ViewPager>GetElement(R.id.viewpager_shows).setAdapter(pagerAdapter);

        _layoutHelper.ApplyModifications();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_plan)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //PRIVATE
    private List<Fragment> getFragments(ViewEnum typeView){

        List<Fragment> fList = new ArrayList<Fragment>();

        fList.add(CardFragment.newInstance("Fragment 1"));

        fList.add(CardFragment.newInstance("Fragment 2"));

        fList.add(CardFragment.newInstance("Fragment 3"));

        return fList;

    }

}
