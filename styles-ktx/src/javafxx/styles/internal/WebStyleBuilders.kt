@file:Suppress("ClassName")

package javafxx.styles.internal

import javafx.scene.text.FontSmoothingType
import javafxx.styles.WebViewStyleBuilder

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