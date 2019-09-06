@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.jfoenix

import com.jfoenix.controls.JFXToolbar
import javafx.scene.Node
import ktfx.layouts.HBoxConstraints
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

open class _JFXToolbar : JFXToolbar() {

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
    init: (@LayoutDslMarker _JFXToolbar).() -> Unit
): JFXToolbar = _JFXToolbar().apply(init)

/** Add a [JFXToolbar] to this manager. */
fun NodeManager.jfxToolbar(): JFXToolbar =
    addNode(ktfx.jfoenix.jfxToolbar { })

/** Add a [JFXToolbar] with initialization block to this manager. */
inline fun NodeManager.jfxToolbar(
    init: (@LayoutDslMarker _JFXToolbar).() -> Unit
): JFXToolbar = addNode(ktfx.jfoenix.jfxToolbar(init))
