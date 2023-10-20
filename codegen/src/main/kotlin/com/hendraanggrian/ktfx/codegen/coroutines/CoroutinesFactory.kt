package com.hendraanggrian.ktfx.codegen.coroutines

import com.hendraanggrian.kotlinpoet.FileSpecBuilder
import com.hendraanggrian.kotlinpoet.buildParameterSpec
import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.hendraanggrian.kotlinpoet.lambdaBy
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
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
        buildParameterSpec<CoroutineContext>("context") { defaultValue("Dispatchers.JavaFx") },
        extraFileConfiguration = {
            annotations.add<Suppress> { addMember("%S", "ktlint") }
            addImport("kotlinx.coroutines", "GlobalScope")
            addImport("kotlinx.coroutines", "Dispatchers")
            addImport("kotlinx.coroutines", "launch")
            addImport("kotlinx.coroutines.javafx", "JavaFx")
        },
    ) {
    companion object;

    override fun ParameterSpecListScope.action(vararg params: TypeName): ParameterSpec =
        add(
            "action",
            Unit::class.asTypeName().lambdaBy(
                *params,
                receiver = CoroutineScope::class.asTypeName(),
            )
                .copy(suspending = true),
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
        asTypeName().invoke(configuration)

    operator fun TypeName.invoke(configuration: FunctionsFactory.() -> Unit) {
        entries +=
            CoroutinesClassEntry(
                this,
                extraFunctionModifier,
                FunctionsFactory(extraFunctionParameter).apply(configuration).entries,
                extraFileConfiguration,
            )
    }

    inline fun <reified T> ParameterSpecListScope.action(): ParameterSpec =
        action(T::class.asTypeName())

    abstract fun ParameterSpecListScope.action(vararg params: TypeName): ParameterSpec

    class FunctionsFactory(private val extraFunctionParameter: ParameterSpec?) {
        val entries = mutableListOf<CoroutinesFunctionEntry>()

        operator fun String.invoke(configuration: ParameterSpecListScope.() -> Unit = { }) {
            val parameters = listOfNotNull(extraFunctionParameter).toMutableList()
            ParameterSpecListScope(parameters).configuration()
            entries += CoroutinesFunctionEntry(this, parameters)
        }
    }
}
