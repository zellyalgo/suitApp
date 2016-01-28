package com.zellyalgo.suitapp.pictureRow;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zellyalgo.suitapp.R;
import com.zellyalgo.suitapp.controllers.ImageControl;

/**
 * Created by zellyalgo on 22/12/15.
 */
public class RowFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if(0L == arguments.getLong("pictureId", 0L))
            return inflater.inflate(R.layout.picture_empty, container, false);

        View view = inflater.inflate(R.layout.picture_outfit, container, false);
        String imageUri = arguments.getString("imageUri");
        ImageControl imageControl = new ImageControl();
        Bitmap bitmap = imageControl.shrinkBitmap(imageUri, 200, 200);
        ImageView imageView= (ImageView)view.findViewById(R.id.imageOutfit);
        imageView.setImageBitmap(bitmap);
        return view;
    }



}
