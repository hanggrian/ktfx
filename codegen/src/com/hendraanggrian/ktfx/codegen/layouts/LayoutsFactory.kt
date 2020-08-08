package com.hendraanggrian.ktfx.codegen.layouts

import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.hendraanggrian.kotlinpoet.memberOf
import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.hendraanggrian.kotlinpoet.typeVarOf
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeVariableName
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ProgressBar
import javafx.scene.control.TreeItem
import javafx.scene.paint.Color
import java.time.LocalDate
import kotlin.reflect.KClass

abstract class LayoutsFactory(
    val path: String,
    val packageName: String,
    val className: String
) {

    companion object

    val entries = mutableListOf<LayoutsEntry>()

    operator fun KClass<*>.invoke(
        vararg typeVariables: TypeVariableName,
        customClass: Boolean = false,
        configuration: ParameterSpecListScope.() -> Unit = { }
    ) {
        val parameters = mutableListOf<ParameterSpec>()
        ParameterSpecListScope(parameters).apply(configuration)
        entries += LayoutsEntry(packageName, this, parameters, typeVariables.asList(), customClass = customClass)
    }

    val T = "T".typeVarOf()
    val S = "S".typeVarOf()
    val X = "X".typeVarOf()
    val Y = "Y".typeVarOf()

    fun ParameterSpecListScope.text() = "text"(String::class.asNullable()) { defaultValue("null") }

    fun ParameterSpecListScope.graphic() = "graphic"(Node::class.asNullable()) { defaultValue("null") }

    fun ParameterSpecListScope.content() = "content"(Node::class.asNullable()) { defaultValue("null") }

    fun ParameterSpecListScope.progress() =
        "progress"<Double> { defaultValue("%M", ProgressBar::class.memberOf("INDETERMINATE_PROGRESS")) }

    fun ParameterSpecListScope.color() =
        "color"<Color> { defaultValue("%M", Color::class.memberOf("WHITE")) }

    fun ParameterSpecListScope.date() = "date"(LocalDate::class.asNullable()) { defaultValue("null") }

    fun ParameterSpecListScope.items(name: TypeVariableName) =
        "items"(ObservableList::class.parameterizedBy(name)) {
            defaultValue("%M()", FXCollections::class.memberOf("observableArrayList"))
        }

    fun ParameterSpecListScope.treeItem(name: String, variable: TypeVariableName) =
        name(TreeItem::class.parameterizedBy(variable).asNullable()) { defaultValue("null") }

    fun ParameterSpecListScope.slider(value: String) {
        "min"<Double> { defaultValue("0.0") }
        "max"<Double> { defaultValue("100.0") }
        "value"<Double> { defaultValue(value) }
    }
}