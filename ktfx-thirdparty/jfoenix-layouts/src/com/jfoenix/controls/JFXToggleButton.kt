@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXToggleButton
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXToggleButton] with initialization block. */
inline fun jfxToggleButton(
    init: (@LayoutDslMarker JFXToggleButton).() -> Unit
): JFXToggleButton = JFXToggleButton().apply(init)

/** Add a [JFXToggleButton] to this manager. */
fun NodeManager.jfxToggleButton(): JFXToggleButton =
    addNode(JFXToggleButton())

/** Add a [JFXToggleButton] with initialization block to this manager. */
inline fun NodeManager.jfxToggleButton(
    init: (@LayoutDslMarker JFXToggleButton).() -> Unit
): JFXToggleButton = addNode(JFXToggleButton(), init)
