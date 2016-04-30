package ovh.ice.icecons;

import android.content.Context;

public class IceScreenUtils {

    public static boolean isPortrait( Context context ) {

        return context.getResources().getDisplayMetrics().widthPixels < context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int width( Context context ) {

        return IceScreenUtils.isPortrait( context ) ? context.getResources().getDisplayMetrics().widthPixels : context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int height( Context context ) {

        return IceScreenUtils.isPortrait( context ) ? context.getResources().getDisplayMetrics().heightPixels : context.getResources().getDisplayMetrics().widthPixels;
    }

    public static float densityScale( Context context ) {

        return ( context.getResources().getDisplayMetrics().density );
    }
}