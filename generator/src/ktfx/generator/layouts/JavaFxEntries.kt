package ktfx.generator.layouts

import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.buildParameter
import com.hendraanggrian.kotlinpoet.memberOf
import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.hendraanggrian.kotlinpoet.typeVariableBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asClassName
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.canvas.Canvas
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.BarChart
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.PieChart
import javafx.scene.chart.ScatterChart
import javafx.scene.chart.StackedAreaChart
import javafx.scene.chart.StackedBarChart
import javafx.scene.chart.XYChart
import javafx.scene.control.Accordion
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import javafx.scene.control.CheckBox
import javafx.scene.control.CheckMenuItem
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ColorPicker
import javafx.scene.control.ComboBox
import javafx.scene.control.CustomMenuItem
import javafx.scene.control.DatePicker
import javafx.scene.control.Hyperlink
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem
import javafx.scene.control.Pagination
import javafx.scene.control.PasswordField
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressIndicator
import javafx.scene.control.RadioButton
import javafx.scene.control.RadioMenuItem
import javafx.scene.control.ScrollBar
import javafx.scene.control.ScrollPane
import javafx.scene.control.Separator
import javafx.scene.control.SeparatorMenuItem
import javafx.scene.control.Slider
import javafx.scene.control.Spinner
import javafx.scene.control.SplitMenuButton
import javafx.scene.control.SplitPane
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.control.TableView
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.control.TitledPane
import javafx.scene.control.ToggleButton
import javafx.scene.control.ToolBar
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView
import javafx.scene.control.TreeView
import javafx.scene.paint.Color
import java.time.LocalDate
import kotlin.reflect.KClass

object JavaFxEntries : LayoutsEntries(
    "ktfx-layouts/src",
    "LayoutsKt",
    // javafx.scene.canvas
    Canvas::class(width, height),
    // javafx.scene.chart
    AreaChart::class(xAxis, yAxis, seriesData, typeVariables = "XY"),
    BarChart::class(
        xAxis, yAxis, seriesData,
        buildParameter<Double>("categoryGap") { defaultValue("10.0") },
        typeVariables = "XY"
    ),
    BubbleChart::class(xAxis, yAxis, seriesData, typeVariables = "XY"),
    PieChart::class(dataData),
    ScatterChart::class(xAxis, yAxis, seriesData, typeVariables = "XY"),
    StackedAreaChart::class(xAxis, yAxis, seriesData, typeVariables = "XY"),
    StackedBarChart::class(xAxis, yAxis, seriesData, typeVariables = "XY"),
    // javafx.scene.control
    Accordion::class(customClass = true),
    Button::class(text, graphic),
    ButtonBar::class(
        buildParameter("buttonOrder", String::class.asClassName().asNullable()) { defaultValue("null") },
        customClass = true
    ),
    CheckBox::class(text),
    CheckMenuItem::class(text, graphic),
    ChoiceBox::class(items(T), typeVariables = "T"),
    ColorPicker::class(buildParameter<Color>("value") { defaultValue("%M", Color::class.memberOf("WHITE")) }),
    ComboBox::class(items(T), typeVariables = "T"),
    CustomMenuItem::class(content, buildParameter<Boolean>("hideOnClick") { defaultValue("true") }),
    DatePicker::class(buildParameter("value", LocalDate::class.asClassName().asNullable()) { defaultValue("null") }),
    Hyperlink::class(text, graphic),
    Label::class(text, graphic),
    ListView::class(items(T), typeVariables = "T"),
    Menu::class(emptyText, graphic, customClass = true),
    MenuBar::class(customClass = true),
    MenuButton::class(text, graphic, customClass = true),
    MenuItem::class(text, graphic),
    Pagination::class(
        buildParameter<Int>("pageCount") { defaultValue("%M", Pagination::class.memberOf("INDETERMINATE")) },
        buildParameter<Int>("currentPageIndex") { defaultValue("0") }
    ),
    PasswordField::class(),
    ProgressBar::class(progress),
    ProgressIndicator::class(progress),
    RadioButton::class(text),
    RadioMenuItem::class(text, graphic),
    ScrollBar::class(),
    ScrollPane::class(content, customClass = true),
    Separator::class(),
    SeparatorMenuItem::class(),
    Slider::class(
        buildParameter<Double>("min") { defaultValue("0.0") },
        buildParameter<Double>("max") { defaultValue("100.0") },
        buildParameter<Double>("value") { defaultValue("0.0") }
    ),
    Spinner::class(typeVariables = "T"),
    SplitMenuButton::class(customClass = true),
    SplitPane::class(customClass = true),
    Tab::class(text, content, customClass = true),
    TableView::class(items(S), typeVariables = "S"),
    TabPane::class(customClass = true),
    TextArea::class(emptyText),
    TextField::class(emptyText),
    TitledPane::class(title, customClass = true),
    ToggleButton::class(text, graphic),
    ToolBar::class(customClass = true),
    TreeTableView::class(root(TreeItem::class, S), typeVariables = "S"),
    TreeView::class(root(TreeItem::class, T), typeVariables = "T")
)

private val T = "T".typeVariableBy()
private val S = "S".typeVariableBy()
private val X = "X".typeVariableBy()
private val Y = "Y".typeVariableBy()

private val text = buildParameter("text", String::class.asClassName().asNullable()) { defaultValue("null") }
private val emptyText = buildParameter<String>("text") { defaultValue("\"\"") }
private val title = buildParameter("title", String::class.asClassName().asNullable()) { defaultValue("null") }
private val graphic = buildParameter("graphic", Node::class.asClassName().asNullable()) { defaultValue("null") }
private val content = buildParameter("content", Node::class.asClassName().asNullable()) { defaultValue("null") }
private val progress = buildParameter<Double>("progress") {
    defaultValue("%M", ProgressBar::class.memberOf("INDETERMINATE_PROGRESS"))
}

private fun root(rootClass: KClass<*>, typeVariableName: TypeVariableName) = buildParameter(
    "root", rootClass.asClassName().parameterizedBy(typeVariableName).asNullable()
) { defaultValue("null") }

private val width = buildParameter<Double>("width") { defaultValue("0.0") }
private val height = buildParameter<Double>("height") { defaultValue("0.0") }

private fun items(typeVariableName: TypeVariableName) = buildParameter(
    "items",
    ObservableList::class.asClassName().parameterizedBy(typeVariableName)
) { defaultValue("%M()", FXCollections::class.memberOf("observableArrayList")) }

private val xAxis = buildParameter("x", Axis::class.asClassName().parameterizedBy(X))
private val yAxis = buildParameter("y", Axis::class.asClassName().parameterizedBy(Y))
private val seriesData = buildParameter(
    "data", ObservableList::class.asClassName().parameterizedBy(
        XYChart.Series::class.asClassName().parameterizedBy(X, Y)
    )
) {
    defaultValue("%M()", FXCollections::class.memberOf("observableArrayList"))
}
private val dataData = buildParameter("data", ObservableList::class.parameterizedBy(PieChart.Data::class)) {
    defaultValue("%M()", FXCollections::class.memberOf("observableArrayList"))
}
