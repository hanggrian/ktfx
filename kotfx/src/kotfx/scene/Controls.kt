@file:Suppress("NOTHING_TO_INLINE")

package kotfx.scene

import javafx.collections.ObservableList
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.Node
import javafx.scene.canvas.Canvas
import javafx.scene.chart.*
import javafx.scene.chart.PieChart.Data
import javafx.scene.chart.XYChart.Series
import javafx.scene.control.*
import javafx.scene.control.Pagination.INDETERMINATE
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE
import javafx.scene.paint.Paint
import javafx.scene.shape.*
import javafx.scene.shape.Box.DEFAULT_SIZE
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import javafx.scene.web.WebView
import kotfx.collections.mutableObservableListOf
import kotfx.annotations.SceneDsl
import java.time.LocalDate

//region Layouts

inline fun anchorPane(init: (@SceneDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init)
inline fun ChildRoot.anchorPane(init: (@SceneDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()
inline fun ItemRoot.anchorPane(init: (@SceneDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()

inline fun borderPane(init: (@SceneDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init)
inline fun ChildRoot.borderPane(init: (@SceneDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()
inline fun ItemRoot.borderPane(init: (@SceneDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()

inline fun flowPane(init: (@SceneDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init)
inline fun ChildRoot.flowPane(init: (@SceneDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()
inline fun ItemRoot.flowPane(init: (@SceneDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()

inline fun gridPane(init: (@SceneDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init)
inline fun ChildRoot.gridPane(init: (@SceneDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()
inline fun ItemRoot.gridPane(init: (@SceneDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()

inline fun hbox(init: (@SceneDsl _HBox).() -> Unit): HBox = _HBox().apply(init)
inline fun ChildRoot.hbox(init: (@SceneDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()
inline fun ItemRoot.hbox(init: (@SceneDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()

inline fun stackPane(init: (@SceneDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init)
inline fun ChildRoot.stackPane(init: (@SceneDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()
inline fun ItemRoot.stackPane(init: (@SceneDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()

inline fun textFlow(init: (@SceneDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init)
inline fun ChildRoot.textFlow(init: (@SceneDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()
inline fun ItemRoot.textFlow(init: (@SceneDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()

inline fun tilePane(init: (@SceneDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init)
inline fun ChildRoot.tilePane(init: (@SceneDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init).add()
inline fun ItemRoot.tilePane(init: (@SceneDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init).add()

inline fun vbox(init: (@SceneDsl _VBox).() -> Unit): VBox = _VBox().apply(init)
inline fun ChildRoot.vbox(init: (@SceneDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()
inline fun ItemRoot.vbox(init: (@SceneDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()
//endregion

//region Controls

@JvmOverloads inline fun accordion(vararg titledPanes: TitledPane, noinline init: ((@SceneDsl Accordion).() -> Unit)? = null): Accordion = Accordion(*titledPanes).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.accordion(vararg titledPanes: TitledPane, noinline init: ((@SceneDsl Accordion).() -> Unit)? = null): Accordion = Accordion(*titledPanes).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.accordion(vararg titledPanes: TitledPane, noinline init: ((@SceneDsl Accordion).() -> Unit)? = null): Accordion = Accordion(*titledPanes).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun buttonBar(buttonOrder: String? = null, noinline init: ((@SceneDsl ButtonBar).() -> Unit)? = null): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.buttonBar(buttonOrder: String? = null, noinline init: ((@SceneDsl ButtonBar).() -> Unit)? = null): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.buttonBar(buttonOrder: String? = null, noinline init: ((@SceneDsl ButtonBar).() -> Unit)? = null): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun button(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Button).() -> Unit)? = null): Button = Button(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.button(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Button).() -> Unit)? = null): Button = Button(text, graphic).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.button(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Button).() -> Unit)? = null): Button = Button(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun checkBox(text: String? = null, noinline init: ((@SceneDsl CheckBox).() -> Unit)? = null): CheckBox = CheckBox(text).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.checkBox(text: String? = null, noinline init: ((@SceneDsl CheckBox).() -> Unit)? = null): CheckBox = CheckBox(text).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.checkBox(text: String? = null, noinline init: ((@SceneDsl CheckBox).() -> Unit)? = null): CheckBox = CheckBox(text).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <T> choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }
@JvmOverloads inline fun <T> ChildRoot.choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <T> ItemRoot.choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun colorPicker(color: Color = WHITE, noinline init: ((@SceneDsl ColorPicker).() -> Unit)? = null): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.colorPicker(color: Color = WHITE, noinline init: ((@SceneDsl ColorPicker).() -> Unit)? = null): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.colorPicker(color: Color = WHITE, noinline init: ((@SceneDsl ColorPicker).() -> Unit)? = null): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <T> comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }
@JvmOverloads inline fun <T> ChildRoot.comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <T> ItemRoot.comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun datePicker(date: LocalDate? = null, noinline init: ((@SceneDsl DatePicker).() -> Unit)? = null): DatePicker = DatePicker(date).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.datePicker(date: LocalDate? = null, noinline init: ((@SceneDsl DatePicker).() -> Unit)? = null): DatePicker = DatePicker(date).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.datePicker(date: LocalDate? = null, noinline init: ((@SceneDsl DatePicker).() -> Unit)? = null): DatePicker = DatePicker(date).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Hyperlink).() -> Unit)? = null): Hyperlink = Hyperlink(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Hyperlink).() -> Unit)? = null): Hyperlink = Hyperlink(text, graphic).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Hyperlink).() -> Unit)? = null): Hyperlink = Hyperlink(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun label(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Label).() -> Unit)? = null): Label = Label(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.label(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Label).() -> Unit)? = null): Label = Label(text, graphic).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.label(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Label).() -> Unit)? = null): Label = Label(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <T> listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ListView<T>).() -> Unit)? = null): ListView<T> = ListView(items).apply { init?.invoke(this) }
@JvmOverloads inline fun <T> ChildRoot.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ListView<T>).() -> Unit)? = null): ListView<T> = ListView(items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <T> ItemRoot.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@SceneDsl ListView<T>).() -> Unit)? = null): ListView<T> = ListView(items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun menuBar(vararg menus: Menu, noinline init: ((@SceneDsl _MenuBar).() -> Unit)? = null): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.menuBar(vararg menus: Menu, noinline init: ((@SceneDsl _MenuBar).() -> Unit)? = null): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.menuBar(vararg menus: Menu, noinline init: ((@SceneDsl _MenuBar).() -> Unit)? = null): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl MenuButton).() -> Unit)? = null): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl MenuButton).() -> Unit)? = null): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl MenuButton).() -> Unit)? = null): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun menu(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Menu).() -> Unit)? = null): Menu = Menu(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupRoot.menu(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Menu).() -> Unit)? = null): Menu = Menu(text, graphic).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun MenuRoot.menu(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl Menu).() -> Unit)? = null): Menu = Menu(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@SceneDsl Pagination).() -> Unit)? = null): Pagination = Pagination(count, index).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@SceneDsl Pagination).() -> Unit)? = null): Pagination = Pagination(count, index).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@SceneDsl Pagination).() -> Unit)? = null): Pagination = Pagination(count, index).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun passwordField(noinline init: ((@SceneDsl PasswordField).() -> Unit)? = null): PasswordField = PasswordField().apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.passwordField(noinline init: ((@SceneDsl PasswordField).() -> Unit)? = null): PasswordField = PasswordField().apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.passwordField(noinline init: ((@SceneDsl PasswordField).() -> Unit)? = null): PasswordField = PasswordField().apply { init?.invoke(this) }.add()

@JvmOverloads inline fun progressBar(progress: Number = INDETERMINATE_PROGRESS, noinline init: ((@SceneDsl ProgressBar).() -> Unit)? = null): ProgressBar = ProgressBar(progress.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.progressBar(progress: Number = INDETERMINATE_PROGRESS, noinline init: ((@SceneDsl ProgressBar).() -> Unit)? = null): ProgressBar = ProgressBar(progress.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.progressBar(progress: Number = INDETERMINATE_PROGRESS, noinline init: ((@SceneDsl ProgressBar).() -> Unit)? = null): ProgressBar = ProgressBar(progress.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun progressIndicator(progress: Number = INDETERMINATE_PROGRESS, noinline init: ((@SceneDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.progressIndicator(progress: Number = INDETERMINATE_PROGRESS, noinline init: ((@SceneDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.progressIndicator(progress: Number = INDETERMINATE_PROGRESS, noinline init: ((@SceneDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun radioButton(text: String? = null, noinline init: ((@SceneDsl RadioButton).() -> Unit)? = null): RadioButton = RadioButton(text).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.radioButton(text: String? = null, noinline init: ((@SceneDsl RadioButton).() -> Unit)? = null): RadioButton = RadioButton(text).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.radioButton(text: String? = null, noinline init: ((@SceneDsl RadioButton).() -> Unit)? = null): RadioButton = RadioButton(text).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun scrollBar(noinline init: ((@SceneDsl ScrollBar).() -> Unit)? = null): ScrollBar = ScrollBar().apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.scrollBar(noinline init: ((@SceneDsl ScrollBar).() -> Unit)? = null): ScrollBar = ScrollBar().apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.scrollBar(noinline init: ((@SceneDsl ScrollBar).() -> Unit)? = null): ScrollBar = ScrollBar().apply { init?.invoke(this) }.add()

@JvmOverloads inline fun scrollPane(content: Node? = null, noinline init: ((@SceneDsl ScrollPane).() -> Unit)? = null): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.scrollPane(content: Node? = null, noinline init: ((@SceneDsl ScrollPane).() -> Unit)? = null): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.scrollPane(content: Node? = null, noinline init: ((@SceneDsl ScrollPane).() -> Unit)? = null): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun separator(orientation: Orientation = HORIZONTAL, noinline init: ((@SceneDsl Separator).() -> Unit)? = null): Separator = Separator(orientation).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.separator(orientation: Orientation = HORIZONTAL, noinline init: ((@SceneDsl Separator).() -> Unit)? = null): Separator = Separator(orientation).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.separator(orientation: Orientation = HORIZONTAL, noinline init: ((@SceneDsl Separator).() -> Unit)? = null): Separator = Separator(orientation).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun slider(min: Number, max: Number, value: Number, noinline init: ((@SceneDsl Slider).() -> Unit)? = null): Slider = Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.slider(min: Number, max: Number, value: Number, noinline init: ((@SceneDsl Slider).() -> Unit)? = null): Slider = Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.slider(min: Number, max: Number, value: Number, noinline init: ((@SceneDsl Slider).() -> Unit)? = null): Slider = Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <T> spinner(noinline init: ((@SceneDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }
@JvmOverloads inline fun <T> ChildRoot.spinner(noinline init: ((@SceneDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <T> ItemRoot.spinner(noinline init: ((@SceneDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }.add()

@JvmOverloads inline fun splitMenuButton(vararg items: MenuItem, noinline init: ((@SceneDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.splitMenuButton(vararg items: MenuItem, noinline init: ((@SceneDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.splitMenuButton(vararg items: MenuItem, noinline init: ((@SceneDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun splitPane(vararg items: Node, noinline init: ((@SceneDsl SplitPane).() -> Unit)? = null): SplitPane = SplitPane(*items).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.splitPane(vararg items: Node, noinline init: ((@SceneDsl SplitPane).() -> Unit)? = null): SplitPane = SplitPane(*items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.splitPane(vararg items: Node, noinline init: ((@SceneDsl SplitPane).() -> Unit)? = null): SplitPane = SplitPane(*items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <S> tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@SceneDsl TableView<S>).() -> Unit)? = null): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }
@JvmOverloads inline fun <S> ChildRoot.tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@SceneDsl TableView<S>).() -> Unit)? = null): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <S> ItemRoot.tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@SceneDsl TableView<S>).() -> Unit)? = null): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun tabPane(vararg tabs: Tab, noinline init: ((@SceneDsl TabPane).() -> Unit)? = null): TabPane = TabPane(*tabs).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.tabPane(vararg tabs: Tab, noinline init: ((@SceneDsl TabPane).() -> Unit)? = null): TabPane = TabPane(*tabs).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.tabPane(vararg tabs: Tab, noinline init: ((@SceneDsl TabPane).() -> Unit)? = null): TabPane = TabPane(*tabs).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun tab(text: String? = null, content: Node? = null, noinline init: ((@SceneDsl Tab).() -> Unit)? = null): Tab = Tab(text, content).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.tab(text: String? = null, content: Node? = null, noinline init: ((@SceneDsl Tab).() -> Unit)? = null): Tab = Tab(text, content).apply { init?.invoke(this) }
@JvmOverloads inline fun ItemRoot.tab(text: String? = null, content: Node? = null, noinline init: ((@SceneDsl Tab).() -> Unit)? = null): Tab = Tab(text, content).apply { init?.invoke(this) }

@JvmOverloads inline fun textArea(text: String = "", noinline init: ((@SceneDsl TextArea).() -> Unit)? = null): TextArea = TextArea(text).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.textArea(text: String = "", noinline init: ((@SceneDsl TextArea).() -> Unit)? = null): TextArea = TextArea(text).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.textArea(text: String = "", noinline init: ((@SceneDsl TextArea).() -> Unit)? = null): TextArea = TextArea(text).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun textField(text: String = "", noinline init: ((@SceneDsl TextField).() -> Unit)? = null): TextField = TextField(text).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.textField(text: String = "", noinline init: ((@SceneDsl TextField).() -> Unit)? = null): TextField = TextField(text).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.textField(text: String = "", noinline init: ((@SceneDsl TextField).() -> Unit)? = null): TextField = TextField(text).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun titledPane(text: String? = null, content: Node? = null, noinline init: ((@SceneDsl TitledPane).() -> Unit)? = null): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.titledPane(text: String? = null, content: Node? = null, noinline init: ((@SceneDsl TitledPane).() -> Unit)? = null): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.titledPane(text: String? = null, content: Node? = null, noinline init: ((@SceneDsl TitledPane).() -> Unit)? = null): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl ToggleButton).() -> Unit)? = null): ToggleButton = ToggleButton(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl ToggleButton).() -> Unit)? = null): ToggleButton = ToggleButton(text, graphic).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl ToggleButton).() -> Unit)? = null): ToggleButton = ToggleButton(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun toolBar(vararg items: Node, noinline init: ((@SceneDsl _ToolBar).() -> Unit)? = null): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.toolBar(vararg items: Node, noinline init: ((@SceneDsl _ToolBar).() -> Unit)? = null): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.toolBar(vararg items: Node, noinline init: ((@SceneDsl _ToolBar).() -> Unit)? = null): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <S> treeTableView(root: TreeItem<S>? = null, noinline init: ((@SceneDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }
@JvmOverloads inline fun <S> ChildRoot.treeTableView(root: TreeItem<S>? = null, noinline init: ((@SceneDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <S> ItemRoot.treeTableView(root: TreeItem<S>? = null, noinline init: ((@SceneDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <T> treeView(root: TreeItem<T>? = null, noinline init: ((@SceneDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }
@JvmOverloads inline fun <T> ChildRoot.treeView(root: TreeItem<T>? = null, noinline init: ((@SceneDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <T> ItemRoot.treeView(root: TreeItem<T>? = null, noinline init: ((@SceneDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }.add()
//endregion

//region Other controls from scene package

@JvmOverloads inline fun canvas(width: Number = 0, height: Number = 0, noinline init: ((@SceneDsl Canvas).() -> Unit)? = null): Canvas = Canvas(width.toDouble(), height.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.canvas(width: Number = 0, height: Number = 0, noinline init: ((@SceneDsl Canvas).() -> Unit)? = null): Canvas = Canvas(width.toDouble(), height.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.canvas(width: Number = 0, height: Number = 0, noinline init: ((@SceneDsl Canvas).() -> Unit)? = null): Canvas = Canvas(width.toDouble(), height.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun imageView(image: Image? = null, noinline init: ((@SceneDsl ImageView).() -> Unit)? = null): ImageView = ImageView(image).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.imageView(image: Image? = null, noinline init: ((@SceneDsl ImageView).() -> Unit)? = null): ImageView = ImageView(image).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.imageView(image: Image? = null, noinline init: ((@SceneDsl ImageView).() -> Unit)? = null): ImageView = ImageView(image).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun mediaView(player: MediaPlayer? = null, noinline init: ((@SceneDsl MediaView).() -> Unit)? = null): MediaView = MediaView(player).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.mediaView(player: MediaPlayer? = null, noinline init: ((@SceneDsl MediaView).() -> Unit)? = null): MediaView = MediaView(player).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.mediaView(player: MediaPlayer? = null, noinline init: ((@SceneDsl MediaView).() -> Unit)? = null): MediaView = MediaView(player).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun text(text: String? = null, noinline init: ((@SceneDsl Text).() -> Unit)? = null): Text = Text(text).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.text(text: String? = null, noinline init: ((@SceneDsl Text).() -> Unit)? = null): Text = Text(text).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.text(text: String? = null, noinline init: ((@SceneDsl Text).() -> Unit)? = null): Text = Text(text).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun webView(noinline init: ((@SceneDsl WebView).() -> Unit)? = null): WebView = WebView().apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.webView(noinline init: ((@SceneDsl WebView).() -> Unit)? = null): WebView = WebView().apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.webView(noinline init: ((@SceneDsl WebView).() -> Unit)? = null): WebView = WebView().apply { init?.invoke(this) }.add()
//endregion

//region Charts

@JvmOverloads inline fun <X, Y> areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = AreaChart(x, y, data).apply { init?.invoke(this) }
@JvmOverloads inline fun <X, Y> ChildRoot.areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = AreaChart(x, y, data).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <X, Y> ItemRoot.areaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl AreaChart<X, Y>).() -> Unit)? = null): AreaChart<X, Y> = AreaChart(x, y, data).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <X, Y> barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), gap: Number = 10, noinline init: ((@SceneDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = BarChart(x, y, data, gap.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun <X, Y> ChildRoot.barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), gap: Number = 10, noinline init: ((@SceneDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = BarChart(x, y, data, gap.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <X, Y> ItemRoot.barChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), gap: Number = 10, noinline init: ((@SceneDsl BarChart<X, Y>).() -> Unit)? = null): BarChart<X, Y> = BarChart(x, y, data, gap.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <X, Y> bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = BubbleChart(x, y, data).apply { init?.invoke(this) }
@JvmOverloads inline fun <X, Y> ChildRoot.bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = BubbleChart(x, y, data).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <X, Y> ItemRoot.bubbleChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl BubbleChart<X, Y>).() -> Unit)? = null): BubbleChart<X, Y> = BubbleChart(x, y, data).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun pieChart(data: ObservableList<Data> = mutableObservableListOf(), noinline init: ((@SceneDsl PieChart).() -> Unit)? = null): PieChart = PieChart(data).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.pieChart(data: ObservableList<Data> = mutableObservableListOf(), noinline init: ((@SceneDsl PieChart).() -> Unit)? = null): PieChart = PieChart(data).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.pieChart(data: ObservableList<Data> = mutableObservableListOf(), noinline init: ((@SceneDsl PieChart).() -> Unit)? = null): PieChart = PieChart(data).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <X, Y> scatterChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl ScatterChart<X, Y>).() -> Unit)? = null): ScatterChart<X, Y> = ScatterChart(x, y, data).apply { init?.invoke(this) }
@JvmOverloads inline fun <X, Y> ChildRoot.scatterChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl ScatterChart<X, Y>).() -> Unit)? = null): ScatterChart<X, Y> = ScatterChart(x, y, data).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <X, Y> ItemRoot.scatterChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl ScatterChart<X, Y>).() -> Unit)? = null): ScatterChart<X, Y> = ScatterChart(x, y, data).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <X, Y> stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).apply { init?.invoke(this) }
@JvmOverloads inline fun <X, Y> ChildRoot.stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <X, Y> ItemRoot.stackedAreaChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl StackedAreaChart<X, Y>).() -> Unit)? = null): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <X, Y> stackedBarChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl StackedBarChart<X, Y>).() -> Unit)? = null): StackedBarChart<X, Y> = StackedBarChart(x, y, data).apply { init?.invoke(this) }
@JvmOverloads inline fun <X, Y> ChildRoot.stackedBarChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl StackedBarChart<X, Y>).() -> Unit)? = null): StackedBarChart<X, Y> = StackedBarChart(x, y, data).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <X, Y> ItemRoot.stackedBarChart(x: Axis<X>, y: Axis<Y>, data: ObservableList<Series<X, Y>> = mutableObservableListOf(), noinline init: ((@SceneDsl StackedBarChart<X, Y>).() -> Unit)? = null): StackedBarChart<X, Y> = StackedBarChart(x, y, data).apply { init?.invoke(this) }.add()
//endregion

//region Shapes

@JvmOverloads inline fun arc(centerX: Number = 0, centerY: Number = 0, radiusX: Number = 0, radiusY: Number = 0, startAngle: Number = 0, length: Number = 0, noinline init: ((@SceneDsl Arc).() -> Unit)? = null): Arc = Arc(centerX.toDouble(), centerY.toDouble(), radiusX.toDouble(), radiusY.toDouble(), startAngle.toDouble(), length.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.arc(centerX: Number = 0, centerY: Number = 0, radiusX: Number = 0, radiusY: Number = 0, startAngle: Number = 0, length: Number = 0, noinline init: ((@SceneDsl Arc).() -> Unit)? = null): Arc = Arc(centerX.toDouble(), centerY.toDouble(), radiusX.toDouble(), radiusY.toDouble(), startAngle.toDouble(), length.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.arc(centerX: Number = 0, centerY: Number = 0, radiusX: Number = 0, radiusY: Number = 0, startAngle: Number = 0, length: Number = 0, noinline init: ((@SceneDsl Arc).() -> Unit)? = null): Arc = Arc(centerX.toDouble(), centerY.toDouble(), radiusX.toDouble(), radiusY.toDouble(), startAngle.toDouble(), length.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun box(width: Number = DEFAULT_SIZE, height: Number = DEFAULT_SIZE, depth: Number = DEFAULT_SIZE, noinline init: ((@SceneDsl Box).() -> Unit)? = null): Box = Box(width.toDouble(), height.toDouble(), depth.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.box(width: Number = DEFAULT_SIZE, height: Number = DEFAULT_SIZE, depth: Number = DEFAULT_SIZE, noinline init: ((@SceneDsl Box).() -> Unit)? = null): Box = Box(width.toDouble(), height.toDouble(), depth.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun ItemRoot.box(width: Number = DEFAULT_SIZE, height: Number = DEFAULT_SIZE, depth: Number = DEFAULT_SIZE, noinline init: ((@SceneDsl Box).() -> Unit)? = null): Box = Box(width.toDouble(), height.toDouble(), depth.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun circle(centerX: Number = 0, centerY: Number = 0, radius: Number = 0, fill: Paint? = null, noinline init: ((@SceneDsl Circle).() -> Unit)? = null): Circle = Circle(centerX.toDouble(), centerY.toDouble(), radius.toDouble(), fill).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.circle(centerX: Number = 0, centerY: Number = 0, radius: Number = 0, fill: Paint? = null, noinline init: ((@SceneDsl Circle).() -> Unit)? = null): Circle = Circle(centerX.toDouble(), centerY.toDouble(), radius.toDouble(), fill).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun ItemRoot.circle(centerX: Number = 0, centerY: Number = 0, radius: Number = 0, fill: Paint? = null, noinline init: ((@SceneDsl Circle).() -> Unit)? = null): Circle = Circle(centerX.toDouble(), centerY.toDouble(), radius.toDouble(), fill).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun cubicCurve(startX: Number = 0, startY: Number = 0, controlX1: Number = 0, controlY1: Number = 0, controlX2: Number = 0, controlY2: Number = 0, endX: Number = 0, endY: Number = 0, noinline init: ((@SceneDsl CubicCurve).() -> Unit)? = null): CubicCurve = CubicCurve(startX.toDouble(), startY.toDouble(), controlX1.toDouble(), controlY1.toDouble(), controlX2.toDouble(), controlY2.toDouble(), endX.toDouble(), endY.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.cubicCurve(startX: Number = 0, startY: Number = 0, controlX1: Number = 0, controlY1: Number = 0, controlX2: Number = 0, controlY2: Number = 0, endX: Number = 0, endY: Number = 0, noinline init: ((@SceneDsl CubicCurve).() -> Unit)? = null): CubicCurve = CubicCurve(startX.toDouble(), startY.toDouble(), controlX1.toDouble(), controlY1.toDouble(), controlX2.toDouble(), controlY2.toDouble(), endX.toDouble(), endY.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun ItemRoot.cubicCurve(startX: Number = 0, startY: Number = 0, controlX1: Number = 0, controlY1: Number = 0, controlX2: Number = 0, controlY2: Number = 0, endX: Number = 0, endY: Number = 0, noinline init: ((@SceneDsl CubicCurve).() -> Unit)? = null): CubicCurve = CubicCurve(startX.toDouble(), startY.toDouble(), controlX1.toDouble(), controlY1.toDouble(), controlX2.toDouble(), controlY2.toDouble(), endX.toDouble(), endY.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun cylinder(radius: Number = 1, height: Number = 2, division: Int = 64, noinline init: ((@SceneDsl Cylinder).() -> Unit)? = null): Cylinder = Cylinder(radius.toDouble(), height.toDouble(), division).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.cylinder(radius: Number = 1, height: Number = 2, division: Int = 64, noinline init: ((@SceneDsl Cylinder).() -> Unit)? = null): Cylinder = Cylinder(radius.toDouble(), height.toDouble(), division).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun ItemRoot.cylinder(radius: Number = 1, height: Number = 2, division: Int = 64, noinline init: ((@SceneDsl Cylinder).() -> Unit)? = null): Cylinder = Cylinder(radius.toDouble(), height.toDouble(), division).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ellipse(centerX: Number = 0, centerY: Number = 0, radiusX: Number = 0, radiusY: Number = 0, noinline init: ((@SceneDsl Ellipse).() -> Unit)? = null): Ellipse = Ellipse(centerX.toDouble(), centerY.toDouble(), radiusX.toDouble(), radiusY.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.ellipse(centerX: Number = 0, centerY: Number = 0, radiusX: Number = 0, radiusY: Number = 0, noinline init: ((@SceneDsl Ellipse).() -> Unit)? = null): Ellipse = Ellipse(centerX.toDouble(), centerY.toDouble(), radiusX.toDouble(), radiusY.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun ItemRoot.ellipse(centerX: Number = 0, centerY: Number = 0, radiusX: Number = 0, radiusY: Number = 0, noinline init: ((@SceneDsl Ellipse).() -> Unit)? = null): Ellipse = Ellipse(centerX.toDouble(), centerY.toDouble(), radiusX.toDouble(), radiusY.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun line(centerX: Number = 0, centerY: Number = 0, endX: Number = 0, endY: Number = 0, noinline init: ((@SceneDsl Line).() -> Unit)? = null): Line = Line(centerX.toDouble(), centerY.toDouble(), endX.toDouble(), endY.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.line(centerX: Number = 0, centerY: Number = 0, endX: Number = 0, endY: Number = 0, noinline init: ((@SceneDsl Line).() -> Unit)? = null): Line = Line(centerX.toDouble(), centerY.toDouble(), endX.toDouble(), endY.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun ItemRoot.line(centerX: Number = 0, centerY: Number = 0, endX: Number = 0, endY: Number = 0, noinline init: ((@SceneDsl Line).() -> Unit)? = null): Line = Line(centerX.toDouble(), centerY.toDouble(), endX.toDouble(), endY.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun meshView(mesh: Mesh? = null, noinline init: ((@SceneDsl MeshView).() -> Unit)? = null): MeshView = MeshView(mesh).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.meshView(mesh: Mesh? = null, noinline init: ((@SceneDsl MeshView).() -> Unit)? = null): MeshView = MeshView(mesh).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun ItemRoot.meshView(mesh: Mesh? = null, noinline init: ((@SceneDsl MeshView).() -> Unit)? = null): MeshView = MeshView(mesh).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun path(vararg elements: PathElement, noinline init: ((@SceneDsl Path).() -> Unit)? = null): Path = Path(*elements).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.path(vararg elements: PathElement, noinline init: ((@SceneDsl Path).() -> Unit)? = null): Path = Path(*elements).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun ItemRoot.path(vararg elements: PathElement, noinline init: ((@SceneDsl Path).() -> Unit)? = null): Path = Path(*elements).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun polygon(vararg points: Number, noinline init: ((@SceneDsl Polygon).() -> Unit)? = null): Polygon = Polygon(*points.map { it.toDouble() }.toDoubleArray()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.polygon(vararg points: Number, noinline init: ((@SceneDsl Polygon).() -> Unit)? = null): Polygon = Polygon(*points.map { it.toDouble() }.toDoubleArray()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.polygon(vararg points: Number, noinline init: ((@SceneDsl Polygon).() -> Unit)? = null): Polygon = Polygon(*points.map { it.toDouble() }.toDoubleArray()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun polyline(vararg points: Number, noinline init: ((@SceneDsl Polyline).() -> Unit)? = null): Polyline = Polyline(*points.map { it.toDouble() }.toDoubleArray()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.polyline(vararg points: Number, noinline init: ((@SceneDsl Polyline).() -> Unit)? = null): Polyline = Polyline(*points.map { it.toDouble() }.toDoubleArray()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.polyline(vararg points: Number, noinline init: ((@SceneDsl Polyline).() -> Unit)? = null): Polyline = Polyline(*points.map { it.toDouble() }.toDoubleArray()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun quadCurve(startX: Number = 0, startY: Number = 0, controlX: Number = 0, controlY: Number = 0, endX: Number = 0, endY: Number = 0, noinline init: ((@SceneDsl QuadCurve).() -> Unit)? = null): QuadCurve = QuadCurve(startX.toDouble(), startY.toDouble(), controlX.toDouble(), controlY.toDouble(), endX.toDouble(), endY.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.quadCurve(startX: Number = 0, startY: Number = 0, controlX: Number = 0, controlY: Number = 0, endX: Number = 0, endY: Number = 0, noinline init: ((@SceneDsl QuadCurve).() -> Unit)? = null): QuadCurve = QuadCurve(startX.toDouble(), startY.toDouble(), controlX.toDouble(), controlY.toDouble(), endX.toDouble(), endY.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.quadCurve(startX: Number = 0, startY: Number = 0, controlX: Number = 0, controlY: Number = 0, endX: Number = 0, endY: Number = 0, noinline init: ((@SceneDsl QuadCurve).() -> Unit)? = null): QuadCurve = QuadCurve(startX.toDouble(), startY.toDouble(), controlX.toDouble(), controlY.toDouble(), endX.toDouble(), endY.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun rectangle(x: Number = 0, y: Number = 0, width: Number = 0, height: Number = 0, noinline init: ((@SceneDsl Rectangle).() -> Unit)? = null): Rectangle = Rectangle(x.toDouble(), y.toDouble(), width.toDouble(), height.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.rectangle(x: Number = 0, y: Number = 0, width: Number = 0, height: Number = 0, noinline init: ((@SceneDsl Rectangle).() -> Unit)? = null): Rectangle = Rectangle(x.toDouble(), y.toDouble(), width.toDouble(), height.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.rectangle(x: Number = 0, y: Number = 0, width: Number = 0, height: Number = 0, noinline init: ((@SceneDsl Rectangle).() -> Unit)? = null): Rectangle = Rectangle(x.toDouble(), y.toDouble(), width.toDouble(), height.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun sphere(radius: Number = 1, division: Int = 64, noinline init: ((@SceneDsl Sphere).() -> Unit)? = null): Sphere = Sphere(radius.toDouble(), division).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.sphere(radius: Number = 1, division: Int = 64, noinline init: ((@SceneDsl Sphere).() -> Unit)? = null): Sphere = Sphere(radius.toDouble(), division).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.sphere(radius: Number = 1, division: Int = 64, noinline init: ((@SceneDsl Sphere).() -> Unit)? = null): Sphere = Sphere(radius.toDouble(), division).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun svgPath(noinline init: ((@SceneDsl SVGPath).() -> Unit)? = null): SVGPath = SVGPath().apply { init?.invoke(this) }
@JvmOverloads inline fun ChildRoot.svgPath(noinline init: ((@SceneDsl SVGPath).() -> Unit)? = null): SVGPath = SVGPath().apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemRoot.svgPath(noinline init: ((@SceneDsl SVGPath).() -> Unit)? = null): SVGPath = SVGPath().apply { init?.invoke(this) }.add()
//endregion

//region Popups

@JvmOverloads inline fun contextMenu(vararg items: MenuItem, noinline init: ((@SceneDsl _ContextMenu).() -> Unit)? = null): ContextMenu = _ContextMenu(*items).apply { init?.invoke(this) }

@JvmOverloads inline fun checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupRoot.checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@SceneDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupRoot.customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@SceneDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl MenuItem).() -> Unit)? = null): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupRoot.menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl MenuItem).() -> Unit)? = null): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupRoot.radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@SceneDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun separatorMenuItem(noinline init: ((@SceneDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }
@JvmOverloads inline fun PopupRoot.separatorMenuItem(noinline init: ((@SceneDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }.add()

@JvmOverloads inline fun tooltip(text: String? = null, noinline init: ((@SceneDsl Tooltip).() -> Unit)? = null): Tooltip = Tooltip(text).apply { init?.invoke(this) }
//endregion