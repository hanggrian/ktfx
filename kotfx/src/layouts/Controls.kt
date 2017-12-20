@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.collections.ObservableList
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.Node
import javafx.scene.control.*
import javafx.scene.control.Pagination.INDETERMINATE
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.paint.Color.WHITE
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import javafx.scene.web.WebView
import java.time.LocalDate

//region Layout
inline fun anchorPane(init: (@KotfxDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init)
inline fun ChildManager.anchorPane(init: (@KotfxDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()
inline fun ItemManager.anchorPane(init: (@KotfxDsl _AnchorPane).() -> Unit): AnchorPane = _AnchorPane().apply(init).add()

inline fun borderPane(init: (@KotfxDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init)
inline fun ChildManager.borderPane(init: (@KotfxDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()
inline fun ItemManager.borderPane(init: (@KotfxDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()

inline fun flowPane(init: (@KotfxDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init)
inline fun ChildManager.flowPane(init: (@KotfxDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()
inline fun ItemManager.flowPane(init: (@KotfxDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()

inline fun gridPane(init: (@KotfxDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init)
inline fun ChildManager.gridPane(init: (@KotfxDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()
inline fun ItemManager.gridPane(init: (@KotfxDsl _GridPane).() -> Unit): GridPane = _GridPane().apply(init).add()

inline fun hbox(init: (@KotfxDsl _HBox).() -> Unit): HBox = _HBox().apply(init)
inline fun ChildManager.hbox(init: (@KotfxDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()
inline fun ItemManager.hbox(init: (@KotfxDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()

inline fun stackPane(init: (@KotfxDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init)
inline fun ChildManager.stackPane(init: (@KotfxDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()
inline fun ItemManager.stackPane(init: (@KotfxDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()

inline fun textFlow(init: (@KotfxDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init)
inline fun ChildManager.textFlow(init: (@KotfxDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()
inline fun ItemManager.textFlow(init: (@KotfxDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()

inline fun tilePane(init: (@KotfxDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init)
inline fun ChildManager.tilePane(init: (@KotfxDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init).add()
inline fun ItemManager.tilePane(init: (@KotfxDsl _TilePane).() -> Unit): TilePane = _TilePane().apply(init).add()

inline fun vbox(init: (@KotfxDsl _VBox).() -> Unit): VBox = _VBox().apply(init)
inline fun ChildManager.vbox(init: (@KotfxDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()
inline fun ItemManager.vbox(init: (@KotfxDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()
//endregion

//region Control
@JvmOverloads inline fun accordion(vararg titledPanes: TitledPane, noinline init: ((@KotfxDsl Accordion).() -> Unit)? = null): Accordion = Accordion(*titledPanes).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.accordion(vararg titledPanes: TitledPane, noinline init: ((@KotfxDsl Accordion).() -> Unit)? = null): Accordion = Accordion(*titledPanes).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.accordion(vararg titledPanes: TitledPane, noinline init: ((@KotfxDsl Accordion).() -> Unit)? = null): Accordion = Accordion(*titledPanes).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun buttonBar(buttonOrder: String? = null, noinline init: ((@KotfxDsl ButtonBar).() -> Unit)? = null): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.buttonBar(buttonOrder: String? = null, noinline init: ((@KotfxDsl ButtonBar).() -> Unit)? = null): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.buttonBar(buttonOrder: String? = null, noinline init: ((@KotfxDsl ButtonBar).() -> Unit)? = null): ButtonBar = ButtonBar(buttonOrder).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun button(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl Button).() -> Unit)? = null): Button = Button(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.button(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl Button).() -> Unit)? = null): Button = Button(text, graphic).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.button(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl Button).() -> Unit)? = null): Button = Button(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun checkBox(text: String? = null, noinline init: ((@KotfxDsl CheckBox).() -> Unit)? = null): CheckBox = CheckBox(text).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.checkBox(text: String? = null, noinline init: ((@KotfxDsl CheckBox).() -> Unit)? = null): CheckBox = CheckBox(text).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.checkBox(text: String? = null, noinline init: ((@KotfxDsl CheckBox).() -> Unit)? = null): CheckBox = CheckBox(text).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <T> choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@KotfxDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }
@JvmOverloads inline fun <T> ChildManager.choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@KotfxDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <T> ItemManager.choiceBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@KotfxDsl ChoiceBox<T>).() -> Unit)? = null): ChoiceBox<T> = ChoiceBox(items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun colorPicker(color: Color = WHITE, noinline init: ((@KotfxDsl ColorPicker).() -> Unit)? = null): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.colorPicker(color: Color = WHITE, noinline init: ((@KotfxDsl ColorPicker).() -> Unit)? = null): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.colorPicker(color: Color = WHITE, noinline init: ((@KotfxDsl ColorPicker).() -> Unit)? = null): ColorPicker = ColorPicker(color).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <T> comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@KotfxDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }
@JvmOverloads inline fun <T> ChildManager.comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@KotfxDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <T> ItemManager.comboBox(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@KotfxDsl ComboBox<T>).() -> Unit)? = null): ComboBox<T> = ComboBox(items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun datePicker(date: LocalDate? = null, noinline init: ((@KotfxDsl DatePicker).() -> Unit)? = null): DatePicker = DatePicker(date).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.datePicker(date: LocalDate? = null, noinline init: ((@KotfxDsl DatePicker).() -> Unit)? = null): DatePicker = DatePicker(date).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.datePicker(date: LocalDate? = null, noinline init: ((@KotfxDsl DatePicker).() -> Unit)? = null): DatePicker = DatePicker(date).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl Hyperlink).() -> Unit)? = null): Hyperlink = Hyperlink(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl Hyperlink).() -> Unit)? = null): Hyperlink = Hyperlink(text, graphic).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.hyperlink(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl Hyperlink).() -> Unit)? = null): Hyperlink = Hyperlink(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun imageView(image: Image? = null, noinline init: ((@KotfxDsl ImageView).() -> Unit)? = null): ImageView = ImageView(image).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.imageView(image: Image? = null, noinline init: ((@KotfxDsl ImageView).() -> Unit)? = null): ImageView = ImageView(image).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.imageView(image: Image? = null, noinline init: ((@KotfxDsl ImageView).() -> Unit)? = null): ImageView = ImageView(image).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun label(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl Label).() -> Unit)? = null): Label = Label(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.label(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl Label).() -> Unit)? = null): Label = Label(text, graphic).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.label(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl Label).() -> Unit)? = null): Label = Label(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <T> listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@KotfxDsl ListView<T>).() -> Unit)? = null): ListView<T> = ListView(items).apply { init?.invoke(this) }
@JvmOverloads inline fun <T> ChildManager.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@KotfxDsl ListView<T>).() -> Unit)? = null): ListView<T> = ListView(items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <T> ItemManager.listView(items: ObservableList<T> = mutableObservableListOf(), noinline init: ((@KotfxDsl ListView<T>).() -> Unit)? = null): ListView<T> = ListView(items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun menuBar(vararg menus: Menu, noinline init: ((@KotfxDsl _MenuBar).() -> Unit)? = null): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.menuBar(vararg menus: Menu, noinline init: ((@KotfxDsl _MenuBar).() -> Unit)? = null): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.menuBar(vararg menus: Menu, noinline init: ((@KotfxDsl _MenuBar).() -> Unit)? = null): MenuBar = _MenuBar(*menus).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl MenuButton).() -> Unit)? = null): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl MenuButton).() -> Unit)? = null): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.menuButton(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl MenuButton).() -> Unit)? = null): MenuButton = MenuButton(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun menu(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl Menu).() -> Unit)? = null): Menu = Menu(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupManager.menu(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl Menu).() -> Unit)? = null): Menu = Menu(text, graphic).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun MenuManager.menu(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl Menu).() -> Unit)? = null): Menu = Menu(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@KotfxDsl Pagination).() -> Unit)? = null): Pagination = Pagination(count, index).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@KotfxDsl Pagination).() -> Unit)? = null): Pagination = Pagination(count, index).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.pagination(count: Int = INDETERMINATE, index: Int = 0, noinline init: ((@KotfxDsl Pagination).() -> Unit)? = null): Pagination = Pagination(count, index).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun passwordField(noinline init: ((@KotfxDsl PasswordField).() -> Unit)? = null): PasswordField = PasswordField().apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.passwordField(noinline init: ((@KotfxDsl PasswordField).() -> Unit)? = null): PasswordField = PasswordField().apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.passwordField(noinline init: ((@KotfxDsl PasswordField).() -> Unit)? = null): PasswordField = PasswordField().apply { init?.invoke(this) }.add()

@JvmOverloads inline fun progressBar(progress: Number = INDETERMINATE_PROGRESS, noinline init: ((@KotfxDsl ProgressBar).() -> Unit)? = null): ProgressBar = ProgressBar(progress.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.progressBar(progress: Number = INDETERMINATE_PROGRESS, noinline init: ((@KotfxDsl ProgressBar).() -> Unit)? = null): ProgressBar = ProgressBar(progress.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.progressBar(progress: Number = INDETERMINATE_PROGRESS, noinline init: ((@KotfxDsl ProgressBar).() -> Unit)? = null): ProgressBar = ProgressBar(progress.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun progressIndicator(progress: Number = INDETERMINATE_PROGRESS, noinline init: ((@KotfxDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.progressIndicator(progress: Number = INDETERMINATE_PROGRESS, noinline init: ((@KotfxDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.progressIndicator(progress: Number = INDETERMINATE_PROGRESS, noinline init: ((@KotfxDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ProgressIndicator(progress.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun radioButton(text: String? = null, noinline init: ((@KotfxDsl RadioButton).() -> Unit)? = null): RadioButton = RadioButton(text).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.radioButton(text: String? = null, noinline init: ((@KotfxDsl RadioButton).() -> Unit)? = null): RadioButton = RadioButton(text).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.radioButton(text: String? = null, noinline init: ((@KotfxDsl RadioButton).() -> Unit)? = null): RadioButton = RadioButton(text).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun scrollBar(noinline init: ((@KotfxDsl ScrollBar).() -> Unit)? = null): ScrollBar = ScrollBar().apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.scrollBar(noinline init: ((@KotfxDsl ScrollBar).() -> Unit)? = null): ScrollBar = ScrollBar().apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.scrollBar(noinline init: ((@KotfxDsl ScrollBar).() -> Unit)? = null): ScrollBar = ScrollBar().apply { init?.invoke(this) }.add()

@JvmOverloads inline fun scrollPane(content: Node? = null, noinline init: ((@KotfxDsl ScrollPane).() -> Unit)? = null): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.scrollPane(content: Node? = null, noinline init: ((@KotfxDsl ScrollPane).() -> Unit)? = null): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.scrollPane(content: Node? = null, noinline init: ((@KotfxDsl ScrollPane).() -> Unit)? = null): ScrollPane = ScrollPane(content).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun separator(orientation: Orientation = HORIZONTAL, noinline init: ((@KotfxDsl Separator).() -> Unit)? = null): Separator = Separator(orientation).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.separator(orientation: Orientation = HORIZONTAL, noinline init: ((@KotfxDsl Separator).() -> Unit)? = null): Separator = Separator(orientation).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.separator(orientation: Orientation = HORIZONTAL, noinline init: ((@KotfxDsl Separator).() -> Unit)? = null): Separator = Separator(orientation).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun slider(min: Number, max: Number, value: Number, noinline init: ((@KotfxDsl Slider).() -> Unit)? = null): Slider = Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.slider(min: Number, max: Number, value: Number, noinline init: ((@KotfxDsl Slider).() -> Unit)? = null): Slider = Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.slider(min: Number, max: Number, value: Number, noinline init: ((@KotfxDsl Slider).() -> Unit)? = null): Slider = Slider(min.toDouble(), max.toDouble(), value.toDouble()).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <T> spinner(noinline init: ((@KotfxDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }
@JvmOverloads inline fun <T> ChildManager.spinner(noinline init: ((@KotfxDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <T> ItemManager.spinner(noinline init: ((@KotfxDsl Spinner<T>).() -> Unit)? = null): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }.add()

@JvmOverloads inline fun splitMenuButton(vararg items: MenuItem, noinline init: ((@KotfxDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.splitMenuButton(vararg items: MenuItem, noinline init: ((@KotfxDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.splitMenuButton(vararg items: MenuItem, noinline init: ((@KotfxDsl SplitMenuButton).() -> Unit)? = null): SplitMenuButton = SplitMenuButton(*items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun splitPane(vararg items: Node, noinline init: ((@KotfxDsl SplitPane).() -> Unit)? = null): SplitPane = SplitPane(*items).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.splitPane(vararg items: Node, noinline init: ((@KotfxDsl SplitPane).() -> Unit)? = null): SplitPane = SplitPane(*items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.splitPane(vararg items: Node, noinline init: ((@KotfxDsl SplitPane).() -> Unit)? = null): SplitPane = SplitPane(*items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <S> tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@KotfxDsl TableView<S>).() -> Unit)? = null): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }
@JvmOverloads inline fun <S> ChildManager.tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@KotfxDsl TableView<S>).() -> Unit)? = null): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <S> ItemManager.tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@KotfxDsl TableView<S>).() -> Unit)? = null): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun tabPane(vararg tabs: Tab, noinline init: ((@KotfxDsl TabPane).() -> Unit)? = null): TabPane = TabPane(*tabs).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.tabPane(vararg tabs: Tab, noinline init: ((@KotfxDsl TabPane).() -> Unit)? = null): TabPane = TabPane(*tabs).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.tabPane(vararg tabs: Tab, noinline init: ((@KotfxDsl TabPane).() -> Unit)? = null): TabPane = TabPane(*tabs).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun tab(text: String? = null, content: Node? = null, noinline init: ((@KotfxDsl Tab).() -> Unit)? = null): Tab = Tab(text, content).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.tab(text: String? = null, content: Node? = null, noinline init: ((@KotfxDsl Tab).() -> Unit)? = null): Tab = Tab(text, content).apply { init?.invoke(this) }
@JvmOverloads inline fun ItemManager.tab(text: String? = null, content: Node? = null, noinline init: ((@KotfxDsl Tab).() -> Unit)? = null): Tab = Tab(text, content).apply { init?.invoke(this) }

@JvmOverloads inline fun textArea(noinline init: ((@KotfxDsl TextArea).() -> Unit)? = null): TextArea = TextArea().apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.textArea(noinline init: ((@KotfxDsl TextArea).() -> Unit)? = null): TextArea = TextArea().apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.textArea(noinline init: ((@KotfxDsl TextArea).() -> Unit)? = null): TextArea = TextArea().apply { init?.invoke(this) }.add()

@JvmOverloads inline fun textField(text: String = "", noinline init: ((@KotfxDsl TextField).() -> Unit)? = null): TextField = TextField(text).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.textField(text: String = "", noinline init: ((@KotfxDsl TextField).() -> Unit)? = null): TextField = TextField(text).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.textField(text: String = "", noinline init: ((@KotfxDsl TextField).() -> Unit)? = null): TextField = TextField(text).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun text(text: String? = null, noinline init: ((@KotfxDsl Text).() -> Unit)? = null): Text = Text(text).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.text(text: String? = null, noinline init: ((@KotfxDsl Text).() -> Unit)? = null): Text = Text(text).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.text(text: String? = null, noinline init: ((@KotfxDsl Text).() -> Unit)? = null): Text = Text(text).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun titledPane(text: String? = null, content: Node? = null, noinline init: ((@KotfxDsl TitledPane).() -> Unit)? = null): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.titledPane(text: String? = null, content: Node? = null, noinline init: ((@KotfxDsl TitledPane).() -> Unit)? = null): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.titledPane(text: String? = null, content: Node? = null, noinline init: ((@KotfxDsl TitledPane).() -> Unit)? = null): TitledPane = TitledPane(text, content).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl ToggleButton).() -> Unit)? = null): ToggleButton = ToggleButton(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl ToggleButton).() -> Unit)? = null): ToggleButton = ToggleButton(text, graphic).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.toggleButton(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl ToggleButton).() -> Unit)? = null): ToggleButton = ToggleButton(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun toolBar(vararg items: Node, noinline init: ((@KotfxDsl _ToolBar).() -> Unit)? = null): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.toolBar(vararg items: Node, noinline init: ((@KotfxDsl _ToolBar).() -> Unit)? = null): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.toolBar(vararg items: Node, noinline init: ((@KotfxDsl _ToolBar).() -> Unit)? = null): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <S> treeTableView(root: TreeItem<S>? = null, noinline init: ((@KotfxDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }
@JvmOverloads inline fun <S> ChildManager.treeTableView(root: TreeItem<S>? = null, noinline init: ((@KotfxDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <S> ItemManager.treeTableView(root: TreeItem<S>? = null, noinline init: ((@KotfxDsl TreeTableView<S>).() -> Unit)? = null): TreeTableView<S> = TreeTableView<S>(root).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun <T> treeView(root: TreeItem<T>? = null, noinline init: ((@KotfxDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }
@JvmOverloads inline fun <T> ChildManager.treeView(root: TreeItem<T>? = null, noinline init: ((@KotfxDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }.add()
@JvmOverloads inline fun <T> ItemManager.treeView(root: TreeItem<T>? = null, noinline init: ((@KotfxDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun webView(noinline init: ((@KotfxDsl WebView).() -> Unit)? = null): WebView = WebView().apply { init?.invoke(this) }
@JvmOverloads inline fun ChildManager.webView(noinline init: ((@KotfxDsl WebView).() -> Unit)? = null): WebView = WebView().apply { init?.invoke(this) }.add()
@JvmOverloads inline fun ItemManager.webView(noinline init: ((@KotfxDsl WebView).() -> Unit)? = null): WebView = WebView().apply { init?.invoke(this) }.add()
//endregion

//region Popup
inline fun contextMenu(vararg items: MenuItem, noinline init: (@KotfxDsl _ContextMenu).() -> Unit): ContextMenu = _ContextMenu(*items).apply(init)

@JvmOverloads inline fun checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupManager.checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@KotfxDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupManager.customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@KotfxDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl MenuItem).() -> Unit)? = null): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupManager.menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl MenuItem).() -> Unit)? = null): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupManager.radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun separatorMenuItem(noinline init: ((@KotfxDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }
@JvmOverloads inline fun PopupManager.separatorMenuItem(noinline init: ((@KotfxDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }.add()

@JvmOverloads inline fun tooltip(text: String? = null, noinline init: ((@KotfxDsl Tooltip).() -> Unit)? = null): Tooltip = Tooltip(text).apply { init?.invoke(this) }
//endregion