@file:Suppress("ClassName")

package ktfx.styles.internal

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.control.ContentDisplay
import javafx.scene.control.OverrunStyle
import javafx.scene.control.ScrollPane
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import ktfx.styles.CellStyleBuilder
import ktfx.styles.ColorPickerStyleBuilder
import ktfx.styles.ControlStyleBuilder
import ktfx.styles.LabeledStyleBuilder
import ktfx.styles.ListViewStyleBuilder
import ktfx.styles.MenuBarStyleBuilder
import ktfx.styles.PageAlignment
import ktfx.styles.PaginationStyleBuilder
import ktfx.styles.ProgressBarStyleBuilder
import ktfx.styles.ProgressIndicatorStyleBuilder
import ktfx.styles.ScrollBarStyleBuilder
import ktfx.styles.ScrollPaneStyleBuilder
import ktfx.styles.SeparatorStyleBuilder
import ktfx.styles.SliderStyleBuilder
import ktfx.styles.SplitPaneStyleBuilder
import ktfx.styles.TabPaneStyleBuilder
import ktfx.styles.TableViewStyleBuilder
import ktfx.styles.TextFieldStyleBuilder
import ktfx.styles.TextInputControlStyleBuilder
import ktfx.styles.TitledPaneStyleBuilder
import ktfx.styles.ToolBarStyleBuilder
import ktfx.styles.TooltipStyleBuilder
import ktfx.styles.TreeCellStyleBuilder
import ktfx.styles.Url

open class _CellStyleBuilder(
    prettyPrint: Boolean
) : _LabeledStyleBuilder(prettyPrint), CellStyleBuilder {
    override var cellSize: Number by map
}

@PublishedApi
internal class _ColorPickerStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint),
    ColorPickerStyleBuilder {
    override var colorLabelVisible: Boolean by map
}

open class _ControlStyleBuilder(
    prettyPrint: Boolean
) : _NodeStyleBuilder(prettyPrint), ControlStyleBuilder {
    override var skin: String by map
}

open class _LabeledStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), LabeledStyleBuilder {
    override var alignment: Pos by map
    override var textAlignment: TextAlignment by map
    override var textOverrun: OverrunStyle by map
    override var wrapText: Boolean by map
    override var font: String by map
    override var underline: Boolean by map
    override var graphic: Url by map
    override var contentDisplay: ContentDisplay by map
    override var graphicTextGap: Number by map
    override var labelPadding: Insets by map
    override var textFill: Color by map
    override var ellipsisString: String by map
}

@PublishedApi
internal class _ListViewStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), ListViewStyleBuilder {
    override var orientation: Orientation by map
}

@PublishedApi
internal class _MenuBarStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), MenuBarStyleBuilder {
    override var useSystemMenuBar: Boolean by map
}

@PublishedApi
internal class _PaginationStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), PaginationStyleBuilder {
    override var maxPageIndicatorCount: Number by map
    override var arrowsVisible: Boolean by map
    override var tooltipVisible: Boolean by map
    override var pageInformationVisible: Boolean by map
    override var pageInformationAlignment: PageAlignment by map
}

@PublishedApi
internal class _ProgressBarStyleBuilder(
    prettyPrint: Boolean
) : _ProgressIndicatorStyleBuilder(prettyPrint), ProgressBarStyleBuilder {
    override var indeterminateBarLength: Number by map
    override var indeterminateBarEscape: Boolean by map
    override var indeterminateBarFlip: Boolean by map
    override var indeterminateBarAnimationTime: Number by map
}

open class _ProgressIndicatorStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), ProgressIndicatorStyleBuilder {
    override var progressColor: Color by map
}

@PublishedApi
internal class _ScrollBarStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), ScrollBarStyleBuilder {
    override var orientation: Orientation by map
    override var blockIncrement: Number by map
    override var unitIncrement: Number by map
}

@PublishedApi
internal class _ScrollPaneStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), ScrollPaneStyleBuilder {
    override var fitToWidth: Boolean by map
    override var fitToHeight: Boolean by map
    override var pannable: Boolean by map
    override var hbarPolicy: ScrollPane.ScrollBarPolicy by map
    override var vbarPolicy: ScrollPane.ScrollBarPolicy by map
}

@PublishedApi
internal class _SeparatorStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), SeparatorStyleBuilder {
    override var orientation: Orientation by map
    override var halignment: HPos by map
    override var valignment: VPos by map
}

@PublishedApi
internal class _SliderStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), SliderStyleBuilder {
    override var orientation: Orientation by map
    override var showTickLabels: Boolean by map
    override var showTickMarks: Boolean by map
    override var majorTickUnit: Number by map
    override var minorTickCount: Int by map
    override var snapToTicks: Boolean by map
    override var blockIncrement: Int by map
}

@PublishedApi
internal class _SplitPaneStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), SplitPaneStyleBuilder {
    override var orientation: Orientation by map
}

@PublishedApi
internal class _TableViewStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), TableViewStyleBuilder {
    override var size: Number by map
}

@PublishedApi
internal class _TabPaneStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), TabPaneStyleBuilder {
    override var tabMinWidth: Int by map
    override var tabMaxWidth: Int by map
    override var tabMinHeight: Int by map
    override var tabMaxHeight: Int by map
}

@PublishedApi
internal class _TextFieldStyleBuilder(
    prettyPrint: Boolean
) : _TextInputControlStyleBuilder(prettyPrint), TextFieldStyleBuilder {
    override var alignment: Pos by map
}

open class _TextInputControlStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), TextInputControlStyleBuilder {
    override var font: String by map
    override var textFill: Color by map
    override var promptTextFill: Color by map
    override var highlightFill: Color by map
    override var highlightTextFill: Color by map
    override var displayCaret: Boolean by map
}

@PublishedApi
internal class _TitledPaneStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), TitledPaneStyleBuilder {
    override var animated: Boolean by map
    override var collapsible: Boolean by map
}

@PublishedApi
internal class _ToolBarStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), ToolBarStyleBuilder {
    override var orientation: Orientation by map
}

@PublishedApi
internal class _TooltipStyleBuilder(
    prettyPrint: Boolean
) : _ControlStyleBuilder(prettyPrint), TooltipStyleBuilder {
    override var textAlignment: TextAlignment by map
    override var textOverrun: OverrunStyle by map
    override var wrapText: Boolean by map
    override var graphic: Url by map
    override var contentDisplay: ContentDisplay by map
    override var graphicTextGap: Number by map
    override var font: String by map
}

@PublishedApi
internal class _TreeCellStyleBuilder(
    prettyPrint: Boolean
) : _CellStyleBuilder(prettyPrint), TreeCellStyleBuilder {
    override var indent: Number by map
}