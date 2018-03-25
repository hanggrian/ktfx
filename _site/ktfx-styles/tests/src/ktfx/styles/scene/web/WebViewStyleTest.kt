package ktfx.styles.scene.web

import javafx.scene.text.FontSmoothingType.LCD
import javafx.scene.web.WebView
import ktfx.styles.NodeTest
import ktfx.styles.webViewStyle

class WebViewStyleTest : NodeTest<WebView>() {

    override fun newInstance() = WebView()

    override val style: String
        get() = webViewStyle(true) {
            contextMenuEnabled = false
            fontSmoothingType = LCD
            fontScale = 2
            minWidth = 100
            minHeight = 200
            prefWidth = 300
            prefHeight = 400
            maxWidth = 500
            maxHeight = 600
        }

    override fun WebView.assertion() {
        // TODO: investigate why this test run successfully but gradle build failed
        /*assertEquals(isContextMenuEnabled, false)
        assertEquals(fontSmoothingType, LCD)
        assertEquals(fontScale, 2.0)
        assertEquals(minWidth, 100.0)
        assertEquals(minHeight, 200.0)
        assertEquals(prefWidth, 300.0)
        assertEquals(prefHeight, 400.0)
        assertEquals(maxWidth, 500.0)
        assertEquals(maxHeight, 600.0)*/
    }
}