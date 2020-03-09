package ktfx.generator.layouts

import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.buildParameter
import com.hendraanggrian.kotlinpoet.memberOf
import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.hendraanggrian.kotlinpoet.typeVariableBy
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asClassName
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.geometry.Orientation
import javafx.scene.Group
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
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.FlowPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.Region
import javafx.scene.layout.StackPane
import javafx.scene.layout.TilePane
import javafx.scene.layout.VBox
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.scene.shape.Arc
import javafx.scene.shape.ArcTo
import javafx.scene.shape.Box
import javafx.scene.shape.Circle
import javafx.scene.shape.ClosePath
import javafx.scene.shape.CubicCurve
import javafx.scene.shape.CubicCurveTo
import javafx.scene.shape.Cylinder
import javafx.scene.shape.Ellipse
import javafx.scene.shape.HLineTo
import javafx.scene.shape.Line
import javafx.scene.shape.LineTo
import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView
import javafx.scene.shape.MoveTo
import javafx.scene.shape.Path
import javafx.scene.shape.Polygon
import javafx.scene.shape.Polyline
import javafx.scene.shape.QuadCurve
import javafx.scene.shape.QuadCurveTo
import javafx.scene.shape.Rectangle
import javafx.scene.shape.SVGPath
import javafx.scene.shape.Sphere
import javafx.scene.shape.VLineTo
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import javafx.scene.web.WebView
import java.time.LocalDate

object JavaFxEntries : LayoutsEntries(
    "ktfx-layouts/src",
    "LayoutsKt",

    // javafx.scene
    Group::class(customClass = true),

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
    ChoiceBox::class(T.items, typeVariables = "T"),
    ColorPicker::class(buildParameter<Color>("value") { defaultValue("%M", Color::class.memberOf("WHITE")) }),
    ComboBox::class(T.items, typeVariables = "T"),
    CustomMenuItem::class(content, buildParameter<Boolean>("hideOnClick") { defaultValue("true") }),
    DatePicker::class(buildParameter("value", LocalDate::class.asClassName().asNullable()) { defaultValue("null") }),
    Hyperlink::class(text, graphic),
    Label::class(text, graphic),
    ListView::class(T.items, typeVariables = "T"),
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
    Separator::class(orientation),
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
    TableView::class(S.items, typeVariables = "S"),
    TabPane::class(customClass = true),
    TextArea::class(emptyText),
    TextField::class(emptyText),
    TitledPane::class(title, customClass = true),
    ToggleButton::class(text, graphic),
    ToolBar::class(customClass = true),
    TreeTableView::class(S.root, typeVariables = "S"),
    TreeView::class(T.root, typeVariables = "T"),

    // javafx.scene.image
    ImageView::class(buildParameter("image", Image::class.asClassName().asNullable()) { defaultValue("null") }),
    ImageView::class(buildParameter<String>("imageUrl")),

    // javafx.scene.media
    MediaView::class(
        buildParameter("mediaPlayer", MediaPlayer::class.asClassName().asNullable()) { defaultValue("null") }
    ),

    // javafx.scene.layout
    AnchorPane::class(customClass = true),
    BorderPane::class(customClass = true),
    FlowPane::class(orientation, buildParameter<Double>("hgap"), buildParameter<Double>("vgap"), customClass = true),
    FlowPane::class(orientation, buildParameter<Double>("gap") { defaultValue("0.0") }, customClass = true),
    GridPane::class(customClass = true),
    HBox::class(spacing, customClass = true),
    Pane::class(customClass = true),
    Region::class(),
    StackPane::class(customClass = true),
    TilePane::class(orientation, buildParameter<Double>("hgap"), buildParameter<Double>("vgap"), customClass = true),
    TilePane::class(orientation, buildParameter<Double>("gap") { defaultValue("0.0") }, customClass = true),
    VBox::class(spacing, customClass = true),

    // javafx.scene.shape
    Arc::class(centerX, centerY, radiusX, radiusY, startAngle, length),
    ArcTo::class(
        radiusX, radiusY,
        buildParameter<Double>("xAxisRotation") { defaultValue("0.0") },
        x, y,
        buildParameter<Boolean>("largeArcFlag") { defaultValue("false") },
        buildParameter<Boolean>("sweepFlag") { defaultValue("false") }
    ),
    Box::class(
        buildParameter<Double>("width") { defaultValue("%M", Box::class.memberOf("DEFAULT_SIZE")) },
        buildParameter<Double>("height") { defaultValue("%M", Box::class.memberOf("DEFAULT_SIZE")) },
        buildParameter<Double>("depth") { defaultValue("%M", Box::class.memberOf("DEFAULT_SIZE")) }
    ),
    Circle::class(centerX, centerY, 0.0.radius, fill),
    ClosePath::class(),
    CubicCurve::class(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY),
    CubicCurveTo::class(controlX1, controlY1, controlX2, controlY2, x, y),
    Cylinder::class(1.0.radius, buildParameter<Double>("height") { defaultValue("2.0") }, division),
    Ellipse::class(centerX, centerY, radiusX, radiusY),
    HLineTo::class(x),
    Line::class(centerX, centerY, endX, endY),
    LineTo::class(x, y),
    MeshView::class(buildParameter("mesh", Mesh::class.asClassName().asNullable()) { defaultValue("null") }),
    MoveTo::class(x, y),
    Path::class(customClass = true),
    Polygon::class(), // points param not included since vararg is reserved
    Polyline::class(), // points param not included since vararg is reserved
    QuadCurve::class(startX, startY, controlX, controlY, endX, endY),
    QuadCurveTo::class(controlX, controlY, x, y),
    Rectangle::class(x, y, width, height),
    Sphere::class(1.0.radius, division),
    SVGPath::class(),
    VLineTo::class(y),

    // javafx.scene.text
    Text::class(text),
    TextFlow::class(customClass = true),

    // javafx.scene.web
    WebView::class()
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

private val orientation = buildParameter<Orientation>("orientation") {
    defaultValue("%M", Orientation::class.memberOf("HORIZONTAL"))
}
private val spacing = buildParameter<Double>("spacing") { defaultValue("0.0") }

private val TypeVariableName.root
    get() = buildParameter("root", TreeItem::class.asClassName().parameterizedBy(this).asNullable()) {
        defaultValue("null")
    }

private val width = buildParameter<Double>("width") { defaultValue("0.0") }
private val height = buildParameter<Double>("height") { defaultValue("0.0") }

private val TypeVariableName.items
    get() = buildParameter("items", ObservableList::class.asClassName().parameterizedBy(this)) {
        defaultValue("%M()", FXCollections::class.memberOf("observableArrayList"))
    }

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

private val x = buildParameter<Double>("x") { defaultValue("0.0") }
private val y = buildParameter<Double>("y") { defaultValue("0.0") }
private val startX = buildParameter<Double>("startX") { defaultValue("0.0") }
private val startY = buildParameter<Double>("startY") { defaultValue("0.0") }
private val endX = buildParameter<Double>("endX") { defaultValue("0.0") }
private val endY = buildParameter<Double>("endY") { defaultValue("0.0") }
private val centerX = buildParameter<Double>("centerX") { defaultValue("0.0") }
private val centerY = buildParameter<Double>("centerY") { defaultValue("0.0") }
private val radiusX = buildParameter<Double>("radiusX") { defaultValue("0.0") }
private val radiusY = buildParameter<Double>("radiusY") { defaultValue("0.0") }
private val startAngle = buildParameter<Double>("startAngle") { defaultValue("0.0") }
private val length = buildParameter<Double>("length") { defaultValue("0.0") }
private val Double.radius: ParameterSpec get() = buildParameter<Double>("radius") { defaultValue(this@radius.toString()) }
private val fill = buildParameter("fill", Paint::class.asClassName().asNullable()) { defaultValue("null") }
private val controlX = buildParameter<Double>("controlX") { defaultValue("0.0") }
private val controlY = buildParameter<Double>("controlY") { defaultValue("0.0") }
private val controlX1 = buildParameter<Double>("controlX1") { defaultValue("0.0") }
private val controlY1 = buildParameter<Double>("controlY1") { defaultValue("0.0") }
private val controlX2 = buildParameter<Double>("controlX2") { defaultValue("0.0") }
private val controlY2 = buildParameter<Double>("controlY2") { defaultValue("0.0") }
private val division = buildParameter<Int>("division") { defaultValue("64") }