@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.web.WebView

/** Add a [WebView] to this manager. */
fun NodeManager.webView(): WebView =
    WebView().add()

/** Add a [WebView] with initialization block to this manager. */
inline fun NodeManager.webView(
    init: (@LayoutDslMarker WebView).() -> Unit
): WebView = webView().apply(init)
