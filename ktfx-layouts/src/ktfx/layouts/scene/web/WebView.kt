@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.web.WebView

/** Creates a [WebView]. */
fun webView(
    init: ((@LayoutDslMarker WebView).() -> Unit)? = null
): WebView = WebView().also { init?.invoke(it) }

/** Creates a [WebView] and add it to this manager. */
inline fun NodeManager.webView(
    noinline init: ((@LayoutDslMarker WebView).() -> Unit)? = null
): WebView = ktfx.layouts.webView(init).add()
