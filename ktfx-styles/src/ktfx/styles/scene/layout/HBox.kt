package ktfx.styles

import javafx.geometry.Pos

class HBoxStyleBuilder(prettyPrint: Boolean) : RegionStyleBuilder(prettyPrint) {

    var spacing: Number by map

    var alignment: Pos by map

    var fillHeight: Boolean by map
}

inline fun hboxStyle(
    prettyPrint: Boolean = false,
    builder: HBoxStyleBuilder.() -> Unit
): String = HBoxStyleBuilder(prettyPrint).apply(builder).toString()