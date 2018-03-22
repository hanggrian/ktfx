package ktfx.styles

class ProgressBarStyleBuilder : ProgressIndicatorStyleBuilder() {

    var indeterminateBarLength: Number by map

    var indeterminateBarEscape: Boolean by map

    var indeterminateBarFlip: Boolean by map

    var indeterminateBarAnimationTime: Number by map
}

inline fun progressBarStyle(builder: ProgressBarStyleBuilder .() -> Unit): String =
    ProgressBarStyleBuilder().apply(builder).toString()