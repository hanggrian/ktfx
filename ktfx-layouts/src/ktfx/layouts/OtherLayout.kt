@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.canvas.Canvas
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import javafx.scene.text.Text
import javafx.scene.web.WebView

inline fun canvas(width: Double = 0.0, height: Double = 0.0, noinline init: ((@LayoutDsl Canvas).() -> Unit)? = null): Canvas = Canvas(width, height).apply { init?.invoke(this) }
inline fun ChildManager.canvas(width: Double = 0.0, height: Double = 0.0, noinline init: ((@LayoutDsl Canvas).() -> Unit)? = null): Canvas = ktfx.layouts.canvas(width, height, init).add()
inline fun ItemManager.canvas(width: Double = 0.0, height: Double = 0.0, noinline init: ((@LayoutDsl Canvas).() -> Unit)? = null): Canvas = ktfx.layouts.canvas(width, height, init).add()
inline fun ButtonManager.canvas(width: Double = 0.0, height: Double = 0.0, noinline init: ((@LayoutDsl Canvas).() -> Unit)? = null): Canvas = ktfx.layouts.canvas(width, height, init).add()

inline fun imageView(image: Image? = null, noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null): ImageView = ImageView(image).apply { init?.invoke(this) }
inline fun ChildManager.imageView(image: Image? = null, noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null): ImageView = ktfx.layouts.imageView(image, init).add()
inline fun ItemManager.imageView(image: Image? = null, noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null): ImageView = ktfx.layouts.imageView(image, init).add()
inline fun ButtonManager.imageView(image: Image? = null, noinline init: ((@LayoutDsl ImageView).() -> Unit)? = null): ImageView = ktfx.layouts.imageView(image, init).add()

inline fun mediaView(player: MediaPlayer? = null, noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null): MediaView = MediaView(player).apply { init?.invoke(this) }
inline fun ChildManager.mediaView(player: MediaPlayer? = null, noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null): MediaView = ktfx.layouts.mediaView(player, init).add()
inline fun ItemManager.mediaView(player: MediaPlayer? = null, noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null): MediaView = ktfx.layouts.mediaView(player, init).add()
inline fun ButtonManager.mediaView(player: MediaPlayer? = null, noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null): MediaView = ktfx.layouts.mediaView(player, init).add()

inline fun text(text: String? = null, noinline init: ((@LayoutDsl Text).() -> Unit)? = null): Text = Text(text).apply { init?.invoke(this) }
inline fun ChildManager.text(text: String? = null, noinline init: ((@LayoutDsl Text).() -> Unit)? = null): Text = ktfx.layouts.text(text, init).add()
inline fun ItemManager.text(text: String? = null, noinline init: ((@LayoutDsl Text).() -> Unit)? = null): Text = ktfx.layouts.text(text, init).add()
inline fun ButtonManager.text(text: String? = null, noinline init: ((@LayoutDsl Text).() -> Unit)? = null): Text = ktfx.layouts.text(text, init).add()

inline fun webView(noinline init: ((@LayoutDsl WebView).() -> Unit)? = null): WebView = WebView().apply { init?.invoke(this) }
inline fun ChildManager.webView(noinline init: ((@LayoutDsl WebView).() -> Unit)? = null): WebView = ktfx.layouts.webView(init).add()
inline fun ItemManager.webView(noinline init: ((@LayoutDsl WebView).() -> Unit)? = null): WebView = ktfx.layouts.webView(init).add()
inline fun ButtonManager.webView(noinline init: ((@LayoutDsl WebView).() -> Unit)? = null): WebView = ktfx.layouts.webView(init).add()