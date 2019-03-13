@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

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

/** Creates a [JFXToolbar]. */
fun jfxToolbar(
    init: ((@LayoutDslMarker _JFXToolbar).() -> Unit)? = null
): JFXToolbar = _JFXToolbar().also { init?.invoke(it) }

/** Creates a [JFXToolbar] and add it to this manager. */
inline fun NodeManager.jfxToolbar(
    noinline init: ((@LayoutDslMarker _JFXToolbar).() -> Unit)? = null
): JFXToolbar = ktfx.jfoenix.jfxToolbar(init).add()