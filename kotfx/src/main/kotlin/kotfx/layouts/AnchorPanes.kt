@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.Pane
import kotfx._Pane
import kotfx.internal.LayoutDsl

class _AnchorPane : AnchorPane(), _Pane {
    override val node: Pane get() = this

    inline infix fun <N : Node> N.anchorTop(value: Number?): N = apply { setTopAnchor(this, value?.toDouble()) }
    inline infix fun <N : Node> N.anchorLeft(value: Number?): N = apply { setLeftAnchor(this, value?.toDouble()) }
    inline infix fun <N : Node> N.anchorBottom(value: Number?): N = apply { setBottomAnchor(this, value?.toDouble()) }
    inline infix fun <N : Node> N.anchorRight(value: Number?): N = apply { setRightAnchor(this, value?.toDouble()) }

    inline val Node.anchorTop: Double get() = getTopAnchor(this) ?: 0.0
    inline val Node.anchorLeft: Double get() = getLeftAnchor(this) ?: 0.0
    inline val Node.anchorBottom: Double get() = getBottomAnchor(this) ?: 0.0
    inline val Node.anchorRight: Double get() = getRightAnchor(this) ?: 0.0

    override fun <T : Node> T.clearConstraints(): T = apply { clearConstraints(this) }
}

inline fun anchorPaneOf(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init)
inline fun _Pane.anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = anchorPaneOf(init).add()