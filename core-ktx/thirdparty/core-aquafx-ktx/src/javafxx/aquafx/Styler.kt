@file:Suppress("NOTHING_TO_INLINE", "UNCHECKED_CAST")

package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.ControlSizeVariant
import com.aquafx_project.controls.skin.styles.styler.Styler
import javafx.scene.control.Control

inline infix fun <T : Control, S : Styler<T>> S.size(variant: ControlSizeVariant): S = setSizeVariant(variant) as S