@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXTimePicker
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import java.time.LocalTime

/** Creates a [JFXTimePicker]. */
fun jfxTimePicker(
    localTime: LocalTime? = null,
    init: ((@LayoutDsl JFXTimePicker).() -> Unit)? = null
): JFXTimePicker = JFXTimePicker(localTime).also { init?.invoke(it) }

/** Creates a [JFXTimePicker] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxTimePicker(
    localTime: LocalTime? = null,
    noinline init: ((@LayoutDsl JFXTimePicker).() -> Unit)? = null
): JFXTimePicker = ktfx.jfoenix.jfxTimePicker(localTime, init)()