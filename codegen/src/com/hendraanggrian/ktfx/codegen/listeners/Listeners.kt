package com.hendraanggrian.ktfx.codegen.listeners

import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.hendraanggrian.kotlinpoet.lambdaBy
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName

val ListenersFactory.Companion.Listeners: ListenersFactory
    get() = object : ListenersFactory(
        "ktfx-listeners/src",
        "ktfx.listeners",
        "FxListenersKt",
        KModifier.INLINE,
        extraFileConfiguration = {
            annotations.add<Suppress> { addMember("%S", "NOTHING_TO_INLINE") }
        }
    ) {

        override fun ParameterSpecListScope.action(vararg params: TypeName): Boolean =
            add("action", Unit::class.asTypeName().lambdaBy(*params), KModifier.NOINLINE)
    }