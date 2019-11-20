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

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    inline fun Node.clearConstraints(): Unit =
        clearConstraints(this)

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
    inline infix fun <T : Node> T.row(index: Int): T =
        apply { rowIndex = index }

    /** Configure row index and span fluidly using infix operator. */
    inline infix fun <T : Node> T.row(pair: Pair<Int, Int>): T =
        apply {
            rowIndex = pair.first
            rowSpan = pair.second
        }

    /** Configure column index fluidly using infix operator. */
    inline infix fun <T : Node> T.col(index: Int): T =
        apply { columnIndex = index }

    /** Configure column index and span fluidly using infix operator. */
    inline infix fun <T : Node> T.col(pair: Pair<Int, Int>): T =
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
    inline infix fun <T : Node> T.margin(margin: Insets): T =
        apply { this.margin = margin }

    /** Configure all sides margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginAll(margin: Double): T =
        apply { this.margin = Insets(margin) }

    /** Configure top margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginTop(margin: Double): T =
        apply { updateMargin(top = margin) }

    /** Configure right margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginRight(margin: Double): T =
        apply { updateMargin(right = margin) }

    /** Configure bottom margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginBottom(margin: Double): T =
        apply { updateMargin(bottom = margin) }

    /** Configure left margin fluidly using infix operator. */
    inline infix fun <T : Node> T.marginLeft(margin: Double): T =
        apply { updateMargin(left = margin) }

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
    inline infix fun <T : Node> T.align(pos: Pos): T =
        apply { alignment = pos }

    /** Configure horizontal alignment fluidly using infix operator. */
    inline infix fun <T : Node> T.halign(hpos: HPos): T =
        apply { halignment = hpos }

    /** Configure vertical alignment fluidly using infix operator. */
    inline infix fun <T : Node> T.valign(vpos: VPos): T =
        apply { valignment = vpos }

    /** Children fill width property in this layout. */
    inline var Node.fillWidth: Boolean?
        get() = isFillWidth(this)
        @JvmName("setFillWidth2") set(value) = setFillWidth(this, value)

    /** Children fill height property in this layout. */
    inline var Node.fillHeight: Boolean?
        get() = isFillHeight(this)
        @JvmName("setFillHeight2") set(value) = setFillHeight(this, value)

    /** Configure fill width fluidly using infix operator. */
    inline infix fun <T : Node> T.fillWidth(fill: Boolean): T =
        apply { fillWidth = fill }

    /** Configure fill height fluidly using infix operator. */
    inline infix fun <T : Node> T.fillHeight(fill: Boolean): T =
        apply { fillHeight = fill }

    /** Children horizontal grow priority in this layout. */
    inline var Node.hgrow: Priority?
        @JvmName("getHgrow2") get() = getHgrow(this)
        @JvmName("setHgrow2") set(value) = setHgrow(this, value)

    /** Children vertical grow priority in this layout. */
    inline var Node.vgrow: Priority?
        @JvmName("getVgrow2") get() = getVgrow(this)
        @JvmName("setVgrow2") set(value) = setVgrow(this, value)

    /** Configure horizontal grow fluidly using infix operator. */
    inline infix fun <T : Node> T.hgrow(priority: Priority): T =
        apply { hgrow = priority }

    /** Configure horizontal grow fluidly using infix operator. */
    inline infix fun <T : Node> T.hgrow(always: Boolean): T =
        hgrow(if (always) Priority.ALWAYS else Priority.NEVER)

    /** Configure vertical grow fluidly using infix operator. */
    inline infix fun <T : Node> T.vgrow(priority: Priority): T =
        apply { vgrow = priority }

    /** Configure vertical grow fluidly using infix operator. */
    inline infix fun <T : Node> T.vgrow(always: Boolean): T =
        vgrow(if (always) Priority.ALWAYS else Priority.NEVER)
}

/** Create a [GridPane] with initialization block. */
inline fun gridPane(
    init: (@KtfxLayoutsDslMarker KtfxGridPane).() -> Unit
): GridPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxGridPane().apply(init)
}

/** Add a [GridPane] to this manager. */
fun NodeManager.gridPane(): GridPane =
    addNode(KtfxGridPane())

/** Add a [GridPane] with initialization block to this manager. */
inline fun NodeManager.gridPane(
    init: (@KtfxLayoutsDslMarker KtfxGridPane).() -> Unit
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
