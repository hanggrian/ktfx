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
            override fun <R : Node> R.add(): R = also { leftItems += it }
        }.apply(init)
    }

    fun rightItems(init: (@LayoutDslMarker HBoxConstraints).() -> Unit) {
        object : HBoxConstraints {
            override fun <R : Node> R.add(): R = also { rightItems += it }
        }.apply(init)
    }
}

/** Add a [JFXToolbar] to this manager. */
fun NodeManager.jfxToolbar(): JFXToolbar =
    _JFXToolbar().add()

/** Add a [JFXToolbar] with initialization block to this manager. */
inline fun NodeManager.jfxToolbar(
    init: (@LayoutDslMarker _JFXToolbar).() -> Unit
): JFXToolbar = (jfxToolbar() as _JFXToolbar).apply(init)
