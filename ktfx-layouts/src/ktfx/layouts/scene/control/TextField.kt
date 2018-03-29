@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TextField

inline fun textField(
    text: String = ""
): TextField = textField(text) { }

inline fun textField(
    text: String = "",
    init: (@LayoutDsl TextField).() -> Unit
): TextField = TextField(text).apply(init)

inline fun LayoutManager<Node>.textField(
    text: String = ""
): TextField = textField(text) { }

inline fun LayoutManager<Node>.textField(
    text: String = "",
    init: (@LayoutDsl TextField).() -> Unit
): TextField = ktfx.layouts.textField(text, init).add()