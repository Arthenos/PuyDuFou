package com.exia.puydufou.Helper;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import com.exia.puydufou.R;

public class LayoutHelper
{
    private Activity _referencedActivity = null;
    private View _view = null;

    public LayoutHelper(Context context, int idLayout)
    {
        _referencedActivity = ((Activity)context);

        if (_referencedActivity == null)
            throw new NullPointerException("_referencedActivity inside LayoutHelper is not defined !");

        _view = _referencedActivity.getLayoutInflater().inflate(idLayout, null);

        if (_view == null)
            throw new NullPointerException("_view inside LayoutHelper is not define -> ApplyModifications call");

    }

    public <T> T GetElement(int idElement/*, Class<T> type*/)
    {
//        Useless Now
//        if (_view == null)
//            throw new NullPointerException("_view inside LayoutHelper is not defined -> GetElement call -> T = " + type.getName());

        return (T)_view.findViewById(idElement);
    }

    public void ApplyModifications()
    {
        if (_view == null)
            throw new NullPointerException("_view inside LayoutHelper is not defined -> ApplyModifications call");

        _referencedActivity.setContentView(_view);
    }

    //Utility
    public void SetTitle(String title)
    {
        _referencedActivity.setTitle(title);
    }

    public void SetTitle(int idResString)
    {
        SetTitle(_referencedActivity.getString(idResString));
    }

    public void ConcatTitle(String extraTitle)
    {
        _referencedActivity.setTitle(_referencedActivity.getTitle() + extraTitle);
    }

    public void ConcatTitle(int idResString)
    {
        ConcatTitle(_referencedActivity.getString(idResString));
    }

    public ActionBar ActionBar()
    {
        return _referencedActivity.getActionBar();
    }

    public MenuInflater MenuInflater()
    {
        return _referencedActivity.getMenuInflater();
    }

//    Use "setContentView(GetView)" in the parent if ApplyModifications doesn't work
//    public View GetView()
//    {
//        return _view;
//    }
}
