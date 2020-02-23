package ktfx.generator

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.MemberName

const val KTFX_LAYOUTS = "ktfx.layouts"
const val KOTLIN_CONTRACTS = "kotlin.contracts"

val USE_EXPERIMENTAL = ClassName("", "UseExperimental")
val EXPERIMENTAL_CONTRACTS = ClassName(KOTLIN_CONTRACTS, "ExperimentalContracts")
val CONTRACT = MemberName(KOTLIN_CONTRACTS, "contract")
val EXACTLY_ONCE = MemberName("$KOTLIN_CONTRACTS.InvocationKind", "EXACTLY_ONCE")

val NEW_CHILD = MemberName("ktfx.internal.KtfxInternals", "newChild")
val LAYOUTS_DSL_MARKER = ClassName(KTFX_LAYOUTS, "LayoutDslMarker")