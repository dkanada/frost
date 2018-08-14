package com.dkanada.icecons.async;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

import com.dkanada.icecons.utils.ImageUtils;

public class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {

    private ImageView imageView;
    public Resources resources;
    public int resId;
    public int width;
    public int height;

    public BitmapWorkerTask(ImageView imageView) {
        this.imageView = imageView;
    }

    // decode image in background
    @Override
    protected Bitmap doInBackground(Integer... parameters) {
        return ImageUtils.bitmapLoad(resources, resId, width, height);
    }

    // check if image view still exists and set bitmap
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (imageView != null && bitmap != null) {
            ImageView imageView = this.imageView;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
                imageView.setAlpha(0f);
                imageView.setVisibility(View.VISIBLE);
                imageView.animate()
                        .alpha(1f)
                        .setDuration(resources.getInteger(android.R.integer.config_mediumAnimTime))
                        .setListener(null);
            }
        }
    }
}
