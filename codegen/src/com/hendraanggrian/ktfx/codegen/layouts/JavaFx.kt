package com.hendraanggrian.ktfx.codegen.layouts

import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.hendraanggrian.kotlinpoet.memberOf
import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.hendraanggrian.ktfx.codegen.KTFX_LAYOUTS
import com.hendraanggrian.ktfx.codegen.S
import com.hendraanggrian.ktfx.codegen.T
import com.hendraanggrian.ktfx.codegen.X
import com.hendraanggrian.ktfx.codegen.Y
import com.squareup.kotlinpoet.asClassName
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.geometry.Orientation
import javafx.scene.Group
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

val LayoutsFactory.Companion.JavaFx: LayoutsFactory
    get() = object : LayoutsFactory("ktfx-layouts/src", KTFX_LAYOUTS, "LayoutsKt") {
        init {
            // javafx.scene
            Group::class(customClass = true)

            // javafx.scene.canvas
            Canvas::class { width(); height() }

            // javafx.scene.chart
            AreaChart::class(X, Y) { xyChartParameters() }
            BarChart::class(X, Y) { xyChartParameters(); "categoryGap"<Double> { defaultValue("10.0") } }
            BubbleChart::class(X, Y) { xyChartParameters() }
            PieChart::class {
                "data"(ObservableList::class.parameterizedBy(PieChart.Data::class)) {
                    defaultValue("%M()", FXCollections::class.memberOf("observableArrayList"))
                }
            }
            ScatterChart::class(X, Y) { xyChartParameters() }
            StackedAreaChart::class(X, Y) { xyChartParameters() }
            StackedBarChart::class(X, Y) { xyChartParameters() }

            // javafx.scene.control
            Accordion::class(customClass = true)
            Button::class { text(); graphic() }
            ButtonBar::class(customClass = true) { "buttonOrder"(String::class.asNullable()) { defaultValue("null") } }
            CheckBox::class { text() }
            CheckMenuItem::class { text(); graphic() }
            ChoiceBox::class(T) { items(T) }
            ColorPicker::class { color() }
            ComboBox::class(T) { items(T) }
            CustomMenuItem::class { content(); "hideOnClick"<Boolean> { defaultValue("true") } }
            DatePicker::class { date() }
            Hyperlink::class{ text(); graphic() }
            Label::class{ text(); graphic() }
            ListView::class(T) { items(T) }
            Menu::class(customClass = true) { emptyText(); graphic() }
            MenuBar::class(customClass = true)
            MenuButton::class(customClass = true) { text(); graphic() }
            MenuItem::class { text(); graphic() }
            Pagination::class {
                "pageCount"<Int> { defaultValue("%M", Pagination::class.memberOf("INDETERMINATE")) }
                "currentPageIndex"<Int> { defaultValue("0") }
            }
            PasswordField::class()
            ProgressBar::class { progress() }
            ProgressIndicator::class { progress() }
            RadioButton::class { text() }
            RadioMenuItem::class { text(); graphic() }
            ScrollBar::class()
            ScrollPane::class(customClass = true) { content() }
            Separator::class { orientation() }
            SeparatorMenuItem::class()
            Slider::class { slider("0.0") }
            Spinner::class(T)
            SplitMenuButton::class(customClass = true)
            SplitPane::class(customClass = true)
            Tab::class(customClass = true) { text(); content() }
            TableView::class(S) { items(S) }
            TabPane::class(customClass = true)
            TextArea::class { emptyText() }
            TextField::class { emptyText() }
            TitledPane::class(customClass = true) { "title"(String::class.asNullable()) { defaultValue("null") } }
            ToggleButton::class { text(); graphic() }
            ToolBar::class(customClass = true)
            TreeTableView::class(S) { treeItem("root", S) }
            TreeView::class(T) { treeItem("root", T) }

            // javafx.scene.image
            ImageView::class { add("image", Image::class.asNullable()) { defaultValue("null") } }
            ImageView::class { add<String>("imageUrl") }

            // javafx.scene.media
            MediaView::class { add("mediaPlayer", MediaPlayer::class.asNullable()) { defaultValue("null") } }

            // javafx.scene.layout
            AnchorPane::class(customClass = true)
            BorderPane::class(customClass = true)
            FlowPane::class(customClass = true) { orientation(); add<Double>("hgap"); add<Double>("vgap") }
            FlowPane::class(customClass = true) { orientation(); "gap"<Double> { defaultValue("0.0") } }
            GridPane::class(customClass = true)
            HBox::class(customClass = true) { spacing() }
            Pane::class(customClass = true)
            Region::class()
            StackPane::class(customClass = true)
            TilePane::class(customClass = true) { orientation(); add<Double>("hgap"); add<Double>("vgap") }
            TilePane::class(customClass = true) { orientation(); "gap"<Double> { defaultValue("0.0") } }
            VBox::class(customClass = true) { spacing() }

            // javafx.scene.shape
            Arc::class {
                centerXY(); radiusXY()
                "startAngle"<Double> { defaultValue("0.0") }
                "length"<Double> { defaultValue("0.0") }
            }
            ArcTo::class {
                radiusXY()
                "xAxisRotation"<Double> { defaultValue("0.0") }
                x(); y()
                "largeArcFlag"<Boolean> { defaultValue("false") }
                "sweepFlag"<Boolean> { defaultValue("false") }
            }
            Box::class {
                "width"<Double> { defaultValue("%M", Box::class.memberOf("DEFAULT_SIZE")) }
                "height"<Double> { defaultValue("%M", Box::class.memberOf("DEFAULT_SIZE")) }
                "depth"<Double> { defaultValue("%M", Box::class.memberOf("DEFAULT_SIZE")) }
            }
            Circle::class { centerXY(); radius(0.0); fill() }
            ClosePath::class()
            CubicCurve::class { startXY(); controlXY1(); controlXY2(); endXY() }
            CubicCurveTo::class { controlXY1(); controlXY2(); x(); y(); }
            Cylinder::class { radius(1.0); "height"<Double> { defaultValue("2.0") }; division() }
            Ellipse::class { centerXY(); radiusXY() }
            HLineTo::class { x() }
            Line::class { centerXY(); endXY() }
            LineTo::class { x(); y() }
            MeshView::class { "mesh"(Mesh::class.asClassName().asNullable()) { defaultValue("null") } }
            MoveTo::class { x(); y() }
            Path::class(customClass = true)
            Polygon::class() // points param not included since vararg is reserved
            Polyline::class() // points param not included since vararg is reserved
            QuadCurve::class { startXY(); controlXY(); endXY() }
            QuadCurveTo::class { controlXY(); x(); y() }
            Rectangle::class { x(); y(); width(); height() }
            Sphere::class { radius(1.0); division() }
            SVGPath::class()
            VLineTo::class { y() }

            // javafx.scene.text
            Text::class { text() }
            TextFlow::class(customClass = true)

            // javafx.scene.web
            WebView::class()
        }

        fun ParameterSpecListScope.emptyText() = "text"<String> { defaultValue("\"\"") }

        fun ParameterSpecListScope.orientation() =
            "orientation"<Orientation> { defaultValue("%M", Orientation::class.memberOf("HORIZONTAL")) }

        fun ParameterSpecListScope.spacing() = "spacing"<Double> { defaultValue("0.0") }
        fun ParameterSpecListScope.width() = "width"<Double> { defaultValue("0.0") }
        fun ParameterSpecListScope.height() = "height"<Double> { defaultValue("0.0") }

        fun ParameterSpecListScope.xyChartParameters() {
            add("x", Axis::class.parameterizedBy(X))
            add("y", Axis::class.parameterizedBy(Y))
            "data"(ObservableList::class.parameterizedBy(XYChart.Series::class.parameterizedBy(X, Y))) {
                defaultValue("%M()", FXCollections::class.memberOf("observableArrayList"))
            }
        }

        fun ParameterSpecListScope.x() = "x"<Double> { defaultValue("0.0") }
        fun ParameterSpecListScope.y() = "y"<Double> { defaultValue("0.0") }

        fun ParameterSpecListScope.startXY() {
            "startX"<Double> { defaultValue("0.0") }
            "startY"<Double> { defaultValue("0.0") }
        }

        fun ParameterSpecListScope.endXY() {
            "endX"<Double> { defaultValue("0.0") }
            "endY"<Double> { defaultValue("0.0") }
        }

        fun ParameterSpecListScope.centerXY() {
            "centerX"<Double> { defaultValue("0.0") }
            "centerY"<Double> { defaultValue("0.0") }
        }

        fun ParameterSpecListScope.radiusXY() {
            "radiusX"<Double> { defaultValue("0.0") }
            "radiusY"<Double> { defaultValue("0.0") }
        }

        fun ParameterSpecListScope.radius(radius: Double) = "radius"<Double> { defaultValue("$radius") }

        fun ParameterSpecListScope.fill() = "fill"(Paint::class.asNullable()) { defaultValue("null") }

        fun ParameterSpecListScope.controlXY() {
            "controlX"<Double> { defaultValue("0.0") }
            "controlY"<Double> { defaultValue("0.0") }
        }

        fun ParameterSpecListScope.controlXY1() {
            "controlX1"<Double> { defaultValue("0.0") }
            "controlY1"<Double> { defaultValue("0.0") }
        }

        fun ParameterSpecListScope.controlXY2() {
            "controlX2"<Double> { defaultValue("0.0") }
            "controlY2"<Double> { defaultValue("0.0") }
        }

        fun ParameterSpecListScope.division() = "division"<Int> { defaultValue("64") }
    }