@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority
import kotlin.contracts.ExperimentalContracts

/**
 * [GridPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxGridPane : GridPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

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

    fun <C : Node> C.grid(
        row: Int? = rowIndex,
        col: Int? = columnIndex,
        rowSpan: Int? = this.rowSpan,
        colSpan: Int? = columnSpan
    ): C {
        if (row != rowIndex) rowIndex = row
        if (col != columnIndex) columnIndex = col
        if (rowSpan != this.rowSpan) this.rowSpan = rowSpan
        if (colSpan != columnSpan) columnSpan = colSpan
        return this
    }

    /** Children horizontal alignment in this layout. */
    inline var Node.halignment: HPos?
        @JvmName("getHalignment2") get() = getHalignment(this)
        @JvmName("setHalignment2") set(value) = setHalignment(this, value)

    /** Children vertical alignment in this layout. */
    inline var Node.valignment: VPos?
        @JvmName("getValignment2") get() = getValignment(this)
        @JvmName("setValignment2") set(value) = setValignment(this, value)

    /** Configure horizontal alignment fluidly. */
    fun <C : Node> C.align(hpos: HPos? = halignment, vpos: VPos? = valignment): C {
        if (hpos != halignment) halignment = hpos
        if (vpos != valignment) valignment = vpos
        return this
    }

    /** Children fill width property in this layout. */
    inline var Node.isFillWidth: Boolean?
        @JvmName("isFillWidth2") get() = isFillWidth(this)
        @JvmName("setFillWidth2") set(value) = setFillWidth(this, value)

    /** Children fill height property in this layout. */
    inline var Node.isFillHeight: Boolean?
        @JvmName("isFillHeight2") get() = isFillHeight(this)
        @JvmName("setFillHeight2") set(value) = setFillHeight(this, value)

    /** Configure fill width fluidly. */
    fun <C : Node> C.fillWidth(fill: Boolean = true): C {
        isFillWidth = fill
        return this
    }

    /** Configure fill height fluidly. */
    fun <C : Node> C.fillHeight(fill: Boolean = true): C {
        isFillHeight = fill
        return this
    }

    /** Children horizontal grow priority in this layout. */
    inline var Node.hgrow: Priority?
        @JvmName("getHgrow2") get() = getHgrow(this)
        @JvmName("setHgrow2") set(value) = setHgrow(this, value)

    /** Children vertical grow priority in this layout. */
    inline var Node.vgrow: Priority?
        @JvmName("getVgrow2") get() = getVgrow(this)
        @JvmName("setVgrow2") set(value) = setVgrow(this, value)

    /** Configure horizontal grow fluidly. */
    fun <C : Node> C.hgrow(always: Boolean = true): C {
        hgrow = if (always) Priority.ALWAYS else Priority.NEVER
        return this
    }

    /** Configure vertical grow fluidly. */
    fun <C : Node> C.vgrow(always: Boolean = true): C {
        vgrow = if (always) Priority.ALWAYS else Priority.NEVER
        return this
    }

    /** Children margin in this layout. */
    inline var Node.margin: Insets?
        @JvmName("getMargin2") get() = getMargin(this)
        @JvmName("setMargin2") set(value) = setMargin(this, value)

    /** Set children margin on all side in this layout. */
    fun <C : Node> C.margin(all: Number): C {
        margin = Insets(all.toDouble())
        return this
    }

    /** Set children margin on each side in this layout. */
    fun <C : Node> C.margin(horizontal: Number? = null, vertical: Number? = null): C = margin(
        vertical ?: margin?.top,
        horizontal ?: margin?.right,
        vertical ?: margin?.bottom,
        horizontal ?: margin?.left
    )

    /** Set children margin on each side in this layout. */
    fun <C : Node> C.margin(
        top: Number? = margin?.top,
        right: Number? = margin?.right,
        bottom: Number? = margin?.bottom,
        left: Number? = margin?.left
    ): C {
        margin =
            Insets(top?.toDouble() ?: 0.0, right?.toDouble() ?: 0.0, bottom?.toDouble() ?: 0.0, left?.toDouble() ?: 0.0)
        return this
    }
}
