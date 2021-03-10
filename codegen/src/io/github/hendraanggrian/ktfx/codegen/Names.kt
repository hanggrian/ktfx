package io.github.hendraanggrian.ktfx.codegen

import com.squareup.kotlinpoet.ParameterSpec
import io.github.hendraanggrian.kotlinpoet.VARARG
import io.github.hendraanggrian.kotlinpoet.classOf
import io.github.hendraanggrian.kotlinpoet.memberOf
import io.github.hendraanggrian.kotlinpoet.typeVarOf

const val KTFX_LAYOUTS = "ktfx.layouts"
const val KOTLIN_CONTRACTS = "kotlin.contracts"

val OPT_IN = "".classOf("OptIn")
val EXPERIMENTAL_CONTRACTS = KOTLIN_CONTRACTS.classOf("ExperimentalContracts")
val CONTRACT = KOTLIN_CONTRACTS.memberOf("contract")
val EXACTLY_ONCE = "$KOTLIN_CONTRACTS.InvocationKind".memberOf("EXACTLY_ONCE")

val DSL_MARKER = KTFX_LAYOUTS.classOf("KtfxLayoutDslMarker")

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
            if (VARARG in it.modifiers) {
                val index = s.lastIndexOf(it.name)
                s = s.substring(0, index) + '*' + s.substring(index)
            }
            s
        })
        if (commaSuffix && isNotEmpty()) append(", ")
    }