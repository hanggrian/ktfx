@file:Suppress("NOTHING_TO_INLINE")

package kotfx.scene

import javafx.collections.ObservableList
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.Node
import javafx.scene.canvas.Canvas
import javafx.scene.chart.AreaChart
import javafx.scene.chart.Axis
import javafx.scene.chart.BarChart
import javafx.scene.chart.BubbleChart
import javafx.scene.chart.PieChart
import javafx.scene.chart.PieChart.Data
import javafx.scene.chart.ScatterChart
import javafx.scene.chart.StackedAreaChart
import javafx.scene.chart.StackedBarChart
import javafx.scene.chart.XYChart.Series
import javafx.scene.control.Accordion
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import javafx.scene.control.CheckBox
import javafx.scene.control.CheckMenuItem
import javafx.scene.control.ChoiceBox
import javafx.scene.control.ColorPicker
import javafx.scene.control.ComboBox
import javafx.scene.control.ContextMenu
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
import javafx.scene.control.Pagination.INDETERMINATE
import javafx.scene.control.PasswordField
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
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
import javafx.scene.control.Tooltip
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
import javafx.scene.layout.StackPane
import javafx.scene.layout.TilePane
import javafx.scene.layout.VBox
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint
import javafx.scene.shape.Arc
import javafx.scene.shape.Box
import javafx.scene.shape.Box.DEFAULT_SIZE
import javafx.scene.shape.Circle
import javafx.scene.shape.CubicCurve
import javafx.scene.shape.Cylinder
import javafx.scene.shape.Ellipse
import javafx.scene.shape.Line
import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView
import javafx.scene.shape.Path
import javafx.scene.shape.PathElement
import javafx.scene.shape.Polygon
import javafx.scene.shape.Polyline
import javafx.scene.shape.QuadCurve
import javafx.scene.shape.Rectangle
import javafx.scene.shape.SVGPath
import javafx.scene.shape.Sphere
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import javafx.scene.web.WebView
import kotfx.annotations.SceneDsl
import kotfx.collections.mutableObservableListOf
import java.time.LocalDate

//<editor-fold desc="Layouts">

inline fun anchorPane(init: (@SceneDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init)
inline fun ChildManager.anchorPane(init: (@SceneDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()
inline fun ItemManager.anchorPane(init: (@SceneDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()

inline fun borderPane(init: (@SceneDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init)
inline fun ChildManager.borderPane(init: (@SceneDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()
inline fun ItemManager.borderPane(init: (@SceneDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()

inline fun flowPane(init: (@SceneDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init)
inline fun ChildManager.flowPane(init: (@SceneDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()
inline fun ItemManager.flowPane(init: (@SceneDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()

inline fun gridPane(init: (@SceneDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init)
inline fun ChildManager.gridPane(init: (@SceneDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()
inline fun ItemManager.gridPane(init: (@SceneDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()

inline fun hbox(init: (@SceneDsl _HBox).() -> Unit): HBox = _HBox().apply(init)
inline fun ChildManager.hbox(init: (@SceneDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()
inline fun ItemManager.hbox(init: (@SceneDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()

inline fun stackPane(init: (@SceneDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init)
inline fun ChildManager.stackPane(init: (@SceneDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()
inline fun ItemManager.stackPane(init: (@SceneDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()

inline fun textFlow(init: (@SceneDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init)
inline fun ChildManager.textFlow(init: (@SceneDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()
inline fun ItemManager.textFlow(init: (@SceneDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()

inline fun tilePane(init: (@SceneDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init)
inline fun ChildManager.tilePane(init: (@SceneDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init).add()
inline fun ItemManager.tilePane(init: (@SceneDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init).add()

inline fun vbox(init: (@SceneDsl _VBox).() -> Unit): VBox = _VBox().apply(init)
inline fun ChildManager.vbox(init: (@SceneDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()
inline fun ItemManager.vbox(init: (@SceneDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()
//</editor-fold>

//<editor-fold desc="Controls">

inline fun accordion(vararg titledPanes: TitledPane, noinline init: ((@SceneDsl Accordion).() -> Unit)? = null): Accordion = Accordion(*titledPanes).apply { init?.invoke(this) }
inline fun ChildManager.accordion(vararg titledPanes: TitledPane, noinline init: ((@SceneDsl Accordion).() -> Unit)? = null): Accordion = Accordion(*titledPanes).apply { init?.invoke(this) }.add()
inline fun ItemManager.accordion(vararg titledPanes: TitledPane, noinline init: ((@SceneDsl Accordion).() -> Unit)? = null): Accordion = Accordion(*titledPanes).apply { init?.invoke(this) }.add()

inline fun buttonBar(buttonOrder: String? = null, noinline init: ((@SceneDsl ButtonBar).() -> Unit)? = null): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }
inline fun ChildManager.buttonBar(buttonOrder: String? = null, noinline init: ((@SceneDsl ButtonBar).() -> Unit)? = null): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }.add()
inline fun ItemManager.buttonBar(buttonOrder: String? = null, noinline init: ((@SceneDsl ButtonBar).() -> Unit)? = null): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }.add()

inline fun button(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Button).() -> Unit)? = null): Button = Button(text, graphic).apply { init?.invoke(this) }
inline fun ChildManager.button(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Button).() -> Unit)? = null): Button = Button(text, graphic).apply { init?.invoke(this) }.add()
inline fun ItemManager.button(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Button).() -> Unit)? = null): Button = Button(text, graphic).apply { init?.invoke(this) }.add()

inline fun checkBox(text: String? = null, noinline init: ((@SceneDsl CheckBox).() -> Unit)? = null): CheckBox = CheckBox(text).apply { init?.invoke(this) }
inline fun ChildManager.checkBox(text: String? = null, noinline init: ((@SceneDsl CheckBox).() -> Unit)? = null): CheckBox = CheckBox(text).apply { init?.invoke(this) }.add()
inline fun ItemManager.checkBox(text: String? = null, noinline init: ((@SceneDsl CheckBox).() -> Unit)? = null): CheckBox = CheckBox(text).apply { init?.invoke(this) }.add()

inline fun <T> choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }
inline fun <T> ChildManager.choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }.add()
inline fun <T> ItemManager.choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }.add()

inline fun colorPicker(color: Color = WHITE, noinline init: ((@SceneDsl ColorPicker).() -> Unit)? = null): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }
inline fun ChildManager.colorPicker(color: Color = WHITE, noinline init: ((@SceneDsl ColorPicker).() -> Unit)? = null): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }.add()
inline fun ItemManager.colorPicker(color: Color = WHITE, noinline init: ((@SceneDsl ColorPicker).() -> Unit)? = null): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }.add()

inline fun <T> comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }
inline fun <T> ChildManager.comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }.add()
inline fun <T> ItemManager.comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }.add()

inline fun datePicker(date: LocalDate? = null, noinline init: ((@SceneDsl DatePicker).() -> Unit)? = null): DatePicker = DatePicker(date).apply { init?.invoke(this) }
inline fun ChildManager.datePicker(date: LocalDate? = null, noinline init: ((@SceneDsl DatePicker).() -> Unit)? = null): DatePicker = DatePicker(date).apply { init?.invoke(this) }.add()
inline fun ItemManager.datePicker(date: LocalDate? = null, noinline init: ((@SceneDsl DatePicker).() -> Unit)? = null): DatePicker = DatePicker(date).apply { init?.invoke(this) }.add()

inline fun hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Hyperlink).() -> Unit)? = null): Hyperlink = Hyperlink(text, graphic).apply { init?.invoke(this) }
inline fun ChildManager.hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Hyperlink).() -> Unit)? = null): Hyperlink = Hyperlink(text, graphic).apply { init?.invoke(this) }.add()
inline fun ItemManager.hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Hyperlink).() -> Unit)? = null): Hyperlink = Hyperlink(text, graphic).apply { init?.invoke(this) }.add()

inline fun label(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Label).() -> Unit)? = null): Label = Label(text, graphic).apply { init?.invoke(this) }
inline fun ChildManager.label(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Label).() -> Unit)? = null): Label = Label(text, graphic).apply { init?.invoke(this) }.add()
inline fun ItemManager.label(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Label).() -> Unit)? = null): Label = Label(text, graphic).apply { init?.invoke(this) }.add()

inline fun <T> listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ListView<T>).() -> Unit)? = null): ListView<T> = ListView(items).apply { init?.invoke(this) }
inline fun <T> ChildManager.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ListView<T>).() -> Unit)? = null): ListView<T> = ListView(items).apply { init?.invoke(this) }.add()
inline fun <T> ItemManager.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ListView<T>).() -> Unit)? = null): ListView<T> = ListView(items).apply { init?.invoke(this) }.add()

inline fun menuBar(vararg menus: Menu, noinline init: ((@SceneDsl _MenuBar).() -> Unit)? = null): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }
inline fun ChildManager.menuBar(vararg menus: Menu, noinline init: ((@SceneDsl _MenuBar).() -> Unit)? = null): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }.add()
inline fun ItemManager.menuBar(vararg menus: Menu, noinline init: ((@SceneDsl _MenuBar).() -> Unit)? = null): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }.add()

inline fun menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl MenuButton).() -> Unit)? = null): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }
inline fun ChildManager.menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl MenuButton).() -> Unit)? = null): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }.add()
inline fun ItemManager.menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl MenuButton).() -> Unit)? = null): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }.add()

inline fun menu(text: String = "", graphic: Node? = null, vararg items: MenuItem, noinline init: ((@SceneDsl _Menu).() -> Unit)? = null): Menu = _Menu(text, graphic, *items).apply { init?.invoke(this) }
inline fun PopupManager.menu(text: String = "", graphic: Node? = null, vararg items: MenuItem, noinline init: ((@SceneDsl _Menu).() -> Unit)? = null): Menu = _Menu(text, graphic, *items).apply { init?.invoke(this) }.add()
inline fun MenuManager.menu(text: String = "", graphic: Node? = null, vararg items: MenuItem, noinline init: ((@SceneDsl _Menu).() -> Unit)? = null): Menu = _Menu(text, graphic, *items).apply { init?.invoke(this) }.add()

inline fun pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@SceneDsl Pagination).() -> Unit)? = null): Pagination = Pagination(count, index).apply { init?.invoke(this) }
inline fun ChildManager.pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@SceneDsl Pagination).() -> Unit)? = null): Pagination = Pagination(count, index).apply { init?.invoke(this) }.add()
inline fun ItemManager.pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@SceneDsl Pagination).() -> Unit)? = null): Pagination = Pagination(count, index).apply { init?.invoke(this) }.add()

inline fun passwordField(noinline init: ((@SceneDsl PasswordField).() -> Unit)? = null): PasswordField = PasswordField().apply { init?.invoke(this) }
inline fun ChildManager.passwordField(noinline init: ((@SceneDsl PasswordField).() -> Unit)? = null): PasswordField = PasswordField().apply { init?.invoke(this) }.add()
inline fun ItemManager.passwordField(noinline init: ((@SceneDsl PasswordField).() -> Unit)? = null): PasswordField = PasswordField().apply { init?.invoke(this) }.add()

inline fun progressBar(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@SceneDsl ProgressBar).() -> Unit)? = null): ProgressBar = ProgressBar(progress).apply { init?.invoke(this) }
inline fun ChildManager.progressBar(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@SceneDsl ProgressBar).() -> Unit)? = null): ProgressBar = ProgressBar(progress).apply { init?.invoke(this) }.add()
inline fun ItemManager.progressBar(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@SceneDsl ProgressBar).() -> Unit)? = null): ProgressBar = ProgressBar(progress).apply { init?.invoke(this) }.add()

inline fun progressIndicator(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@SceneDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ProgressIndicator(progress).apply { init?.invoke(this) }
inline fun ChildManager.progressIndicator(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@SceneDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ProgressIndicator(progress).apply { init?.invoke(this) }.add()
inline fun ItemManager.progressIndicator(progress: Double = INDETERMINATE_PROGRESS, noinline init: ((@SceneDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ProgressIndicator(progress).apply { init?.invoke(this) }.add()

inline fun radioButton(text: String? = null, noinline init: ((@SceneDsl RadioButton).() -> Unit)? = null): RadioButton = RadioButton(text).apply { init?.invoke(this) }
inline fun ChildManager.radioButton(text: String? = null, noinline init: ((@SceneDsl RadioButton).() -> Unit)? = null): RadioButton = RadioButton(text).apply { init?.invoke(this) }.add()
inline fun ItemManager.radioButton(text: String? = null, noinline init: ((@SceneDsl RadioButton).() -> Unit)? = null): RadioButton = RadioButton(text).apply { init?.invoke(this) }.add()

inline fun scrollBar(noinline init: ((@SceneDsl ScrollBar).() -> Unit)? = null): ScrollBar = ScrollBar().apply { init?.invoke(this) }
inline fun ChildManager.scrollBar(noinline init: ((@SceneDsl ScrollBar).() -> Unit)? = null): ScrollBar = ScrollBar().apply { init?.invoke(this) }.add()
inline fun ItemManager.scrollBar(noinline init: ((@SceneDsl ScrollBar).() -> Unit)? = null): ScrollBar = ScrollBar().apply { init?.invoke(this) }.add()

inline fun scrollPane(content: Node? = null, noinline init: ((@SceneDsl ScrollPane).() -> Unit)? = null): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }
inline fun ChildManager.scrollPane(content: Node? = null, noinline init: ((@SceneDsl ScrollPane).() -> Unit)? = null): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }.add()
inline fun ItemManager.scrollPane(content: Node? = null, noinline init: ((@SceneDsl ScrollPane).() -> Unit)? = null): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }.add()

inline fun separator(orientation: Orientation = HORIZONTAL, noinline init: ((@SceneDsl Separator).() -> Unit)? = null): Separator = Separator(orientation).apply { init?.invoke(this) }
inline fun ChildManager.separator(orientation: Orientation = HORIZONTAL, noinline init: ((@SceneDsl Separator).() -> Unit)? = null): Separator = Separator(orientation).apply { init?.invoke(this) }.add()
inline fun ItemManager.separator(orientation: Orientation = HORIZONTAL, noinline init: ((@SceneDsl Separator).() -> Unit)? = null): Separator = Separator(orientation).apply { init?.invoke(this) }.add()

inline fun slider(min: Double, max: Double, value: Double, noinline init: ((@SceneDsl Slider).() -> Unit)? = null): Slider = Slider(min, max, value).apply { init?.invoke(this) }
inline fun ChildManager.slider(min: Double, max: Double, value: Double, noinline init: ((@SceneDsl Slider).() -> Unit)? = null): Slider = Slider(min, max, value).apply { init?.invoke(this) }.add()
inline fun ItemManager.slider(min: Double, max: Double, value: Double, noinline init: ((@SceneDsl Slider).() -> Unit)? = null): Slider = Slider(min, max, value).apply { init?.invoke(this) }.add()

inline fun <T> spinner(noinline init: ((@SceneDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }
inline fun <T> ChildManager.spinner(noinline init: ((@SceneDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }.add()
inline fun <T> ItemManager.spinner(noinline init: ((@SceneDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }.add()

inline fun splitMenuButton(vararg items: MenuItem, noinline init: ((@SceneDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }
inline fun ChildManager.splitMenuButton(vararg items: MenuItem, noinline init: ((@SceneDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }.add()
inline fun ItemManager.splitMenuButton(vararg items: MenuItem, noinline init: ((@SceneDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }.add()

inline fun splitPane(vararg items: Node, noinline init: ((@SceneDsl SplitPane).() -> Unit)? = null): SplitPane = SplitPane(*items).apply { init?.invoke(this) }
inline fun ChildManager.splitPane(vararg items: Node, noinline init: ((@SceneDsl SplitPane).() -> Unit)? = null): SplitPane = SplitPane(*items).apply { init?.invoke(this) }.add()
inline fun ItemManager.splitPane(vararg items: Node, noinline init: ((@SceneDsl SplitPane).() -> Unit)? = null): SplitPane = SplitPane(*items).apply { init?.invoke(this) }.add()

inline fun <S> tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@SceneDsl TableView<S>).() -> Unit)? = null): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }
inline fun <S> ChildManager.tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@SceneDsl TableView<S>).() -> Unit)? = null): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }.add()
inline fun <S> ItemManager.tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@SceneDsl TableView<S>).() -> Unit)? = null): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }.add()

inline fun tabPane(vararg tabs: Tab, noinline init: ((@SceneDsl TabPane).() -> Unit)? = null): TabPane = TabPane(*tabs).apply { init?.invoke(this) }
inline fun ChildManager.tabPane(vararg tabs: Tab, noinline init: ((@SceneDsl TabPane).() -> Unit)? = null): TabPane = TabPane(*tabs).apply { init?.invoke(this) }.add()
inline fun ItemManager.tabPane(vararg tabs: Tab, noinline init: ((@SceneDsl TabPane).() -> Unit)? = null): TabPane = TabPane(*tabs).apply { init?.invoke(this) }.add()

inline fun tab(text: String? = null, content: Node? = null, noinline init: ((@SceneDsl Tab).() -> Unit)? = null): Tab = Tab(text, content).apply { init?.invoke(this) }
inline fun ChildManager.tab(text: String? = null, content: Node? = null, noinline init: ((@SceneDsl Tab).() -> Unit)? = null): Tab = Tab(text, content).apply { init?.invoke(this) }
inline fun ItemManager.tab(text: String? = null, content: Node? = null, noinline init: ((@SceneDsl Tab).() -> Unit)? = null): Tab = Tab(text, content).apply { init?.invoke(this) }

inline fun textArea(text: String = "", noinline init: ((@SceneDsl TextArea).() -> Unit)? = null): TextArea = TextArea(text).apply { init?.invoke(this) }
inline fun ChildManager.textArea(text: String = "", noinline init: ((@SceneDsl TextArea).() -> Unit)? = null): TextArea = TextArea(text).apply { init?.invoke(this) }.add()
inline fun ItemManager.textArea(text: String = "", noinline init: ((@SceneDsl TextArea).() -> Unit)? = null): TextArea = TextArea(text).apply { init?.invoke(this) }.add()

inline fun textField(text: String = "", noinline init: ((@SceneDsl TextField).() -> Unit)? = null): TextField = TextField(text).apply { init?.invoke(this) }
inline fun ChildManager.textField(text: String = "", noinline init: ((@SceneDsl TextField).() -> Unit)? = null): TextField = TextField(text).apply { init?.invoke(this) }.add()
inline fun ItemManager.textField(text: String = "", noinline init: ((@SceneDsl TextField).() -> Unit)? = null): TextField = TextField(text).apply { init?.invoke(this) }.add()

inline fun titledPane(text: String? = null, content: Node? = null, noinline init: ((@SceneDsl TitledPane).() -> Unit)? = null): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }
inline fun ChildManager.titledPane(text: String? = null, content: Node? = null, noinline init: ((@SceneDsl TitledPane).() -> Unit)? = null): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }.add()
inline fun ItemManager.titledPane(text: String? = null, content: Node? = null, noinline init: ((@SceneDsl TitledPane).() -> Unit)? = null): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }.add()

inline fun toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl ToggleButton).() -> Unit)? = null): ToggleButton = ToggleButton(text, graphic).apply { init?.invoke(this) }
inline fun ChildManager.toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl ToggleButton).() -> Unit)? = null): ToggleButton = ToggleButton(text, graphic).apply { init?.invoke(this) }.add()
inline fun ItemManager.toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl ToggleButton).() -> Unit)? = null): ToggleButton = ToggleButton(text, graphic).apply { init?.invoke(this) }.add()

inline fun toolBar(vararg items: Node, noinline init: ((@SceneDsl _ToolBar).() -> Unit)? = null): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }
inline fun ChildManager.toolBar(vararg items: Node, noinline init: ((@SceneDsl _ToolBar).() -> Unit)? = null): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }.add()
inline fun ItemManager.toolBar(vararg items: Node, noinline init: ((@SceneDsl _ToolBar).() -> Unit)? = null): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }.add()

inline fun <S> treeTableView(root: TreeItem<S>? = null, noinline init: ((@SceneDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }
inline fun <S> ChildManager.treeTableView(root: TreeItem<S>? = null, noinline init: ((@SceneDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }.add()
inline fun <S> ItemManager.treeTableView(root: TreeItem<S>? = null, noinline init: ((@SceneDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }.add()

inline fun <T> treeView(root: TreeItem<T>? = null, noinline init: ((@SceneDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }
inline fun <T> ChildManager.treeView(root: TreeItem<T>? = null, noinline init: ((@SceneDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }.add()
inline fun <T> ItemManager.treeView(root: TreeItem<T>? = null, noinline init: ((@SceneDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }.add()
//</editor-fold>

//<editor-fold desc="Other controls from scene package">

inline fun canvas(width: Double = 0.0, height: Double = 0.0, noinline init: ((@SceneDsl Canvas).() -> Unit)? = null): Canvas = Canvas(width, height).apply { init?.invoke(this) }
inline fun ChildManager.canvas(width: Double = 0.0, height: Double = 0.0, noinline init: ((@SceneDsl Canvas).() -> Unit)? = null): Canvas = Canvas(width, height).apply { init?.invoke(this) }.add()
inline fun ItemManager.canvas(width: Double = 0.0, height: Double = 0.0, noinline init: ((@SceneDsl Canvas).() -> Unit)? = null): Canvas = Canvas(width, height).apply { init?.invoke(this) }.add()

inline fun imageView(image: Image? = null, noinline init: ((@SceneDsl ImageView).() -> Unit)? = null): ImageView = ImageView(image).apply { init?.invoke(this) }
inline fun ChildManager.imageView(image: Image? = null, noinline init: ((@SceneDsl ImageView).() -> Unit)? = null): ImageView = ImageView(image).apply { init?.invoke(this) }.add()
inline fun ItemManager.imageView(image: Image? = null, noinline init: ((@SceneDsl ImageView).() -> Unit)? = null): ImageView = ImageView(image).apply { init?.invoke(this) }.add()

inline fun mediaView(player: MediaPlayer? = null, noinline init: ((@SceneDsl MediaView).() -> Unit)? = null): MediaView = MediaView(player).apply { init?.invoke(this) }
inline fun ChildManager.mediaView(player: MediaPlayer? = null, noinline init: ((@SceneDsl MediaView).() -> Unit)? = null): MediaView = MediaView(player).apply { init?.invoke(this) }.add()
inline fun ItemManager.mediaView(player: MediaPlayer? = null, noinline init: ((@SceneDsl MediaView).() -> Unit)? = null): MediaView = MediaView(player).apply { init?.invoke(this) }.add()

inline fun text(text: String? = null, noinline init: ((@SceneDsl Text).() -> Unit)? = null): Text = Text(text).apply { init?.invoke(this) }
inline fun ChildManager.text(text: String? = null, noinline init: ((@SceneDsl Text).() -> Unit)? = null): Text = Text(text).apply { init?.invoke(this) }.add()
inline fun ItemManager.text(text: String? = null, noinline init: ((@SceneDsl Text).() -> Unit)? = null): Text = Text(text).apply { init?.invoke(this) }.add()

inline fun webView(noinline init: ((@SceneDsl WebView).() -> Unit)? = null): WebView = WebView().apply { init?.invoke(this) }
inline fun ChildManager.webView(noinline init: ((@SceneDsl WebView).() -> Unit)? = null): WebView = WebView().apply { init?.invoke(this) }.add()
inline fun ItemManager.webView(noinline init: ((@SceneDsl WebView).() -> Unit)? = null): WebView = WebView().apply { init?.invoke(this) }.add()
//</editor-fold>

//<editor-fold desc="Charts">

inline fun <X, Y> areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = AreaChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = AreaChart(x, y, data).apply { init?.invoke(this) }.add()
inline fun <X, Y> ItemManager.areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = AreaChart(x, y, data).apply { init?.invoke(this) }.add()

inline fun <X, Y> barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), gap: Double = 10.0, noinline init: ((@SceneDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = BarChart(x, y, data, gap).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), gap: Double = 10.0, noinline init: ((@SceneDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = BarChart(x, y, data, gap).apply { init?.invoke(this) }.add()
inline fun <X, Y> ItemManager.barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), gap: Double = 10.0, noinline init: ((@SceneDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = BarChart(x, y, data, gap).apply { init?.invoke(this) }.add()

inline fun <X, Y> bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = BubbleChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = BubbleChart(x, y, data).apply { init?.invoke(this) }.add()
inline fun <X, Y> ItemManager.bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = BubbleChart(x, y, data).apply { init?.invoke(this) }.add()

inline fun pieChart(data: ObservableList<Data> = mutableObservableListOf(), noinline init: ((@SceneDsl PieChart).() -> Unit)? = null): PieChart = PieChart(data).apply { init?.invoke(this) }
inline fun ChildManager.pieChart(data: ObservableList<Data> = mutableObservableListOf(), noinline init: ((@SceneDsl PieChart).() -> Unit)? = null): PieChart = PieChart(data).apply { init?.invoke(this) }.add()
inline fun ItemManager.pieChart(data: ObservableList<Data> = mutableObservableListOf(), noinline init: ((@SceneDsl PieChart).() -> Unit)? = null): PieChart = PieChart(data).apply { init?.invoke(this) }.add()

inline fun <X, Y> scatterChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl ScatterChart<X, Y>).() -> Unit)? = null): ScatterChart<X, Y> = ScatterChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.scatterChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl ScatterChart<X, Y>).() -> Unit)? = null): ScatterChart<X, Y> = ScatterChart(x, y, data).apply { init?.invoke(this) }.add()
inline fun <X, Y> ItemManager.scatterChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl ScatterChart<X, Y>).() -> Unit)? = null): ScatterChart<X, Y> = ScatterChart(x, y, data).apply { init?.invoke(this) }.add()

inline fun <X, Y> stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).apply { init?.invoke(this) }.add()
inline fun <X, Y> ItemManager.stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).apply { init?.invoke(this) }.add()

inline fun <X, Y> stackedBarChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl StackedBarChart<X, Y>).() -> Unit)? = null): StackedBarChart<X, Y> = StackedBarChart(x, y, data).apply { init?.invoke(this) }
inline fun <X, Y> ChildManager.stackedBarChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl StackedBarChart<X, Y>).() -> Unit)? = null): StackedBarChart<X, Y> = StackedBarChart(x, y, data).apply { init?.invoke(this) }.add()
inline fun <X, Y> ItemManager.stackedBarChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl StackedBarChart<X, Y>).() -> Unit)? = null): StackedBarChart<X, Y> = StackedBarChart(x, y, data).apply { init?.invoke(this) }.add()
//</editor-fold>

//<editor-fold desc="Shapes">

inline fun arc(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, startAngle: Double = 0.0, length: Double = 0.0, noinline init: ((@SceneDsl Arc).() -> Unit)? = null): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).apply { init?.invoke(this) }
inline fun ChildManager.arc(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, startAngle: Double = 0.0, length: Double = 0.0, noinline init: ((@SceneDsl Arc).() -> Unit)? = null): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).apply { init?.invoke(this) }.add()
inline fun ItemManager.arc(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, startAngle: Double = 0.0, length: Double = 0.0, noinline init: ((@SceneDsl Arc).() -> Unit)? = null): Arc = Arc(centerX, centerY, radiusX, radiusY, startAngle, length).apply { init?.invoke(this) }.add()

inline fun box(width: Double = DEFAULT_SIZE, height: Double = DEFAULT_SIZE, depth: Double = DEFAULT_SIZE, noinline init: ((@SceneDsl Box).() -> Unit)? = null): Box = Box(width, height, depth).apply { init?.invoke(this) }
inline fun ChildManager.box(width: Double = DEFAULT_SIZE, height: Double = DEFAULT_SIZE, depth: Double = DEFAULT_SIZE, noinline init: ((@SceneDsl Box).() -> Unit)? = null): Box = Box(width, height, depth).apply { init?.invoke(this) }.add()
inline fun ItemManager.box(width: Double = DEFAULT_SIZE, height: Double = DEFAULT_SIZE, depth: Double = DEFAULT_SIZE, noinline init: ((@SceneDsl Box).() -> Unit)? = null): Box = Box(width, height, depth).apply { init?.invoke(this) }.add()

inline fun circle(centerX: Double = 0.0, centerY: Double = 0.0, radius: Double = 0.0, fill: Paint? = null, noinline init: ((@SceneDsl Circle).() -> Unit)? = null): Circle = Circle(centerX, centerY, radius, fill).apply { init?.invoke(this) }
inline fun ChildManager.circle(centerX: Double = 0.0, centerY: Double = 0.0, radius: Double = 0.0, fill: Paint? = null, noinline init: ((@SceneDsl Circle).() -> Unit)? = null): Circle = Circle(centerX, centerY, radius, fill).apply { init?.invoke(this) }.add()
inline fun ItemManager.circle(centerX: Double = 0.0, centerY: Double = 0.0, radius: Double = 0.0, fill: Paint? = null, noinline init: ((@SceneDsl Circle).() -> Unit)? = null): Circle = Circle(centerX, centerY, radius, fill).apply { init?.invoke(this) }.add()

inline fun cubicCurve(startX: Double = 0.0, startY: Double = 0.0, controlX1: Double = 0.0, controlY1: Double = 0.0, controlX2: Double = 0.0, controlY2: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl CubicCurve).() -> Unit)? = null): CubicCurve = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY).apply { init?.invoke(this) }
inline fun ChildManager.cubicCurve(startX: Double = 0.0, startY: Double = 0.0, controlX1: Double = 0.0, controlY1: Double = 0.0, controlX2: Double = 0.0, controlY2: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl CubicCurve).() -> Unit)? = null): CubicCurve = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY).apply { init?.invoke(this) }.add()
inline fun ItemManager.cubicCurve(startX: Double = 0.0, startY: Double = 0.0, controlX1: Double = 0.0, controlY1: Double = 0.0, controlX2: Double = 0.0, controlY2: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl CubicCurve).() -> Unit)? = null): CubicCurve = CubicCurve(startX, startY, controlX1, controlY1, controlX2, controlY2, endX, endY).apply { init?.invoke(this) }.add()

inline fun cylinder(radius: Double = 1.0, height: Double = 2.0, division: Int = 64, noinline init: ((@SceneDsl Cylinder).() -> Unit)? = null): Cylinder = Cylinder(radius, height, division).apply { init?.invoke(this) }
inline fun ChildManager.cylinder(radius: Double = 1.0, height: Double = 2.0, division: Int = 64, noinline init: ((@SceneDsl Cylinder).() -> Unit)? = null): Cylinder = Cylinder(radius, height, division).apply { init?.invoke(this) }.add()
inline fun ItemManager.cylinder(radius: Double = 1.0, height: Double = 2.0, division: Int = 64, noinline init: ((@SceneDsl Cylinder).() -> Unit)? = null): Cylinder = Cylinder(radius, height, division).apply { init?.invoke(this) }.add()

inline fun ellipse(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, noinline init: ((@SceneDsl Ellipse).() -> Unit)? = null): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).apply { init?.invoke(this) }
inline fun ChildManager.ellipse(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, noinline init: ((@SceneDsl Ellipse).() -> Unit)? = null): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).apply { init?.invoke(this) }.add()
inline fun ItemManager.ellipse(centerX: Double = 0.0, centerY: Double = 0.0, radiusX: Double = 0.0, radiusY: Double = 0.0, noinline init: ((@SceneDsl Ellipse).() -> Unit)? = null): Ellipse = Ellipse(centerX, centerY, radiusX, radiusY).apply { init?.invoke(this) }.add()

inline fun line(centerX: Double = 0.0, centerY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl Line).() -> Unit)? = null): Line = Line(centerX, centerY, endX, endY).apply { init?.invoke(this) }
inline fun ChildManager.line(centerX: Double = 0.0, centerY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl Line).() -> Unit)? = null): Line = Line(centerX, centerY, endX, endY).apply { init?.invoke(this) }.add()
inline fun ItemManager.line(centerX: Double = 0.0, centerY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl Line).() -> Unit)? = null): Line = Line(centerX, centerY, endX, endY).apply { init?.invoke(this) }.add()

inline fun meshView(mesh: Mesh? = null, noinline init: ((@SceneDsl MeshView).() -> Unit)? = null): MeshView = MeshView(mesh).apply { init?.invoke(this) }
inline fun ChildManager.meshView(mesh: Mesh? = null, noinline init: ((@SceneDsl MeshView).() -> Unit)? = null): MeshView = MeshView(mesh).apply { init?.invoke(this) }.add()
inline fun ItemManager.meshView(mesh: Mesh? = null, noinline init: ((@SceneDsl MeshView).() -> Unit)? = null): MeshView = MeshView(mesh).apply { init?.invoke(this) }.add()

inline fun path(vararg elements: PathElement, noinline init: ((@SceneDsl Path).() -> Unit)? = null): Path = Path(*elements).apply { init?.invoke(this) }
inline fun ChildManager.path(vararg elements: PathElement, noinline init: ((@SceneDsl Path).() -> Unit)? = null): Path = Path(*elements).apply { init?.invoke(this) }.add()
inline fun ItemManager.path(vararg elements: PathElement, noinline init: ((@SceneDsl Path).() -> Unit)? = null): Path = Path(*elements).apply { init?.invoke(this) }.add()

inline fun polygon(vararg points: Double, noinline init: ((@SceneDsl Polygon).() -> Unit)? = null): Polygon = Polygon(*points).apply { init?.invoke(this) }
inline fun ChildManager.polygon(vararg points: Double, noinline init: ((@SceneDsl Polygon).() -> Unit)? = null): Polygon = Polygon(*points).apply { init?.invoke(this) }.add()
inline fun ItemManager.polygon(vararg points: Double, noinline init: ((@SceneDsl Polygon).() -> Unit)? = null): Polygon = Polygon(*points).apply { init?.invoke(this) }.add()

inline fun polyline(vararg points: Double, noinline init: ((@SceneDsl Polyline).() -> Unit)? = null): Polyline = Polyline(*points).apply { init?.invoke(this) }
inline fun ChildManager.polyline(vararg points: Double, noinline init: ((@SceneDsl Polyline).() -> Unit)? = null): Polyline = Polyline(*points).apply { init?.invoke(this) }.add()
inline fun ItemManager.polyline(vararg points: Double, noinline init: ((@SceneDsl Polyline).() -> Unit)? = null): Polyline = Polyline(*points).apply { init?.invoke(this) }.add()

inline fun quadCurve(startX: Double = 0.0, startY: Double = 0.0, controlX: Double = 0.0, controlY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl QuadCurve).() -> Unit)? = null): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).apply { init?.invoke(this) }
inline fun ChildManager.quadCurve(startX: Double = 0.0, startY: Double = 0.0, controlX: Double = 0.0, controlY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl QuadCurve).() -> Unit)? = null): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).apply { init?.invoke(this) }.add()
inline fun ItemManager.quadCurve(startX: Double = 0.0, startY: Double = 0.0, controlX: Double = 0.0, controlY: Double = 0.0, endX: Double = 0.0, endY: Double = 0.0, noinline init: ((@SceneDsl QuadCurve).() -> Unit)? = null): QuadCurve = QuadCurve(startX, startY, controlX, controlY, endX, endY).apply { init?.invoke(this) }.add()

inline fun rectangle(x: Double = 0.0, y: Double = 0.0, width: Double = 0.0, height: Double = 0.0, noinline init: ((@SceneDsl Rectangle).() -> Unit)? = null): Rectangle = Rectangle(x, y, width, height).apply { init?.invoke(this) }
inline fun ChildManager.rectangle(x: Double = 0.0, y: Double = 0.0, width: Double = 0.0, height: Double = 0.0, noinline init: ((@SceneDsl Rectangle).() -> Unit)? = null): Rectangle = Rectangle(x, y, width, height).apply { init?.invoke(this) }.add()
inline fun ItemManager.rectangle(x: Double = 0.0, y: Double = 0.0, width: Double = 0.0, height: Double = 0.0, noinline init: ((@SceneDsl Rectangle).() -> Unit)? = null): Rectangle = Rectangle(x, y, width, height).apply { init?.invoke(this) }.add()

inline fun sphere(radius: Double = 1.0, division: Int = 64, noinline init: ((@SceneDsl Sphere).() -> Unit)? = null): Sphere = Sphere(radius, division).apply { init?.invoke(this) }
inline fun ChildManager.sphere(radius: Double = 1.0, division: Int = 64, noinline init: ((@SceneDsl Sphere).() -> Unit)? = null): Sphere = Sphere(radius, division).apply { init?.invoke(this) }.add()
inline fun ItemManager.sphere(radius: Double = 1.0, division: Int = 64, noinline init: ((@SceneDsl Sphere).() -> Unit)? = null): Sphere = Sphere(radius, division).apply { init?.invoke(this) }.add()

inline fun svgPath(noinline init: ((@SceneDsl SVGPath).() -> Unit)? = null): SVGPath = SVGPath().apply { init?.invoke(this) }
inline fun ChildManager.svgPath(noinline init: ((@SceneDsl SVGPath).() -> Unit)? = null): SVGPath = SVGPath().apply { init?.invoke(this) }.add()
inline fun ItemManager.svgPath(noinline init: ((@SceneDsl SVGPath).() -> Unit)? = null): SVGPath = SVGPath().apply { init?.invoke(this) }.add()
//</editor-fold>

//<editor-fold desc="Popups">

inline fun contextMenu(vararg items: MenuItem, noinline init: ((@SceneDsl _ContextMenu).() -> Unit)? = null): ContextMenu = _ContextMenu(*items).apply { init?.invoke(this) }

inline fun checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }
inline fun PopupManager.checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }.add()

inline fun customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@SceneDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }
inline fun PopupManager.customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@SceneDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }.add()

inline fun menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl MenuItem).() -> Unit)? = null): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }
inline fun PopupManager.menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl MenuItem).() -> Unit)? = null): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }.add()

inline fun radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }
inline fun PopupManager.radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }.add()

inline fun separatorMenuItem(noinline init: ((@SceneDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }
inline fun PopupManager.separatorMenuItem(noinline init: ((@SceneDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }.add()

inline fun tooltip(text: String? = null, noinline init: ((@SceneDsl Tooltip).() -> Unit)? = null): Tooltip = Tooltip(text).apply { init?.invoke(this) }
//</editor-fold>