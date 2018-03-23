package ktfx.styles

class MenuBarStyleBuilder(prettyPrint: Boolean) : ControlStyleBuilder(prettyPrint) {

    var useSystemMenuBar: Boolean by map
}

inline fun menuBarStyle(
    prettyPrint: Boolean = false,
    builder: MenuBarStyleBuilder .() -> Unit
): String = MenuBarStyleBuilder(prettyPrint).apply(builder).toString()