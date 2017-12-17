@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.LayoutDsl

class _AnchorPane : AnchorPane(), ChildManager, Constrained {
    inline infix fun <N : Node> N.anchorTop(value: Number?): N = apply { setTopAnchor(this, value?.toDouble()) }
    inline infix fun <N : Node> N.anchorLeft(value: Number?): N = apply { setLeftAnchor(this, value?.toDouble()) }
    inline infix fun <N : Node> N.anchorBottom(value: Number?): N = apply { setBottomAnchor(this, value?.toDouble()) }
    inline infix fun <N : Node> N.anchorRight(value: Number?): N = apply { setRightAnchor(this, value?.toDouble()) }

    inline val Node.anchorTop: Double get() = getTopAnchor(this) ?: 0.0
    inline val Node.anchorLeft: Double get() = getLeftAnchor(this) ?: 0.0
    inline val Node.anchorBottom: Double get() = getBottomAnchor(this) ?: 0.0
    inline val Node.anchorRight: Double get() = getRightAnchor(this) ?: 0.0

    override fun <T : Node> T.reset(): T = apply { clearConstraints(this) }
}

inline fun anchorPaneOf(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init)
inline fun ChildManager.anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()
inline fun ItemManager.anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()