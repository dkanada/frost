package com.dkanada.icecons.activities;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.dkanada.icecons.R;
import com.dkanada.icecons.utils.IntentUtils;
import com.dkanada.icecons.views.CenterButton;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createLayout();
    }

    private void createLayout() {
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

        CenterButton icons = new CenterButton(this);
        icons.setText(R.string.icons);
        icons.setIcon(R.drawable.ic_icon_button);
        icons.setOnClickListener((v) -> IntentUtils.openActivity(this, IconActivity.class));
        baseLayout.addView(icons);

        CenterButton wallpapers = new CenterButton(this);
        wallpapers.setText(R.string.wallpapers);
        wallpapers.setIcon(R.drawable.ic_wallpaper_button);
        wallpapers.setOnClickListener((v) -> IntentUtils.openActivity(this, WallpaperActivity.class));
        baseLayout.addView(wallpapers);

        CenterButton source = new CenterButton(this);
        source.setText(R.string.source);
        source.setIcon(R.drawable.ic_source_button);
        source.setOnClickListener((v) -> IntentUtils.openActivity(this, SourceActivity.class));
        baseLayout.addView(source);

        CenterButton code = new CenterButton(this);
        code.setText(R.string.license);
        code.setIcon(R.drawable.ic_license_button);
        code.setOnClickListener((v) -> IntentUtils.openActivity(this, LicenseActivity.class));
        baseLayout.addView(code);
    }
}
