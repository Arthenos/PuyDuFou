package com.exia.puydufou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.exia.puydufou.Adapter.ViewPagerAdapter;
import com.exia.puydufou.Helper.LayoutHelper;

import java.util.ArrayList;
import java.util.List;


public class Show extends FragmentActivity
{
    private LayoutHelper _layoutHelper = null;
    private ViewPagerAdapter showsAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        _layoutHelper = new LayoutHelper(this, R.layout.activity_show);

        List<Fragment> fragments = getFragments();
        showsAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        _layoutHelper.<ViewPager>GetElement(R.id.viewpager_shows).setAdapter(showsAdapter);

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
    private List<Fragment> getFragments(){

        List<Fragment> fList = new ArrayList<Fragment>();

        fList.add(DetailedShow.newInstance("Fragment 1"));

        fList.add(DetailedShow.newInstance("Fragment 2"));

        fList.add(DetailedShow.newInstance("Fragment 3"));

        return fList;

    }

}
