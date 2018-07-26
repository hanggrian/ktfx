package javafxx.styles

import javafx.scene.text.FontSmoothingType
import javafxx.styles.internal._WebViewStyleBuilder

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