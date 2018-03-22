package ktfx.styles

import javafx.geometry.Pos

class HBoxStyleBuilder : NodeStyleBuilder(), SpacableStyleBuilder, AlignableStyleBuilder {

    override var spacing: Number by map

    override var alignment: Pos by map

    var fillHeight: Boolean by map
}

inline fun hboxStyle(builder: HBoxStyleBuilder.() -> Unit): String =
    HBoxStyleBuilder().apply(builder).toString()