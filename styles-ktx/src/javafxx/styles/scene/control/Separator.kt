package javafxx.styles

import javafx.geometry.HPos
import javafx.geometry.Orientation
import javafx.geometry.VPos
import javafxx.styles.internal._SeparatorStyleBuilder

interface SeparatorStyleBuilder {

    var orientation: Orientation

    var halignment: HPos

    var valignment: VPos
}

inline fun separatorStyle(
    prettyPrint: Boolean = false,
    builder: SeparatorStyleBuilder .() -> Unit
): String = _SeparatorStyleBuilder(prettyPrint).apply(builder).toString()