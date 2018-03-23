package ktfx.styles

import javafx.scene.paint.Color

interface ProgressIndicatorStyleBuilder {

    var progressColor: Color
}

@Suppress("ClassName")
open class _ProgressIndicatorStyleBuilder(prettyPrint: Boolean) : _ControlStyleBuilder(prettyPrint),
    ProgressIndicatorStyleBuilder {
    override var progressColor: Color by map
}

inline fun progressIndicatorStyle(
    prettyPrint: Boolean = false,
    builder: ProgressIndicatorStyleBuilder .() -> Unit
): String = _ProgressIndicatorStyleBuilder(prettyPrint).apply(builder).toString()