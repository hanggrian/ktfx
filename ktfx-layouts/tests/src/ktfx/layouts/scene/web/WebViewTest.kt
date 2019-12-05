package ktfx.layouts.scene.web

import javafx.scene.web.WebView
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.webView

class WebViewTest : LayoutTest<NodeManager, WebView>() {

    override fun createManager() = KtfxPane()
    override fun create() = webView { }
    override fun NodeManager.add() = webView()
    override fun NodeManager.addWithBuilder() = webView { }
}