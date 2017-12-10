@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.dialogs

import javafx.scene.Node
import javafx.scene.control.ButtonType
import javafx.stage.Window

interface DialogBuilder<R> {

    fun owner(owner: Window)

    fun buttons(vararg buttons: ButtonType)

    fun content(content: R)

    fun header(header: String)

    fun graphic(graphic: Node)

    fun result(result: R)

    fun resultConverter(converter: (ButtonType) -> R)

    fun resizable(resizable: Boolean)

    fun title(title: String)
}