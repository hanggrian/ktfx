package ktfx.generator

import com.hendraanggrian.kotlinpoet.buildParameter
import com.hendraanggrian.kotlinpoet.member
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.KModifier
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

class LayoutsFactory(
    private val kClass: KClass<*>,
    private vararg val params: LayoutsParameter,
    private val customClass: Boolean = false
) {
    companion object {
        fun listAll(): List<LayoutsFactory> = listOf(
            Accordion::class(customClass = true),
            Button::class(PARAM_TEXT, PARAM_GRAPHIC),
            ButtonBar::class("buttonOrder"<String>(), customClass = true),
            CheckBox::class(PARAM_TEXT),
            CheckMenuItem::class(PARAM_TEXT, PARAM_GRAPHIC),
            ColorPicker::class("value"<Color>("%M", Color::class.asClassName().member("WHITE"))),
            CustomMenuItem::class(PARAM_CONTENT, "hideOnClick"<Boolean>("true")),
            DatePicker::class("value"<LocalDate>()),
            Hyperlink::class(PARAM_TEXT, PARAM_GRAPHIC),
            Label::class(PARAM_TEXT, PARAM_GRAPHIC),
            Menu::class(PARAM_TEXT_EMPTY, PARAM_GRAPHIC, customClass = true),
            MenuBar::class(customClass = true),
            MenuButton::class(PARAM_TEXT, PARAM_GRAPHIC, customClass = true),
            MenuItem::class(PARAM_TEXT, PARAM_GRAPHIC),
            Pagination::class(
                "pageCount"<Int>("%M", Pagination::class.asClassName().member("INDETERMINATE")),
                "currentPageIndex"<Int>("0")
            ),
            PasswordField::class(),
            ProgressBar::class(PARAM_PROGRESS),
            ProgressIndicator::class(PARAM_PROGRESS),
            RadioButton::class(PARAM_TEXT),
            RadioMenuItem::class(PARAM_TEXT, PARAM_GRAPHIC),
            ScrollBar::class(),
            ScrollPane::class(PARAM_CONTENT, customClass = true),
            Separator::class(),
            SeparatorMenuItem::class(),
            Slider::class("min"<Double>("0.0"), "max"<Double>("100.0"), "value"<Double>("0.0")),
            SplitMenuButton::class(customClass = true),
            SplitPane::class(customClass = true),
            Tab::class(PARAM_TEXT, PARAM_CONTENT, customClass = true),
            TabPane::class(customClass = true),
            TextArea::class(PARAM_TEXT_EMPTY),
            TextField::class(PARAM_TEXT_EMPTY),
            TitledPane::class(PARAM_TITLE, customClass = true),
            ToggleButton::class(PARAM_TEXT, PARAM_GRAPHIC),
            ToolBar::class(customClass = true)
        )

        private val VALID_MANAGERS: Set<KClass<*>> = setOf(
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
        get() = className.takeUnless { customClass } ?: ClassName(KTFX_LAYOUTS, "Ktfx$simpleName")

    val managerClassNames: List<ClassName>
        get() = VALID_MANAGERS.filter { it == kClass || it.isSuperclassOf(kClass) }
            .map { ClassName(KTFX_LAYOUTS, "${it.simpleName}Manager") }

    val fullManagerClassNames: List<ClassName?>
        get() = listOf(null, *managerClassNames.toTypedArray())

    val functionName: String get() = "${simpleName.first().toLowerCase()}${simpleName.substring(1)}"

    val styledFunctionName: String get() = "styled$simpleName"

    fun getComment(add: Boolean, styled: Boolean, configured: Boolean): String = buildString {
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

    val parameters: List<ParameterSpec>
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
}

private operator fun KClass<*>.invoke(
    vararg params: LayoutsParameter,
    customClass: Boolean = false
) = LayoutsFactory(this, *params, customClass = customClass)

private val PARAM_TEXT = "text"<String>()
private val PARAM_TEXT_EMPTY = "text"<String>("\"\"")
private val PARAM_TITLE = "title"<String>()
private val PARAM_GRAPHIC = "graphic"<Node>()
private val PARAM_CONTENT = "content"<Node>()
private val PARAM_PROGRESS = "progress"<Double>("%M", ProgressBar::class.asClassName().member("INDETERMINATE_PROGRESS"))

private inline operator fun <reified T> String.invoke(
    defFormat: String = "null",
    vararg defArgs: Any = emptyArray(),
    vararg: Boolean = false
) = LayoutsParameter(this, T::class, defFormat, defArgs, vararg)

data class LayoutsParameter(
    val name: String,
    val type: KClass<*>,
    val defFormat: String,
    val defArgs: Array<out Any>,
    val vararg: Boolean
) {
    override fun equals(other: Any?) = other is LayoutsParameter && other.name == name
    override fun hashCode() = name.hashCode()
}