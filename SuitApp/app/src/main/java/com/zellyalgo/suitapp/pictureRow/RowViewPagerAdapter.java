package com.zellyalgo.suitapp.pictureRow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zellyalgo.suitapp.model.Picture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zellyalgo on 22/12/15.
 */
public class RowViewPagerAdapter extends FragmentStatePagerAdapter {
    private static String APP_TAG = "SuitApp";
    private List<Picture> pictureList;

    public RowViewPagerAdapter(FragmentManager fm) {
        super(fm);
        pictureList = new ArrayList<>();
        Picture picture = new Picture();
        picture.setId(0L);
        pictureList.add(picture);
    }

    @Override
    public float getPageWidth(int position){
        return 0.6f;
    }

    @Override
    public Fragment getItem(int position) {
        RowFragment bf = new RowFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("pictureId", pictureList.get(position).getId());
        bundle.putString("imageUri", pictureList.get(position).getImageUri());
        bf.setArguments(bundle);
        return bf;
    }

    @Override
    public int getCount() {
        return pictureList.size();
    }

    public void addItem(Picture picture){
        pictureList.add(picture);
    }
}
