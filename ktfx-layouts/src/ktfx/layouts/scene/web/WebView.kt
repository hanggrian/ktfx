@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.web.WebView

inline fun webView(noinline init: ((@LayoutDsl WebView).() -> Unit)? = null): WebView = WebView().apply { init?.invoke(this) }

inline fun Manager<Node>.webView(noinline init: ((@LayoutDsl WebView).() -> Unit)? = null): WebView = ktfx.layouts.webView(init).add()