package ktfx.styles

import javafx.geometry.Pos

interface HBoxStyleBuilder : RegionStyleBuilder {

    var spacing: Number

    var alignment: Pos

    var fillHeight: Boolean
}

@PublishedApi
@Suppress("ClassName")
internal class _HBoxStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), HBoxStyleBuilder {
    override var spacing: Number by map
    override var alignment: Pos by map
    override var fillHeight: Boolean by map
}

inline fun hboxStyle(
    prettyPrint: Boolean = false,
    builder: HBoxStyleBuilder.() -> Unit
): String = _HBoxStyleBuilder(prettyPrint).apply(builder).toString()