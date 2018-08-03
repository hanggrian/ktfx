@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafxx.styles.internal._TilePaneStyleBuilder

interface TilePaneStyleBuilder {

    var orientation: Orientation

    var prefRows: Int

    var prefColumns: Int

    var prefTileWidth: Number

    var prefTileHeight: Number

    var hgap: Number

    var vgap: Number

    var alignment: Pos

    var tileAlignment: Pos
}

inline fun tilePaneStyle(
    prettyPrint: Boolean = false,
    builder: TilePaneStyleBuilder.() -> Unit
): String = _TilePaneStyleBuilder(prettyPrint).apply(builder).toString()