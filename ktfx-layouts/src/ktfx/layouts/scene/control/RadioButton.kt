@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.RadioButton
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [RadioButton]. */
fun radioButton(
    text: String? = null,
    init: ((@LayoutDsl RadioButton).() -> Unit)? = null
): RadioButton = RadioButton(text).also { init?.invoke(it) }

/** Creates a [RadioButton] and add it to this manager. */
inline fun NodeManager.radioButton(
    text: String? = null,
    noinline init: ((@LayoutDsl RadioButton).() -> Unit)? = null
): RadioButton = ktfx.layouts.radioButton(text, init)()