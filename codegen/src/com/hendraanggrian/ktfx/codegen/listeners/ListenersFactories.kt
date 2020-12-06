package com.hendraanggrian.ktfx.codegen.listeners

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

open class ListenersFactory(
    path: String,
    packageName: String,
    className: String
) : BaseListenersFactory(
    path,
    packageName,
    className,
    KModifier.INLINE,
    extraFileConfiguration = {
        annotations.add<Suppress> { addMember("%S", "NOTHING_TO_INLINE") }
    }
) {
    companion object;

    override fun ParameterSpecListScope.action(vararg params: TypeName): Boolean =
        add("action", Unit::class.asTypeName().lambdaBy(*params), KModifier.NOINLINE)
}

open class CoroutinesFactory(
    path: String,
    packageName: String,
    className: String
) : BaseListenersFactory(
    path,
    packageName,
    className,
    null,
    buildParameterSpec<CoroutineContext>("context") { defaultValue("Dispatchers.JavaFx") },
    {
        addImport("kotlinx.coroutines", "GlobalScope")
        addImport("kotlinx.coroutines", "Dispatchers")
        addImport("kotlinx.coroutines", "launch")
        addImport("kotlinx.coroutines.javafx", "JavaFx")
    }
) {
    companion object;

    override fun ParameterSpecListScope.action(vararg params: TypeName): Boolean =
        add(
            "action", Unit::class.asTypeName().lambdaBy(*params, receiver = CoroutineScope::class.asTypeName())
                .copy(suspending = true)
        )
}

abstract class BaseListenersFactory(
    val path: String,
    val packageName: String,
    val className: String,
    val extraFunctionModifier: KModifier? = null,
    private val extraFunctionParameter: ParameterSpec? = null,
    val extraFileConfiguration: FileSpecBuilder.() -> Unit = { }
) {
    val entries = mutableListOf<ListenersClassEntry>()

    operator fun KClass<*>.invoke(configuration: FunctionsFactory.() -> Unit) = asTypeName().invoke(configuration)

    operator fun TypeName.invoke(configuration: FunctionsFactory.() -> Unit) {
        entries += ListenersClassEntry(
            this,
            extraFunctionModifier,
            FunctionsFactory(extraFunctionParameter).apply(configuration).entries,
            extraFileConfiguration
        )
    }

    inline fun <reified Type> ParameterSpecListScope.action(): Boolean = action(Type::class.asTypeName())

    abstract fun ParameterSpecListScope.action(vararg params: TypeName): Boolean

    class FunctionsFactory(private val extraFunctionParameter: ParameterSpec?) {
        val entries = mutableListOf<ListenersFunctionEntry>()

        operator fun String.invoke(configuration: ParameterSpecListScope.() -> Unit = { }) {
            val parameters = listOfNotNull(extraFunctionParameter).toMutableList()
            ParameterSpecListScope(parameters).configuration()
            entries += ListenersFunctionEntry(this, parameters)
        }
    }
}