package ktfx.styles

interface TableViewStyleBuilder {

    /** The table column header size. */
    var size: Number
}

@PublishedApi
@Suppress("ClassName")
internal class _TableViewStyleBuilder(prettyPrint: Boolean) : _ControlStyleBuilder(prettyPrint), TableViewStyleBuilder {
    override var size: Number by map
}

inline fun tableViewStyle(
    prettyPrint: Boolean = false,
    builder: TableViewStyleBuilder .() -> Unit
): String = _TableViewStyleBuilder(prettyPrint).apply(builder).toString()