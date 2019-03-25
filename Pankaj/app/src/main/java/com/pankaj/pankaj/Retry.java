package com.pankaj.pankaj;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class Retry extends Fragment {
    Button retry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview=inflater.inflate(R.layout.fragment_retry, container, false);
        retry=rootview.findViewById(R.id.retry);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean network=( (MainActivity) getContext()).isNetworkConnected();
                if(network==false)
                {
                    Toast.makeText(getContext(),"Connect to internet",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    closeFragment();
                }
            }
        });

        return rootview;
    }




    public void closeFragment()
    {
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }


}
