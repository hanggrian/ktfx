@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.GridPane
import javafx.scene.layout.Priority

/**
 * [GridPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
public open class KtfxGridPane :
    GridPane(),
    NodeContainer {
    final override fun <T : Node> addChild(child: T): T = child.also { children += it }

    /** Children row index in this layout. */
    public inline var Node.rowIndex: Int?
        @JvmName("getRowIndex2")
        get() = getRowIndex(this)

        @JvmName("setRowIndex2")
        set(value) = setRowIndex(this, value)

    /** Children column index in this layout. */
    public inline var Node.columnIndex: Int?
        @JvmName("getColumnIndex2")
        get() = getColumnIndex(this)

        @JvmName("setColumnIndex2")
        set(value) = setColumnIndex(this, value)

    /** Children row span in this layout. */
    public inline var Node.rowSpan: Int?
        @JvmName("getRowSpan2")
        get() = getRowSpan(this)

        @JvmName("setRowSpan2")
        set(value) = setRowSpan(this, value)

    /** Children column span in this layout. */
    public inline var Node.columnSpan: Int?
        @JvmName("getColumnSpan2")
        get() = getColumnSpan(this)

        @JvmName("setColumnSpan2")
        set(value) = setColumnSpan(this, value)

    /** Configure [rowIndex] and [columnIndex] fluidly. */
    public fun <T : Node> T.grid(row: Int = 0, col: Int = 0): T {
        rowIndex = row
        columnIndex = col
        return this
    }

    /** Configure [rowIndex], [rowSpan] and [columnIndex] fluidly. */
    public fun <T : Node> T.grid(row: Pair<Int, Int>, col: Int = 0): T {
        rowIndex = row.first
        rowSpan = row.second
        columnIndex = col
        return this
    }

    /** Configure [rowIndex], [columnIndex] and [columnSpan] fluidly. */
    public fun <T : Node> T.grid(row: Int = 0, col: Pair<Int, Int>): T {
        rowIndex = row
        columnIndex = col.first
        columnSpan = col.second
        return this
    }

    /** Configure [rowIndex], [rowSpan], [columnIndex] and [columnSpan] fluidly. */
    public fun <T : Node> T.grid(row: Pair<Int, Int>, col: Pair<Int, Int>): T {
        rowIndex = row.first
        rowSpan = row.second
        columnIndex = col.first
        columnSpan = col.second
        return this
    }

    /** Children horizontal alignment in this layout. */
    public inline var Node.halignment: HPos?
        @JvmName("getHalignment2")
        get() = getHalignment(this)

        @JvmName("setHalignment2")
        set(value) = setHalignment(this, value)

    /** Children vertical alignment in this layout. */
    public inline var Node.valignment: VPos?
        @JvmName("getValignment2")
        get() = getValignment(this)

        @JvmName("setValignment2")
        set(value) = setValignment(this, value)

    /** Configure [halignment] fluidly. */
    public fun <T : Node> T.halign(hpos: HPos): T {
        halignment = hpos
        return this
    }

    /** Configure [valignment] fluidly. */
    public fun <T : Node> T.valign(vpos: VPos): T {
        valignment = vpos
        return this
    }

    /** Children fill width property in this layout. */
    public inline var Node.isFillWidth: Boolean?
        @JvmName("isFillWidth2")
        get() = isFillWidth(this)

        @JvmName("setFillWidth2")
        set(value) = setFillWidth(this, value)

    /** Children fill height property in this layout. */
    public inline var Node.isFillHeight: Boolean?
        @JvmName("isFillHeight2")
        get() = isFillHeight(this)

        @JvmName("setFillHeight2")
        set(value) = setFillHeight(this, value)

    /** Configure [isFillWidth] fluidly. */
    public fun <T : Node> T.fillWidth(fill: Boolean = true): T {
        isFillWidth = fill
        return this
    }

    /** Configure [isFillHeight] fluidly. */
    public fun <T : Node> T.fillHeight(fill: Boolean = true): T {
        isFillHeight = fill
        return this
    }

    /** Children horizontal grow priority in this layout. */
    public inline var Node.hgrow: Priority?
        @JvmName("getHgrow2")
        get() = getHgrow(this)

        @JvmName("setHgrow2")
        set(value) = setHgrow(this, value)

    /** Children vertical grow priority in this layout. */
    public inline var Node.vgrow: Priority?
        @JvmName("getVgrow2")
        get() = getVgrow(this)

        @JvmName("setVgrow2")
        set(value) = setVgrow(this, value)

    /** Configure [hgrow] fluidly. */
    public fun <T : Node> T.hgrow(always: Boolean = true): T {
        hgrow = if (always) Priority.ALWAYS else Priority.NEVER
        return this
    }

    /** Configure [vgrow] fluidly. */
    public fun <T : Node> T.vgrow(always: Boolean = true): T {
        vgrow = if (always) Priority.ALWAYS else Priority.NEVER
        return this
    }

    /** Children margin in this layout. */
    public inline var Node.margin: Insets?
        @JvmName("getMargin2")
        get() = getMargin(this)

        @JvmName("setMargin2")
        set(value) = setMargin(this, value)

    /** Configure [margin] fluidly. */
    public fun <T : Node> T.margin(insets: Insets): T {
        margin = insets
        return this
    }

    /** Clear children constraints. */
    @JvmName("clearConstraints2")
    public inline fun Node.clearConstraints(): Unit = clearConstraints(this)
}
