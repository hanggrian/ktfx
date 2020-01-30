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
import kotlin.DeprecationLevel.ERROR
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.internal.KtfxInternals.NO_GETTER
import ktfx.internal.KtfxInternals.noGetter

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
    infix fun <C : Node> C.row(pair: Pair<Int, Int>): C = apply {
        rowIndex = pair.first
        rowSpan = pair.second
    }

    /** Configure column index fluidly using infix operator. */
    inline infix fun <C : Node> C.col(index: Int): C = apply { columnIndex = index }

    /** Configure column index and span fluidly using infix operator. */
    infix fun <C : Node> C.col(pair: Pair<Int, Int>): C = apply {
        columnIndex = pair.first
        columnSpan = pair.second
    }

    /** Children alignment in this layout. */
    var Node.alignment: Pos?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
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
    inline var Node.isFillWidth: Boolean?
        @JvmName("isFillWidth2") get() = isFillWidth(this)
        @JvmName("setFillWidth2") set(value) = setFillWidth(this, value)

    /** Children fill height property in this layout. */
    inline var Node.isFillHeight: Boolean?
        @JvmName("isFillHeight2") get() = isFillHeight(this)
        @JvmName("setFillHeight2") set(value) = setFillHeight(this, value)

    /** Configure fill width fluidly using infix operator. */
    inline infix fun <C : Node> C.fillWidth(fill: Boolean): C = apply { isFillWidth = fill }

    /** Configure fill height fluidly using infix operator. */
    inline infix fun <C : Node> C.fillHeight(fill: Boolean): C = apply { isFillHeight = fill }

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
    infix fun <C : Node> C.hgrow(always: Boolean): C = hgrow(if (always) Priority.ALWAYS else Priority.NEVER)

    /** Configure vertical grow fluidly using infix operator. */
    inline infix fun <C : Node> C.vgrow(priority: Priority): C = apply { vgrow = priority }

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
        set(value) {
            margin = Insets(value ?: 0.0)
        }

    /** Configure margin fluidly using infix operator. */
    inline infix fun <C : Node> C.margin(insets: Insets): C = apply { margin = insets }

    /** Configure top margin fluidly using infix operator. */
    inline infix fun <C : Node> C.topMargin(margin: Double): C = apply { topMargin = margin }

    /** Configure right margin fluidly using infix operator. */
    inline infix fun <C : Node> C.rightMargin(margin: Double): C = apply { rightMargin = margin }

    /** Configure bottom margin fluidly using infix operator. */
    inline infix fun <C : Node> C.bottomMargin(margin: Double): C = apply { bottomMargin = margin }

    /** Configure left margin fluidly using infix operator. */
    inline infix fun <C : Node> C.leftMargin(margin: Double): C = apply { leftMargin = margin }

    /** Configure horizontal margin fluidly using infix operator. */
    inline infix fun <C : Node> C.horizontalMargin(margin: Double): C = apply { horizontalMargin = margin }

    /** Configure vertical margin fluidly using infix operator. */
    inline infix fun <C : Node> C.verticalMargin(margin: Double): C = apply { verticalMargin = margin }

    /** Configure all margin fluidly using infix operator. */
    inline infix fun <C : Node> C.allMargin(margin: Double): C = apply { allMargin = margin }
}

/** Create a [GridPane] with initialization block. */
inline fun gridPane(
    configuration: (@LayoutsDslMarker KtfxGridPane).() -> Unit
): GridPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxGridPane().apply(configuration)
}

/** Add a [GridPane] to this manager. */
fun NodeManager.gridPane(): GridPane = addChild(KtfxGridPane())

/** Add a [GridPane] with initialization block to this manager. */
inline fun NodeManager.gridPane(
    configuration: (@LayoutsDslMarker KtfxGridPane).() -> Unit
): GridPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxGridPane(), configuration)
}

/** Interface to build [GridPane] row and column constraints with Kotlin DSL. */
interface ConstraintsBuilder<out T : ConstraintsBase> {

    fun constraints(): T

    fun constraints(configuration: T.() -> Unit): T =
        constraints().apply(configuration)

    fun constraints(size: Double): T

    fun constraints(size: Double, configuration: T.() -> Unit): T =
        constraints(size).apply(configuration)

    fun constraints(minSize: Double, prefSize: Double, maxSize: Double): T

    fun constraints(minSize: Double, prefSize: Double, maxSize: Double, configuration: T.() -> Unit): T =
        constraints(minSize, prefSize, maxSize).apply(configuration)
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
fun GridPane.rowConstraints(configuration: ConstraintsBuilder<RowConstraints>.() -> Unit) {
    rowConstraints += ConstraintsBuilderImpl.ofRow().apply(configuration).collection
}

/** Invokes a column constraints DSL builder. */
fun GridPane.columnConstraints(configuration: ConstraintsBuilder<ColumnConstraints>.() -> Unit) {
    columnConstraints += ConstraintsBuilderImpl.ofColumn().apply(configuration).collection
}
