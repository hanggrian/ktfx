package ktfx.styles

import javafx.geometry.Pos

class VBoxStyleBuilder(prettyPrint: Boolean) : RegionStyleBuilder(prettyPrint) {

    var spacing: Number by map

    var alignment: Pos by map

    var fillWidth: Boolean by map
}

inline fun vboxStyle(
    prettyPrint: Boolean = false,
    builder: VBoxStyleBuilder.() -> Unit
): String = VBoxStyleBuilder(prettyPrint).apply(builder).toString()