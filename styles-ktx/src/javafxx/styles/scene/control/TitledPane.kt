package javafxx.styles

import javafxx.styles.internal._TitledPaneStyleBuilder

interface TitledPaneStyleBuilder {

    var animated: Boolean

    var collapsible: Boolean
}

inline fun titledPaneStyle(
    prettyPrint: Boolean = false,
    builder: TitledPaneStyleBuilder .() -> Unit
): String = _TitledPaneStyleBuilder(prettyPrint).apply(builder).toString()