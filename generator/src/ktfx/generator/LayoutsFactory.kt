package ktfx.generator

import com.hendraanggrian.kotlinpoet.buildParameter
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.asClassName
import javafx.scene.Node
import javafx.scene.control.Accordion
import javafx.scene.control.Button
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import javafx.scene.control.ToggleButton
import javafx.scene.shape.PathElement
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

val VALID_MANAGERS = listOf(
    MenuItem::class,
    Menu::class,
    Node::class,
    PathElement::class,
    Tab::class,
    TitledPane::class,
    ToggleButton::class
)

enum class LayoutsFactory(kClass: KClass<*>, vararg params: Param, hasCustomClass: Boolean = false) {
    ACCORDION(Accordion::class, hasCustomClass = true),
    BUTTON(Button::class, Param("text", String::class), Param("graphic", Node::class));

    private val simpleName = kClass.simpleName!!

    val generatedName = "_$simpleName"

    val className = kClass.asClassName()

    val customClassName = ClassName(KTFX_LAYOUTS, "Ktfx$simpleName").takeIf { hasCustomClass } ?: className

    val managerClassName =
        ClassName(KTFX_LAYOUTS, VALID_MANAGERS.single { kClass.isSubclassOf(it) }.simpleName!! + "Manager")

    val functionName = simpleName.first().toLowerCase() + simpleName.substring(1)

    val styledFunctionName = "styled$simpleName"

    fun getComment(isAdd: Boolean = false, isStyled: Boolean = false, hasConfiguration: Boolean = false) = buildString {
        append(if (!isAdd) "Create" else "Add")
        append(
            when {
                !isStyled && simpleName.first().let { it == 'A' || it == 'E' || it == 'I' || it == 'O' || it == 'U' } ->
                    " an"
                else -> " a"
            }
        )
        if (isStyled) append(" styled")
        append(" [$simpleName]")
        if (hasConfiguration) append(" with configuration block")
        if (isAdd) append(" to this manager")
        append('.')
    }

    val parameterSpecs = params.map { param ->
        val className = param.type.asClassName()
        buildParameter(
            param.name,
            className.takeIf { param.defFormat == "null" }?.copy(true) ?: className
        ) {
            if (param.isVararg) addModifiers(KModifier.VARARG)
            defaultValue(param.defFormat, *param.defArgs)
        }
    }

    class Param(
        val name: String,
        val type: KClass<*>,
        val defFormat: String = "null",
        val defArgs: Array<Any> = emptyArray(),
        val isVararg: Boolean = false
    ) {
        constructor(
            name: String,
            type: KClass<*>,
            defFormat: String,
            defArg: Any,
            isVararg: Boolean = false
        ) : this(name, type, defFormat, arrayOf(defArg), isVararg)
    }
}