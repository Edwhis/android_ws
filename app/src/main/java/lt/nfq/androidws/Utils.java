package lt.nfq.androidws;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by eakatauskas on 09/12/2016.
 */

public class Utils {

    public static boolean isConnected(Context context){
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if(info != null && info.isConnected()){
            return true;
        }
        return false;
    }
}
