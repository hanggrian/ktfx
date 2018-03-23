@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.web.WebView

inline fun webView(noinline init: ((@LayoutDsl WebView).() -> Unit)? = null): WebView = WebView().apply { init?.invoke(this) }
inline fun ChildManager.webView(noinline init: ((@LayoutDsl WebView).() -> Unit)? = null): WebView = ktfx.layouts.webView(init).add()
inline fun ItemManager.webView(noinline init: ((@LayoutDsl WebView).() -> Unit)? = null): WebView = ktfx.layouts.webView(init).add()
inline fun ButtonManager.webView(noinline init: ((@LayoutDsl WebView).() -> Unit)? = null): WebView = ktfx.layouts.webView(init).add()