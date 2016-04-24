package ovh.ice.icecons;

import android.app.WallpaperManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gitLink(View v) {

        Uri uri = Uri.parse("https://github.com/1C3/ICEcons");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void wallpaperPicker(View v) {

        Intent intent = new Intent(this, WallpaperActivity.class);
        startActivity(intent);
    }
}
