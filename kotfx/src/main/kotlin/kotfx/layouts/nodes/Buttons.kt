@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts.nodes

import javafx.scene.control.Button
import kotfx.layouts.PaneBuilder

@JvmOverloads
inline fun PaneBuilder<*>.button(
        text: String? = null,
        noinline init: (ButtonBuilder.() -> Unit)? = null
): Button = FXButtonBuilder(text).apply { if (init != null) init() }.t.apply { children.add(this) }