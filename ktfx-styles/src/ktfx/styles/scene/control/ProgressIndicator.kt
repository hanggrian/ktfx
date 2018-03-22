package ktfx.styles

import javafx.scene.paint.Color

open class ProgressIndicatorStyleBuilder : ControlStyleBuilder() {

    var progressColor: Color by map
}

inline fun progressIndicatorStyle(builder: ProgressIndicatorStyleBuilder .() -> Unit): String =
    ProgressIndicatorStyleBuilder().apply(builder).toString()