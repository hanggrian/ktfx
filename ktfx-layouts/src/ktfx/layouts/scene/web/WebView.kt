@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.web.WebView
import ktfx.NodeInvokable
import ktfx.LayoutDsl

/** Creates a [WebView]. */
fun webView(
    init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = WebView().also { init?.invoke(it) }

/** Creates a [WebView] and add it to this manager. */
inline fun NodeInvokable.webView(
    noinline init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = ktfx.layouts.webView(init)()