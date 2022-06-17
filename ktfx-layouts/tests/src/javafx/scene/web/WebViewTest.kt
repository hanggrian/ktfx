package ktfx.layouts

import javafx.scene.web.WebView
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.Ignore

/** Error on [child1], [child2] and [child3] because creating [WebView] must be in FX thread. */
@Ignore
class WebViewTest : LayoutsTest<KtfxPane, WebView>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = webView { }
    override fun KtfxPane.child2() = webView()
    override fun KtfxPane.child3() = webView { }
}
