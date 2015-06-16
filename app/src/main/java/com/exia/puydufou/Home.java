package com.exia.puydufou;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.exia.puydufou.Helper.LayoutHelper;
import com.exia.puydufou.Messenger.MessageQueue;


public class Home extends AppCompatActivity
{
    private LayoutHelper _layoutHelper = null;

    private View.OnClickListener ButtonClick = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
//            if(_view == null)
//                throw new NullPointerException("_view is undefined");

//            ((TextView)_view.findViewById(R.id.TestText)).setText("Changement -> !");

            _layoutHelper.<TextView>GetElement(R.id.TestText).setText("Changement -> !");

            MessageQueue.Instance().AddMessage(3);

            Intent i = new Intent(Home.this, Sample.class);
            startActivity(i);

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        _view = getLayoutInflater().inflate(R.layout.home, null);
//        ((Button)_view.findViewById(R.id.Button)).setOnClickListener(ButtonClick);
//        setContentView(_view);

        _layoutHelper = new LayoutHelper(this, R.layout.activity_home);
        //Android match le nom de la première activité avec le nom de l'application
        _layoutHelper.ConcatTitle(R.string.AddHomeTitle);
        _layoutHelper.<Button>GetElement(R.id.Button).setOnClickListener(ButtonClick);

        _layoutHelper.ApplyModifications();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
