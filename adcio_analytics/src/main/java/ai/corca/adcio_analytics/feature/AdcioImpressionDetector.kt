package ai.corca.adcio_analytics.feature

import ai.corca.adcio_analytics.R
import ai.corca.adcio_analytics.model.AdcioLogOption
import android.content.Context
import android.graphics.Canvas
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

    private var isImpression: Boolean = false
    private val rect = Rect()
    var useImpression: Boolean = true
    lateinit var option: AdcioLogOption

    init {
        context.withStyledAttributes(attrs, R.styleable.AdcioImpressionDetector, defStyleAttr) {
            useImpression = getBoolean(R.styleable.AdcioImpressionDetector_use_impression, true)
        }
    }

    private val onScrollChangedListener = ViewTreeObserver.OnScrollChangedListener {
        if (isMoreThanHalfVisible()) {
            if (!isImpression && useImpression) {
                isImpression = true
                if (AdcioAnalytics.hasImpression(option.adsetId).not()) {
                    onImpression()
                }
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewTreeObserver.removeOnScrollChangedListener(onScrollChangedListener)
    }

    private fun isMoreThanHalfVisible(): Boolean {
        val height = height.toFloat()
        val width = width.toFloat()

        getGlobalVisibleRect(rect)

        return rect.height() > height / 2 && rect.width() > width / 2 &&
                rect.top >= 0 && rect.bottom <= rootView.height &&
                rect.left >= 0 && rect.right <= rootView.width
    }

    private fun onImpression() {
        thread(start = true) {
            AdcioAnalytics.onImpression(
                option = option,
            )
        }
    }
}
