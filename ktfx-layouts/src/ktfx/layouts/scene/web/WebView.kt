@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.web.WebView

/** Creates a [WebView]. */
fun webView(
    init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = WebView().also {
    init?.invoke(it)
}

/** Creates a [WebView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.webView(
    noinline init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = ktfx.layouts.webView(init)()