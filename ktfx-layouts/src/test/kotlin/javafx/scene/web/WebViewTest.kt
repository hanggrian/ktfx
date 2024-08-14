package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.web.WebView
import kotlin.test.Ignore

/** Error on [child1], [child2] and [child3] because creating [WebView] must be in FX thread. */
@Ignore
class WebViewTest : LayoutsStyledTest<KtfxPane, WebView>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = webView {}

    override fun KtfxPane.child2() = webView()

    override fun child3() = styledWebView(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledWebView(styleClass = arrayOf("style"))
}
