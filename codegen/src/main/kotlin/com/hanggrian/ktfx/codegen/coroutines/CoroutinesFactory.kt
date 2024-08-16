package com.hanggrian.ktfx.codegen.coroutines

import com.hanggrian.kotlinpoet.FileSpecBuilder
import com.hanggrian.kotlinpoet.ParameterSpecHandler
import com.hanggrian.kotlinpoet.ParameterSpecHandlerScope
import com.hanggrian.kotlinpoet.add
import com.hanggrian.kotlinpoet.buildParameterSpec
import com.hanggrian.kotlinpoet.lambdaBy
import com.hanggrian.kotlinpoet.name
import com.hanggrian.kotlinpoet.suspending
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.UNIT
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.KClass

open class CoroutinesFactory(path: String, packageName: String, className: String) :
    ListenerFactory(
        path,
        packageName,
        className,
        null,
        buildParameterSpec("context", CoroutineContext::class.name) {
            setDefaultValue("Dispatchers.JavaFx")
        },
        extraFileConfiguration = {
            annotations.add(Suppress::class) {
                addMember("%S", "ktlint")
                useSiteTarget = AnnotationSpec.UseSiteTarget.FILE
            }
            addImport("kotlinx.coroutines", "DelicateCoroutinesApi")
            addImport("kotlinx.coroutines", "GlobalScope")
            addImport("kotlinx.coroutines", "Dispatchers")
            addImport("kotlinx.coroutines", "launch")
            addImport("kotlinx.coroutines.javafx", "JavaFx")
        },
    ) {
    override fun ParameterSpecHandlerScope.action(vararg params: TypeName): ParameterSpec =
        add(
            "action",
            CoroutineScope::class.name.lambdaBy(*params, returns = UNIT).suspending(),
        )

    companion object;
}

abstract class ListenerFactory(
    val path: String,
    val packageName: String,
    val className: String,
    val extraFunctionModifier: KModifier? = null,
    private val extraFunctionParameter: ParameterSpec? = null,
    val extraFileConfiguration: FileSpecBuilder.() -> Unit = { },
) {
    val entries = mutableListOf<CoroutinesClassEntry>()

    operator fun KClass<*>.invoke(configuration: FunctionsFactory.() -> Unit) =
        name.invoke(configuration)

    operator fun TypeName.invoke(configuration: FunctionsFactory.() -> Unit) {
        entries +=
            CoroutinesClassEntry(
                this,
                extraFunctionModifier,
                FunctionsFactory(extraFunctionParameter).apply(configuration).entries,
                extraFileConfiguration,
            )
    }

    inline fun <reified T> ParameterSpecHandlerScope.action(): ParameterSpec = action(T::class.name)

    abstract fun ParameterSpecHandlerScope.action(vararg params: TypeName): ParameterSpec

    class FunctionsFactory(private val extraFunctionParameter: ParameterSpec?) {
        val entries = mutableListOf<CoroutinesFunctionEntry>()

        operator fun String.invoke(configuration: ParameterSpecHandlerScope.() -> Unit = { }) {
            val parameters = listOfNotNull(extraFunctionParameter).toMutableList()
            ParameterSpecHandlerScope
                .of(
                    object : ParameterSpecHandler {
                        override fun add(parameter: ParameterSpec) {
                            parameters += parameter
                        }
                    },
                ).configuration()
            entries += CoroutinesFunctionEntry(this, parameters)
        }
    }
}
