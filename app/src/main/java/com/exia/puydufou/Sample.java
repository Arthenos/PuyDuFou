package com.exia.puydufou;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.exia.puydufou.Helper.LayoutHelper;
import com.exia.puydufou.Messenger.MessageQueue;

import java.lang.Object;


public class Sample extends AppCompatActivity
{
    private LayoutHelper _layoutHelper = null;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        _layoutHelper = new LayoutHelper(this, R.layout.activity_sample);


        Integer t = MessageQueue.Instance().RetrievingLastMessage(Integer.class);

        if (t == null)
        {
            Toast.makeText(this, "Not retrieving data !", Toast.LENGTH_SHORT).show();
            return;
        }

        _layoutHelper.<TextView>GetElement(R.id.MessageTitle).setText(t.toString());
        Toast.makeText(this, "Retrieving data success!", Toast.LENGTH_SHORT).show();

        _layoutHelper.ApplyModifications();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sample, menu);
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
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
