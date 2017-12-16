@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.scene.text.TextFlow
import kotfx.internal.LayoutDsl

class _TextFlow : TextFlow(), ChildManager

inline fun textFlow(init: (@LayoutDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init)
inline fun ChildManager.textFlow(init: (@LayoutDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()