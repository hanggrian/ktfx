@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.CheckBox
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [CheckBox]. */
fun checkBox(
    text: String? = null,
    init: ((@LayoutDsl CheckBox).() -> Unit)? = null
): CheckBox = CheckBox(text).also { init?.invoke(it) }

/** Creates a [CheckBox] and add it to this manager. */
inline fun NodeManager.checkBox(
    text: String? = null,
    noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null
): CheckBox = ktfx.layouts.checkBox(text, init)()