@file:Suppress("PackageDirectoryMismatch", "ClassName")

/* ktlint-disable package-name */
package ktfx.styles

/* ktlint-enable package-name */

import javafx.scene.text.FontSmoothingType

@PublishedApi
internal class _WebViewStyleBuilder(
    prettyPrint: Boolean
) : _NodeStyleBuilder(prettyPrint), WebViewStyleBuilder {
    override var contextMenuEnabled: Boolean by map
    override var fontSmoothingType: FontSmoothingType by map
    override var fontScale: Number by map
    override var minWidth: Number by map
    override var minHeight: Number by map
    override var prefWidth: Number by map
    override var prefHeight: Number by map
    override var maxWidth: Number by map
    override var maxHeight: Number by map
}

interface WebViewStyleBuilder {

    var contextMenuEnabled: Boolean

    var fontSmoothingType: FontSmoothingType

    var fontScale: Number

    var minWidth: Number

    var minHeight: Number

    var prefWidth: Number

    var prefHeight: Number

    var maxWidth: Number

    var maxHeight: Number
}

inline fun webViewStyle(
    prettyPrint: Boolean = false,
    builder: WebViewStyleBuilder.() -> Unit
): String = _WebViewStyleBuilder(prettyPrint).apply(builder).toString()