package com.dkanada.icecons.async;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.dkanada.icecons.interfaces.BitmapListener;
import com.dkanada.icecons.utils.ImageUtils;

public class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {

    private BitmapListener bitmapListener;
    private Resources resources;
    private int resId;
    private int width;
    private int height;

    public BitmapWorkerTask(Resources resources, int resId, int width, int height, BitmapListener bitmapListener) {
        this.resources = resources;
        this.resId = resId;
        this.width = width;
        this.height = height;
        this.bitmapListener = bitmapListener;
    }

    // decode image in background
    @Override
    protected Bitmap doInBackground(Integer... parameters) {
        return ImageUtils.bitmapLoad(resources, resId, width, height);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        bitmapListener.onBitmap(bitmap);
    }
}
