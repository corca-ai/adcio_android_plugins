package ai.corca.adcio_android_plugins

import ai.corca.adcio_analytics.feature.AdcioAnalyticsHistory
import android.app.Application

class AdcioAndroidPluginsApplication : Application() {

    lateinit var adcioAnalyticsHistory: AdcioAnalyticsHistory
    override fun onCreate() {
        super.onCreate()
        adcioAnalyticsHistory = AdcioAnalyticsHistory()
    }
}
