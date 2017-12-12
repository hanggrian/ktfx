@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.scene.layout.BorderPane

inline fun borderPane(init: BorderPaneBuilder.() -> Unit): BorderPane = FXBorderPaneBuilder().apply(init).t

inline fun PaneBuilder<*>.borderPane(init: BorderPaneBuilder.() -> Unit): BorderPane = FXBorderPaneBuilder().apply(init).t.apply { this@borderPane.children.add(this) }