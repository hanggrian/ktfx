@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.Pane
import kotfx.internal.ChildManager
import kotfx.internal.LayoutDsl

class _AnchorPane : AnchorPane(), ChildManager {
    override val control: Pane get() = this

    inline infix fun <T : Node> T.anchorTop(value: Number?): T = apply { setTopAnchor(this, value?.toDouble()) }
    inline infix fun <T : Node> T.anchorLeft(value: Number?): T = apply { setLeftAnchor(this, value?.toDouble()) }
    inline infix fun <T : Node> T.anchorBottom(value: Number?): T = apply { setBottomAnchor(this, value?.toDouble()) }
    inline infix fun <T : Node> T.anchorRight(value: Number?): T = apply { setRightAnchor(this, value?.toDouble()) }

    inline val Node.anchorTop: Double get() = getTopAnchor(this) ?: 0.0
    inline val Node.anchorLeft: Double get() = getLeftAnchor(this) ?: 0.0
    inline val Node.anchorBottom: Double get() = getBottomAnchor(this) ?: 0.0
    inline val Node.anchorRight: Double get() = getRightAnchor(this) ?: 0.0

    override fun <T : Node> T.clearConstraints(): T = apply { clearConstraints(this) }
}

inline fun anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init)
inline fun ChildManager.anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()