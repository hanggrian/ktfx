@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import ktfx.internal.KtFXInternals.NO_GETTER
import ktfx.internal.KtFXInternals.noGetter
import ktfx.layouts.internal.ConstrainedPane
import kotlin.DeprecationLevel.ERROR

open class _AnchorPane : AnchorPane(), LayoutManager<Node>, ConstrainedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.clear() = clearConstraints(this)

    infix fun <N : Node> N.anchorAll(value: Double?): N = apply { anchorAll = value }

    infix fun <N : Node> N.anchorTop(value: Double?): N = apply { anchorTop = value }

    infix fun <N : Node> N.anchorLeft(value: Double?): N = apply { anchorLeft = value }

    infix fun <N : Node> N.anchorBottom(value: Double?): N = apply { anchorBottom = value }

    infix fun <N : Node> N.anchorRight(value: Double?): N = apply { anchorRight = value }

    var Node.anchorAll: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            anchorTop = value
            anchorLeft = value
            anchorBottom = value
            anchorRight = value
        }

    var Node.anchorTop: Double?
        get() = getTopAnchor(this)
        set(value) = setTopAnchor(this, value)

    var Node.anchorLeft: Double?
        get() = getLeftAnchor(this)
        set(value) = setLeftAnchor(this, value)

    var Node.anchorBottom: Double?
        get() = getBottomAnchor(this)
        set(value) = setBottomAnchor(this, value)

    var Node.anchorRight: Double?
        get() = getRightAnchor(this)
        set(value) = setRightAnchor(this, value)
}

inline fun anchorPane(): AnchorPane = anchorPane { }

inline fun anchorPane(
    init: (@LayoutDsl _AnchorPane).() -> Unit
): AnchorPane = _AnchorPane().apply(init)

inline fun LayoutManager<Node>.anchorPane(): AnchorPane = anchorPane { }

inline fun LayoutManager<Node>.anchorPane(
    init: (@LayoutDsl _AnchorPane).() -> Unit
): AnchorPane = ktfx.layouts.anchorPane(init).add()