package com.hendraanggrian.ktfx.codegen.coroutines

import com.hendraanggrian.kotlinpoet.FileSpecBuilder
import com.hendraanggrian.kotlinpoet.ParameterSpecHandler
import com.hendraanggrian.kotlinpoet.ParameterSpecHandlerScope
import com.hendraanggrian.kotlinpoet.annotation
import com.hendraanggrian.kotlinpoet.buildParameterSpec
import com.hendraanggrian.kotlinpoet.lambdaBy
import com.hendraanggrian.kotlinpoet.name
import com.hendraanggrian.kotlinpoet.suspending
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.UNIT
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.KClass

open class CoroutinesFactory(
    path: String,
    packageName: String,
    className: String,
) : ListenerFactory(
        path,
        packageName,
        className,
        null,
        buildParameterSpec("context", CoroutineContext::class.name) {
            defaultValue("Dispatchers.JavaFx")
        },
        extraFileConfiguration = {
            annotation(Suppress::class) { member("%S", "ktlint") }
            import("kotlinx.coroutines", "GlobalScope")
            import("kotlinx.coroutines", "Dispatchers")
            import("kotlinx.coroutines", "launch")
            import("kotlinx.coroutines.javafx", "JavaFx")
        },
    ) {
    companion object;

    override fun ParameterSpecHandlerScope.action(vararg params: TypeName): ParameterSpec =
        parameter(
            "action",
            CoroutineScope::class.name.lambdaBy(*params, returns = UNIT).suspending(),
        )
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
                        override fun parameter(parameter: ParameterSpec) {
                            parameters += parameter
                        }
                    },
                )
                .configuration()
            entries += CoroutinesFunctionEntry(this, parameters)
        }
    }
}
