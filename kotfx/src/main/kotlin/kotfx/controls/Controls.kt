@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.*
import javafx.scene.paint.Paint
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment
import kotfx._Region

internal interface _Control<out N : Control> : _Region<N> {
    fun skin(value: Skin<*>) = node.setSkin(value)
    fun tooltip(value: Tooltip) = node.setTooltip(value)
    fun contextMenu(value: ContextMenu) = node.setContextMenu(value)
}

internal interface _ComboBoxBase<out N : ComboBoxBase<T>, T> : _Control<N> {
    fun value(value: T) = node.setValue(value)
    fun editable(value: Boolean) = node.setEditable(value)
    fun prompt(value: String) = node.setPromptText(value)
}

internal interface _Labeled<out N : Labeled> : _Control<N>, Fontable {
    override fun font(value: Font) = node.setFont(value)
    fun text(value: String) = node.setText(value)
    fun align(value: Pos) = node.setAlignment(value)
    fun textAlign(value: TextAlignment) = node.setTextAlignment(value)
    fun overrun(value: OverrunStyle) = node.setTextOverrun(value)
    fun ellipsis(value: String) = node.setEllipsisString(value)
    fun wrap(value: Boolean) = node.setWrapText(value)
    fun graphic(value: Node) = node.setGraphic(value)
    fun underline(value: Boolean) = node.setUnderline(value)
    fun spacing(value: Number) = node.setLineSpacing(value.toDouble())
    fun display(value: ContentDisplay) = node.setContentDisplay(value)
    fun graphicGap(value: Number) = node.setGraphicTextGap(value.toDouble())
    fun fill(value: Paint) = node.setTextFill(value)
    fun mnemonic(value: Boolean) = node.setMnemonicParsing(value)
}

internal interface _Progressed<out N : ProgressIndicator> : _Control<N> {
    fun progress(value: Number) = node.setProgress(value.toDouble())
}

internal interface _Toggled<out N : ToggleButton> : _Control<N> {
    fun selected(value: Boolean) = node.setSelected(value)
    fun toggleGroup(value: ToggleGroup) = node.setToggleGroup(value)
}

internal interface _TextInputControl<out N : TextInputControl> : _Control<N>, Fontable {
    override fun font(value: Font) = node.setFont(value)
    fun prompt(value: String) = node.setPromptText(value)
    fun textFormatter(value: TextFormatter<*>) = node.setTextFormatter(value)
    fun text(value: String) = node.setText(value)
    fun editable(value: Boolean) = node.setEditable(value)
}

internal interface Fontable {
    fun font(value: Font)
    fun font(family: String?, weight: FontWeight?, posture: FontPosture?, size: Number?) = font(Font.font(family, weight, posture, size?.toDouble() ?: -1.0))
    fun font(family: String?, weight: FontWeight?, size: Number?) = font(Font.font(family, weight, size?.toDouble() ?: -1.0))
    fun font(family: String?, posture: FontPosture?, size: Number?) = font(Font.font(family, posture, size?.toDouble() ?: -1.0))
    fun font(family: String?, size: Number?) = font(Font.font(family, size?.toDouble() ?: -1.0))
    fun font(family: String?) = font(Font.font(family))
    fun font(size: Number?) = font(Font.font(size?.toDouble() ?: -1.0))
}