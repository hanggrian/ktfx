@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.testfx

import javafx.geometry.Point2D
import javafx.geometry.Pos
import javafx.scene.Node
import org.testfx.service.query.PointQuery

/** Updates [PointQuery.getPosition] to the new `position`. */
inline infix fun PointQuery.atPosition(position: Point2D): PointQuery =
    atPosition(position)

/** Updates [PointQuery.getPosition] to a new one based on the given `position`. */
inline infix fun PointQuery.atPosition(position: Pos): PointQuery =
    atPosition(position)

/** Updates [PointQuery.getOffset] to be `Point2D(offset.x + offset.x, offset.y + offset.y)`. */
inline infix fun PointQuery.atOffset(position: Point2D): PointQuery =
    atOffset(position)

inline infix fun PointQuery.onNode(node: Node): PointQuery =
    onNode(node)