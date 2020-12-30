package com.dkanada.icecons.activities;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.dkanada.icecons.utils.IntentUtils;
import com.dkanada.icecons.views.CenterButton;
import com.dkanada.icecons.R;

public class SourceActivity extends BaseActivity {
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

        CenterButton code = new CenterButton(this);
        code.setText(R.string.code);
        code.setIcon(R.drawable.ic_code);
        code.setOnClickListener((v) -> IntentUtils.openUrl(this, R.string.url_repository));
        baseLayout.addView(code);

        CenterButton support = new CenterButton(this);
        support.setText(R.string.support);
        support.setIcon(R.drawable.ic_favorite);
        support.setOnClickListener((v) -> IntentUtils.openUrl(this, R.string.url_support));
        baseLayout.addView(support);
    }
}
