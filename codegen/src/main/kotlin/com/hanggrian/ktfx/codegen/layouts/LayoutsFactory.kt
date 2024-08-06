package com.hanggrian.ktfx.codegen.layouts

import com.hanggrian.kotlinpoet.ParameterSpecHandler
import com.hanggrian.kotlinpoet.ParameterSpecHandlerScope
import com.hanggrian.kotlinpoet.name
import com.hanggrian.kotlinpoet.nullable
import com.squareup.kotlinpoet.DOUBLE
import com.squareup.kotlinpoet.MemberName.Companion.member
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeVariableName
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ProgressBar
import javafx.scene.control.TreeItem
import javafx.scene.paint.Color
import java.time.LocalDate
import kotlin.reflect.KClass

open class LayoutsFactory(val path: String, val packageName: String, val className: String) {
    val entries = mutableListOf<LayoutsEntry>()

    operator fun KClass<*>.invoke(
        vararg typeVariables: TypeVariableName,
        customClass: Boolean = false,
        configuration: ParameterSpecHandlerScope.() -> Unit = { },
    ) {
        val parameters = mutableListOf<ParameterSpec>()
        ParameterSpecHandlerScope
            .of(
                object : ParameterSpecHandler {
                    override fun parameter(parameter: ParameterSpec) {
                        parameters += parameter
                    }
                },
            ).configuration()
        entries +=
            LayoutsEntry(
                packageName,
                this,
                parameters,
                typeVariables.asList(),
                isCustomClass = customClass,
            )
    }

    companion object {
        fun ParameterSpecHandlerScope.text() = "text"(STRING.nullable()) { defaultValue("null") }

        fun ParameterSpecHandlerScope.graphic() =
            "graphic"(Node::class.name.nullable()) { defaultValue("null") }

        fun ParameterSpecHandlerScope.content() =
            "content"(Node::class.name.nullable()) { defaultValue("null") }

        fun ParameterSpecHandlerScope.progress() =
            "progress"(DOUBLE) {
                defaultValue(
                    "%M",
                    ProgressBar::class.name.member("INDETERMINATE_PROGRESS"),
                )
            }

        fun ParameterSpecHandlerScope.color() =
            "color"(Color::class.name) {
                defaultValue("%M", Color::class.name.member("WHITE"))
            }

        fun ParameterSpecHandlerScope.date() =
            "date"(LocalDate::class.name.nullable()) { defaultValue("null") }

        fun ParameterSpecHandlerScope.items(name: TypeVariableName) =
            "items"(ObservableList::class.name.parameterizedBy(name)) {
                defaultValue(
                    "%M()",
                    FXCollections::class.name.member("observableArrayList"),
                )
            }

        fun ParameterSpecHandlerScope.treeItem(name: String, variable: TypeVariableName) =
            name(TreeItem::class.name.parameterizedBy(variable).copy(true)) {
                defaultValue("null")
            }

        fun ParameterSpecHandlerScope.slider(value: String) {
            "min"(DOUBLE) { defaultValue("0.0") }
            "max"(DOUBLE) { defaultValue("100.0") }
            "value"(DOUBLE) { defaultValue(value) }
        }
    }
}
