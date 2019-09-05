@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDatePicker
import java.time.LocalDate
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXDatePicker] to this manager. */
fun NodeManager.jfxDatePicker(
    date: LocalDate? = null
): JFXDatePicker = JFXDatePicker(date).add()

/** Add a [JFXDatePicker] with initialization block to this manager. */
inline fun NodeManager.jfxDatePicker(
    date: LocalDate? = null,
    init: (@LayoutDslMarker JFXDatePicker).() -> Unit
): JFXDatePicker = jfxDatePicker(date).apply(init)
