package ktfx.styles

class TitledPaneStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var animated: Boolean by map

    var collapsible: Boolean by map
}

inline fun titledPaneStyle(
    prettyPrint: Boolean = false,
    builder: TitledPaneStyleBuilder .() -> Unit
): String = TitledPaneStyleBuilder(prettyPrint).apply(builder).toString()