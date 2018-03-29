@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.web.WebView

inline fun webView(): WebView = webView { }

inline fun webView(
    init: (@LayoutDsl WebView).() -> Unit
): WebView = WebView().apply(init)

inline fun LayoutManager<Node>.webView(): WebView = webView { }

inline fun LayoutManager<Node>.webView(
    init: (@LayoutDsl WebView).() -> Unit
): WebView = ktfx.layouts.webView(init).add()