package com.hendraanggrian.ktfx.codegen.layouts

import com.hendraanggrian.kotlinpoet.classNamed
import com.hendraanggrian.kotlinpoet.name
import com.hendraanggrian.ktfx.codegen.KTFX_LAYOUTS
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeVariableName
import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import javafx.scene.control.Tab
import javafx.scene.control.TitledPane
import javafx.scene.control.ToggleButton
import javafx.scene.shape.PathElement
import kotlin.reflect.KClass
import kotlin.reflect.full.isSuperclassOf

data class LayoutsEntry(
    private val packageName: String,
    val kClass: KClass<*>,
    val parameters: List<ParameterSpec>,
    val typeVarNames: List<TypeVariableName>,
    private val customClass: Boolean,
) {
    private companion object {
        val VALID_CONTAINERS: Set<KClass<*>> =
            setOf(
                MenuItem::class,
                Menu::class,
                Node::class,
                PathElement::class,
                Tab::class,
                TitledPane::class,
                ToggleButton::class,
            )
    }

    private val simpleName: String get() = kClass.simpleName!!

    val generatedName: String get() = "_$simpleName"

    val typeName: TypeName
        get() {
            val name = kClass.name
            return name.takeIf { typeVarNames.isEmpty() } ?: name.parameterizedBy(typeVarNames)
        }

    val customTypeName: TypeName
        get() =
            typeName.takeUnless { customClass } ?: classNamed(
                packageName,
                when {
                    simpleName.startsWith("JFX") -> "KtfxJfx${simpleName.substringAfter("JFX")}"
                    else -> "Ktfx$simpleName"
                },
            )

    val containerClassNames: List<ClassName>
        get() =
            VALID_CONTAINERS.filter { it == kClass || it.isSuperclassOf(kClass) }
                .map { classNamed(KTFX_LAYOUTS, "${it.simpleName}Container") }

    val fullContainerClassNames: List<ClassName?>
        get() = listOf(null, *containerClassNames.toTypedArray())

    val functionName: String
        get() =
            simpleName.mapIndexed { index, c ->
                when {
                    index == 0 || index == 1 -> c.lowercaseChar()
                    c.isUpperCase() && simpleName.getOrNull(index + 1)
                        ?.isUpperCase() ?: false -> c.lowercaseChar()
                    else -> c
                }
            }.joinToString("")

    val styledFunctionName: String get() = "styled$simpleName"

    val supportStyledFunction: Boolean
        get() =
            classNamed("ktfx.layouts", "PathElementContainer") !in containerClassNames

    fun getFileComment(add: Boolean, styled: Boolean, configured: Boolean): String =
        buildString {
            append(if (!add) "Create" else "Add")
            append(
                when {
                    !styled &&
                        simpleName.first()
                            .let { it == 'A' || it == 'E' || it == 'I' || it == 'O' || it == 'U' }
                    -> " an"
                    else -> " a"
                },
            )
            if (styled) append(" styled")
            append(" [$simpleName]")
            if (configured) append(" with configuration block")
            if (add) append(" to this container")
            append('.')
        }

    fun getReturnsComment(add: Boolean, styled: Boolean): String =
        buildString {
            append("the")
            if (styled) append(" styled")
            append(" control")
            append(
                when {
                    add -> " added"
                    else -> " created"
                },
            )
            append('.')
        }
}
