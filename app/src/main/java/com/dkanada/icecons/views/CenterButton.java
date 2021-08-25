package com.dkanada.icecons.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.res.ResourcesCompat;

import com.dkanada.icecons.R;
import com.dkanada.icecons.utils.ScreenUtils;

public class CenterButton extends LinearLayoutCompat {
    public Context context;
    public LinearLayout button;

    public ImageView imageView;
    public TextView textView;

    public CenterButton(Context context) {
        super(context);

        float scale = ScreenUtils.densityScale(context);
        int padding = Math.round(24 * scale);

        this.context = context;
        this.button = new LinearLayout(context);

        this.imageView = new ImageView(context);
        this.textView = new TextView(context);

        textView.setTextSize(24);
        textView.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        textView.setPadding(padding, padding, padding, padding);

        button.addView(imageView);
        button.addView(textView);

        button.setOrientation(LinearLayout.HORIZONTAL);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        button.setGravity(Gravity.CENTER);

        setForeground(R.color.textLight);
        setBackground(R.color.colorLight);
        setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f));
        setGravity(Gravity.CENTER_VERTICAL);
        addView(button);
    }

    public void setText(int resId) {
        textView.setText(resId);
    }

    public void setIcon(int resId) {
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), resId, null);
        ViewGroup.LayoutParams params = imageView.getLayoutParams();

        float scale = ScreenUtils.densityScale(context);
        int size = Math.round(48 * scale);

        params.width = size;
        params.height = size;

        imageView.setImageDrawable(drawable);
        imageView.setLayoutParams(params);
    }

    public void setForeground(int resId) {
        int color = context.getResources().getColor(resId);

        textView.setTextColor(color);
        imageView.setColorFilter(color);
    }

    public void setBackground(int resId) {
        setBackgroundColor(context.getResources().getColor(resId));
    }

    public void disableIcon() {
        int padding = textView.getPaddingLeft() * 2;

        textView.setPadding(padding, padding, padding, padding);
        imageView.setImageDrawable(null);
    }
}
