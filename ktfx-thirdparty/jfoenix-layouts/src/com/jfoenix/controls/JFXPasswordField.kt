@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXPasswordField
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXPasswordField] with initialization block. */
inline fun jfxPasswordField(
    init: (@LayoutDslMarker JFXPasswordField).() -> Unit
): JFXPasswordField = JFXPasswordField().apply(init)

/** Add a [JFXPasswordField] to this manager. */
fun NodeManager.jfxPasswordField(): JFXPasswordField =
    addNode(JFXPasswordField())

/** Add a [JFXPasswordField] with initialization block to this manager. */
inline fun NodeManager.jfxPasswordField(
    init: (@LayoutDslMarker JFXPasswordField).() -> Unit
): JFXPasswordField = addNode(JFXPasswordField(), init)
