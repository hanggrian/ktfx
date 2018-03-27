package ktfx.styles

import javafx.scene.control.ContentDisplay
import javafx.scene.control.OverrunStyle
import javafx.scene.text.TextAlignment
import ktfx.styles.internal.Beta

interface TooltipStyleBuilder {

    var textAlignment: TextAlignment

    var textOverrun: OverrunStyle

    var wrapText: Boolean

    var graphic: Url

    var contentDisplay: ContentDisplay

    var graphicTextGap: Number

    @Beta
    var font: String
}

@PublishedApi
@Suppress("ClassName")
internal class _TooltipStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), TooltipStyleBuilder {
    override var textAlignment: TextAlignment by map
    override var textOverrun: OverrunStyle by map
    override var wrapText: Boolean by map
    override var graphic: Url by map
    override var contentDisplay: ContentDisplay by map
    override var graphicTextGap: Number by map
    override var font: String by map
}

inline fun tooltipStyle(
    prettyPrint: Boolean = false,
    builder: TooltipStyleBuilder .() -> Unit
): String = _TooltipStyleBuilder(prettyPrint).apply(builder).toString()