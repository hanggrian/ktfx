package ktfx.generator

import com.squareup.kotlinpoet.ClassName

const val KTFX_LAYOUTS = "ktfx.layouts"

val USE_EXPERIMENTAL = ClassName("", "UseExperimental")

val LAYOUTS_DSL_MARKER = ClassName(KTFX_LAYOUTS, "LayoutDslMarker")
val NODE_MANAGER = ClassName(KTFX_LAYOUTS, "NodeManager")