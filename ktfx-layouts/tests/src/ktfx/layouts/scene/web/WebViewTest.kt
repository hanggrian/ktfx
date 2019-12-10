package ktfx.layouts.scene.web

import javafx.scene.web.WebView
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.webView
import ktfx.test.LayoutTest
import kotlin.test.Ignore

/** Error on [child1], [child2] and [child3] because creating [WebView] must be in FX thread. */
@Ignore
class WebViewTest : LayoutTest<NodeManager, WebView>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = webView { }
    override fun NodeManager.child2() = webView()
    override fun NodeManager.child3() = webView { }
}