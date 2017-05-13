package com.dkanada.icecons.async;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

import com.dkanada.icecons.utils.IceImageUtils;

/**
 * Created by kanadill on 5/11/2017.
 */

public class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {

    private WeakReference<ImageView> imageViewReference;
    public Resources res;
    public int resId;
    public int width;
    public int height;

    public BitmapWorkerTask(ImageView imageView) {
        imageViewReference = new WeakReference<>(imageView);
    }

    // decode image in background
    @Override
    protected Bitmap doInBackground(Integer... parameters) {
        return IceImageUtils.bitmapLoad(res, resId, width, height);
    }

    // check if image view still exists and set bitmap
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (imageViewReference != null && bitmap != null) {
            final ImageView imageView = imageViewReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
                imageView.setAlpha(0f);
                imageView.setVisibility(View.VISIBLE);
                imageView.animate()
                        .alpha(1f)
                        .setDuration(res.getInteger(android.R.integer.config_mediumAnimTime))
                        .setListener(null);
            }
        }
    }
}
