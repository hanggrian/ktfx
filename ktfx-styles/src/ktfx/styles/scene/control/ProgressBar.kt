package ktfx.styles

class ProgressBarStyleBuilder(prettyPrint: Boolean) : ProgressIndicatorStyleBuilder(prettyPrint) {

    var indeterminateBarLength: Number by map

    var indeterminateBarEscape: Boolean by map

    var indeterminateBarFlip: Boolean by map

    var indeterminateBarAnimationTime: Number by map
}

inline fun progressBarStyle(
    prettyPrint: Boolean = false,
    builder: ProgressBarStyleBuilder .() -> Unit
): String = ProgressBarStyleBuilder(prettyPrint).apply(builder).toString()