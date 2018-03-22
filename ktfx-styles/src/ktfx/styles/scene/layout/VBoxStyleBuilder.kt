package ktfx.styles

import javafx.geometry.Pos

class VBoxStyleBuilder : NodeStyleBuilder(), SpacableStyleBuilder, AlignableStyleBuilder {

    override var spacing: Number by map

    override var alignment: Pos by map

    var fillWidth: Boolean by map
}

inline fun vboxStyle(builder: VBoxStyleBuilder.() -> Unit): String =
    VBoxStyleBuilder().apply(builder).toString()