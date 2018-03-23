package ktfx.styles

import javafx.geometry.Pos

interface GridPaneStyleBuilder {

    var hgap: Number

    var vgap: Number

    var alignment: Pos

    var gridLinesVisible: Boolean
}

@PublishedApi
@Suppress("ClassName")
internal class _GridPaneStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), GridPaneStyleBuilder {
    override var hgap: Number by map
    override var vgap: Number by map
    override var alignment: Pos by map
    override var gridLinesVisible: Boolean by map
}

inline fun gridPaneStyle(
    prettyPrint: Boolean = false,
    builder: GridPaneStyleBuilder.() -> Unit
): String = _GridPaneStyleBuilder(prettyPrint).apply(builder).toString()