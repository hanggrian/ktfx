@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import ktfx.internal.KtFXInternals.NO_GETTER
import ktfx.internal.KtFXInternals.noGetter
import ktfx.layouts.internal.ConstrainedPane
import kotlin.DeprecationLevel.ERROR

open class _AnchorPane(
    vararg children: Node
) : AnchorPane(*children), LayoutManager<Node>, ConstrainedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    inline infix fun <N : Node> N.anchorAll(anchorAll: Double?): N = also { it.anchorAll = anchorAll }

    inline infix fun <N : Node> N.anchorTop(anchorTop: Double?): N = also { it.anchorTop = anchorTop }

    inline infix fun <N : Node> N.anchorLeft(anchorLeft: Double?): N = also { it.anchorLeft = anchorLeft }

    inline infix fun <N : Node> N.anchorBottom(anchorBottom: Double?): N = also { it.anchorBottom = anchorBottom }

    inline infix fun <N : Node> N.anchorRight(anchorRight: Double?): N = also { it.anchorRight = anchorRight }

    inline var Node.anchorAll: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            anchorTop = value
            anchorLeft = value
            anchorBottom = value
            anchorRight = value
        }

    inline var Node.anchorTop: Double?
        get() = getTopAnchor(this)
        set(value) = setTopAnchor(this, value)

    inline var Node.anchorLeft: Double?
        get() = getLeftAnchor(this)
        set(value) = setLeftAnchor(this, value)

    inline var Node.anchorBottom: Double?
        get() = getBottomAnchor(this)
        set(value) = setBottomAnchor(this, value)

    inline var Node.anchorRight: Double?
        get() = getRightAnchor(this)
        set(value) = setRightAnchor(this, value)
}

inline fun anchorPane(
    vararg children: Node
): AnchorPane = anchorPane(*children) { }

inline fun anchorPane(
    vararg children: Node,
    init: (@LayoutDsl _AnchorPane).() -> Unit
): AnchorPane = _AnchorPane(*children).apply(init)

inline fun LayoutManager<Node>.anchorPane(
    vararg children: Node
): AnchorPane = anchorPane(*children) { }

inline fun LayoutManager<Node>.anchorPane(
    vararg children: Node,
    init: (@LayoutDsl _AnchorPane).() -> Unit
): AnchorPane = ktfx.layouts.anchorPane(*children, init = init).add()