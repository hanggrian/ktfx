package com.hendraanggrian.ktfx.codegen.layouts

import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.hendraanggrian.ktfx.codegen.KTFX_LAYOUTS
import com.hendraanggrian.ktfx.codegen.S
import com.hendraanggrian.ktfx.codegen.T
import com.hendraanggrian.ktfx.codegen.X
import com.hendraanggrian.ktfx.codegen.Y
import com.squareup.kotlinpoet.MemberName.Companion.member
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.asTypeName
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
    get() =
        object : LayoutsFactory("ktfx-layouts/src/main/kotlin", KTFX_LAYOUTS, "KtfxLayoutsKt") {
            init {
                // javafx.scene
                Group::class(customClass = true)

                // javafx.scene.canvas
                Canvas::class {
                    width()
                    height()
                }

                // javafx.scene.chart
                AreaChart::class(X, Y) { xyChartParameters() }
                BarChart::class(X, Y) {
                    xyChartParameters()
                    add<Double>("categoryGap") { defaultValue("10.0") }
                }
                BubbleChart::class(X, Y) { xyChartParameters() }
                PieChart::class {
                    "data"(ObservableList::class.parameterizedBy(PieChart.Data::class)) {
                        defaultValue(
                            "%M()",
                            FXCollections::class.asClassName().member("observableArrayList"),
                        )
                    }
                }
                ScatterChart::class(X, Y) { xyChartParameters() }
                StackedAreaChart::class(X, Y) { xyChartParameters() }
                StackedBarChart::class(X, Y) { xyChartParameters() }

                // javafx.scene.control
                Accordion::class(customClass = true)
                Button::class {
                    text()
                    graphic()
                }
                ButtonBar::class(customClass = true) {
                    "buttonOrder"(String::class.asTypeName().copy(true)) { defaultValue("null") }
                }
                CheckBox::class { text() }
                CheckMenuItem::class {
                    text()
                    graphic()
                }
                ChoiceBox::class(T) { items(T) }
                ColorPicker::class { color() }
                ComboBox::class(T) { items(T) }
                CustomMenuItem::class {
                    content()
                    add<Boolean>("hideOnClick") { defaultValue("true") }
                }
                DatePicker::class { date() }
                Hyperlink::class {
                    text()
                    graphic()
                }
                Label::class {
                    text()
                    graphic()
                }
                ListView::class(T) { items(T) }
                Menu::class(customClass = true) {
                    emptyText()
                    graphic()
                }
                MenuBar::class(customClass = true)
                MenuButton::class(customClass = true) {
                    text()
                    graphic()
                }
                MenuItem::class {
                    text()
                    graphic()
                }
                Pagination::class {
                    add<Int>("pageCount") {
                        defaultValue("%M", Pagination::class.asClassName().member("INDETERMINATE"))
                    }
                    add<Int>("currentPageIndex") { defaultValue("0") }
                }
                PasswordField::class()
                ProgressBar::class { progress() }
                ProgressIndicator::class { progress() }
                RadioButton::class { text() }
                RadioMenuItem::class {
                    text()
                    graphic()
                }
                ScrollBar::class()
                ScrollPane::class(customClass = true) { content() }
                Separator::class { orientation() }
                SeparatorMenuItem::class()
                Slider::class { slider("0.0") }
                Spinner::class(T)
                SplitMenuButton::class(customClass = true)
                SplitPane::class(customClass = true)
                Tab::class(customClass = true) {
                    text()
                    content()
                }
                TableView::class(S) { items(S) }
                TabPane::class(customClass = true)
                TextArea::class { emptyText() }
                TextField::class { emptyText() }
                TitledPane::class(customClass = true) {
                    "title"(String::class.asTypeName().copy(true)) { defaultValue("null") }
                }
                ToggleButton::class {
                    text()
                    graphic()
                }
                ToolBar::class(customClass = true)
                TreeTableView::class(S) { treeItem("root", S) }
                TreeView::class(T) { treeItem("root", T) }

                // javafx.scene.image
                ImageView::class {
                    add("image", Image::class.asTypeName().copy(true)) { defaultValue("null") }
                }
                ImageView::class { add<String>("imageUrl") }

                // javafx.scene.media
                MediaView::class {
                    add("mediaPlayer", MediaPlayer::class.asTypeName().copy(true)) {
                        defaultValue("null")
                    }
                }

                // javafx.scene.layout
                AnchorPane::class(customClass = true)
                BorderPane::class(customClass = true)
                FlowPane::class(customClass = true) {
                    orientation()
                    add<Double>("hgap")
                    add<Double>("vgap")
                }
                FlowPane::class(customClass = true) {
                    orientation()
                    add<Double>("gap") { defaultValue("0.0") }
                }
                GridPane::class(customClass = true)
                HBox::class(customClass = true) { spacing() }
                Pane::class(customClass = true)
                Region::class()
                StackPane::class(customClass = true)
                TilePane::class(customClass = true) {
                    orientation()
                    add<Double>("hgap")
                    add<Double>("vgap")
                }
                TilePane::class(customClass = true) {
                    orientation()
                    add<Double>("gap") { defaultValue("0.0") }
                }
                VBox::class(customClass = true) { spacing() }

                // javafx.scene.shape
                Arc::class {
                    centerXY()
                    radiusXY()
                    add<Double>("startAngle") { defaultValue("0.0") }
                    add<Double>("length") { defaultValue("0.0") }
                }
                ArcTo::class {
                    radiusXY()
                    add<Double>("xAxisRotation") { defaultValue("0.0") }
                    x()
                    y()
                    add<Boolean>("largeArcFlag") { defaultValue("false") }
                    add<Boolean>("sweepFlag") { defaultValue("false") }
                }
                Box::class {
                    add<Double>("width") {
                        defaultValue("%M", Box::class.asClassName().member("DEFAULT_SIZE"))
                    }
                    add<Double>("height") {
                        defaultValue("%M", Box::class.asClassName().member("DEFAULT_SIZE"))
                    }
                    add<Double>("depth") {
                        defaultValue("%M", Box::class.asClassName().member("DEFAULT_SIZE"))
                    }
                }
                Circle::class {
                    centerXY()
                    radius(0.0)
                    fill()
                }
                ClosePath::class()
                CubicCurve::class {
                    startXY()
                    controlXY1()
                    controlXY2()
                    endXY()
                }
                CubicCurveTo::class {
                    controlXY1()
                    controlXY2()
                    x()
                    y()
                }
                Cylinder::class {
                    radius(1.0)
                    add<Double>("height") { defaultValue("2.0") }
                    division()
                }
                Ellipse::class {
                    centerXY()
                    radiusXY()
                }
                HLineTo::class { x() }
                Line::class {
                    centerXY()
                    endXY()
                }
                LineTo::class {
                    x()
                    y()
                }
                MeshView::class {
                    "mesh"(
                        Mesh::class.asTypeName().copy(true),
                    ) { defaultValue("null") }
                }
                MoveTo::class {
                    x()
                    y()
                }
                Path::class(customClass = true)
                Polygon::class() // points param not included since vararg is reserved
                Polyline::class() // points param not included since vararg is reserved
                QuadCurve::class {
                    startXY()
                    controlXY()
                    endXY()
                }
                QuadCurveTo::class {
                    controlXY()
                    x()
                    y()
                }
                Rectangle::class {
                    x()
                    y()
                    width()
                    height()
                }
                Sphere::class {
                    radius(1.0)
                    division()
                }
                SVGPath::class()
                VLineTo::class { y() }

                // javafx.scene.text
                Text::class { text() }
                TextFlow::class(customClass = true)

                // javafx.scene.web
                WebView::class()
            }

            fun ParameterSpecListScope.emptyText() = add<String>("text") { defaultValue("\"\"") }

            fun ParameterSpecListScope.orientation() =
                add<Orientation>("orientation") {
                    defaultValue(
                        "%M",
                        Orientation::class.asClassName().member("HORIZONTAL"),
                    )
                }

            fun ParameterSpecListScope.spacing() = add<Double>("spacing") { defaultValue("0.0") }

            fun ParameterSpecListScope.width() = add<Double>("width") { defaultValue("0.0") }

            fun ParameterSpecListScope.height() = add<Double>("height") { defaultValue("0.0") }

            fun ParameterSpecListScope.xyChartParameters() {
                add("x", Axis::class.asClassName().parameterizedBy(X))
                add("y", Axis::class.asClassName().parameterizedBy(Y))
                "data"(
                    ObservableList::class.asClassName()
                        .parameterizedBy(XYChart.Series::class.asClassName().parameterizedBy(X, Y)),
                ) {
                    defaultValue(
                        "%M()",
                        FXCollections::class.asClassName().member("observableArrayList"),
                    )
                }
            }

            fun ParameterSpecListScope.x() = add<Double>("x") { defaultValue("0.0") }

            fun ParameterSpecListScope.y() = add<Double>("y") { defaultValue("0.0") }

            fun ParameterSpecListScope.startXY() {
                add<Double>("startX") { defaultValue("0.0") }
                add<Double>("startY") { defaultValue("0.0") }
            }

            fun ParameterSpecListScope.endXY() {
                add<Double>("endX") { defaultValue("0.0") }
                add<Double>("endY") { defaultValue("0.0") }
            }

            fun ParameterSpecListScope.centerXY() {
                add<Double>("centerX") { defaultValue("0.0") }
                add<Double>("centerY") { defaultValue("0.0") }
            }

            fun ParameterSpecListScope.radiusXY() {
                add<Double>("radiusX") { defaultValue("0.0") }
                add<Double>("radiusY") { defaultValue("0.0") }
            }

            fun ParameterSpecListScope.radius(radius: Double) =
                add<Double>("radius") { defaultValue("$radius") }

            fun ParameterSpecListScope.fill() =
                "fill"(Paint::class.asTypeName().copy(true)) { defaultValue("null") }

            fun ParameterSpecListScope.controlXY() {
                add<Double>("controlX") { defaultValue("0.0") }
                add<Double>("controlY") { defaultValue("0.0") }
            }

            fun ParameterSpecListScope.controlXY1() {
                add<Double>("controlX1") { defaultValue("0.0") }
                add<Double>("controlY1") { defaultValue("0.0") }
            }

            fun ParameterSpecListScope.controlXY2() {
                add<Double>("controlX2") { defaultValue("0.0") }
                add<Double>("controlY2") { defaultValue("0.0") }
            }

            fun ParameterSpecListScope.division() = add<Int>("division") { defaultValue("64") }
        }
