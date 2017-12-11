@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.scene.layout.AnchorPane

inline fun anchorPane(init: AnchorPaneBuilder.() -> Unit): AnchorPane = FXAnchorPaneBuilder().apply(init).t