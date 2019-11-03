@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXMasonryPane
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXMasonryPane] with initialization block. */
inline fun jfxMasonryPane(
    init: (@LayoutDslMarker JFXMasonryPane).() -> Unit
): JFXMasonryPane = JFXMasonryPane().apply(init)

/** Add a [JFXMasonryPane] to this manager. */
fun NodeManager.jfxMasonryPane(): JFXMasonryPane =
    addNode(JFXMasonryPane())

/** Add a [JFXMasonryPane] with initialization block to this manager. */
inline fun NodeManager.jfxMasonryPane(
    init: (@LayoutDslMarker JFXMasonryPane).() -> Unit
): JFXMasonryPane = addNode(JFXMasonryPane(), init)
