@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXCheckBox
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXCheckBox] with initialization block. */
inline fun jfxCheckBox(
    text: String? = null,
    init: (@LayoutDslMarker JFXCheckBox).() -> Unit
): JFXCheckBox = JFXCheckBox(text).apply(init)

/** Add a [JFXCheckBox] to this manager. */
fun NodeManager.jfxCheckBox(
    text: String? = null
): JFXCheckBox = addNode(JFXCheckBox(text))

/** Add a [JFXCheckBox] with initialization block to this manager. */
inline fun NodeManager.jfxCheckBox(
    text: String? = null,
    init: (@LayoutDslMarker JFXCheckBox).() -> Unit
): JFXCheckBox = addNode(JFXCheckBox(text), init)
