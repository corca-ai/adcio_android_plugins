package ai.corca.adcio_analytics.feature

import ai.corca.adcio_analytics.R
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.core.content.withStyledAttributes

class AdcioImpressionDetector @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    private val myViewTreeObserver: ViewTreeObserver = this.viewTreeObserver
    private var isVisible: Boolean = false
    private val rect = Rect()
    var useImpression: Boolean = true
    lateinit var manager: AdcioImpressionDetectorManager

    init {
        context.withStyledAttributes(attrs, R.styleable.AdcioImpressionDetector, defStyleAttr) {
            useImpression = getBoolean(R.styleable.AdcioImpressionDetector_use_impression, true)
        }

        Log.d("TestTest", "$useImpression")

        if (useImpression) {
            myViewTreeObserver.addOnDrawListener {
                getGlobalVisibleRect(rect).let {
                    if (isVisible != it) {
                        isVisible = it
                        if (isVisible && manager.adcioAnalyticsHistory.getImpressionHistories()
                                .contains(manager.adsetId).not()
                        ) {
                            // onImpression()
                        }
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
