@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import kotlin.DeprecationLevel.ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

/**
 * [HBox] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxHBox(spacing: Double) : HBox(spacing), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    final override val childCount: Int get() = childrenUnmodifiable.size

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Children horizontal grow priority in this layout. */
    inline var Node.hgrow: Priority?
        @JvmName("getHgrow2") get() = getHgrow(this)
        @JvmName("setHgrow2") set(value) = setHgrow(this, value)

    /** Configure horizontal grow fluidly using infix operator. */
    infix fun <C : Node> C.hgrow(priority: Priority): C = apply { hgrow = priority }

    /** Configure horizontal grow fluidly using infix operator. */
    infix fun <C : Node> C.hgrow(always: Boolean): C = hgrow(if (always) Priority.ALWAYS else Priority.NEVER)

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
    var Node.allMargin: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
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

/** Create an [HBox] with initialization block. */
inline fun hbox(
    spacing: Double = 0.0,
    configuration: (@LayoutsDslMarker KtfxHBox).() -> Unit
): HBox {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxHBox(spacing).apply(configuration)
}

/** Add an [HBox] to this manager. */
fun NodeManager.hbox(
    spacing: Double = 0.0
): HBox = addChild(KtfxHBox(spacing))

/** Add an [HBox] with initialization block to this manager. */
inline fun NodeManager.hbox(
    spacing: Double = 0.0,
    configuration: (@LayoutsDslMarker KtfxHBox).() -> Unit
): HBox {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxHBox(spacing), configuration)
}
