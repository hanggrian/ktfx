package ktfx.styles

import ktfx.styles.internal._TabPaneStyleBuilder

interface TabPaneStyleBuilder {

    var tabMinWidth: Int

    var tabMaxWidth: Int

    var tabMinHeight: Int

    var tabMaxHeight: Int
}

inline fun tabPaneStyle(
    prettyPrint: Boolean = false,
    builder: TabPaneStyleBuilder .() -> Unit
): String = _TabPaneStyleBuilder(prettyPrint).apply(builder).toString()