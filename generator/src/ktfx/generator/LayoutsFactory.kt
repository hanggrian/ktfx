package ktfx.generator

import com.hendraanggrian.kotlinpoet.buildParameter
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.asClassName
import javafx.scene.Node
import javafx.scene.control.Accordion
import javafx.scene.control.Button
import kotlin.reflect.KClass

enum class LayoutsFactory(
    val kClass: KClass<*>,
    val managerClassName: ClassName,
    private vararg val params: Param,
    private val hasCustomClass: Boolean = false
) {
    ACCORDION(Accordion::class, NODE_MANAGER, hasCustomClass = true),
    BUTTON(Button::class, NODE_MANAGER, Param("text", String::class), Param("graphic", Node::class));

    val customClassName: ClassName
        get() = when {
            hasCustomClass -> ClassName(KTFX_LAYOUTS, "Ktfx$simpleName")
            else -> kClass.asClassName()
        }

    val simpleName: String get() = kClass.simpleName!!

    val functionName: String = simpleName.first().toLowerCase() + simpleName.substring(1)

    val styledFunctionName: String = "styled${simpleName}"

    fun getComment(hasReceiver: Boolean = false, isStyled: Boolean = false, hasConfiguration: Boolean = false): String {
        val firstChar = simpleName.first()
        return buildString {
            append(if (!hasReceiver) "Create" else "Add")
            append(
                when {
                    !isStyled && (firstChar == 'A' || firstChar == 'E' || firstChar == 'I' || firstChar == 'O' || firstChar == 'U') ->
                        " an"
                    else -> " a"
                }
            )
            if (isStyled) append(" styled")
            append(" [$simpleName]")
            if (hasConfiguration) append(" with configuration block")
            if (hasReceiver) append(" to this manager")
            append('.')
        }
    }

    val parameterSpecs: List<ParameterSpec>
        get() = params.map { param ->
            val className = param.type.asClassName()
            buildParameter(
                param.name,
                className.takeIf { param.defFormat == "null" }?.copy(true) ?: className
            ) {
                if (param.isVararg) addModifiers(KModifier.VARARG)
                defaultValue(param.defFormat, *param.defArgs)
            }
        }

    data class Param(
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