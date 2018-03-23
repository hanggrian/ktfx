package ktfx.styles

interface TabPaneStyleBuilder {

    var tabMinWidth: Int

    var tabMaxWidth: Int

    var tabMinHeight: Int

    var tabMaxHeight: Int
}

@PublishedApi
@Suppress("ClassName")
internal class _TabPaneStyleBuilder(prettyPrint: Boolean) : _ControlStyleBuilder(prettyPrint), TabPaneStyleBuilder {
    override var tabMinWidth: Int by map
    override var tabMaxWidth: Int by map
    override var tabMinHeight: Int by map
    override var tabMaxHeight: Int by map
}

inline fun tabPaneStyle(
    prettyPrint: Boolean = false,
    builder: TabPaneStyleBuilder .() -> Unit
): String = _TabPaneStyleBuilder(prettyPrint).apply(builder).toString()