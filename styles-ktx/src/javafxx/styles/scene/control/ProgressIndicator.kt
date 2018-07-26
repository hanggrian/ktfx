package javafxx.styles

import javafx.scene.paint.Color
import javafxx.styles.internal._ProgressIndicatorStyleBuilder

interface ProgressIndicatorStyleBuilder {

    var progressColor: Color
}

inline fun progressIndicatorStyle(
    prettyPrint: Boolean = false,
    builder: ProgressIndicatorStyleBuilder .() -> Unit
): String = _ProgressIndicatorStyleBuilder(prettyPrint).apply(builder).toString()