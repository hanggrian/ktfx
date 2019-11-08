package ktfx.layouts

import javafx.geometry.Pos
import javafx.scene.Node

/**
 * Marks a layout manager with alignable children's position.
 *
 * @see KtfxBorderPane
 * @see KtfxStackPane
 * @see KtfxTilePane
 */
interface AlignConstraints : Constraints {

    /** Children alignment in this container. */
    var Node.align: Pos?

    /** Convenient method to align children to [Pos.TOP_LEFT]. */
    fun Node.alignTopLeft() {
        align = Pos.TOP_LEFT
    }

    /** Convenient method to align children to [Pos.TOP_CENTER]. */
    fun Node.alignTop() {
        align = Pos.TOP_CENTER
    }

    /** Convenient method to align children to [Pos.TOP_RIGHT]. */
    fun Node.alignTopRight() {
        align = Pos.TOP_RIGHT
    }

    /** Convenient method to align children to [Pos.CENTER_LEFT]. */
    fun Node.alignLeft() {
        align = Pos.CENTER_LEFT
    }

    /** Convenient method to align children to [Pos.CENTER]. */
    fun Node.alignCenter() {
        align = Pos.CENTER
    }

    /** Convenient method to align children to [Pos.CENTER_RIGHT]. */
    fun Node.alignRight() {
        align = Pos.CENTER_RIGHT
    }

    /** Convenient method to align children to [Pos.BOTTOM_LEFT]. */
    fun Node.alignBottomLeft() {
        align = Pos.BOTTOM_LEFT
    }

    /** Convenient method to align children to [Pos.BOTTOM_CENTER]. */
    fun Node.alignBottom() {
        align = Pos.BOTTOM_CENTER
    }

    /** Convenient method to align children to [Pos.BOTTOM_RIGHT]. */
    fun Node.alignBottomRight() {
        align = Pos.BOTTOM_RIGHT
    }

    /** Convenient method to align children to [Pos.BASELINE_LEFT]. */
    fun Node.alignBaselineLeft() {
        align = Pos.BASELINE_LEFT
    }

    /** Convenient method to align children to [Pos.BASELINE_CENTER]. */
    fun Node.alignBaseline() {
        align = Pos.BASELINE_CENTER
    }

    /** Convenient method to align children to [Pos.BASELINE_RIGHT]. */
    fun Node.alignBaselineRight() {
        align = Pos.BASELINE_RIGHT
    }
}
