@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

@PublishedApi
internal class _TitledPaneStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), TitledPaneStyleBuilder {
    override var animated: Boolean by map
    override var collapsible: Boolean by map
}

interface TitledPaneStyleBuilder {

    var animated: Boolean

    var collapsible: Boolean
}

inline fun titledPaneStyle(
    prettyPrint: Boolean = false,
    builder: TitledPaneStyleBuilder .() -> Unit
): String = _TitledPaneStyleBuilder(prettyPrint).apply(builder).toString()