package kotfx

import javafx.scene.Node
import javafx.scene.layout.AnchorPane

class _AnchorPane : AnchorPane(), ChildManager, ConstrainedPane {
    infix fun <N : Node> N.anchorTop(value: Number?): N = apply { setTopAnchor(this, value?.toDouble()) }
    infix fun <N : Node> N.anchorLeft(value: Number?): N = apply { setLeftAnchor(this, value?.toDouble()) }
    infix fun <N : Node> N.anchorBottom(value: Number?): N = apply { setBottomAnchor(this, value?.toDouble()) }
    infix fun <N : Node> N.anchorRight(value: Number?): N = apply { setRightAnchor(this, value?.toDouble()) }

    val Node.anchorTop: Double get() = getTopAnchor(this) ?: 0.0
    val Node.anchorLeft: Double get() = getLeftAnchor(this) ?: 0.0
    val Node.anchorBottom: Double get() = getBottomAnchor(this) ?: 0.0
    val Node.anchorRight: Double get() = getRightAnchor(this) ?: 0.0

    override fun <T : Node> T.reset(): T = apply { clearConstraints(this) }
}