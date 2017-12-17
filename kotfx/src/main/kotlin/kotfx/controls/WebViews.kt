@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.web.WebView
import kotfx.internal.ChildManager
import kotfx.internal.KotfxDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun webViewOf(
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