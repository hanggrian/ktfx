@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.CheckBox

/** Creates a [CheckBox]. */
fun checkBox(
    text: String? = null,
    init: ((@LayoutDslMarker CheckBox).() -> Unit)? = null
): CheckBox = CheckBox(text).also { init?.invoke(it) }

/** Creates a [CheckBox] and add it to this manager. */
inline fun NodeManager.checkBox(
    text: String? = null,
    noinline init: ((@LayoutDslMarker CheckBox).() -> Unit)? = null
): CheckBox = ktfx.layouts.checkBox(text, init).add()
