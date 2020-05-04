package com.hendraanggrian.ktfx.codegen.layouts

import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.dsl.ParameterSpecContainer
import com.hendraanggrian.kotlinpoet.dsl.ParameterSpecContainerScope
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
        configuration: ParameterSpecContainerScope.() -> Unit = { }
    ) {
        val parameters = mutableListOf<ParameterSpec>()
        ParameterSpecContainerScope(object : ParameterSpecContainer() {
            override fun add(spec: ParameterSpec) {
                parameters += spec
            }
        }).apply(configuration)
        entries += LayoutsEntry(packageName, this, parameters, typeVariables.asList(), customClass = customClass)
    }

    val T = "T".typeVarOf()
    val S = "S".typeVarOf()
    val X = "X".typeVarOf()
    val Y = "Y".typeVarOf()

    fun ParameterSpecContainerScope.text() = "text"(String::class.asNullable()) { defaultValue("null") }

    fun ParameterSpecContainerScope.graphic() = "graphic"(Node::class.asNullable()) { defaultValue("null") }

    fun ParameterSpecContainerScope.content() = "content"(Node::class.asNullable()) { defaultValue("null") }

    fun ParameterSpecContainerScope.progress() =
        "progress"<Double> { defaultValue("%M", ProgressBar::class.memberOf("INDETERMINATE_PROGRESS")) }

    fun ParameterSpecContainerScope.color() =
        "color"<Color> { defaultValue("%M", Color::class.memberOf("WHITE")) }

    fun ParameterSpecContainerScope.date() = "date"(LocalDate::class.asNullable()) { defaultValue("null") }

    fun ParameterSpecContainerScope.items(name: TypeVariableName) =
        "items"(ObservableList::class.parameterizedBy(name)) {
            defaultValue("%M()", FXCollections::class.memberOf("observableArrayList"))
        }

    fun ParameterSpecContainerScope.treeItem(name: String, variable: TypeVariableName) =
        name(TreeItem::class.parameterizedBy(variable).asNullable()) { defaultValue("null") }

    fun ParameterSpecContainerScope.slider(value: String) {
        "min"<Double> { defaultValue("0.0") }
        "max"<Double> { defaultValue("100.0") }
        "value"<Double> { defaultValue(value) }
    }
}