package com.thunderclouddev.tunedeeplinking

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.tune.Tune
import com.tune.TuneDeeplinkListener

/**
 * Created by David Whitman on 06 November, 2016.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Tune.init(this, "193294", "93241473ebab9a4975eff08dd94e84bb");

        Tune.getInstance().checkForDeferredDeeplink(object : TuneDeeplinkListener {
            override fun didReceiveDeeplink(deeplink: String) {
                // Handle the deferred deeplink here
                // e.g. open the link
                if ("" != deeplink) {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(deeplink)))
                    Log.e("", "HELLO!!!!")
                }
            }

            override fun didFailDeeplink(error: String) {
                // Error was encountered
            }
        })
    }
}