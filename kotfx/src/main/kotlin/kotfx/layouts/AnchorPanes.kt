@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.scene.layout.AnchorPane

inline fun anchorPane(init: AnchorPaneBuilder.() -> Unit): AnchorPane = FXAnchorPaneBuilder().apply(init).t

inline fun PaneBuilder<*>.anchorPane(init: AnchorPaneBuilder.() -> Unit): AnchorPane = FXAnchorPaneBuilder().apply(init).t.apply { this@anchorPane.children.add(this) }