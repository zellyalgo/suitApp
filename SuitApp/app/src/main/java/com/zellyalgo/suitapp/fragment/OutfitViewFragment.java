package com.zellyalgo.suitapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zellyalgo.suitapp.R;

/**
 * Created by zellyalgo on 22/12/15.
 */
public class OutfitViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.outfit_view_fragment, container, false);
    }

}
