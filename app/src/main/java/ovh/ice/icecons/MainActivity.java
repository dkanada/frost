package ovh.ice.icecons;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        createLayout();
    }

    private void createLayout() {

        LinearLayout.LayoutParams smallLayoutParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f );
        ViewGroup.LayoutParams buttonParams = new ViewGroup.LayoutParams( 256, 256 );

        LinearLayout baseLayout = new LinearLayout( this );
        baseLayout.setOrientation( LinearLayout.VERTICAL );
        baseLayout.setLayoutParams( new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT ) );
        baseLayout.setBackgroundResource( R.drawable.menu_background );
        baseLayout.setPadding( 16, 36, 16, 0 );
        setContentView( baseLayout );

        LinearLayout wallpaperLayout = new LinearLayout( this );
        wallpaperLayout.setOrientation( LinearLayout.HORIZONTAL );
        wallpaperLayout.setLayoutParams( smallLayoutParams );
        wallpaperLayout.setGravity( Gravity.CENTER );
        baseLayout.addView( wallpaperLayout );

        Button wallpaperButton = new Button( this );
        wallpaperButton.setLayoutParams( buttonParams );
        wallpaperButton.setBackgroundResource( R.drawable.ic_wallpaper_button );
        wallpaperLayout.addView( wallpaperButton );
        wallpaperButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                wallpaperPicker( v );
            }
        });

        TextView wallpaperText = new TextView( this );
        wallpaperText.setText( "wallpapers" );
        wallpaperText.setTextSize( 24 );
        wallpaperText.setTextColor( ContextCompat.getColor( getApplicationContext(), R.color.colorPrimaryDark) );
        wallpaperText.setPadding( 64, 64, 64, 64 );
        wallpaperLayout.addView( wallpaperText );

        LinearLayout sourceLayout = new LinearLayout( this );
        sourceLayout.setOrientation( LinearLayout.HORIZONTAL );
        sourceLayout.setLayoutParams( smallLayoutParams );
        sourceLayout.setGravity( Gravity.CENTER );
        baseLayout.addView( sourceLayout );

        TextView sourceText = new TextView( this );
        sourceText.setText( "source code" );
        sourceText.setTextSize( 24 );
        sourceText.setTextColor( ContextCompat.getColor( getApplicationContext(), R.color.colorPrimaryDark) );
        sourceText.setPadding(64, 64, 64, 64);
        sourceLayout.addView( sourceText );

        Button sourceButton = new Button( this );
        sourceButton.setLayoutParams( buttonParams );
        sourceButton.setBackgroundResource( R.drawable.ic_source_button );
        sourceLayout.addView( sourceButton );
        sourceButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                gitLink( v );
            }
        });
    }

    public void gitLink( View v ) {

        Uri uri = Uri.parse( "https://github.com/1C3/ICEcons" );
        Intent intent = new Intent( Intent.ACTION_VIEW, uri );
        startActivity( intent );
    }

    public void wallpaperPicker( View v ) {

        Intent intent = new Intent( this, WallpaperActivity.class );
        startActivity( intent );
    }
}
