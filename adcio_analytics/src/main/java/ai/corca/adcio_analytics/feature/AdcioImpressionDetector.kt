package ai.corca.adcio_analytics.feature

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.ViewTreeObserver
import android.widget.FrameLayout

class AdcioImpressionDetector : FrameLayout {

    private val myViewTreeObserver: ViewTreeObserver = this.viewTreeObserver
    private var isVisible: Boolean = false
    private val rect = Rect()
    lateinit var manager: AdcioImpressionDetectorManager

    constructor(context: Context) : super(context)

    constructor(
        context: Context,
        attrs: AttributeSet,
    ) : super(context, attrs) {
        myViewTreeObserver.addOnDrawListener {
            getGlobalVisibleRect(rect).let {
                if (isVisible != it) {
                    isVisible = it
                    if (isVisible && manager.adcioAnalyticsHistory.getImpressionHistories().contains(manager.adsetId).not()) {
                        onImpression()
                    }
                }
            }
        }
    }

    private fun onImpression() {
        AdcioAnalytics.onImpression(
            requestId = manager.requestId,
            adsetId = manager.adsetId,
            baseUrl = manager.baseUrl
        )
    }
}

data class AdcioImpressionDetectorManager(
    val adcioAnalyticsHistory: AdcioAnalyticsHistory,
    val requestId: String,
    val adsetId: String,
    val baseUrl: String? = null,
)
