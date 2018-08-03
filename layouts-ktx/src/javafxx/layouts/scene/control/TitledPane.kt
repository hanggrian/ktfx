@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.TitledPane

open class _TitledPane(
    title: String?,
    content: Node?
) : TitledPane(title, content), LayoutManager<Node> {

    override operator fun <T : Node> T.invoke(): T = also { content = it }
}

/** Creates a [TitledPane]. */
fun titledPane(
    text: String? = null,
    content: Node? = null,
    init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
): TitledPane = _TitledPane(text, content).also {
    init?.invoke(it)
}

/** Creates a [TitledPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.titledPane(
    text: String? = null,
    content: Node? = null,
    noinline init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
): TitledPane = javafxx.layouts.titledPane(text, content, init)()

/** Create a styled [TitledPane]. */
fun styledTitledPane(
    styleClass: String,
    text: String? = null,
    content: Node? = null,
    init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
): TitledPane = _TitledPane(text, content).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [TitledPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledTitledPane(
    styleClass: String,
    text: String? = null,
    content: Node? = null,
    noinline init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
): TitledPane = javafxx.layouts.styledTitledPane(styleClass, text, content, init)()