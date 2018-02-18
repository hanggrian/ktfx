@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene

import javafx.scene.control.Control
import javafx.scene.control.Tooltip
import kotfx.annotations.SceneDsl

inline fun tooltip(text: String? = null, noinline init: ((@SceneDsl Tooltip).() -> Unit)? = null): Tooltip = Tooltip(text).apply { init?.invoke(this) }

inline fun Control.tooltip(text: String? = null, noinline init: ((@SceneDsl Tooltip).() -> Unit)? = null) = setTooltip(Tooltip(text).apply { init?.invoke(this) })