@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.web.WebView
import kotfx._Pane
import kotfx.internal.LayoutDsl

@JvmOverloads
inline fun webViewOf(
        noinline init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = WebView().apply { if (init != null) init() }

@JvmOverloads
inline fun _Pane.webView(
        noinline init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = WebView().apply { if (init != null) init() }.add()