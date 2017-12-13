@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.*
import javafx.scene.layout.Region
import javafx.scene.paint.Paint
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.scene.text.TextAlignment

interface Controlled<out C> {
    val control: C
}

interface _Region<out C : Region> : Controlled<C> {
    fun minWidth(width: Number) = control.setMinWidth(width.toDouble())
    fun minHeight(height: Number) = control.setMinHeight(height.toDouble())
    fun minSize(width: Number, height: Number) = control.setMinSize(width.toDouble(), height.toDouble())
    fun minSize(size: Number) = minSize(size, size)

    fun prefWidth(width: Number) = control.setPrefWidth(width.toDouble())
    fun prefHeight(height: Number) = control.setPrefHeight(height.toDouble())
    fun prefSize(width: Number, height: Number) = control.setPrefSize(width.toDouble(), height.toDouble())
    fun prefSize(size: Number) = prefSize(size, size)

    fun maxWidth(width: Number) = control.setMaxWidth(width.toDouble())
    fun maxHeight(height: Number) = control.setMaxHeight(height.toDouble())
    fun maxSize(width: Number, height: Number) = control.setMaxSize(width.toDouble(), height.toDouble())
    fun maxSize(size: Number) = maxSize(size, size)

    fun forceWidth(width: Number) {
        minWidth(width)
        prefWidth(width)
        maxWidth(width)
    }

    fun forceHeight(width: Number) {
        minHeight(width)
        prefHeight(width)
        maxHeight(width)
    }

    fun forceSize(width: Number, height: Number) {
        forceWidth(width)
        forceHeight(height)
    }

    fun forceSize(size: Number) = forceSize(size, size)

    fun padding(padding: Insets) = control.setPadding(padding)
    fun padding(padding: Number) = padding(Insets(padding.toDouble()))
    fun paddingTop(padding: Number) = control.padding.let { padding(Insets(padding.toDouble(), it.right, it.bottom, it.left)) }
    fun paddingRight(padding: Number) = control.padding.let { padding(Insets(it.top, padding.toDouble(), it.bottom, it.left)) }
    fun paddingBottom(padding: Number) = control.padding.let { padding(Insets(it.top, it.right, padding.toDouble(), it.left)) }
    fun paddingLeft(padding: Number) = control.padding.let { padding(Insets(it.top, it.right, it.bottom, padding.toDouble())) }
}

internal interface _Control<out C : Control> : _Region<C> {
    fun skin(skin: Skin<*>) = control.setSkin(skin)
    fun tooltip(tooltip: Tooltip) = control.setTooltip(tooltip)
    fun contextMenu(menu: ContextMenu) = control.setContextMenu(menu)
}

internal interface _ComboBoxBase<out C : ComboBoxBase<T>, T> : _Control<C> {
    fun value(value: T) = control.setValue(value)
    fun editable(editable: Boolean) = control.setEditable(editable)
    fun prompt(prompt: String) = control.setPromptText(prompt)
}

internal interface _Labeled<out C : Labeled> : _Control<C>, Fontable {
    override fun font(font: Font) = control.setFont(font)
    fun text(text: String) = control.setText(text)
    fun align(pos: Pos) = control.setAlignment(pos)
    fun textAlign(alignment: TextAlignment) = control.setTextAlignment(alignment)
    fun overrun(style: OverrunStyle) = control.setTextOverrun(style)
    fun ellipsis(ellipsis: String) = control.setEllipsisString(ellipsis)
    fun wrap(wrap: Boolean) = control.setWrapText(wrap)
    fun graphic(graphic: Node) = control.setGraphic(graphic)
    fun underline(underline: Boolean) = control.setUnderline(underline)
    fun spacing(spacing: Number) = control.setLineSpacing(spacing.toDouble())
    fun display(display: ContentDisplay) = control.setContentDisplay(display)
    fun graphicGap(gap: Number) = control.setGraphicTextGap(gap.toDouble())
    fun fill(fill: Paint) = control.setTextFill(fill)
    fun mnemonic(mnemonic: Boolean) = control.setMnemonicParsing(mnemonic)
}

internal interface _TextInputControl<out C : TextInputControl> : _Control<C>, Fontable {
    override fun font(font: Font) = control.setFont(font)
    fun prompt(prompt: String) = control.setPromptText(prompt)
    fun textFormatter(formatter: TextFormatter<*>) = control.setTextFormatter(formatter)
    fun text(text: String) = control.setText(text)
    fun editable(editable: Boolean) = control.setEditable(editable)
}

internal interface Fontable {
    fun font(font: Font)
    fun font(family: String?, weight: FontWeight?, posture: FontPosture?, size: Number?) = font(Font.font(family, weight, posture, size?.toDouble() ?: -1.0))
    fun font(family: String?, weight: FontWeight?, size: Number?) = font(Font.font(family, weight, size?.toDouble() ?: -1.0))
    fun font(family: String?, posture: FontPosture?, size: Number?) = font(Font.font(family, posture, size?.toDouble() ?: -1.0))
    fun font(family: String?, size: Number?) = font(Font.font(family, size?.toDouble() ?: -1.0))
    fun font(family: String?) = font(Font.font(family))
    fun font(size: Number?) = font(Font.font(size?.toDouble() ?: -1.0))
}