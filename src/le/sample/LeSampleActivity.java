package le.sample;

import de.madvertise.android.sdk.MadvertiseView;
import de.madvertise.android.sdk.MadvertiseView.MadvertiseViewCallbackListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class LeSampleActivity extends Activity  implements MadvertiseViewCallbackListener {
	
	
	 private MadvertiseView mMadView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        // set the layout
        setContentView(R.layout.main);

        // set the callback listener, to receive a message when an ad was loaded
        mMadView = (MadvertiseView) findViewById(R.id.madad);
        mMadView.setMadvertiseViewCallbackListener(this);
        
    }
    
    
    /**
     * Notifies the listener on success or failure
     * 
     * @param succeed true, if an ad could be loading, else false
     * @param madView specified view
     */
    public void onLoaded(final boolean succeed, final MadvertiseView madView) {
        if (succeed) {
            // ad loaded
            Log.d("YOUR_LOG_TAG", "Ad successfully loaded");
        } else {
            // ad could not be loaded
            Log.w("YOUR_LOG_TAG", "Ad could not be loaded");
        }
    }

    public void onError(final Exception exception) {
        // This method is most times called when there is a
        // SocketTimeoutException.
        // Do something with the exception
    }

    public void onIllegalHttpStatusCode(final int statusCode, final String message) {
        // called when the madvertise-server did not answer with a HTTP-okay
        // statuscode (200).
        // Statuscode 204 usually means your device is not known to the
        // madvertise-server yet.
    }

    public void onAdClicked() {
        Log.d("YOUR_LOG_TAG", "Ad clicked");
        // stop loading new ads and "remove" the view from the layout
//        mMadView.setFetchingAdsEnabled(false);
//        mMadView.setVisibility(View.GONE);
    }

    public void onApplicationPause() {
        // called when a rich media ad is expanded. Should then call onPause().
        this.onPause();
    }

    public void onApplicationResume() {
        // called when a rich media ad is expanded. Should then call onPause().
        this.onResume();
    }
    
}