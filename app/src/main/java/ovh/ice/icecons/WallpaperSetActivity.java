package ovh.ice.icecons;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;

public class WallpaperSetActivity extends AppCompatActivity {

    private int imageId;
    private int screenWidth;
    private int screenHeight;
    float scale;

    Bitmap Wallpaper;

    //Resources res = getResources();

    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );

        final Intent intent = getIntent();
        imageId = intent.getIntExtra( "image", 0 );
        screenWidth = IceScreenUtils.width( getApplicationContext() );
        screenHeight = IceScreenUtils.height( getApplicationContext() );
        Wallpaper =  IceImageUtils.bitmapLoad( getApplicationContext().getResources(), imageId, screenWidth, screenHeight );
        scale = IceScreenUtils.densityScale( getApplicationContext() );

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
        buttonBar.setLayoutParams( new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, Math.round( 96 * scale ) ) );
        baseLayout.setBackgroundColor( ContextCompat.getColor( getApplicationContext(), R.color.colorPrimary ) );
        buttonBar.setGravity( Gravity.CENTER );
        buttonBar.setBackgroundColor( 0xffffffff );
        baseLayout.addView( buttonBar );

        ImageView backButton = new ImageView( this );
        backButton.setLayoutParams( new LinearLayout.LayoutParams( 0, Math.round( 72 * scale ), 1 ) );
        backButton.setImageBitmap( IceImageUtils.bitmapLoad( getApplicationContext().getResources(), R.drawable.ic_close, Math.round( 72 * scale ), Math.round( 72 * scale ) ) );
        buttonBar.addView( backButton );
        backButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                finish();
            }
        });

        ImageView applyButton = new ImageView( this );
        applyButton.setLayoutParams( new LinearLayout.LayoutParams( 0, Math.round( 72 * scale ), 1 ) );
        applyButton.setImageBitmap( IceImageUtils.bitmapLoad( getApplicationContext().getResources(), R.drawable.ic_apply, Math.round( 72 * scale ), Math.round( 72 * scale ) ) );
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

            Toast toast = Toast.makeText( this, "Wallpaper set", Toast.LENGTH_SHORT );
            toast.setGravity( Gravity.CENTER, 0, 0 );
            toast.show();

        } catch ( IOException e ) {

            e.printStackTrace();
        }
    }
}

