package javafxx.styles

import javafxx.styles.internal._ValueAxisStyleBuilder

interface ValueAxisStyleBuilder {

    var minorTickLength: Number

    var minorTickCount: Number

    var minorTickVisible: Boolean
}

inline fun valueAxisStyle(
    prettyPrint: Boolean = false,
    builder: ValueAxisStyleBuilder.() -> Unit
): String = _ValueAxisStyleBuilder(prettyPrint).apply(builder).toString()