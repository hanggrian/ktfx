@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

@PublishedApi
internal class _ProgressBarStyleBuilder(
    prettyPrint: Boolean
) : _ProgressIndicatorStyleBuilder(prettyPrint), ProgressBarStyleBuilder {
    override var indeterminateBarLength: Number by map
    override var indeterminateBarEscape: Boolean by map
    override var indeterminateBarFlip: Boolean by map
    override var indeterminateBarAnimationTime: Number by map
}

interface ProgressBarStyleBuilder {

    var indeterminateBarLength: Number

    var indeterminateBarEscape: Boolean

    var indeterminateBarFlip: Boolean

    var indeterminateBarAnimationTime: Number
}

inline fun progressBarStyle(
    prettyPrint: Boolean = false,
    builder: ProgressBarStyleBuilder .() -> Unit
): String = _ProgressBarStyleBuilder(prettyPrint).apply(builder).toString()