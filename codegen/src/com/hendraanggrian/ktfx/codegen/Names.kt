package com.hendraanggrian.ktfx.codegen

import com.hendraanggrian.kotlinpoet.classOf
import com.hendraanggrian.kotlinpoet.memberOf
import com.hendraanggrian.kotlinpoet.typeVarOf
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec

const val KTFX_LAYOUTS = "ktfx.layouts"
const val KOTLIN_CONTRACTS = "kotlin.contracts"

val OPT_IN = "".classOf("OptIn")
val EXPERIMENTAL_CONTRACTS = KOTLIN_CONTRACTS.classOf("ExperimentalContracts")
val CONTRACT = KOTLIN_CONTRACTS.memberOf("contract")
val EXACTLY_ONCE = "$KOTLIN_CONTRACTS.InvocationKind".memberOf("EXACTLY_ONCE")

val LAYOUTS_DSL_MARKER = KTFX_LAYOUTS.classOf("LayoutDslMarker")

val T = "T".typeVarOf()
val S = "S".typeVarOf()
val X = "X".typeVarOf()
val Y = "Y".typeVarOf()

fun List<ParameterSpec>.toString(namedArgument: Boolean, commaSuffix: Boolean): String =
    buildString {
        append(joinToString {
            var s = buildString {
                append(it.name)
                if (namedArgument) append(" = ${it.name}")
            }
            if (KModifier.VARARG in it.modifiers) {
                val index = s.lastIndexOf(it.name)
                s = s.substring(0, index) + '*' + s.substring(index)
            }
            s
        })
        if (commaSuffix && isNotEmpty()) append(", ")
    }