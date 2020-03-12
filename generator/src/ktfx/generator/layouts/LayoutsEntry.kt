package ktfx.generator.layouts

import com.hendraanggrian.kotlinpoet.classOf
import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.KModifier
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

data class LayoutsEntry(
    private val packageName: String,
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
        get() = typeName.takeUnless { customClass } ?: packageName.classOf("Ktfx$simpleName")

    val managerClassNames: List<ClassName>
        get() = VALID_MANAGERS.filter { it == kClass || it.isSuperclassOf(kClass) }
            .map { KTFX_LAYOUTS.classOf("${it.simpleName}Manager") }

    val fullManagerClassNames: List<ClassName?>
        get() = listOf(null, *managerClassNames.toTypedArray())

    val functionName: String
        get() = simpleName.mapIndexed { index, c ->
            when {
                index == 0 || index == 1 -> c.toLowerCase()
                c.isUpperCase() && simpleName.getOrNull(index + 1)?.isUpperCase() ?: false -> c.toLowerCase()
                else -> c
            }
        }.joinToString("")

    val styledFunctionName: String get() = "styled$simpleName"

    val supportStyledFunction: Boolean get() = "ktfx.layouts".classOf("PathElementManager") !in managerClassNames

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
                var s = buildString {
                    append(it.name)
                    if (namedArgument) append(" = ${it.name}")
                }
                if (KModifier.VARARG in it.modifiers) {
                    val index = s.lastIndexOf(it.name)
                    s = s.substring(0, index) + '*' + s.substring(index)
                }
                s
            })
            if (commaSuffix && parameters.isNotEmpty()) append(", ")
        }
}
