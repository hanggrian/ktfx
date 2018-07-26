package javafxx.styles

import javafxx.styles.internal._RectangleStyleBuilder

interface RectangleStyleBuilder {

    var arcHeight: Number

    var arcWidth: Number
}

inline fun rectangleStyle(
    prettyPrint: Boolean = false,
    builder: RectangleStyleBuilder.() -> Unit
): String = _RectangleStyleBuilder(prettyPrint).apply(builder).toString()