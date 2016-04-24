package ovh.ice.icecons;

import android.app.WallpaperManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class WallpaperSetActivity extends AppCompatActivity {

    private Integer imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper_set);

        final Intent intent = getIntent();
        imageId = intent.getIntExtra("image", 0);

        findViewById(R.id.wallpaperSetView).setBackgroundResource(imageId);
        ( (ImageView)findViewById(R.id.wallpaperSetView) ).setScaleType( ImageView.ScaleType.CENTER_CROP );
    }

    public void setWallpaper(View v) {

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        try {

            wallpaperManager.setResource(imageId);

            Toast toast = Toast.makeText(this, "Wallpaper Set", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
