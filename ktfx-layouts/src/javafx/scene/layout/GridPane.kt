@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

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
open class KtfxGridPane : GridPane(), NodeManager, MarginConstraintable, AlignmentConstraintable,
    HGrowConstraintable, VGrowConstraintable {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Constraints.clear(): Unit =
        clearConstraints(node)

    /** Children row index in this layout. */
    var Constraints.rowIndex: Int?
        get() = getRowIndex(node)
        set(value) = setRowIndex(node, value)

    /** Children column index in this layout. */
    var Constraints.columnIndex: Int?
        get() = getColumnIndex(node)
        set(value) = setColumnIndex(node, value)

    /** Configure row index fluidly using infix operator. */
    infix fun Constraints.row(index: Int): Constraints =
        apply { rowIndex = index }

    /** Configure column index fluidly using infix operator. */
    infix fun Constraints.col(index: Int): Constraints =
        apply { columnIndex = index }

    /** Children row span in this layout. */
    var Constraints.rowSpan: Int?
        get() = getRowSpan(node)
        set(value) = setRowSpan(node, value)

    /** Children column span in this layout. */
    var Constraints.columnSpan: Int?
        get() = getColumnSpan(node)
        set(value) = setColumnSpan(node, value)

    /** Configure row span fluidly using infix operator. */
    infix fun Constraints.rowSpan(span: Int): Constraints =
        apply { rowSpan = span }

    /** Configure column span fluidly using infix operator. */
    infix fun Constraints.colSpan(span: Int): Constraints =
        apply { columnSpan = span }

    final override var Constraints.margin: Insets?
        get() = getMargin(node)
        set(value) = setMargin(node, value)

    final override var Constraints.alignment: Pos?
        @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            halignment = value?.hpos
            valignment = value?.vpos
        }

    /** Children horizontal alignment in this layout. */
    var Constraints.halignment: HPos?
        get() = getHalignment(node)
        set(value) = setHalignment(node, value)

    /** Children vertical alignment in this layout. */
    var Constraints.valignment: VPos?
        get() = getValignment(node)
        set(value) = setValignment(node, value)

    /** Configure horizontal alignment fluidly using infix operator. */
    infix fun Constraints.halign(hpos: HPos): Constraints =
        apply { halignment = hpos }

    /** Configure vertical alignment fluidly using infix operator. */
    infix fun Constraints.valign(vpos: VPos): Constraints =
        apply { valignment = vpos }

    /** Children fill width property in this layout. */
    var Constraints.fillWidth: Boolean?
        get() = isFillWidth(node)
        set(value) = setFillWidth(node, value)

    /** Children fill height property in this layout. */
    var Constraints.fillHeight: Boolean?
        get() = isFillHeight(node)
        set(value) = setFillHeight(node, value)

    /** Configure fill width fluidly using infix operator. */
    infix fun Constraints.hfill(fill: Boolean): Constraints =
        apply { fillWidth = fill }

    /** Configure fill height fluidly using infix operator. */
    infix fun Constraints.vfill(fill: Boolean): Constraints =
        apply { fillHeight = fill }

    final override var Constraints.hgrow: Priority?
        get() = getHgrow(node)
        set(value) = setHgrow(node, value)

    final override var Constraints.vgrow: Priority?
        get() = getVgrow(node)
        set(value) = setVgrow(node, value)
}

/** Create a [GridPane] with initialization block. */
inline fun gridPane(
    init: KtfxGridPane.() -> Unit
): GridPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxGridPane().apply(init)
}

/** Add a [GridPane] to this manager. */
fun NodeManager.gridPane(): GridPane =
    addNode(KtfxGridPane())

/** Add a [GridPane] with initialization block to this manager. */
inline fun NodeManager.gridPane(
    init: KtfxGridPane.() -> Unit
): GridPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxGridPane(), init)
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
