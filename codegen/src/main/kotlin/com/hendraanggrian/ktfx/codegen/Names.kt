package com.hendraanggrian.ktfx.codegen

import com.hendraanggrian.kotlinpoet.VARARG
import com.hendraanggrian.kotlinpoet.classNamed
import com.hendraanggrian.kotlinpoet.generics
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.MemberName.Companion.member
import com.squareup.kotlinpoet.ParameterSpec

val KTFX_LAYOUTS = "ktfx.layouts"
val KOTLIN_CONTRACTS = "kotlin.contracts"

val OPT_IN = classNamed("", "OptIn")
val EXPERIMENTAL_CONTRACTS: ClassName = classNamed(KOTLIN_CONTRACTS, "ExperimentalContracts")
val CONTRACT = MemberName(KOTLIN_CONTRACTS, "contract")
val EXACTLY_ONCE = classNamed(KOTLIN_CONTRACTS, "InvocationKind").member("EXACTLY_ONCE")

val DSL_MARKER = classNamed(KTFX_LAYOUTS, "KtfxLayoutDslMarker")

val T = "T".generics
val S = "S".generics
val X = "X".generics
val Y = "Y".generics

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
