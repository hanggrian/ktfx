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

open class KtfxGridPane : GridPane(), NodeManager, MarginConstraints,
    AlignConstraints, HAlignConstraints, VAlignConstraints,
    HExpandConstraints, VExpandConstraints {

    final override fun <T : Node> addNode(node: T): T =
        node.also { children += it }

    final override fun Node.reset(): Unit =
        clearConstraints(this)

    /** Conveniently set [KtfxGridPane.row] and [KtfxGridPane.col]. */
    fun Node.setIndex(row: Int?, col: Int?) {
        this.row = row
        this.col = col
    }

    /** Alias for reserved variable [GridPane.setRowIndex]. */
    var Node.row: Int?
        get() = getRowIndex(this)
        set(value) = setRowIndex(this, value)

    /** While `colIndex` are not a reserved variable, it follows the standard set by [row]. */
    var Node.col: Int?
        get() = getColumnIndex(this)
        set(value) = setColumnIndex(this, value)

    /** Conveniently set [KtfxGridPane.rowRange] and [KtfxGridPane.colRange]. */
    inline fun Node.setRange(rowRange: Int?, colRange: Int?) {
        this.rowRange = rowRange
        this.colRange = colRange
    }

    /** Alias for reserved variable [GridPane.setRowSpan]. */
    var Node.rowRange: Int?
        get() = getRowSpan(this)
        set(value) = setRowSpan(this, value)

    /** While `colRange` are not a reserved variable, it follows the standard set by [rowRange]. */
    var Node.colRange: Int?
        get() = getColumnSpan(this)
        set(value) = setColumnSpan(this, value)

    final override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)

    /** Conveniently set [KtfxGridPane.valign] and [KtfxGridPane.halign]. */
    final override var Node.align: Pos?
        @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            valign = value?.vpos
            halign = value?.hpos
        }

    final override var Node.valign: VPos?
        get() = getValignment(this)
        set(value) = setValignment(this, value)

    final override var Node.halign: HPos?
        get() = getHalignment(this)
        set(value) = setHalignment(this, value)

    /** Conveniently set [KtfxGridPane.vfill] and [KtfxGridPane.hfill]. */
    var Node.fill: Boolean?
        @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            vfill = value
            hfill = value
        }

    /** Alias for reserved variable [GridPane.setFillWidth]. */
    var Node.hfill: Boolean?
        get() = isFillWidth(this)
        set(value) = setFillWidth(this, value)

    /** Alias for reserved variable [GridPane.setFillHeight]. */
    var Node.vfill: Boolean?
        get() = isFillHeight(this)
        set(value) = setFillHeight(this, value)

    final override var Node.hexpand: Priority?
        get() = getHgrow(this)
        set(value) = setHgrow(this, value)

    final override var Node.vexpand: Priority?
        get() = getVgrow(this)
        set(value) = setVgrow(this, value)
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
