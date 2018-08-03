@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.styles

/* ktlint-enable package-name */

import javafx.scene.control.ContentDisplay
import javafx.scene.control.OverrunStyle
import javafx.scene.text.TextAlignment
import javafxx.styles.internal.NotImplemented
import javafxx.styles.internal._TooltipStyleBuilder

interface TooltipStyleBuilder {

    var textAlignment: TextAlignment

    var textOverrun: OverrunStyle

    var wrapText: Boolean

    var graphic: Url

    var contentDisplay: ContentDisplay

    var graphicTextGap: Number

    @NotImplemented
    var font: String
}

inline fun tooltipStyle(
    prettyPrint: Boolean = false,
    builder: TooltipStyleBuilder .() -> Unit
): String = _TooltipStyleBuilder(prettyPrint).apply(builder).toString()