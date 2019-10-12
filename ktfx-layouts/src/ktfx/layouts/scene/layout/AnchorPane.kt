@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals

open class KtfxAnchorPane : AnchorPane(), NodeManager, Constraints {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Node.reset(): Unit =
        clearConstraints(this)

    infix fun <T : Node> T.anchorAll(anchorAll: Double?): T =
        also { it.anchorAll = anchorAll }

    infix fun <T : Node> T.anchorTop(anchorTop: Double?): T =
        also { it.anchorTop = anchorTop }

    infix fun <T : Node> T.anchorLeft(anchorLeft: Double?): T =
        also { it.anchorLeft = anchorLeft }

    infix fun <T : Node> T.anchorBottom(anchorBottom: Double?): T =
        also { it.anchorBottom = anchorBottom }

    infix fun <T : Node> T.anchorRight(anchorRight: Double?): T =
        also { it.anchorRight = anchorRight }

    var Node.anchorAll: Double?
        @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
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

/** Create an [AnchorPane] with initialization block. */
inline fun anchorPane(
    init: (@LayoutDslMarker KtfxAnchorPane).() -> Unit
): AnchorPane = KtfxAnchorPane().apply(init)

/** Add an [AnchorPane] to this manager. */
fun NodeManager.anchorPane(): AnchorPane =
    addNode(ktfx.layouts.anchorPane { })

/** Add an [AnchorPane] with initialization block to this manager. */
inline fun NodeManager.anchorPane(
    init: (@LayoutDslMarker KtfxAnchorPane).() -> Unit
): AnchorPane = addNode(ktfx.layouts.anchorPane(init))
