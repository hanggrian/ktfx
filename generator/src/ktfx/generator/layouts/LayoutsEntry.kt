package ktfx.generator.layouts

import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.hendraanggrian.kotlinpoet.typeVariableBy
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asClassName
import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import javafx.scene.control.ToggleButton
import javafx.scene.shape.PathElement
import ktfx.generator.KTFX_LAYOUTS
import kotlin.reflect.KClass
import kotlin.reflect.full.isSuperclassOf

operator fun KClass<*>.invoke(
    vararg parameters: ParameterSpec,
    typeVariables: String = "",
    customClass: Boolean = false
) = LayoutsEntry(
    this,
    parameters.asList(),
    typeVariables.map { "$it".typeVariableBy() },
    customClass = customClass
)

open class LayoutsEntries(
    val path: String,
    val className: String,
    vararg entries: LayoutsEntry
) : List<LayoutsEntry> by entries.asList()

class LayoutsEntry(
    val kClass: KClass<*>,
    val parameters: List<ParameterSpec>,
    val typeVariableNames: List<TypeVariableName>,
    private val customClass: Boolean
) {
    private companion object {
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

    val functionName: String
        get() = when (val func = "${simpleName[0].toLowerCase()}${simpleName.substring(1)}") {
            "hBox" -> "hbox"
            "vBox" -> "vbox"
            else -> func
        }

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

    fun getParameterName(namedArgument: Boolean, commaSuffix: Boolean): String =
        buildString {
            append(parameters.joinToString {
                buildString {
                    append(it.name)
                    if (namedArgument) append(" = ${it.name}")
                }
            })
            if (commaSuffix && parameters.isNotEmpty()) append(", ")
        }
}
