package ktfx.styles

interface ProgressBarStyleBuilder {

    var indeterminateBarLength: Number

    var indeterminateBarEscape: Boolean

    var indeterminateBarFlip: Boolean

    var indeterminateBarAnimationTime: Number
}

@PublishedApi
@Suppress("ClassName")
internal class _ProgressBarStyleBuilder(prettyPrint: Boolean) : _ProgressIndicatorStyleBuilder(prettyPrint),
    ProgressBarStyleBuilder {
    override var indeterminateBarLength: Number by map
    override var indeterminateBarEscape: Boolean by map
    override var indeterminateBarFlip: Boolean by map
    override var indeterminateBarAnimationTime: Number by map
}

inline fun progressBarStyle(
    prettyPrint: Boolean = false,
    builder: ProgressBarStyleBuilder .() -> Unit
): String = _ProgressBarStyleBuilder(prettyPrint).apply(builder).toString()