package com.zellyalgo.suitapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.zellyalgo.suitapp.controllers.FileAccess;
import com.zellyalgo.suitapp.model.Picture;
import com.zellyalgo.suitapp.pictureRow.RowViewPagerAdapter;

import java.io.File;

/**
 * Created by zellyalgo on 22/12/15.
 */
public class CreateOutfit extends AppCompatActivity {

    private static String APP_TAG = "SuitApp";
    private static Integer numPhoto = 1;

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;

    private RowViewPagerAdapter head, chest, legs, feet, actualPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_outfit);
        getSupportActionBar().hide();
        head = new RowViewPagerAdapter(getSupportFragmentManager());
        chest = new RowViewPagerAdapter(getSupportFragmentManager());
        legs = new RowViewPagerAdapter(getSupportFragmentManager());
        feet = new RowViewPagerAdapter(getSupportFragmentManager());
        generateAdaptersRows(R.id.pager_head, head);
        generateAdaptersRows(R.id.pager_chest, chest);
        generateAdaptersRows(R.id.pager_legs, legs);
        generateAdaptersRows(R.id.pager_feet, feet);

    }

    private void generateAdaptersRows(int idPager, RowViewPagerAdapter mPagerAdapter){
        ViewPager mPager = (ViewPager) findViewById(idPager);
        mPager.setAdapter(mPagerAdapter);
        mPager.setClipChildren(false);
        mPager.setPageMargin(
                getResources().getDimensionPixelOffset(R.dimen.size_view_pager_pictures));
        mPager.setOffscreenPageLimit(9);
    }

    public void newPicture (View view){
        switch (((ViewGroup)(view.getParent()).getParent()).getId()){
            case R.id.pager_head:
                actualPagerAdapter = head;
                break;
            case R.id.pager_chest:
                actualPagerAdapter = chest;
                break;
            case R.id.pager_legs:
                actualPagerAdapter = legs;
                break;
            case R.id.pager_feet:
                actualPagerAdapter = feet;
                break;
            default:
                Log.d(APP_TAG, "ID NOT FOUND");
        }

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        FileAccess fileAccess = new FileAccess();
        Uri fileUri= fileAccess.getUriAppOfAFile(numPhoto + ".jpg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE){
            FileAccess fileAccess = new FileAccess();
            Uri imagePath = fileAccess.getUriAppOfAFile(numPhoto + ".jpg");
            numPhoto++;
            Picture picture = new Picture();
            picture.setId(1L);
            picture.setImageUri(imagePath.getPath());
            actualPagerAdapter.addItem(picture);
            actualPagerAdapter.notifyDataSetChanged();
        }
    }
}
