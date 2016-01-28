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
        Bitmap bitmap = ShrinkBitmap(imageUri, 200, 200);
        ImageView imageView= (ImageView)view.findViewById(R.id.imageOutfit);
        imageView.setImageBitmap(bitmap);
        return view;
    }

    Bitmap ShrinkBitmap(String file, int width, int height){

        BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
        bmpFactoryOptions.inJustDecodeBounds = true;

        int heightRatio = (int)Math.ceil(bmpFactoryOptions.outHeight/(float)height);
        int widthRatio = (int)Math.ceil(bmpFactoryOptions.outWidth / (float) width);

        if (heightRatio > 1 || widthRatio > 1)
        {
            if (heightRatio > widthRatio)
            {
                bmpFactoryOptions.inSampleSize = heightRatio;
            } else {
                bmpFactoryOptions.inSampleSize = widthRatio;
            }
        }

        bmpFactoryOptions.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeFile(file, bmpFactoryOptions);
        return getResizedBitmap(bitmap, width);
    }

    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 0) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

}
