@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.internal.KtfxInternals

/**
 * [VBox] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxVBox(spacing: Double) : VBox(spacing), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    final override val childCount: Int get() = childrenUnmodifiable.size

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Children vertical grow priority in this layout. */
    inline var Node.vgrow: Priority?
        @JvmName("getVgrow2") get() = getVgrow(this)
        @JvmName("setVgrow2") set(value) = setVgrow(this, value)

    /** Configure vertical grow fluidly using infix operator. */
    infix fun <C : Node> C.vgrow(priority: Priority): C = apply { vgrow = priority }

    /** Configure vertical grow fluidly using infix operator. */
    infix fun <C : Node> C.vgrow(always: Boolean): C = vgrow(if (always) Priority.ALWAYS else Priority.NEVER)

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
        @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            margin = Insets(topMargin ?: 0.0, value ?: 0.0, bottomMargin ?: 0.0, value ?: 0.0)
        }

    /** Sets top and bottom margin of this children. */
    var Node.verticalMargin: Double?
        @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            margin = Insets(value ?: 0.0, rightMargin ?: 0.0, value ?: 0.0, leftMargin ?: 0.0)
        }

    /** Sets margin to all sides of this children. */
    var Node.allMargin: Double?
        @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
        inline set(value) {
            margin = Insets(value ?: 0.0)
        }

    /** Configure margin fluidly using infix operator. */
    infix fun <C : Node> C.margin(insets: Insets): C = apply { margin = insets }

    /** Configure top margin fluidly using infix operator. */
    infix fun <C : Node> C.topMargin(margin: Double): C = apply { topMargin = margin }

    /** Configure right margin fluidly using infix operator. */
    infix fun <C : Node> C.rightMargin(margin: Double): C = apply { rightMargin = margin }

    /** Configure bottom margin fluidly using infix operator. */
    infix fun <C : Node> C.bottomMargin(margin: Double): C = apply { bottomMargin = margin }

    /** Configure left margin fluidly using infix operator. */
    infix fun <C : Node> C.leftMargin(margin: Double): C = apply { leftMargin = margin }

    /** Configure horizontal margin fluidly using infix operator. */
    infix fun <C : Node> C.horizontalMargin(margin: Double): C = apply { horizontalMargin = margin }

    /** Configure vertical margin fluidly using infix operator. */
    infix fun <C : Node> C.verticalMargin(margin: Double): C = apply { verticalMargin = margin }

    /** Configure all margin fluidly using infix operator. */
    infix fun <C : Node> C.allMargin(margin: Double): C = apply { allMargin = margin }
}

/** Create a [VBox] with initialization block. */
inline fun vbox(
    spacing: Double = 0.0,
    configuration: (@LayoutsDslMarker KtfxVBox).() -> Unit
): VBox {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxVBox(spacing).apply(configuration)
}

/** Add a [VBox] to this manager. */
fun NodeManager.vbox(
    spacing: Double = 0.0
): VBox = addChild(KtfxVBox(spacing))

/** Add a [VBox] with initialization block to this manager. */
inline fun NodeManager.vbox(
    spacing: Double = 0.0,
    configuration: (@LayoutsDslMarker KtfxVBox).() -> Unit
): VBox {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxVBox(spacing), configuration)
}
