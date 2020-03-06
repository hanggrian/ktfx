package ktfx.generator

import com.hendraanggrian.kotlinpoet.buildParameter
import com.hendraanggrian.kotlinpoet.memberOf
import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.hendraanggrian.kotlinpoet.typeVariableBy
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asClassName
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
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
import javafx.scene.paint.Color
import javafx.scene.shape.PathElement
import java.time.LocalDate
import kotlin.reflect.KClass
import kotlin.reflect.full.isSuperclassOf

class LayoutsFactory private constructor(
    private val kClass: KClass<*>,
    val parameterSpecs: List<ParameterSpec>,
    val typeVariableNames: List<TypeVariableName>,
    private val customClass: Boolean
) {
    companion object {
        fun listAll(): List<LayoutsFactory> = listOf(
            Accordion::class(customClass = true),
            Button::class(text(), graphic()),
            ButtonBar::class(buildParameter<String>("buttonOrder"), customClass = true),
            CheckBox::class(text()),
            CheckMenuItem::class(text(), graphic()),
            ChoiceBox::class(items(), typeVariables = "T"),
            ColorPicker::class(buildParameter<Color>("value") { defaultValue("%M", Color::class.memberOf("WHITE")) }),
            ComboBox::class(items(), typeVariables = "T"),
            CustomMenuItem::class(content(), buildParameter<Boolean>("hideOnClick") { defaultValue("true") }),
            DatePicker::class(buildParameter<LocalDate>("value")),
            Hyperlink::class(text(), graphic()),
            Label::class(text(), graphic()),
            ListView::class(items(), typeVariables = "T"),
            Menu::class(text(), graphic(), customClass = true),
            MenuBar::class(customClass = true),
            MenuButton::class(text(), graphic(), customClass = true),
            MenuItem::class(text(), graphic()),
            Pagination::class(
                buildParameter<Int>("pageCount") { defaultValue("%M", Pagination::class.memberOf("INDETERMINATE")) },
                buildParameter<Int>("currentPageIndex") { defaultValue("0") }
            ),
            PasswordField::class(),
            ProgressBar::class(progress()),
            ProgressIndicator::class(progress()),
            RadioButton::class(text()),
            RadioMenuItem::class(text(), graphic()),
            ScrollBar::class(),
            ScrollPane::class(content(), customClass = true),
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
            Tab::class(text(), content(), customClass = true),
            TableView::class(items('S'), typeVariables = "S"),
            TabPane::class(customClass = true),
            TextArea::class(text(true)),
            TextField::class(text(true)),
            TitledPane::class(title(), customClass = true),
            ToggleButton::class(text(), graphic()),
            ToolBar::class(customClass = true)/*,
            TreeTableView::class(items('S'), typeVariables = "S"),
            TreeView::class(items('T'), typeVariables = "T")*/
        )

        private fun text(empty: Boolean = false) = buildParameter<String>("text") { if (empty) defaultValue("\"\"") }
        private fun title() = buildParameter<String>("title")
        private fun graphic() = buildParameter<Node>("graphic")
        private fun content() = buildParameter<Node>("content")
        private fun progress() = buildParameter<Double>("progress") {
            defaultValue("%M", ProgressBar::class.memberOf("INDETERMINATE_PROGRESS"))
        }

        private fun items(typeVariable: Char = 'T') = buildParameter(
            "items",
            ObservableList::class.asClassName().parameterizedBy("$typeVariable".typeVariableBy())
        ) {
            defaultValue("%M()", FXCollections::class.memberOf("observableArrayList"))
        }

        private operator fun KClass<*>.invoke(
            vararg parameters: ParameterSpec,
            typeVariables: String = "",
            customClass: Boolean = false
        ) = LayoutsFactory(
            this,
            parameters.asList(),
            typeVariables.map { "$it".typeVariableBy() },
            customClass = customClass
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

    val typeName: TypeName
        get() {
            val name = kClass.asClassName()
            if (typeVariableNames.isNotEmpty()) {
                return name.parameterizedBy(*typeVariableNames.toTypedArray())
            }
            return name
        }

    val customTypeName: TypeName
        get() = typeName.takeUnless { customClass } ?: ClassName(KTFX_LAYOUTS, "Ktfx$simpleName")

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

    fun getParameterName(namedArgument: Boolean, commaSuffix: Boolean): String = buildString {
        append(parameterSpecs.joinToString {
            buildString {
                append(it.name)
                if (namedArgument) append(" = ${it.name}")
            }
        })
        if (commaSuffix && parameterSpecs.isNotEmpty()) append(", ")
    }
}
