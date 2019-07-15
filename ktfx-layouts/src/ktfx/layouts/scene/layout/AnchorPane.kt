@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals

open class _AnchorPane : AnchorPane(), NodeManager, Constraints {

    override fun <R : Node> R.add(): R = also { children += it }

    override fun Node.reset(): Unit = clearConstraints(this)

    infix fun <N : Node> N.anchorAll(anchorAll: Number?): N = also { it.anchorAll = anchorAll }

    infix fun <N : Node> N.anchorTop(anchorTop: Number?): N = also { it.anchorTop = anchorTop }

    infix fun <N : Node> N.anchorLeft(anchorLeft: Number?): N = also { it.anchorLeft = anchorLeft }

    infix fun <N : Node> N.anchorBottom(anchorBottom: Number?): N = also { it.anchorBottom = anchorBottom }

    infix fun <N : Node> N.anchorRight(anchorRight: Number?): N = also { it.anchorRight = anchorRight }

    var Node.anchorAll: Number?
        @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            anchorTop = value
            anchorLeft = value
            anchorBottom = value
            anchorRight = value
        }

    var Node.anchorTop: Number?
        get() = getTopAnchor(this)
        set(value) = setTopAnchor(this, value?.toDouble())

    var Node.anchorLeft: Number?
        get() = getLeftAnchor(this)
        set(value) = setLeftAnchor(this, value?.toDouble())

    var Node.anchorBottom: Number?
        get() = getBottomAnchor(this)
        set(value) = setBottomAnchor(this, value?.toDouble())

    var Node.anchorRight: Number?
        get() = getRightAnchor(this)
        set(value) = setRightAnchor(this, value?.toDouble())
}

/** Creates a [AnchorPane]. */
fun anchorPane(
    init: ((@LayoutDslMarker _AnchorPane).() -> Unit)? = null
): AnchorPane = _AnchorPane().also { init?.invoke(it) }

/** Creates a [AnchorPane] and add it to this manager. */
inline fun NodeManager.anchorPane(
    noinline init: ((@LayoutDslMarker _AnchorPane).() -> Unit)? = null
): AnchorPane = ktfx.layouts.anchorPane(init).add()
