@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXCheckBox
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXCheckBox]. */
fun jfxCheckBox(
    text: String? = null,
    init: ((@LayoutDsl JFXCheckBox).() -> Unit)? = null
): JFXCheckBox = JFXCheckBox(text).also { init?.invoke(it) }

/** Creates a [JFXCheckBox] and add it to this manager. */
inline fun NodeManager.jfxCheckBox(
    text: String? = null,
    noinline init: ((@LayoutDsl JFXCheckBox).() -> Unit)? = null
): JFXCheckBox = ktfx.jfoenix.jfxCheckBox(text, init)()