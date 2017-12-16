@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.scene.text.TextFlow
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.LayoutDsl

class _TextFlow : TextFlow(), ChildManager

inline fun textFlowOf(init: (@LayoutDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init)
inline fun ChildManager.textFlow(init: (@LayoutDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()
inline fun ItemManager.textFlow(init: (@LayoutDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init).add()