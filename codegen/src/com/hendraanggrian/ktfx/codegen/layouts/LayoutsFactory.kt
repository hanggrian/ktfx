package com.hendraanggrian.ktfx.codegen.layouts

import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.memberOf
import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeVariableName
import com.hendraanggrian.kotlinpoet.dsl.ParameterSpecHandlerScope
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ProgressBar
import javafx.scene.control.TreeItem
import javafx.scene.paint.Color
import java.time.LocalDate
import kotlin.reflect.KClass

open class LayoutsFactory(
    val path: String,
    val packageName: String,
    val className: String
) {
    companion object {
        fun ParameterSpecHandlerScope.text() = "text"(String::class.asNullable()) { defaultValue("null") }
        fun ParameterSpecHandlerScope.graphic() = "graphic"(Node::class.asNullable()) { defaultValue("null") }
        fun ParameterSpecHandlerScope.content() = "content"(Node::class.asNullable()) { defaultValue("null") }
        fun ParameterSpecHandlerScope.progress() =
            "progress"<Double> { defaultValue("%M", ProgressBar::class.memberOf("INDETERMINATE_PROGRESS")) }

        fun ParameterSpecHandlerScope.color() =
            "color"<Color> { defaultValue("%M", Color::class.memberOf("WHITE")) }

        fun ParameterSpecHandlerScope.date() = "date"(LocalDate::class.asNullable()) { defaultValue("null") }

        fun ParameterSpecHandlerScope.items(name: TypeVariableName) =
            "items"(ObservableList::class.parameterizedBy(name)) {
                defaultValue("%M()", FXCollections::class.memberOf("observableArrayList"))
            }

        fun ParameterSpecHandlerScope.treeItem(name: String, variable: TypeVariableName) =
            name(TreeItem::class.parameterizedBy(variable).asNullable()) { defaultValue("null") }

        fun ParameterSpecHandlerScope.slider(value: String) {
            "min"<Double> { defaultValue("0.0") }
            "max"<Double> { defaultValue("100.0") }
            "value"<Double> { defaultValue(value) }
        }
    }

    val entries = mutableListOf<LayoutsEntry>()

    operator fun KClass<*>.invoke(
        vararg typeVariables: TypeVariableName,
        customClass: Boolean = false,
        configuration: ParameterSpecHandlerScope.() -> Unit = { }
    ) {
        val parameters = mutableListOf<ParameterSpec>()
        ParameterSpecHandlerScope(parameters).configuration()
        entries += LayoutsEntry(packageName, this, parameters, typeVariables.asList(), customClass = customClass)
    }
}