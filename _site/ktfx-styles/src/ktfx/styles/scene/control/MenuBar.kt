package ktfx.styles

interface MenuBarStyleBuilder {

    var useSystemMenuBar: Boolean
}

@PublishedApi
@Suppress("ClassName")
internal class _MenuBarStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), MenuBarStyleBuilder {
    override var useSystemMenuBar: Boolean by map
}

inline fun menuBarStyle(
    prettyPrint: Boolean = false,
    builder: MenuBarStyleBuilder .() -> Unit
): String = _MenuBarStyleBuilder(prettyPrint).apply(builder).toString()