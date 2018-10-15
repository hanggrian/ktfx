@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import ktfx.internal.KtfxInternals
import kotlin.DeprecationLevel.ERROR

open class _AnchorPane(vararg children: Node) : AnchorPane(*children), NodeManager, ConstrainedPane {

    override val collection: MutableCollection<Node> get() = children

    override fun Node.reset(): Unit = clearConstraints(this)

    inline infix fun <N : Node> N.anchorAll(anchorAll: Double?): N = also { it.anchorAll = anchorAll }

    inline infix fun <N : Node> N.anchorTop(anchorTop: Double?): N = also { it.anchorTop = anchorTop }

    inline infix fun <N : Node> N.anchorLeft(anchorLeft: Double?): N = also { it.anchorLeft = anchorLeft }

    inline infix fun <N : Node> N.anchorBottom(anchorBottom: Double?): N = also { it.anchorBottom = anchorBottom }

    inline infix fun <N : Node> N.anchorRight(anchorRight: Double?): N = also { it.anchorRight = anchorRight }

    inline var Node.anchorAll: Double?
        @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
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

/** Creates a [AnchorPane]. */
fun anchorPane(
    vararg children: Node,
    init: ((@LayoutDsl _AnchorPane).() -> Unit)? = null
): AnchorPane = _AnchorPane(*children).also { init?.invoke(it) }

/** Creates a [AnchorPane] and add it to this manager. */
inline fun NodeManager.anchorPane(
    vararg children: Node,
    noinline init: ((@LayoutDsl _AnchorPane).() -> Unit)? = null
): AnchorPane = ktfx.layouts.anchorPane(*children, init = init)()