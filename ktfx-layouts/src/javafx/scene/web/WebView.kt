@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.web.WebView

/** Create a [WebView] with initialization block. */
inline fun webView(
    init: (@LayoutDslMarker WebView).() -> Unit
): WebView = WebView().apply(init)

/** Add a [WebView] to this manager. */
fun NodeManager.webView(): WebView =
    addNode(WebView())

/** Add a [WebView] with initialization block to this manager. */
inline fun NodeManager.webView(
    init: (@LayoutDslMarker WebView).() -> Unit
): WebView = addNode(WebView(), init)
