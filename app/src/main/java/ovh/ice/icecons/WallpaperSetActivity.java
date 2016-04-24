package ovh.ice.icecons;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;

public class WallpaperSetActivity extends AppCompatActivity {

    private int imageId;
    private boolean isPortrait;
    private int screenWidth;
    private int screenHeight;

    Bitmap Wallpaper;

    //Resources res = getResources();

    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );

        final Intent intent = getIntent();
        imageId = intent.getIntExtra( "image", 0 );
        isPortrait = getResources().getDisplayMetrics().widthPixels < getResources().getDisplayMetrics().heightPixels;
        screenWidth = isPortrait ? getResources().getDisplayMetrics().widthPixels : getResources().getDisplayMetrics().heightPixels;
        screenHeight = isPortrait ? getResources().getDisplayMetrics().heightPixels : getResources().getDisplayMetrics().widthPixels;
        Wallpaper =  decodeSampledBitmapFromResource( getApplicationContext().getResources(), imageId, screenWidth, screenHeight );

        createLayout();
    }

    private void createLayout() {

        LinearLayout baseLayout = new LinearLayout( this );
        baseLayout.setOrientation( LinearLayout.VERTICAL );
        baseLayout.setLayoutParams( new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT ) );
        baseLayout.setGravity( Gravity.BOTTOM );
        setContentView( baseLayout );

        ImageView wallPreview = new ImageView( this );
        wallPreview.setLayoutParams( new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT ) );
        wallPreview.setScaleType( ImageView.ScaleType.CENTER_CROP );
        wallPreview.setImageBitmap( Wallpaper );
        baseLayout.addView( wallPreview );

        LinearLayout buttonBar = new LinearLayout( this );
        buttonBar.setOrientation( LinearLayout.HORIZONTAL );
        buttonBar.setLayoutParams( new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, 256 ) );
        baseLayout.setBackgroundColor( ContextCompat.getColor( getApplicationContext(), R.color.colorPrimary ) );
        buttonBar.setGravity( Gravity.CENTER );
        baseLayout.addView( buttonBar );

        ImageView backButton = new ImageView( this );
        backButton.setLayoutParams( new LinearLayout.LayoutParams( 0, 192, 1 ) );
        backButton.setImageResource( R.drawable.ic_back );
        buttonBar.addView( backButton );
        backButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                finish();
            }
        });

        ImageView applyButton = new ImageView( this );
        applyButton.setLayoutParams( new LinearLayout.LayoutParams( 0, 192, 1 ) );
        applyButton.setImageResource( R.drawable.ic_apply );
        buttonBar.addView( applyButton );
        applyButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                setWallpaper( v );
            }
        });
    }

    public void setWallpaper( View v ) {

        WallpaperManager wallpaperManager = WallpaperManager.getInstance( getApplicationContext() );

        try {

            wallpaperManager.setBitmap( Wallpaper );

            Toast toast = Toast.makeText( this, "Wallpaper Set", Toast.LENGTH_SHORT );
            toast.setGravity( Gravity.CENTER, 0, 0 );
            toast.show();

        } catch ( IOException e ) {

            e.printStackTrace();
        }
    }

    private int calculateInSampleSize( BitmapFactory.Options options, int reqWidth, int reqHeight ) {

        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    private Bitmap decodeSampledBitmapFromResource( Resources res, int resId, int reqWidth, int reqHeight ) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource( res, resId, options );

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource( res, resId, options);
    }
}

