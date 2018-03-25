package ktfx.styles

import javafx.geometry.Pos

interface StackPaneStyleBuilder {

    var alignment: Pos
}

@PublishedApi
@Suppress("ClassName")
internal class _StackPaneStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), StackPaneStyleBuilder {
    override var alignment: Pos by map
}

inline fun stackPaneStyle(
    prettyPrint: Boolean = false,
    builder: StackPaneStyleBuilder.() -> Unit
): String = _StackPaneStyleBuilder(prettyPrint).apply(builder).toString()