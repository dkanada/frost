package ovh.ice.icecons;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

public class IconActivity extends AppCompatActivity {

    private Integer[] mImages = {
            R.drawable.nodpi_a2048,
			R.drawable.nodpi_acdisplay,
			R.drawable.nodpi_acrobat,
			R.drawable.nodpi_adaway,
			R.drawable.nodpi_adiutor,
			R.drawable.nodpi_afwall,
			R.drawable.nodpi_aimsicd,
			R.drawable.nodpi_amaze,
			R.drawable.nodpi_android,
			R.drawable.nodpi_ankidroid,
			R.drawable.nodpi_apex,
			R.drawable.nodpi_apktrack,
			R.drawable.nodpi_apps2org,
			R.drawable.nodpi_audiofx,
			R.drawable.nodpi_bandcamp,
			R.drawable.nodpi_barcode,
			R.drawable.nodpi_bible,
			R.drawable.nodpi_birthdayadapter,
			R.drawable.nodpi_blablacar,
			R.drawable.nodpi_blogger,
			R.drawable.nodpi_blueminimal,
			R.drawable.nodpi_boinc,
			R.drawable.nodpi_book,
			R.drawable.nodpi_browser,
			R.drawable.nodpi_bubble,
			R.drawable.nodpi_cabinet,
			R.drawable.nodpi_calculator,
			R.drawable.nodpi_calendarcolor,
			R.drawable.nodpi_calendar,
			R.drawable.nodpi_callrecorder,
			R.drawable.nodpi_camera,
			R.drawable.nodpi_casper,
			R.drawable.nodpi_cgeo,
			R.drawable.nodpi_chefkoch,
			R.drawable.nodpi_chrome,
			R.drawable.nodpi_clashroyale,
			R.drawable.nodpi_clock,
			R.drawable.nodpi_contacts,
			R.drawable.nodpi_conversations,
			R.drawable.nodpi_cpuz,
			R.drawable.nodpi_daserste,
			R.drawable.nodpi_davdroid,
			R.drawable.nodpi_dbnavigator,
			R.drawable.nodpi_diaspora,
			R.drawable.nodpi_doodle,
			R.drawable.nodpi_downloads,
			R.drawable.nodpi_drawer,
			R.drawable.nodpi_dropbox,
			R.drawable.nodpi_dsub,
			R.drawable.nodpi_duckduckgo,
			R.drawable.nodpi_earth,
			R.drawable.nodpi_echo,
			R.drawable.nodpi_es,
			R.drawable.nodpi_etar,
			R.drawable.nodpi_facebook,
			R.drawable.nodpi_fdroid,
			R.drawable.nodpi_fennec,
			R.drawable.nodpi_files,
			R.drawable.nodpi_firefox,
			R.drawable.nodpi_flickr,
			R.drawable.nodpi_flipboard,
			R.drawable.nodpi_forecastie,
			R.drawable.nodpi_forest,
			R.drawable.nodpi_forkhub,
			R.drawable.nodpi_fourchan,
			R.drawable.nodpi_freeotp,
			R.drawable.nodpi_g2step,
			R.drawable.nodpi_gadgetbridge,
			R.drawable.nodpi_gag,
			R.drawable.nodpi_gallery,
			R.drawable.nodpi_gasflow,
			R.drawable.nodpi_gcamera,
			R.drawable.nodpi_gdocs,
			R.drawable.nodpi_gdrive,
			R.drawable.nodpi_geogebra,
			R.drawable.nodpi_gkeep,
			R.drawable.nodpi_gkeyboard,
			R.drawable.nodpi_gmail,
			R.drawable.nodpi_gmaps,
			R.drawable.nodpi_gmovies,
			R.drawable.nodpi_gmusic,
			R.drawable.nodpi_gnewsstand,
			R.drawable.nodpi_gnewsweather,
			R.drawable.nodpi_googleapp,
			R.drawable.nodpi_google,
			R.drawable.nodpi_gphotos,
			R.drawable.nodpi_gplay,
			R.drawable.nodpi_gplaystore,
			R.drawable.nodpi_gsheets,
			R.drawable.nodpi_gslides,
			R.drawable.nodpi_gtranslate,
			R.drawable.nodpi_hangouts,
			R.drawable.nodpi_hearth,
			R.drawable.nodpi_holo,
			R.drawable.nodpi_icecat,
			R.drawable.nodpi_icecons,
			R.drawable.nodpi_imgur,
			R.drawable.nodpi_instagram,
			R.drawable.nodpi_k9,
			R.drawable.nodpi_keepass2android,
			R.drawable.nodpi_keepassdroid,
			R.drawable.nodpi_keychain,
			R.drawable.nodpi_kik,
			R.drawable.nodpi_kiss,
			R.drawable.nodpi_kodi,
			R.drawable.nodpi_kore,
			R.drawable.nodpi_leafpic,
			R.drawable.nodpi_lightning,
			R.drawable.nodpi_loop,
			R.drawable.nodpi_mail,
			R.drawable.nodpi_map,
			R.drawable.nodpi_mediafire,
			R.drawable.nodpi_mega,
			R.drawable.nodpi_messages,
			R.drawable.nodpi_messenger,
			R.drawable.nodpi_meteo,
			R.drawable.nodpi_microchip,
			R.drawable.nodpi_mifit,
			R.drawable.nodpi_money,
			R.drawable.nodpi_mupdf,
			R.drawable.nodpi_music,
			R.drawable.nodpi_muzei,
			R.drawable.nodpi_mx,
			R.drawable.nodpi_netguard,
			R.drawable.nodpi_nfctasks,
			R.drawable.nodpi_nfctools,
			R.drawable.nodpi_notes,
			R.drawable.nodpi_notificationnotes,
			R.drawable.nodpi_nova,
			R.drawable.nodpi_opencamera,
			R.drawable.nodpi_openconnect,
			R.drawable.nodpi_openmensa,
			R.drawable.nodpi_opentasks,
			R.drawable.nodpi_openvpn,
			R.drawable.nodpi_opera,
			R.drawable.nodpi_orbot,
			R.drawable.nodpi_outlook,
			R.drawable.nodpi_overchan,
			R.drawable.nodpi_owncloudnotes,
			R.drawable.nodpi_owncloud,
			R.drawable.nodpi_pairz,
			R.drawable.nodpi_password,
			R.drawable.nodpi_pb,
			R.drawable.nodpi_phone,
			R.drawable.nodpi_phonograph,
			R.drawable.nodpi_pixlr,
			R.drawable.nodpi_privacybrowser,
			R.drawable.nodpi_qrforkeepass,
			R.drawable.nodpi_quizlet,
			R.drawable.nodpi_radiodroid,
			R.drawable.nodpi_radio,
			R.drawable.nodpi_recorder,
			R.drawable.nodpi_recurrence,
			R.drawable.nodpi_reddit,
			R.drawable.nodpi_redmoon,
			R.drawable.nodpi_redreader,
			R.drawable.nodpi_retrica,
			R.drawable.nodpi_ring,
			R.drawable.nodpi_runnerup,
			R.drawable.nodpi_screencast,
			R.drawable.nodpi_seafile,
			R.drawable.nodpi_sensorreadout,
			R.drawable.nodpi_settings,
			R.drawable.nodpi_sgit,
			R.drawable.nodpi_shazam,
			R.drawable.nodpi_shell,
			R.drawable.nodpi_sieben,
			R.drawable.nodpi_signal,
			R.drawable.nodpi_sim,
			R.drawable.nodpi_skype,
			R.drawable.nodpi_slide,
			R.drawable.nodpi_slidereddit,
			R.drawable.nodpi_snapchat,
			R.drawable.nodpi_snapseed,
			R.drawable.nodpi_soundrecorder,
			R.drawable.nodpi_sparss,
			R.drawable.nodpi_speedtest,
			R.drawable.nodpi_spotify,
			R.drawable.nodpi_su,
			R.drawable.nodpi_swiftkey,
			R.drawable.nodpi_systemappmover,
			R.drawable.nodpi_tasks,
			R.drawable.nodpi_telegram,
			R.drawable.nodpi_themes,
			R.drawable.nodpi_theswitch,
			R.drawable.nodpi_threema,
			R.drawable.nodpi_torch,
			R.drawable.nodpi_trenord,
			R.drawable.nodpi_tumblr,
			R.drawable.nodpi_turtl,
			R.drawable.nodpi_twidere,
			R.drawable.nodpi_twitter,
			R.drawable.nodpi_unifiednlp,
			R.drawable.nodpi_viber,
			R.drawable.nodpi_vine,
			R.drawable.nodpi_viper,
			R.drawable.nodpi_vlc,
			R.drawable.nodpi_vsco,
			R.drawable.nodpi_waze,
			R.drawable.nodpi_weather,
			R.drawable.nodpi_webopac,
			R.drawable.nodpi_whatsapp,
			R.drawable.nodpi_wifianalyzer,
			R.drawable.nodpi_wifiprivacy,
			R.drawable.nodpi_wikipedia,
			R.drawable.nodpi_wunderlist,
			R.drawable.nodpi_xabber,
			R.drawable.nodpi_youtube
    };

    private ArrayList<LinearLayout> layoutList = new ArrayList<>();
    private ArrayList<ImageView> imageList = new ArrayList<>();

    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );

        if( IceScreenUtils.isPortrait( getApplicationContext() ) )
            createLayout( 7 );
        else {
            createLayout( 12 );
        }
    }

    private void createLayout( int width ) {

        float scale = IceScreenUtils.densityScale( getApplicationContext() );
        int margin = 16 * Math.round( scale );

        LinearLayout.LayoutParams baseParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT );
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT );
        LinearLayout.LayoutParams containerParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT );
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f );

        ScrollView baseScroller = new ScrollView( this );
        baseScroller.setLayoutParams( baseParams );
        baseScroller.setBackgroundColor( 0xff000000 );
        setContentView( baseScroller );
        baseScroller.setVisibility( View.VISIBLE );

        // display width hack

        Rect windowRect = new Rect();
        baseScroller.getWindowVisibleDisplayFrame(windowRect);
        int windowWidth = windowRect.right - windowRect.left;

        LinearLayout baseLayout = new LinearLayout( this );
        baseLayout.setOrientation( LinearLayout.VERTICAL );
        baseLayout.setLayoutParams( layoutParams );
        baseLayout.setPadding( margin, margin, 0, 0 );
        baseScroller.addView( baseLayout );

        for( int i =0; i < mImages.length; i++ ) {

            if( ( i%width ) == 0 ) {

                layoutList.add((i / width), new LinearLayout(this));
                layoutList.get(i / width).setOrientation(LinearLayout.HORIZONTAL);
                layoutList.get(i / width).setGravity(Gravity.LEFT);
                layoutList.get(i / width).setLayoutParams(containerParams);

                baseLayout.addView(layoutList.get(i / width));
            }

            imageList.add( i, new ImageView( this ) );
            imageList.get(i).setLayoutParams( imageParams );
            imageList.get(i).setScaleType( ImageView.ScaleType.FIT_XY );
            imageList.get(i).setPadding( 0, 0, margin, margin );
            IceImageUtils.bitmapLoadAsync( imageList.get(i), getApplicationContext().getResources(), mImages[i], ( windowWidth / width ) - ( margin * width + margin ) / width, ( windowWidth / width ) - ( margin * width + margin ) / width );
            imageList.get(i).setAdjustViewBounds( true );
            layoutList.get( i / width ).addView( imageList.get(i) );
        }
    }
}
