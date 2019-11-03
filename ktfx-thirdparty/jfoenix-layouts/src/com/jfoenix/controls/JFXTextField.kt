@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXTextField
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXTextField] with initialization block. */
inline fun jfxTextField(
    text: String? = null,
    init: (@LayoutDslMarker JFXTextField).() -> Unit
): JFXTextField = JFXTextField(text).apply(init)

/** Add a [JFXTextField] to this manager. */
fun NodeManager.jfxTextField(
    text: String? = null
): JFXTextField = addNode(JFXTextField(text))

/** Add a [JFXTextField] with initialization block to this manager. */
inline fun NodeManager.jfxTextField(
    text: String? = null,
    init: (@LayoutDslMarker JFXTextField).() -> Unit
): JFXTextField = addNode(JFXTextField(text), init)
