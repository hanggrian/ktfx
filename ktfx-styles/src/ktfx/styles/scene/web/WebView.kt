package ktfx.styles

import javafx.scene.text.FontSmoothingType

class WebViewStyleBuilder(prettyPrint: Boolean) : NodeStyleBuilder(prettyPrint) {

    var contextMenuEnabled: Boolean by map

    var fontSmoothingType: FontSmoothingType by map

    var fontScale: Number by map

    var minWidth: Number by map

    var minHeight: Number by map

    var prefWidth: Number by map

    var prefHeight: Number by map

    var maxWidth: Number by map

    var maxHeight: Number by map
}

inline fun webViewStyle(
    prettyPrint: Boolean = false,
    builder: WebViewStyleBuilder.() -> Unit
): String = WebViewStyleBuilder(prettyPrint).apply(builder).toString()