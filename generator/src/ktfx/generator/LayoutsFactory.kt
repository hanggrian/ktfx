package ktfx.generator

import com.hendraanggrian.kotlinpoet.buildParameter
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.asClassName
import javafx.scene.Node
import javafx.scene.control.Accordion
import javafx.scene.control.Button
import javafx.scene.control.ButtonBar
import javafx.scene.control.CheckBox
import javafx.scene.control.CheckMenuItem
import javafx.scene.control.ColorPicker
import javafx.scene.control.CustomMenuItem
import javafx.scene.control.DatePicker
import javafx.scene.control.Hyperlink
import javafx.scene.control.Label
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
import javafx.scene.control.SplitMenuButton
import javafx.scene.control.SplitPane
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.control.TitledPane
import javafx.scene.control.ToggleButton
import javafx.scene.control.ToolBar
import javafx.scene.paint.Color
import javafx.scene.shape.PathElement
import java.time.LocalDate
import kotlin.reflect.KClass
import kotlin.reflect.full.isSuperclassOf

enum class LayoutsFactory(
    private val kClass: KClass<*>,
    private vararg val params: P,
    private val customClass: Boolean = false
) {
    // javafx.scene.control
    ACCORDION(Accordion::class, customClass = true),
    BUTTON(Button::class, P.TEXT, P.GRAPHIC),
    BUTTON_BAR(ButtonBar::class, P("buttonOrder", String::class), customClass = true),
    CHECK_BOX(CheckBox::class, P.TEXT),
    CHECK_MENU_ITEM(CheckMenuItem::class, P.TEXT, P.GRAPHIC),
    COLOR_PICKER(
        ColorPicker::class,
        P("value", Color::class, "%M", MemberName("javafx.scene.paint.Color", "WHITE"))
    ),
    CUSTOM_MENU_ITEM(CustomMenuItem::class, P.CONTENT, P("hideOnClick", Boolean::class, "false")),
    DATE_PICKER(DatePicker::class, P("value", LocalDate::class)),
    HYPERLINK(Hyperlink::class, P.TEXT, P.GRAPHIC),
    LABEL(Label::class, P.TEXT, P.GRAPHIC),
    MENU(Menu::class, P.TEXT_EMPTY, P.GRAPHIC, customClass = true),
    MENU_BAR(MenuBar::class, customClass = true),
    MENU_BUTTON(MenuButton::class, P.TEXT, P.GRAPHIC, customClass = true),
    MENU_ITEM(MenuItem::class, P.TEXT, P.GRAPHIC),
    PAGINATION(
        Pagination::class,
        P("pageCount", Int::class, "%M", MemberName("javafx.scene.control.Pagination", "INDETERMINATE")),
        P("currentPageIndex", Int::class, "0")
    ),
    PASSWORD_FIELD(PasswordField::class),
    PROGRESS_BAR(ProgressBar::class, P.PROGRESS),
    PROGRESS_INDICATOR(ProgressIndicator::class, P.PROGRESS),
    RADIO_BUTTON(RadioButton::class, P.TEXT),
    RADIO_MENU_ITEM(RadioMenuItem::class, P.TEXT, P.GRAPHIC),
    SCROLL_BAR(ScrollBar::class),
    SCROLL_PANE(ScrollPane::class, P.CONTENT, customClass = true),
    SEPARATOR(Separator::class),
    SEPARATOR_MENU_ITEM(SeparatorMenuItem::class),
    SLIDER(
        Slider::class,
        P("min", Double::class, "0.0"), P("max", Double::class, "100.0"), P("value", Double::class, "0.0")
    ),
    SPLIT_MENU_BUTTON(SplitMenuButton::class, customClass = true),
    SPLIT_PANE(SplitPane::class, customClass = true),
    TAB(Tab::class, P.TEXT, P.CONTENT, customClass = true),
    TAB_PANE(TabPane::class, customClass = true),
    TEXT_AREA(TextArea::class, P.TEXT_EMPTY),
    TEXT_FIELD(TextField::class, P.TEXT_EMPTY),
    TITLED_PANE(TitledPane::class, P.TITLE, customClass = true),
    TOGGLE_BUTTON(ToggleButton::class, P.TEXT, P.GRAPHIC),
    TOOLBAR(ToolBar::class, customClass = true);

    companion object {
        val VALID_MANAGERS: Set<KClass<*>> = setOf(
            MenuItem::class,
            Menu::class,
            Node::class,
            PathElement::class,
            Tab::class,
            TitledPane::class,
            ToggleButton::class
        )
    }

    private val simpleName: String get() = kClass.simpleName!!

    val generatedName: String get() = "_$simpleName"

    val className: ClassName get() = kClass.asClassName()

    val customClassName: ClassName
        get() = ClassName(KTFX_LAYOUTS, "Ktfx$simpleName").takeIf { customClass } ?: className

    val managerClassNames: List<ClassName>
        get() = VALID_MANAGERS.filter { it == kClass || it.isSuperclassOf(kClass) }
            .map { ClassName(KTFX_LAYOUTS, it.simpleName!! + "Manager") }

    val functionName: String get() = simpleName.first().toLowerCase() + simpleName.substring(1)

    val styledFunctionName: String get() = "styled$simpleName"

    fun getComment(add: Boolean, styled: Boolean, configured: Boolean): String =
        buildString {
            append(if (!add) "Create" else "Add")
            append(when {
                !styled && simpleName.first().let { it == 'A' || it == 'E' || it == 'I' || it == 'O' || it == 'U' } ->
                    " an"
                else -> " a"
            })
            if (styled) append(" styled")
            append(" [$simpleName]")
            if (configured) append(" with configuration block")
            if (add) append(" to this manager")
            append('.')
        }

    val parameterSpecs: List<ParameterSpec>
        get() = params.map { param ->
            val className = param.type.asClassName()
            buildParameter(
                param.name,
                className.takeIf { param.defFormat == "null" }?.copy(true) ?: className
            ) {
                if (param.vararg) addModifiers(KModifier.VARARG)
                defaultValue(param.defFormat, *param.defArgs)
            }
        }

    fun getParameterName(namedArgument: Boolean, commaSuffix: Boolean): String = buildString {
        append(params.joinToString {
            buildString {
                append(it.name)
                if (namedArgument) append(" = ${it.name}")
            }
        })
        if (commaSuffix && params.isNotEmpty()) append(", ")
    }

    class P(
        val name: String,
        val type: KClass<*>,
        val defFormat: String = "null",
        vararg val defArgs: Any = emptyArray(),
        val vararg: Boolean = false
    ) {
        companion object {
            val TEXT = P("text", String::class)
            val TEXT_EMPTY = P("text", String::class, "\"\"")
            val TITLE = P("title", String::class)
            val GRAPHIC = P("graphic", Node::class)
            val CONTENT = P("content", Node::class)
            val PROGRESS = P(
                "progress",
                Double::class, "%M", MemberName("javafx.scene.control.ProgressBar", "INDETERMINATE_PROGRESS")
            )
        }
    }
}