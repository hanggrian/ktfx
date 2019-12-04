@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.ConstraintsBase
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority
import javafx.scene.layout.RowConstraints
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.internal.KtfxInternals

/**
 * [GridPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxGridPane : GridPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    final override val childCount: Int get() = childrenUnmodifiable.size

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit = clearConstraints(this)

    /** Children row index in this layout. */
    inline var Node.rowIndex: Int?
        @JvmName("getRowIndex2") get() = getRowIndex(this)
        @JvmName("setRowIndex2") set(value) = setRowIndex(this, value)

    /** Children column index in this layout. */
    inline var Node.columnIndex: Int?
        @JvmName("getColumnIndex2") get() = getColumnIndex(this)
        @JvmName("setColumnIndex2") set(value) = setColumnIndex(this, value)

    /** Children row span in this layout. */
    inline var Node.rowSpan: Int?
        @JvmName("getRowSpan2") get() = getRowSpan(this)
        @JvmName("setRowSpan2") set(value) = setRowSpan(this, value)

    /** Children column span in this layout. */
    inline var Node.columnSpan: Int?
        @JvmName("getColumnSpan2") get() = getColumnSpan(this)
        @JvmName("setColumnSpan2") set(value) = setColumnSpan(this, value)

    /** Configure row index fluidly using infix operator. */
    inline infix fun <C : Node> C.row(index: Int): C = apply { rowIndex = index }

    /** Configure row index and span fluidly using infix operator. */
    inline infix fun <C : Node> C.row(pair: Pair<Int, Int>): C =
        apply {
            rowIndex = pair.first
            rowSpan = pair.second
        }

    /** Configure column index fluidly using infix operator. */
    inline infix fun <C : Node> C.col(index: Int): C = apply { columnIndex = index }

    /** Configure column index and span fluidly using infix operator. */
    inline infix fun <C : Node> C.col(pair: Pair<Int, Int>): C =
        apply {
            columnIndex = pair.first
            columnSpan = pair.second
        }

    /** Children margin in this layout. */
    inline var Node.margin: Insets?
        @JvmName("getMargin2") get() = getMargin(this)
        @JvmName("setMargin2") set(value) = setMargin(this, value)

    /** Configure children margin, taking account of current margin. */
    inline fun Node.updateMargin(
        top: Double? = margin?.top,
        right: Double? = margin?.right,
        bottom: Double? = margin?.bottom,
        left: Double? = margin?.left
    ) {
        margin = Insets(top ?: 0.0, right ?: 0.0, bottom ?: 0.0, left ?: 0.0)
    }

    /** Configure margin fluidly using infix operator. */
    inline infix fun <C : Node> C.margin(margin: Insets): C = apply { this.margin = margin }

    /** Configure all sides margin fluidly using infix operator. */
    inline infix fun <C : Node> C.marginAll(margin: Double): C = apply { this.margin = Insets(margin) }

    /** Configure top margin fluidly using infix operator. */
    inline infix fun <C : Node> C.marginTop(margin: Double): C = apply { updateMargin(top = margin) }

    /** Configure right margin fluidly using infix operator. */
    inline infix fun <C : Node> C.marginRight(margin: Double): C = apply { updateMargin(right = margin) }

    /** Configure bottom margin fluidly using infix operator. */
    inline infix fun <C : Node> C.marginBottom(margin: Double): C = apply { updateMargin(bottom = margin) }

    /** Configure left margin fluidly using infix operator. */
    inline infix fun <C : Node> C.marginLeft(margin: Double): C = apply { updateMargin(left = margin) }

    /** Children alignment in this layout. */
    inline var Node.alignment: Pos?
        @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            halignment = value?.hpos
            valignment = value?.vpos
        }

    /** Children horizontal alignment in this layout. */
    inline var Node.halignment: HPos?
        @JvmName("getHalignment2") get() = getHalignment(this)
        @JvmName("setHalignment2") set(value) = setHalignment(this, value)

    /** Children vertical alignment in this layout. */
    inline var Node.valignment: VPos?
        @JvmName("getValignment2") get() = getValignment(this)
        @JvmName("setValignment2") set(value) = setValignment(this, value)

    /** Configure alignment fluidly using infix operator. */
    inline infix fun <C : Node> C.align(pos: Pos): C = apply { alignment = pos }

    /** Configure horizontal alignment fluidly using infix operator. */
    inline infix fun <C : Node> C.halign(hpos: HPos): C = apply { halignment = hpos }

    /** Configure vertical alignment fluidly using infix operator. */
    inline infix fun <C : Node> C.valign(vpos: VPos): C = apply { valignment = vpos }

    /** Children fill width property in this layout. */
    inline var Node.fillWidth: Boolean?
        get() = isFillWidth(this)
        @JvmName("setFillWidth2") set(value) = setFillWidth(this, value)

    /** Children fill height property in this layout. */
    inline var Node.fillHeight: Boolean?
        get() = isFillHeight(this)
        @JvmName("setFillHeight2") set(value) = setFillHeight(this, value)

    /** Configure fill width fluidly using infix operator. */
    inline infix fun <C : Node> C.fillWidth(fill: Boolean): C = apply { fillWidth = fill }

    /** Configure fill height fluidly using infix operator. */
    inline infix fun <C : Node> C.fillHeight(fill: Boolean): C = apply { fillHeight = fill }

    /** Children horizontal grow priority in this layout. */
    inline var Node.hgrow: Priority?
        @JvmName("getHgrow2") get() = getHgrow(this)
        @JvmName("setHgrow2") set(value) = setHgrow(this, value)

    /** Children vertical grow priority in this layout. */
    inline var Node.vgrow: Priority?
        @JvmName("getVgrow2") get() = getVgrow(this)
        @JvmName("setVgrow2") set(value) = setVgrow(this, value)

    /** Configure horizontal grow fluidly using infix operator. */
    inline infix fun <C : Node> C.hgrow(priority: Priority): C = apply { hgrow = priority }

    /** Configure horizontal grow fluidly using infix operator. */
    inline infix fun <C : Node> C.hgrow(always: Boolean): C = hgrow(if (always) Priority.ALWAYS else Priority.NEVER)

    /** Configure vertical grow fluidly using infix operator. */
    inline infix fun <C : Node> C.vgrow(priority: Priority): C = apply { vgrow = priority }

    /** Configure vertical grow fluidly using infix operator. */
    inline infix fun <C : Node> C.vgrow(always: Boolean): C = vgrow(if (always) Priority.ALWAYS else Priority.NEVER)
}

/** Create a [GridPane] with initialization block. */
inline fun gridPane(
    init: (@LayoutsDslMarker KtfxGridPane).() -> Unit
): GridPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxGridPane().apply(init)
}

/** Add a [GridPane] to this manager. */
fun NodeManager.gridPane(): GridPane = addChild(KtfxGridPane())

/** Add a [GridPane] with initialization block to this manager. */
inline fun NodeManager.gridPane(
    init: (@LayoutsDslMarker KtfxGridPane).() -> Unit
): GridPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxGridPane(), init)
}

/** Interface to build [GridPane] row and column constraints with Kotlin DSL. */
interface ConstraintsBuilder<out T : ConstraintsBase> {

    fun constraints(): T

    fun constraints(init: T.() -> Unit): T =
        constraints().apply(init)

    fun constraints(size: Double): T

    fun constraints(size: Double, init: T.() -> Unit): T =
        constraints(size).apply(init)

    fun constraints(minSize: Double, prefSize: Double, maxSize: Double): T

    fun constraints(minSize: Double, prefSize: Double, maxSize: Double, init: T.() -> Unit): T =
        constraints(minSize, prefSize, maxSize).apply(init)
}

private abstract class ConstraintsBuilderImpl<T : ConstraintsBase> : ConstraintsBuilder<T> {

    companion object {
        fun ofRow(): ConstraintsBuilderImpl<RowConstraints> = object : ConstraintsBuilderImpl<RowConstraints>() {
            override fun newInstance(): RowConstraints = RowConstraints()
            override fun newInstance(width: Double): RowConstraints = RowConstraints(width)
            override fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): RowConstraints =
                RowConstraints(width, prefWidth, maxWidth)
        }

        fun ofColumn(): ConstraintsBuilderImpl<ColumnConstraints> =
            object : ConstraintsBuilderImpl<ColumnConstraints>() {
                override fun newInstance(): ColumnConstraints = ColumnConstraints()
                override fun newInstance(width: Double): ColumnConstraints = ColumnConstraints(width)
                override fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): ColumnConstraints =
                    ColumnConstraints(width, prefWidth, maxWidth)
            }
    }

    val collection: MutableCollection<T> = mutableListOf()

    abstract fun newInstance(): T

    abstract fun newInstance(width: Double): T

    abstract fun newInstance(width: Double, prefWidth: Double, maxWidth: Double): T

    override fun constraints(): T =
        newInstance().also { collection += it }

    override fun constraints(size: Double): T =
        newInstance(size).also { collection += it }

    override fun constraints(minSize: Double, prefSize: Double, maxSize: Double): T =
        newInstance(minSize, prefSize, maxSize).also { collection += it }
}

/** Invokes a row constraints DSL builder. */
fun GridPane.rowConstraints(init: ConstraintsBuilder<RowConstraints>.() -> Unit) {
    rowConstraints += ConstraintsBuilderImpl.ofRow().apply(init).collection
}

/** Invokes a column constraints DSL builder. */
fun GridPane.columnConstraints(init: ConstraintsBuilder<ColumnConstraints>.() -> Unit) {
    columnConstraints += ConstraintsBuilderImpl.ofColumn().apply(init).collection
}
