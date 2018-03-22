package ktfx.styles

class TabPaneStyleBuilder : ControlStyleBuilder() {

    var tabMinWidth: Int by map

    var tabMaxWidth: Int by map

    var tabMinHeight: Int by map

    var tabMaxHeight: Int by map
}

inline fun tabPaneStyle(builder: TabPaneStyleBuilder .() -> Unit): String =
    TabPaneStyleBuilder().apply(builder).toString()