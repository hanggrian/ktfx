package javafxx.styles

import javafxx.styles.internal._TableViewStyleBuilder

interface TableViewStyleBuilder {

    /** The table column header size. */
    var size: Number
}

inline fun tableViewStyle(
    prettyPrint: Boolean = false,
    builder: TableViewStyleBuilder .() -> Unit
): String = _TableViewStyleBuilder(prettyPrint).apply(builder).toString()