package ovh.ice.icecons;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WallpaperActivity extends AppCompatActivity {

    private Integer[] mImages = {
            R.drawable.bush, R.drawable.clovers,
            R.drawable.daisy, R.drawable.ivy,
            R.drawable.rock, R.drawable.wall
    };

    private Integer[] mThumbnails = {
            R.drawable.bush_thumb, R.drawable.clovers_thumb,
            R.drawable.daisy_thumb, R.drawable.ivy_thumb,
            R.drawable.rock_thumb, R.drawable.wall_thumb
    };

    private ArrayList<LinearLayout> layoutList = new ArrayList<>();
    private ArrayList<ImageView> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);

        createLayout();
    }

    private void createLayout() {

        LinearLayout.LayoutParams containerParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT );
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f );

        for( int i =0; i < mThumbnails.length; i++ ) {

            if( ( i%2 ) == 0 ) {

                layoutList.add( (i/2), new LinearLayout(this) );
                layoutList.get(i/2).setOrientation( LinearLayout.HORIZONTAL );
                layoutList.get(i/2).setLayoutParams( containerParams );

                ( (LinearLayout)findViewById(R.id.wallpaperGridTop) ).addView( layoutList.get(i/2) );

                imageList.add( i, new ImageView(this) );
                imageList.get(i).setLayoutParams( imageParams );
                imageList.get(i).setScaleType( ImageView.ScaleType.CENTER_CROP );
                imageList.get(i).setImageResource( mThumbnails[i] );
                imageList.get(i).setAdjustViewBounds( true );

                final Integer tempId = mImages[i];
                imageList.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        wallpaperView( v, tempId);
                    }
                });

                layoutList.get(i/2).addView( imageList.get(i) );

            } else {

                imageList.add( i, new ImageView(this) );
                imageList.get(i).setLayoutParams( imageParams );
                imageList.get(i).setScaleType( ImageView.ScaleType.CENTER_CROP );
                imageList.get(i).setImageResource( mThumbnails[i] );
                imageList.get(i).setAdjustViewBounds( true );

                final Integer tempId = mImages[i];
                imageList.get(i).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        wallpaperView( v, tempId);
                    }
                });

                layoutList.get(i/2).addView( imageList.get(i) );
            }
        }
    }

    public void wallpaperView(View v, Integer imageId) {

        Intent intent = new Intent(this, WallpaperSetActivity.class);
        intent.putExtra("image", imageId);
        startActivity(intent);
    }
}
