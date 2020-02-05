@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane
import kotlin.DeprecationLevel.ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/**
 * [BorderPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its center. There is currently no way to configure other areas (top, left, right, bottom) with dsl.
 * Instead, create an instance and set it manually (e.g: `left = ktfx.layouts.label()`).
 */
open class KtfxBorderPane : BorderPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { center = it }

    final override val childCount: Int get() = childrenUnmodifiable.size

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Children alignment in this layout. */
    inline var Node.alignment: Pos?
        @JvmName("getAlignment2") get() = getAlignment(this)
        @JvmName("setAlignment2") set(value) = setAlignment(this, value)

    /** Configure alignment fluidly using infix operator. */
    inline infix fun <C : Node> C.align(pos: Pos): C {
        alignment = pos
        return this
    }

    /** Children margin in this layout. */
    inline var Node.margin: Insets?
        @JvmName("getMargin2") get() = getMargin(this)
        @JvmName("setMargin2") set(value) = setMargin(this, value)

    /** Top margin of this children. */
    var Node.topMargin: Double?
        inline get() = margin?.top
        set(value) {
            margin = Insets(value ?: 0.0, rightMargin ?: 0.0, bottomMargin ?: 0.0, leftMargin ?: 0.0)
        }

    /** Right margin of this children. */
    var Node.rightMargin: Double?
        inline get() = margin?.right
        set(value) {
            margin = Insets(topMargin ?: 0.0, value ?: 0.0, bottomMargin ?: 0.0, leftMargin ?: 0.0)
        }

    /** Bottom margin of this children. */
    var Node.bottomMargin: Double?
        inline get() = margin?.bottom
        set(value) {
            margin = Insets(topMargin ?: 0.0, rightMargin ?: 0.0, value ?: 0.0, leftMargin ?: 0.0)
        }

    /** Left margin of this children. */
    var Node.leftMargin: Double?
        inline get() = margin?.left
        set(value) {
            margin = Insets(topMargin ?: 0.0, rightMargin ?: 0.0, bottomMargin ?: 0.0, value ?: 0.0)
        }

    /** Sets left and right margin of this children. */
    var Node.horizontalMargin: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            margin = Insets(topMargin ?: 0.0, value ?: 0.0, bottomMargin ?: 0.0, value ?: 0.0)
        }

    /** Sets top and bottom margin of this children. */
    var Node.verticalMargin: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            margin = Insets(value ?: 0.0, rightMargin ?: 0.0, value ?: 0.0, leftMargin ?: 0.0)
        }

    /** Sets margin to all sides of this children. */
    var Node.margins: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            margin = Insets(value ?: 0.0)
        }

    /** Configure margin fluidly using infix operator. */
    inline infix fun <C : Node> C.margin(insets: Insets): C {
        margin = insets
        return this
    }

    /** Configure top margin fluidly using infix operator. */
    inline infix fun <C : Node> C.topMargin(margin: Double): C {
        topMargin = margin
        return this
    }

    /** Configure right margin fluidly using infix operator. */
    inline infix fun <C : Node> C.rightMargin(margin: Double): C {
        rightMargin = margin
        return this
    }

    /** Configure bottom margin fluidly using infix operator. */
    inline infix fun <C : Node> C.bottomMargin(margin: Double): C {
        bottomMargin = margin
        return this
    }

    /** Configure left margin fluidly using infix operator. */
    inline infix fun <C : Node> C.leftMargin(margin: Double): C {
        leftMargin = margin
        return this
    }

    /** Configure horizontal margin fluidly using infix operator. */
    inline infix fun <C : Node> C.horizontalMargin(margin: Double): C {
        horizontalMargin = margin
        return this
    }

    /** Configure vertical margin fluidly using infix operator. */
    inline infix fun <C : Node> C.verticalMargin(margin: Double): C {
        verticalMargin = margin
        return this
    }

    /** Configure all margin fluidly using infix operator. */
    inline infix fun <C : Node> C.margins(margin: Double): C {
        margins = margin
        return this
    }
}

/** Create a [BorderPane] with initialization block. */
inline fun borderPane(
    init: (@LayoutsDslMarker KtfxBorderPane).() -> Unit
): BorderPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxBorderPane().apply(init)
}

/** Add a [BorderPane] to this manager. */
fun NodeManager.borderPane(): BorderPane = addChild(KtfxBorderPane())

/** Add a [BorderPane] with initialization block to this manager. */
inline fun NodeManager.borderPane(
    init: (@LayoutsDslMarker KtfxBorderPane).() -> Unit
): BorderPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxBorderPane(), init)
}
