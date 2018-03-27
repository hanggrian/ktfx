@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import ktfx.layouts.internal.ConstrainedPane

open class _AnchorPane : AnchorPane(), LayoutManager<Node>, ConstrainedPane {

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

    override fun <T : Node> T.add(): T = also { children += it }
}

inline fun anchorPane(
    noinline init: ((@LayoutDsl _AnchorPane).() -> Unit)? = null
): AnchorPane = _AnchorPane().also { init?.invoke(it) }

inline fun LayoutManager<Node>.anchorPane(
    noinline init: ((@LayoutDsl _AnchorPane).() -> Unit)? = null
): AnchorPane = ktfx.layouts.anchorPane(init).add()