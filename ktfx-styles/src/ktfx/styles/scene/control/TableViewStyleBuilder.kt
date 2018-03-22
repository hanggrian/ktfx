package ktfx.styles

class TableViewStyleBuilder : ControlStyleBuilder() {

    /** The table column header size. */
    var size: Number by map
}

inline fun tableViewStyle(builder: TableViewStyleBuilder .() -> Unit): String =
    TableViewStyleBuilder().apply(builder).toString()