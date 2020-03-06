package ktfx.generator

import com.hendraanggrian.kotlinpoet.classOf
import com.hendraanggrian.kotlinpoet.memberOf

const val KTFX_LAYOUTS = "ktfx.layouts"
const val KOTLIN_CONTRACTS = "kotlin.contracts"

val OPT_IN = "".classOf("OptIn")
val EXPERIMENTAL_CONTRACTS = KOTLIN_CONTRACTS.classOf("ExperimentalContracts")
val CONTRACT = KOTLIN_CONTRACTS.memberOf("contract")
val EXACTLY_ONCE = "$KOTLIN_CONTRACTS.InvocationKind".memberOf("EXACTLY_ONCE")

val NEW_CHILD = "ktfx.internal.KtfxInternals".memberOf("newChild")
val LAYOUTS_DSL_MARKER = KTFX_LAYOUTS.classOf("LayoutDslMarker")