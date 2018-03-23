package ktfx.styles

class TableViewStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    /** The table column header size. */
    var size: Number by map
}

inline fun tableViewStyle(
    prettyPrint: Boolean = false,
    builder: TableViewStyleBuilder .() -> Unit
): String = TableViewStyleBuilder(prettyPrint).apply(builder).toString()