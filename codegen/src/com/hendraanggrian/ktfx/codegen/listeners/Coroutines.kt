package com.hendraanggrian.ktfx.codegen.listeners

import com.hendraanggrian.kotlinpoet.buildParameterSpec
import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.hendraanggrian.kotlinpoet.lambdaBy
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

val ListenersFactory.Companion.Coroutines: ListenersFactory
    get() = object : ListenersFactory(
        "ktfx-coroutines/src",
        "ktfx.coroutines",
        "FxCoroutinesKt",
        null,
        buildParameterSpec<CoroutineContext>("context") { defaultValue("Dispatchers.JavaFx") },
        {
            addImport("kotlinx.coroutines", "GlobalScope")
            addImport("kotlinx.coroutines", "Dispatchers")
            addImport("kotlinx.coroutines", "launch")
            addImport("kotlinx.coroutines.javafx", "JavaFx")
        }
    ) {

        override fun ParameterSpecListScope.action(vararg params: TypeName): Boolean =
            add(
                "action", Unit::class.asTypeName().lambdaBy(*params, receiver = CoroutineScope::class.asTypeName())
                    .copy(suspending = true)
            )
    }