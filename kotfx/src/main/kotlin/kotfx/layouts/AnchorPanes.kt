@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.Pane
import kotfx.internal.LayoutDsl
import kotfx.internal.Noded

class _AnchorPane : AnchorPane(), Noded {

    override val instance: Pane get() = this

    inline infix fun <T : Node> T.topAnchor(value: Double?): T = apply { setTopAnchor(this, value) }
    inline infix fun <T : Node> T.leftAnchor(value: Double?): T = apply { setLeftAnchor(this, value) }
    inline infix fun <T : Node> T.bottomAnchor(value: Double?): T = apply { setBottomAnchor(this, value) }
    inline infix fun <T : Node> T.rightAnchor(value: Double?): T = apply { setRightAnchor(this, value) }

    inline val Node.topAnchor: Double get() = getTopAnchor(this) ?: 0.0
    inline val Node.leftAnchor: Double get() = getLeftAnchor(this) ?: 0.0
    inline val Node.bottomAnchor: Double get() = getBottomAnchor(this) ?: 0.0
    inline val Node.rightAnchor: Double get() = getRightAnchor(this) ?: 0.0

    override fun <T : Node> T.clearConstraints(): T = apply { clearConstraints(this) }
}

inline fun anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init)

inline fun Noded.anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()