@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import kotfx.internal.LayoutDsl

class _AnchorPane : AnchorPane(), Noded {

    inline infix fun Node.topAnchor(value: Double?) = setTopAnchor(this, value)
    inline infix fun Node.leftAnchor(value: Double?) = setLeftAnchor(this, value)
    inline infix fun Node.bottomAnchor(value: Double?) = setBottomAnchor(this, value)
    inline infix fun Node.rightAnchor(value: Double?) = setRightAnchor(this, value)

    inline val Node.topAnchor: Double get() = getTopAnchor(this) ?: 0.0
    inline val Node.leftAnchor: Double get() = getLeftAnchor(this) ?: 0.0
    inline val Node.bottomAnchor: Double get() = getBottomAnchor(this) ?: 0.0
    inline val Node.rightAnchor: Double get() = getRightAnchor(this) ?: 0.0

    override fun Node.removeConstraints() = clearConstraints(this)
}

inline fun anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init)

inline fun Noded.anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()