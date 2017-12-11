@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts.nodes

import javafx.scene.control.Label
import kotfx.layouts.PaneBuilder

@JvmOverloads
inline fun PaneBuilder<*>.label(
        text: String? = null,
        noinline init: (LabelBuilder.() -> Unit)? = null
): Label = FXLabelBuilder(text).apply { if (init != null) init() }.t.apply { children.add(this) }