package ovh.ice.icecons;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
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

public class LicenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        createLayout();
    }

    private void createLayout() {

        // main centered layout

        LinearLayout.LayoutParams smallLayoutParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f );
        float scale = IceScreenUtils.densityScale( getApplicationContext() );
        int padding = Math.round( 64 * scale );

        LinearLayout frameLayout = new LinearLayout( this );
        frameLayout.setLayoutParams( new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT ) );
        frameLayout.setBackgroundColor( 0xffffffff );
        frameLayout.setGravity( Gravity.CENTER );
        setContentView( frameLayout );

        LinearLayout baseLayout = new LinearLayout( this );
        baseLayout.setOrientation( LinearLayout.VERTICAL );
        baseLayout.setLayoutParams( new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT ) );
        baseLayout.setGravity( Gravity.LEFT );
        frameLayout.addView( baseLayout );

        // gpl button

        LinearLayout sourceLayout = new LinearLayout( this );
        sourceLayout.setOrientation( LinearLayout.HORIZONTAL );
        sourceLayout.setLayoutParams( smallLayoutParams );
        sourceLayout.setGravity( Gravity.CENTER );
        baseLayout.addView( sourceLayout );

        LinearLayout sourceClickLayout = new LinearLayout( this );
        sourceClickLayout.setOrientation( LinearLayout.HORIZONTAL );
        sourceClickLayout.setLayoutParams( new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT ) );
        sourceClickLayout.setGravity( Gravity.CENTER );
        sourceLayout.addView( sourceClickLayout );
        sourceClickLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                gplLink( v );
            }
        });

        TextView sourceText = new TextView( this );
        sourceText.setText( "This program's source code is avaiable under the GNU General Public License v3." );
        sourceText.setTextSize( 24 );
        sourceText.setTextColor( ContextCompat.getColor( getApplicationContext(), R.color.colorPrimaryDark) );
        sourceText.setPadding( padding, padding, padding, padding );
        sourceClickLayout.addView( sourceText );

        // cc button

        LinearLayout imgLayout = new LinearLayout( this );
        imgLayout.setOrientation( LinearLayout.HORIZONTAL );
        imgLayout.setLayoutParams( smallLayoutParams );
        imgLayout.setGravity( Gravity.CENTER );
        imgLayout.setBackgroundColor( 0xff000000 );
        baseLayout.addView( imgLayout );

        LinearLayout imgClickLayout = new LinearLayout( this );
        imgClickLayout.setOrientation( LinearLayout.HORIZONTAL );
        imgClickLayout.setLayoutParams( new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT ) );
        imgClickLayout.setGravity( Gravity.CENTER );
        imgLayout.addView( imgClickLayout );
        imgClickLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                ccLink( v );
            }
        });

        TextView aboutText = new TextView( this );
        aboutText.setText( "All the images included in this program are avaiable under the Creative Commons Attribution Share Alike 4.0 license." );
        aboutText.setTextSize( 24 );
        aboutText.setTextColor( 0xffffffff );
        aboutText.setPadding( padding, padding, padding, padding );
        imgClickLayout.addView( aboutText );

    }

    public void gplLink( View v ) {

        Uri uri = Uri.parse( "http://choosealicense.com/licenses/gpl-3.0/" );
        Intent intent = new Intent( Intent.ACTION_VIEW, uri );
        startActivity( intent );
    }

    public void ccLink( View v ) {

        Uri uri = Uri.parse( "http://choosealicense.com/licenses/cc-by-sa-4.0/" );
        Intent intent = new Intent( Intent.ACTION_VIEW, uri );
        startActivity( intent );
    }
}
