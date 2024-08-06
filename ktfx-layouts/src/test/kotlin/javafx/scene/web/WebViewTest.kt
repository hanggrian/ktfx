package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.web.WebView
import kotlin.test.Ignore

/** Error on [child1], [child2] and [child3] because creating [WebView] must be in FX thread. */
@Ignore
class WebViewTest : LayoutsTest<KtfxPane, WebView>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): WebView = webView { }

    override fun KtfxPane.child2(): WebView = webView()

    override fun KtfxPane.child3(): WebView = webView { }
}
