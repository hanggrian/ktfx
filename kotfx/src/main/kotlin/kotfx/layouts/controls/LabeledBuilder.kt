package kotfx.layouts.controls

import javafx.beans.property.*
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.ContentDisplay
import javafx.scene.control.Labeled
import javafx.scene.control.OverrunStyle
import javafx.scene.paint.Paint
import javafx.scene.text.Font
import javafx.scene.text.TextAlignment

interface LabeledBuilder<out T : Labeled> : ControlBuilder<T> {

    val textProperty: StringProperty get() = t.textProperty()
    var text: String
        get() = t.text
        set(value) = t.setText(value)

    val alignmentProperty: ObjectProperty<Pos> get() = t.alignmentProperty()
    var alignment: Pos
        get() = t.alignment
        set(value) = t.setAlignment(value)

    val textAlignmentProperty: ObjectProperty<TextAlignment> get() = t.textAlignmentProperty()
    var textAlignment: TextAlignment
        get() = t.textAlignment
        set(value) = t.setTextAlignment(value)

    val overrunProperty: ObjectProperty<OverrunStyle> get() = t.textOverrunProperty()
    var overrun: OverrunStyle
        get() = t.textOverrun
        set(value) = t.setTextOverrun(value)

    val ellipsisProperty: StringProperty get() = t.ellipsisStringProperty()
    var ellipsis: String
        get() = t.ellipsisString
        set(value) = t.setEllipsisString(value)

    val wrapProperty: BooleanProperty get() = t.wrapTextProperty()
    var isWrap: Boolean
        get() = t.isWrapText
        set(value) = t.setWrapText(value)

    override val contentBias: Orientation? get() = t.contentBias

    val fontProperty: ObjectProperty<Font> get() = t.fontProperty()
    var font: Font
        get() = t.font
        set(value) = t.setFont(value)

    val graphicProperty: ObjectProperty<Node> get() = t.graphicProperty()
    var graphic: Node
        get() = t.graphic
        set(value) = t.setGraphic(value)

    val underlineProperty: BooleanProperty get() = t.underlineProperty()
    var isUnderline: Boolean
        get() = t.isUnderline
        set(value) = t.setUnderline(value)

    val lineSpacingProperty: DoubleProperty get() = t.lineSpacingProperty()
    var lineSpacing: Double
        get() = t.lineSpacing
        set(value) = t.setLineSpacing(value)

    val contentDisplayProperty: ObjectProperty<ContentDisplay> get() = t.contentDisplayProperty()
    var contentDisplay: ContentDisplay
        get() = t.contentDisplay
        set(value) = t.setContentDisplay(value)

    val labelPaddingProperty: ReadOnlyObjectProperty<Insets> get() = t.labelPaddingProperty()
    val labelPadding: Insets get() = t.labelPadding

    val graphicGapProperty: DoubleProperty get() = t.graphicTextGapProperty()
    var graphicGap: Double
        get() = t.graphicTextGap
        set(value) = t.setGraphicTextGap(value)

    val textFillProperty: ObjectProperty<Paint> get() = t.textFillProperty()
    var textFill: Paint
        get() = t.textFill
        set(value) = t.setTextFill(value)

    val mnemonicParsingProperty: BooleanProperty get() = t.mnemonicParsingProperty()
    var isMnemonicParsing: Boolean
        get() = t.isMnemonicParsing
        set(value) = t.setMnemonicParsing(value)
}