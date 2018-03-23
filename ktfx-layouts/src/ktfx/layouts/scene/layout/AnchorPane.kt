package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane

@Suppress("ClassName")
open class _AnchorPane : AnchorPane(), ChildManager, ConstrainedPane {

    infix fun <N : Node> N.anchors(value: Int?): N = apply {
        setTopAnchor(this, value?.toDouble())
        setLeftAnchor(this, value?.toDouble())
        setBottomAnchor(this, value?.toDouble())
        setRightAnchor(this, value?.toDouble())
    }

    infix fun <N : Node> N.anchorTop(value: Int?): N = apply { setTopAnchor(this, value?.toDouble()) }
    infix fun <N : Node> N.anchorLeft(value: Int?): N = apply { setLeftAnchor(this, value?.toDouble()) }
    infix fun <N : Node> N.anchorBottom(value: Int?): N = apply { setBottomAnchor(this, value?.toDouble()) }
    infix fun <N : Node> N.anchorRight(value: Int?): N = apply { setRightAnchor(this, value?.toDouble()) }

    val Node.anchorTop: Int get() = getTopAnchor(this)?.toInt() ?: 0
    val Node.anchorLeft: Int get() = getLeftAnchor(this)?.toInt() ?: 0
    val Node.anchorBottom: Int get() = getBottomAnchor(this)?.toInt() ?: 0
    val Node.anchorRight: Int get() = getRightAnchor(this)?.toInt() ?: 0

    override fun Node.reset() = clearConstraints(this)
}

inline fun anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init)

inline fun Manager<Node>.anchorPane(init: (@LayoutDsl _AnchorPane).() -> Unit): AnchorPane = ktfx.layouts.anchorPane(init).add()