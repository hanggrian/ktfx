@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextArea
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXTextArea] with initialization block. */
inline fun jfxTextArea(
    text: String? = null,
    init: (@LayoutDslMarker JFXTextArea).() -> Unit
): JFXTextArea = JFXTextArea(text).apply(init)

/** Add a [JFXTextArea] to this manager. */
fun NodeManager.jfxTextArea(
    text: String? = null
): JFXTextArea = addNode(JFXTextArea(text))

/** Add a [JFXTextArea] with initialization block to this manager. */
inline fun NodeManager.jfxTextArea(
    text: String? = null,
    init: (@LayoutDslMarker JFXTextArea).() -> Unit
): JFXTextArea = addNode(JFXTextArea(text), init)
