@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.web.WebView
import kotfx.ChildManager
import kotfx.internal.LayoutDsl

@JvmOverloads
inline fun webView(
        noinline init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = WebView().apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.webView(
        noinline init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = WebView().apply { init?.invoke(this) }.add()