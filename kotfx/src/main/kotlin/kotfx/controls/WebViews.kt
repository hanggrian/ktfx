@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.web.WebView
import kotfx.controls.ItemManager
import kotfx.internal.KotfxDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun webView(
        noinline init: ((@KotfxDsl WebView).() -> Unit)? = null
): WebView = WebView().apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.webView(
        noinline init: ((@KotfxDsl WebView).() -> Unit)? = null
): WebView = WebView().apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.webView(
        noinline init: ((@KotfxDsl WebView).() -> Unit)? = null
): WebView = WebView().apply { init?.invoke(this) }.add()