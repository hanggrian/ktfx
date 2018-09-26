@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.geometry.Pos

@PublishedApi
internal class _StackPaneStyleBuilder(
    prettyPrint: Boolean
) : _RegionStyleBuilder(prettyPrint), StackPaneStyleBuilder {
    override var alignment: Pos by map
}

interface StackPaneStyleBuilder {

    var alignment: Pos
}

inline fun stackPaneStyle(
    prettyPrint: Boolean = false,
    builder: StackPaneStyleBuilder.() -> Unit
): String = _StackPaneStyleBuilder(prettyPrint).apply(builder).toString()