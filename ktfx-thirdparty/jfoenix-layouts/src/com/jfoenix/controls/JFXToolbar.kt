@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXToolbar
import javafx.scene.Node
import ktfx.layouts.HBoxConstraints
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

open class KtfxJFXToolbar : JFXToolbar() {

    fun leftItems(init: (@LayoutDslMarker HBoxConstraints).() -> Unit) {
        object : HBoxConstraints {
            override fun <T : Node> addNode(node: T): T = node.also { leftItems += it }
        }.apply(init)
    }

    fun rightItems(init: (@LayoutDslMarker HBoxConstraints).() -> Unit) {
        object : HBoxConstraints {
            override fun <T : Node> addNode(node: T): T = node.also { rightItems += it }
        }.apply(init)
    }
}

/** Create a [JFXToolbar] with initialization block. */
inline fun jfxToolbar(
    init: (@LayoutDslMarker KtfxJFXToolbar).() -> Unit
): JFXToolbar = KtfxJFXToolbar().apply(init)

/** Add a [JFXToolbar] to this manager. */
fun NodeManager.jfxToolbar(): JFXToolbar =
    addNode(KtfxJFXToolbar())

/** Add a [JFXToolbar] with initialization block to this manager. */
inline fun NodeManager.jfxToolbar(
    init: (@LayoutDslMarker KtfxJFXToolbar).() -> Unit
): JFXToolbar = addNode(KtfxJFXToolbar(), init)
