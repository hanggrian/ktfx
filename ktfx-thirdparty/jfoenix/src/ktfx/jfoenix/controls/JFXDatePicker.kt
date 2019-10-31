@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXDatePicker
import java.time.LocalDate
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXDatePicker] with initialization block. */
inline fun jfxDatePicker(
    date: LocalDate? = null,
    init: (@LayoutDslMarker JFXDatePicker).() -> Unit
): JFXDatePicker = JFXDatePicker(date).apply(init)

/** Add a [JFXDatePicker] to this manager. */
fun NodeManager.jfxDatePicker(
    date: LocalDate? = null
): JFXDatePicker = addNode(JFXDatePicker(date))

/** Add a [JFXDatePicker] with initialization block to this manager. */
inline fun NodeManager.jfxDatePicker(
    date: LocalDate? = null,
    init: (@LayoutDslMarker JFXDatePicker).() -> Unit
): JFXDatePicker = addNode(JFXDatePicker(date), init)
