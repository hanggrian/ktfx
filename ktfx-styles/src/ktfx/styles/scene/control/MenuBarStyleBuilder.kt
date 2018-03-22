package ktfx.styles

class MenuBarStyleBuilder : ControlStyleBuilder() {

    var useSystemMenuBar: Boolean by map
}

inline fun menuBarStyle(builder: MenuBarStyleBuilder .() -> Unit): String =
    MenuBarStyleBuilder().apply(builder).toString()