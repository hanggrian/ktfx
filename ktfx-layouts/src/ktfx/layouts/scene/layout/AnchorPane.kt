@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import ktfx.internal.KtfxInternals
import kotlin.DeprecationLevel.ERROR

open class _AnchorPane : AnchorPane(), NodeInvokable, Constraints {

    override fun <R : Node> R.invoke(): R = also { children += it }

    override fun Node.reset(): Unit = clearConstraints(this)

    inline infix fun <N : Node> N.anchorAll(anchorAll: Number?): N = also { it.anchorAll = anchorAll }

    inline infix fun <N : Node> N.anchorTop(anchorTop: Number?): N = also { it.anchorTop = anchorTop }

    inline infix fun <N : Node> N.anchorLeft(anchorLeft: Number?): N = also { it.anchorLeft = anchorLeft }

    inline infix fun <N : Node> N.anchorBottom(anchorBottom: Number?): N = also { it.anchorBottom = anchorBottom }

    inline infix fun <N : Node> N.anchorRight(anchorRight: Number?): N = also { it.anchorRight = anchorRight }

    inline var Node.anchorAll: Number?
        @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            anchorTop = value
            anchorLeft = value
            anchorBottom = value
            anchorRight = value
        }

    inline var Node.anchorTop: Number?
        get() = getTopAnchor(this)
        set(value) = setTopAnchor(this, value?.toDouble())

    inline var Node.anchorLeft: Number?
        get() = getLeftAnchor(this)
        set(value) = setLeftAnchor(this, value?.toDouble())

    inline var Node.anchorBottom: Number?
        get() = getBottomAnchor(this)
        set(value) = setBottomAnchor(this, value?.toDouble())

    inline var Node.anchorRight: Number?
        get() = getRightAnchor(this)
        set(value) = setRightAnchor(this, value?.toDouble())
}

/** Creates a [AnchorPane]. */
fun anchorPane(
    init: ((@LayoutDsl _AnchorPane).() -> Unit)? = null
): AnchorPane = _AnchorPane().also { init?.invoke(it) }

/** Creates a [AnchorPane] and add it to this manager. */
inline fun NodeInvokable.anchorPane(
    noinline init: ((@LayoutDsl _AnchorPane).() -> Unit)? = null
): AnchorPane = ktfx.layouts.anchorPane(init)()