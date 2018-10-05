package example.com.testkotlin.haha.ui

import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import example.com.testkotlin.R
import example.com.testkotlin.haha.activity.AnkoToXml
import org.jetbrains.anko.*

/**
 * Created by admin on 2017/8/18.
 */
class AnkoToXmlUi : AnkoComponent<AnkoToXml> {
    override fun createView(ui: AnkoContext<AnkoToXml>): View = with(ui) {
        return verticalLayout {
            lparams(width = matchParent, height = wrapContent)
            imageView(R.mipmap.anko_logo).
                    lparams(width = matchParent) {
                        bottomMargin = dip(50)
                    }

            button("Tap to Like") {
//                onClick { toast("Thanks for the love!") }
            }

            textView {
                lparams(width = wrapContent, height = wrapContent)
                id = R.id.tv_anko
                text = "我是海贼王路飞"
                textSize = 20f
                typeface = Typeface.MONOSPACE
                padding = dip(5)
                horizontalGravity = Gravity.CENTER_HORIZONTAL
            }
        }
    }
}