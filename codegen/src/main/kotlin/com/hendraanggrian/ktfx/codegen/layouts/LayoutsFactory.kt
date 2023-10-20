package com.hendraanggrian.ktfx.codegen.layouts

import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.squareup.kotlinpoet.MemberName.Companion.member
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.asTypeName
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
    val className: String,
) {
    companion object {
        fun ParameterSpecListScope.text() =
            "text"(String::class.asTypeName().copy(true)) { defaultValue("null") }

        fun ParameterSpecListScope.graphic() =
            "graphic"(Node::class.asTypeName().copy(true)) { defaultValue("null") }

        fun ParameterSpecListScope.content() =
            "content"(Node::class.asTypeName().copy(true)) { defaultValue("null") }

        fun ParameterSpecListScope.progress() =
            add<Double>("progress") {
                defaultValue(
                    "%M",
                    ProgressBar::class.asClassName().member("INDETERMINATE_PROGRESS"),
                )
            }

        fun ParameterSpecListScope.color() =
            add<Color>("color") { defaultValue("%M", Color::class.asClassName().member("WHITE")) }

        fun ParameterSpecListScope.date() =
            "date"(LocalDate::class.asTypeName().copy(true)) { defaultValue("null") }

        fun ParameterSpecListScope.items(name: TypeVariableName) =
            "items"(ObservableList::class.asClassName().parameterizedBy(name)) {
                defaultValue(
                    "%M()",
                    FXCollections::class.asClassName().member("observableArrayList"),
                )
            }

        fun ParameterSpecListScope.treeItem(name: String, variable: TypeVariableName) =
            name(TreeItem::class.asClassName().parameterizedBy(variable).copy(true)) {
                defaultValue("null")
            }

        fun ParameterSpecListScope.slider(value: String) {
            add<Double>("min") { defaultValue("0.0") }
            add<Double>("max") { defaultValue("100.0") }
            add<Double>("value") { defaultValue(value) }
        }
    }

    val entries = mutableListOf<LayoutsEntry>()

    operator fun KClass<*>.invoke(
        vararg typeVariables: TypeVariableName,
        customClass: Boolean = false,
        configuration: ParameterSpecListScope.() -> Unit = { },
    ) {
        val parameters = mutableListOf<ParameterSpec>()
        ParameterSpecListScope(parameters).configuration()
        entries +=
            LayoutsEntry(
                packageName,
                this,
                parameters,
                typeVariables.asList(),
                customClass = customClass,
            )
    }
}
