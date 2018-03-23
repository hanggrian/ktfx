package ktfx.styles

class TabPaneStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var tabMinWidth: Int by map

    var tabMaxWidth: Int by map

    var tabMinHeight: Int by map

    var tabMaxHeight: Int by map
}

inline fun tabPaneStyle(
    prettyPrint: Boolean = false,
    builder: TabPaneStyleBuilder .() -> Unit
): String = TabPaneStyleBuilder(prettyPrint).apply(builder).toString()