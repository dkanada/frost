package com.dkanada.icecons.activities;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dkanada.icecons.R;
import com.dkanada.icecons.utils.ImageUtils;
import com.dkanada.icecons.utils.ScreenUtils;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createLayout();
    }

    private void createLayout() {
        LinearLayout.LayoutParams smallLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
        float scale = ScreenUtils.densityScale(getApplicationContext());
        ViewGroup.LayoutParams buttonParams = new ViewGroup.LayoutParams(Math.round(48 * scale), Math.round(48 * scale));

        LinearLayout frameLayout = new LinearLayout(this);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        frameLayout.setBackgroundColor(getResources().getColor(R.color.colorLight));
        frameLayout.setGravity(Gravity.CENTER);
        setContentView(frameLayout);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT));
        baseLayout.setGravity(Gravity.START);
        frameLayout.addView(baseLayout);

        // icons
        LinearLayout iconLayout = new LinearLayout(this);
        iconLayout.setOrientation(LinearLayout.HORIZONTAL);
        iconLayout.setLayoutParams(smallLayoutParams);
        iconLayout.setGravity(Gravity.CENTER_VERTICAL);
        baseLayout.addView(iconLayout);

        LinearLayout iconClickLayout = new LinearLayout(this);
        iconClickLayout.setOrientation(LinearLayout.HORIZONTAL);
        iconClickLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        iconClickLayout.setGravity(Gravity.CENTER);
        iconLayout.addView(iconClickLayout);
        iconClickLayout.setOnClickListener(this::iconActivity);

        Button iconButton = new Button(this);
        iconButton.setLayoutParams(buttonParams);
        iconButton.setBackground(new BitmapDrawable(getResources(), ImageUtils.bitmapLoad(getApplicationContext().getResources(), R.drawable.ic_icon_button, Math.round(48 * scale), Math.round(48 * scale))));
        iconButton.setClickable(false);
        iconClickLayout.addView(iconButton);

        TextView iconText = new TextView(this);
        iconText.setText(getResources().getString(R.string.icons));
        iconText.setTextSize(24);
        iconText.setTextColor(getResources().getColor(R.color.textLight));
        iconText.setPadding(64, 64, 64, 64);
        iconClickLayout.addView(iconText);

        // wallpapers
        LinearLayout wallpaperLayout = new LinearLayout(this);
        wallpaperLayout.setOrientation(LinearLayout.HORIZONTAL);
        wallpaperLayout.setLayoutParams(smallLayoutParams);
        wallpaperLayout.setGravity(Gravity.CENTER_VERTICAL);
        baseLayout.addView(wallpaperLayout);

        LinearLayout wallpaperClickLayout = new LinearLayout(this);
        wallpaperClickLayout.setOrientation(LinearLayout.HORIZONTAL);
        wallpaperClickLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        wallpaperClickLayout.setGravity(Gravity.CENTER);
        wallpaperLayout.addView(wallpaperClickLayout);
        wallpaperClickLayout.setOnClickListener(this::wallpaperActivity);

        Button wallpaperButton = new Button(this);
        wallpaperButton.setLayoutParams(buttonParams);
        wallpaperButton.setBackground(new BitmapDrawable(getResources(), ImageUtils.bitmapLoad(getApplicationContext().getResources(), R.drawable.ic_wallpaper_button, Math.round(48 * scale), Math.round(48 * scale))));
        wallpaperButton.setClickable(false);
        wallpaperClickLayout.addView(wallpaperButton);

        TextView wallpaperText = new TextView(this);
        wallpaperText.setText(getResources().getString(R.string.wallpapers));
        wallpaperText.setTextSize(24);
        wallpaperText.setTextColor(getResources().getColor(R.color.textLight));
        wallpaperText.setPadding(64, 64, 64, 64);
        wallpaperClickLayout.addView(wallpaperText);

        // source
        LinearLayout sourceLayout = new LinearLayout(this);
        sourceLayout.setOrientation(LinearLayout.HORIZONTAL);
        sourceLayout.setLayoutParams(smallLayoutParams);
        sourceLayout.setGravity(Gravity.CENTER_VERTICAL);
        baseLayout.addView(sourceLayout);

        LinearLayout sourceClickLayout = new LinearLayout(this);
        sourceClickLayout.setOrientation(LinearLayout.HORIZONTAL);
        sourceClickLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        sourceClickLayout.setGravity(Gravity.CENTER);
        sourceLayout.addView(sourceClickLayout);
        sourceClickLayout.setOnClickListener(this::gitLink);

        Button sourceButton = new Button(this);
        sourceButton.setLayoutParams(buttonParams);
        sourceButton.setBackground(new BitmapDrawable(getResources(), ImageUtils.bitmapLoad(getApplicationContext().getResources(), R.drawable.ic_source_button, Math.round(48 * scale), Math.round(48 * scale))));
        sourceButton.setClickable(false);
        sourceClickLayout.addView(sourceButton);

        TextView sourceText = new TextView(this);
        sourceText.setText(getResources().getString(R.string.source));
        sourceText.setTextSize(24);
        sourceText.setTextColor(getResources().getColor(R.color.textLight));
        sourceText.setPadding(64, 64, 64, 64);
        sourceClickLayout.addView(sourceText);

        // license button
        LinearLayout aboutLayout = new LinearLayout(this);
        aboutLayout.setOrientation(LinearLayout.HORIZONTAL);
        aboutLayout.setLayoutParams(smallLayoutParams);
        aboutLayout.setGravity(Gravity.CENTER_VERTICAL);
        baseLayout.addView(aboutLayout);

        LinearLayout aboutClickLayout = new LinearLayout(this);
        aboutClickLayout.setOrientation(LinearLayout.HORIZONTAL);
        aboutClickLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        aboutClickLayout.setGravity(Gravity.CENTER);
        aboutLayout.addView(aboutClickLayout);
        aboutClickLayout.setOnClickListener(this::licenseActivity);

        Button aboutButton = new Button(this);
        aboutButton.setLayoutParams(buttonParams);
        aboutButton.setBackground(new BitmapDrawable(getResources(), ImageUtils.bitmapLoad(getApplicationContext().getResources(), R.drawable.ic_license_button, Math.round(48 * scale), Math.round(48 * scale))));
        aboutButton.setClickable(false);
        aboutClickLayout.addView(aboutButton);

        TextView aboutText = new TextView(this);
        aboutText.setText(getResources().getString(R.string.license));
        aboutText.setTextSize(24);
        aboutText.setTextColor(getResources().getColor(R.color.textLight));
        aboutText.setPadding(64, 64, 64, 64);
        aboutClickLayout.addView(aboutText);
    }

    public void gitLink(View v) {
        Uri uri = Uri.parse(getResources().getString(R.string.url_repository));
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void wallpaperActivity(View v) {
        Intent intent = new Intent(this, WallpaperActivity.class);
        startActivity(intent);
    }

    public void iconActivity(View v) {
        Intent intent = new Intent(this, IconActivity.class);
        startActivity(intent);
    }

    public void licenseActivity(View v) {
        Intent intent = new Intent(this, LicenseActivity.class);
        startActivity(intent);
    }
}
