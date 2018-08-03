@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint

open class _Scene(
    root: Parent,
    width: Double,
    height: Double,
    fill: Paint
) : Scene(root, width, height, fill), LayoutManager<Node> {

    override operator fun <T : Node> T.invoke(): T = also {
        root = when (it) {
            is Parent -> it
            else -> Pane(it)
        }
    }
}

/** Create a [Scene] with initialization. */
fun scene(
    root: Parent = region(),
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = WHITE,
    init: ((@LayoutDsl _Scene).() -> Unit)? = null
): Scene = _Scene(root, width, height, fill).also {
    init?.invoke(it)
}

/** Create a styled [Scene] with initialization. */
fun styledScene(
    stylesheet: String,
    root: Parent = region(),
    width: Double = -1.0,
    height: Double = -1.0,
    fill: Paint = WHITE,
    init: ((@LayoutDsl _Scene).() -> Unit)? = null
): Scene = _Scene(root, width, height, fill).also {
    it.stylesheets += stylesheet
    init?.invoke(it)
}