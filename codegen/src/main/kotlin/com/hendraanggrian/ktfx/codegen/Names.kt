package com.hendraanggrian.ktfx.codegen

import com.hendraanggrian.kotlinpoet.VARARG
import com.hendraanggrian.kotlinpoet.classNameOf
import com.hendraanggrian.kotlinpoet.genericsBy
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.MemberName.Companion.member
import com.squareup.kotlinpoet.ParameterSpec

val KTFX_LAYOUTS = "ktfx.layouts"
val KOTLIN_CONTRACTS = "kotlin.contracts"

val OPT_IN = classNameOf("", "OptIn")
val EXPERIMENTAL_CONTRACTS: ClassName = classNameOf(KOTLIN_CONTRACTS, "ExperimentalContracts")
val CONTRACT = MemberName(KOTLIN_CONTRACTS, "contract")
val EXACTLY_ONCE = classNameOf(KOTLIN_CONTRACTS, "InvocationKind").member("EXACTLY_ONCE")

val DSL_MARKER = classNameOf(KTFX_LAYOUTS, "KtfxLayoutDslMarker")

val T = "T".genericsBy()
val S = "S".genericsBy()
val X = "X".genericsBy()
val Y = "Y".genericsBy()

fun List<ParameterSpec>.toString(namedArgument: Boolean, commaSuffix: Boolean): String =
    buildString {
        append(
            joinToString {
                var s =
                    buildString {
                        append(it.name)
                        if (namedArgument) append(" = ${it.name}")
                    }
                if (VARARG in it.modifiers) {
                    val index = s.lastIndexOf(it.name)
                    s = s.substring(0, index) + '*' + s.substring(index)
                }
                s
            },
        )
        if (commaSuffix && isNotEmpty()) append(", ")
    }
