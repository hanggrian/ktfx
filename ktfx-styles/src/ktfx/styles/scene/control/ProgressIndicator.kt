package ktfx.styles

import javafx.scene.paint.Color

open class ProgressIndicatorStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var progressColor: Color by map
}

inline fun progressIndicatorStyle(
    prettyPrint: Boolean = false,
    builder: ProgressIndicatorStyleBuilder .() -> Unit
): String = ProgressIndicatorStyleBuilder(prettyPrint).apply(builder).toString()