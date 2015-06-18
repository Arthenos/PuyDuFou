package com.exia.puydufou;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.exia.puydufou.BusinessObject.RestaurantBU;
import com.exia.puydufou.BusinessObject.ShopBU;
import com.exia.puydufou.BusinessObject.SpectacleBU;

import com.exia.puydufou.Helper.ViewEnum;
import com.exia.puydufou.Messenger.MessageQueue;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import io.fabric.sdk.android.Fabric;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * 
 * to handle interaction events.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment<T extends Serializable> extends android.support.v4.app.Fragment
{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "detailObject";

    // TODO: Rename and change types of parameters
    private T detailObject;

    CallbackManager callbackManager;
    ShareDialog shareDialog;

//    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param detailObject Parameter 1.
     * @return A new instance of fragment CardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static <T extends Serializable> CardFragment newInstance(T detailObject)
    {
        CardFragment fragment = new CardFragment();

        Bundle args = new Bundle();

        args.putSerializable(ARG_PARAM1, detailObject);
//        args.putString(ARG_PARAM2, param2);

        fragment.setArguments(args);

        return fragment;
    }

    public CardFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        Fabric.with(getActivity(), new TweetComposer());
        FacebookSdk.sdkInitialize(getActivity());
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        if (getArguments() != null)
        {
            detailObject = (T)getArguments().getSerializable(ARG_PARAM1);
        }

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = null;

        Object o = getArguments().getSerializable(ARG_PARAM1);

        if(o instanceof SpectacleBU)
        {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            SpectacleBU sp = (SpectacleBU)o;
            v = inflater.inflate(R.layout.fragment_detailed_show, container, false);
            ((TextView)v.findViewById(R.id.show_name)).setText(sp.getName());
            ((RatingBar)v.findViewById(R.id.show_rating)).setRating(2.5f);
            ((ImageView)v.findViewById(R.id.show_preview)).setImageResource(R.mipmap.puydufou);
            ((TextView)v.findViewById(R.id.show_creationdate)).setText(formatter.format(sp.getDate()));
            ((TextView)v.findViewById(R.id.show_duration)).setText(Integer.toString(sp.getDuration()));
            ((TextView)v.findViewById(R.id.show_actors)).setText(Integer.toString(sp.getActorsNumber()));
            ((TextView)v.findViewById(R.id.show_description)).setText(sp.getDescription());
            ((Button)v.findViewById(R.id.show_shareme_facebook)).setOnClickListener(ShareMeOnFacebookSpectacle);
            ((Button)v.findViewById(R.id.show_shareme_twitter)).setOnClickListener(ShareMeOnTwitterSpectacle);
        }
        else if (o instanceof RestaurantBU)
        {
            RestaurantBU r = (RestaurantBU)o;
            v = inflater.inflate(R.layout.fragment_detailed_restaurant, container, false);
            ((TextView)v.findViewById(R.id.restaurant_name)).setText(r.getName());
            ((RatingBar)v.findViewById(R.id.restaurant_rating)).setRating(3);
            ((ImageView)v.findViewById(R.id.restaurant_preview)).setImageResource(R.mipmap.puydufou);
            ((TextView)v.findViewById(R.id.restaurant_location)).setText(r.getLocation());
            ((TextView)v.findViewById(R.id.restaurant_description)).setText(r.getDescription());
            ((Button)v.findViewById(R.id.restaurant_shareme_facebook)).setOnClickListener(ShareMeOnFacebookRestaurant);
            ((Button)v.findViewById(R.id.restaurant_shareme_twitter)).setOnClickListener(ShareMeOnTwitterRestaurant);
        }
        else if (o instanceof ShopBU)
        {
            ShopBU s = (ShopBU)o;
            v = inflater.inflate(R.layout.fragment_detailed_shop, container, false);
            ((TextView)v.findViewById(R.id.shop_name)).setText(s.getName());
            ((RatingBar)v.findViewById(R.id.shop_rating)).setRating(4.5f);
            ((ImageView)v.findViewById(R.id.shop_preview)).setImageResource(R.mipmap.puydufou);
            ((TextView)v.findViewById(R.id.shop_location)).setText(s.getLocation());
            ((TextView)v.findViewById(R.id.shop_description)).setText(s.getDescription());
            ((Button)v.findViewById(R.id.shop_shareme_facebook)).setOnClickListener(ShareMeOnFacebookShop);
            ((Button)v.findViewById(R.id.shop_shareme_twitter)).setOnClickListener(ShareMeOnTwitterShop);
        }


        setHasOptionsMenu(true);
        return v;
    }

    private View.OnClickListener ShareMeOnFacebookShop = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Object o = getArguments().getSerializable(ARG_PARAM1);
            ShopBU s = (ShopBU)o;
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("Emportez des souvenirs du Puy du Fou")
                    .setContentDescription(
                            s.getDescription() )
                    .setContentUrl(Uri.parse("http://puydufou.com/fr/"))

                    .build();

            shareDialog.show(linkContent);


        }
    };
    private View.OnClickListener ShareMeOnFacebookRestaurant = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Object o = getArguments().getSerializable(ARG_PARAM1);
            RestaurantBU s = (RestaurantBU)o;
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("Venez manger au Puy du Fou")
                    .setContentDescription(
                            s.getDescription())
                    .setContentUrl(Uri.parse("http://puydufou.com/fr/"))

                    .build();

            shareDialog.show(linkContent);


        }
    };
    private View.OnClickListener ShareMeOnFacebookSpectacle = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Object o = getArguments().getSerializable(ARG_PARAM1);
            SpectacleBU s = (SpectacleBU)o;
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("Venez rêver au Puy du Fou")
                    .setContentDescription(
                            s.getDescription())
                    .setContentUrl(Uri.parse("http://puydufou.com/fr/"))

                    .build();

            shareDialog.show(linkContent);


        }
    };
    private View.OnClickListener ShareMeOnTwitterShop = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Object o = getArguments().getSerializable(ARG_PARAM1);
            ShopBU s = (ShopBU)o;
            TweetComposer.Builder builder = new TweetComposer.Builder(getActivity())
                    .text("Actuellement en train de faire du shopping à " + s.getName() + " ! Trop bon ! - Depuis l'application PuyDuFou\"!");


            builder.show();

        }
    };
    private View.OnClickListener ShareMeOnTwitterRestaurant = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Object o = getArguments().getSerializable(ARG_PARAM1);
            RestaurantBU s = (RestaurantBU)o;
            TweetComposer.Builder builder = new TweetComposer.Builder(getActivity())
                    .text(  "Actuellement en train de manger au " + s.getName() + " ! Trop bon ! - Depuis l'application PuyDuFou ");


            builder.show();

        }
    };
    private View.OnClickListener ShareMeOnTwitterSpectacle = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Object o = getArguments().getSerializable(ARG_PARAM1);
            SpectacleBU s = (SpectacleBU)o;

            TweetComposer.Builder builder = new TweetComposer.Builder(getActivity())
                    .text(  "Le spectacle" + s.getName() + " est vraiment génial !! - Depuis l'application PuyDuFou ");


            builder.show();

        }
    };

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri)
//    {
//        if (mListener != null)
//        {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Activity activity)
//    {
//        super.onAttach(activity);
//        try
//        {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e)
//        {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach()
//    {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener
//    {
//        // TODO: Update argument type and name
//        public void onFragmentInteraction(Uri uri);
//    }

}
