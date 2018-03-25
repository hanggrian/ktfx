package ktfx.styles

import javafx.geometry.Pos

interface VBoxStyleBuilder {

    var spacing: Number

    var alignment: Pos

    var fillWidth: Boolean
}

@PublishedApi
@Suppress("ClassName")
internal class _VBoxStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), VBoxStyleBuilder {
    override var spacing: Number by map
    override var alignment: Pos by map
    override var fillWidth: Boolean by map
}

inline fun vboxStyle(
    prettyPrint: Boolean = false,
    builder: VBoxStyleBuilder.() -> Unit
): String = _VBoxStyleBuilder(prettyPrint).apply(builder).toString()