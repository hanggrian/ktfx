@file:Suppress("NOTHING_TO_INLINE")

package kotfx.dialogs

import javafx.scene.Node
import javafx.scene.control.IndexRange
import javafx.scene.control.TextFormatter
import javafx.scene.control.TextInputDialog
import javafx.scene.image.ImageView
import javafx.scene.text.Font
import kotfx.properties.*

inline val TextInputDialog.fontProperty: MutableAnyProperty<Font> get() = editor.fontProperty()
inline var TextInputDialog.font: Font
    get() = editor.font
    set(value) = editor.setFont(value)

inline val TextInputDialog.promptTextProperty: MutableStringProperty get() = editor.promptTextProperty()
inline var TextInputDialog.promptText: String
    get() = editor.promptText
    set(value) = editor.setPromptText(value)

inline val TextInputDialog.textFormatterProperty: MutableAnyProperty<TextFormatter<*>> get() = editor.textFormatterProperty()
inline var TextInputDialog.textFormatter: TextFormatter<*>
    get() = editor.textFormatter
    set(value) = editor.setTextFormatter(value)

inline val TextInputDialog.textProperty: MutableStringProperty get() = editor.textProperty()
inline var TextInputDialog.text: String
    get() = editor.text
    set(value) = editor.setText(value)

inline val TextInputDialog.lengthProperty: IntProperty get() = editor.lengthProperty()
inline val TextInputDialog.length: Int
    get() = editor.length

inline val TextInputDialog.editableProperty: MutableBooleanProperty get() = editor.editableProperty()
inline var TextInputDialog.isEditable: Boolean
    get() = editor.isEditable
    set(value) = editor.setEditable(value)

inline val TextInputDialog.selectionProperty: AnyProperty<IndexRange> get() = editor.selectionProperty()
inline val TextInputDialog.selection: IndexRange
    get() = editor.selection

inline val TextInputDialog.anchorProperty: IntProperty get() = editor.anchorProperty()
inline val TextInputDialog.anchor: Int
    get() = editor.anchor

inline val TextInputDialog.caretPositionProperty: IntProperty get() = editor.caretPositionProperty()
inline val TextInputDialog.caretPosition: Int
    get() = editor.caretPosition

inline val TextInputDialog.undoableProperty: BooleanProperty get() = editor.undoableProperty()
inline val TextInputDialog.isUndoable: Boolean
    get() = editor.isUndoable

inline val TextInputDialog.redoableProperty: BooleanProperty get() = editor.redoableProperty()
inline val TextInputDialog.isRedoable: Boolean
    get() = editor.isRedoable

inline fun TextInputDialog.getText(start: Int, end: Int): String = editor.getText(start, end)

inline fun TextInputDialog.appendText(text: String) = editor.appendText(text)

inline fun TextInputDialog.insertText(index: Int, text: String) = editor.insertText(index, text)

inline fun TextInputDialog.deleteText(range: IndexRange) = editor.deleteText(range)
inline fun TextInputDialog.deleteText(start: Int, end: Int) = editor.deleteText(start, end)

inline fun TextInputDialog.replaceText(range: IndexRange, text: String) = editor.replaceText(range, text)
inline fun TextInputDialog.replaceText(start: Int, end: Int, text: String) = editor.replaceText(start, end, text)

inline fun TextInputDialog.cut() = editor.cut()
inline fun TextInputDialog.copy() = editor.copy()
inline fun TextInputDialog.paste() = editor.paste()

@JvmOverloads
inline fun inputDialog(
        prefill: String = "",
        noinline init: (TextInputDialog.() -> Unit)? = null
): TextInputDialog = inputDialog(null, null, prefill, init)

@JvmOverloads
fun inputDialog(
        title: String?,
        graphic: Node?,
        prefill: String = "",
        init: (TextInputDialog.() -> Unit)? = null
): TextInputDialog = TextInputDialog(prefill).apply {
    if (title != null) headerTitle = title
    if (graphic != null) when (graphic) {
        is ImageView -> graphicIcon = graphic
        else -> setGraphic(graphic)
    }
    init?.invoke(this)
}