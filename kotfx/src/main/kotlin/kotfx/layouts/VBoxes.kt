@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.scene.layout.VBox

inline fun vBox(init: VBoxBuilder.() -> Unit): VBox = FXVBoxBuilder().apply(init).t

inline fun PaneBuilder<*>.vBox(init: VBoxBuilder.() -> Unit): VBox = FXVBoxBuilder().apply(init).t.apply { this@vBox.children.add(this) }