@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.web.WebView
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [WebView]. */
fun webView(
    init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = WebView().also { init?.invoke(it) }

/** Creates a [WebView] and add it to this manager. */
inline fun NodeManager.webView(
    noinline init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = ktfx.layouts.webView(init)()