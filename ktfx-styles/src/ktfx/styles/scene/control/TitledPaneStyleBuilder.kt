package ktfx.styles

class TitledPaneStyleBuilder : ControlStyleBuilder() {

    var animated: Boolean by map

    var collapsible: Boolean by map
}

inline fun titledPaneStyle(builder: TitledPaneStyleBuilder .() -> Unit): String =
    TitledPaneStyleBuilder().apply(builder).toString()