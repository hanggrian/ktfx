package ktfx.styles

import javafx.scene.control.ContentDisplay
import javafx.scene.control.OverrunStyle
import javafx.scene.text.TextAlignment

class TooltipStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var textAlignment: TextAlignment by map

    var textOverrun: OverrunStyle by map

    var wrapText: Boolean by map

    var graphic: Url by map

    var contentDisplay: ContentDisplay by map

    var graphicTextGap: Number by map

    @Incubating
    var font: String by map
}

inline fun tooltipStyle(
    prettyPrint: Boolean = false,
    builder: TooltipStyleBuilder .() -> Unit
): String = TooltipStyleBuilder(prettyPrint).apply(builder).toString()