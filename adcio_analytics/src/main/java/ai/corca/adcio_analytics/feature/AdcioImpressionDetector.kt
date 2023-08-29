package ai.corca.adcio_analytics.feature

import ai.corca.adcio_analytics.R
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import androidx.core.content.withStyledAttributes
import kotlin.concurrent.thread

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

        myViewTreeObserver.addOnDrawListener {
            if (useImpression && this::manager.isInitialized) {
                getGlobalVisibleRect(rect).let {
                    if (isVisible != it) {
                        isVisible = it
                        if (isVisible && AdcioAnalytics.adcioAnalyticsHistory.getImpressionHistories()
                                .contains(manager.adsetId).not()
                        ) {
                            onImpression()
                        }
                    }
                }
            }
        }

    }

    private fun onImpression() {
        Log.d("TestTestTest", "in detector on impression")
        thread(start = true) {
            Log.d("TestTestTest", "in detector on impression thread")
            AdcioAnalytics.onImpression(
                requestId = manager.requestId,
                adsetId = manager.adsetId,
                baseUrl = manager.baseUrl
            )
        }
    }
}

data class AdcioImpressionDetectorManager(
    val requestId: String,
    val adsetId: String,
    val baseUrl: String? = null,
)
