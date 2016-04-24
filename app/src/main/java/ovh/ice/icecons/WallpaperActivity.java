package ovh.ice.icecons;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Config;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class WallpaperActivity extends AppCompatActivity {

    private Integer[] mImages = {
            R.drawable.bush, R.drawable.clovers,
            R.drawable.daisy, R.drawable.ivy,
            R.drawable.rock, R.drawable.wall,
            R.drawable.foam, R.drawable.night
    };

    private Integer[] mThumbnails = {
            R.drawable.bush_thumb, R.drawable.clovers_thumb,
            R.drawable.daisy_thumb, R.drawable.ivy_thumb,
            R.drawable.rock_thumb, R.drawable.wall_thumb,
            R.drawable.foam_thumb, R.drawable.night_thumb
    };

    private ArrayList<LinearLayout> layoutList = new ArrayList<>();
    private ArrayList<ImageView> imageList = new ArrayList<>();

    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );

        if( getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().heightPixels ) {
            createLayout(3);
        } else {
            createLayout(2);
        }
    }

    private void createLayout( int width ) {

        LinearLayout.LayoutParams baseParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT );
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT );
        LinearLayout.LayoutParams containerParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT );
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f );

        ScrollView baseScroller = new ScrollView( this );
        baseScroller.setLayoutParams( baseParams );
        setContentView( baseScroller );

        LinearLayout baseLayout = new LinearLayout( this );
        baseLayout.setOrientation( LinearLayout.VERTICAL );
        baseLayout.setLayoutParams( layoutParams );
        baseScroller.addView( baseLayout );

        for( int i =0; i < mThumbnails.length; i++ ) {

            if( ( i%width ) == 0 ) {

                layoutList.add( ( i / width ), new LinearLayout( this ) );
                layoutList.get( i / width ).setOrientation( LinearLayout.HORIZONTAL );
                layoutList.get( i / width ).setGravity( Gravity.LEFT );
                layoutList.get( i / width ).setLayoutParams( containerParams );

                baseLayout.addView( layoutList.get( i / width ) );

                imageList.add( i, new ImageView( this ) );
                imageList.get(i).setLayoutParams( imageParams );
                imageList.get(i).setScaleType( ImageView.ScaleType.CENTER_CROP );
                imageList.get(i).setImageResource( mThumbnails[i] );
                imageList.get(i).setAdjustViewBounds( true );

                final Integer tempId = mImages[i];
                imageList.get(i).setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick( View v ) {
                        wallpaperView( v, tempId);
                    }
                });

                layoutList.get( i / width ).addView( imageList.get(i) );

            } else {

                imageList.add( i, new ImageView( this ) );
                imageList.get(i).setLayoutParams( imageParams );
                imageList.get(i).setScaleType( ImageView.ScaleType.CENTER_CROP );
                imageList.get(i).setImageResource( mThumbnails[i] );
                imageList.get(i).setAdjustViewBounds( true );

                final Integer tempId = mImages[i];
                imageList.get(i).setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick( View v ) {
                        wallpaperView( v, tempId);
                    }
                });

                layoutList.get( ( i - ( i % width ) ) / width ).addView( imageList.get(i) );
            }
        }
    }

    public void wallpaperView( View v, Integer imageId ) {

        Intent intent = new Intent( this, WallpaperSetActivity.class );
        intent.putExtra( "image", imageId );
        startActivity( intent );
    }
}
