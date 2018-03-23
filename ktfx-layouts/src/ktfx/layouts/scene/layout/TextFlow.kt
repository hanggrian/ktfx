package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.TextFlow

@Suppress("ClassName")
open class _TextFlow : TextFlow(), ChildManager

inline fun textFlow(init: (@LayoutDsl _TextFlow).() -> Unit): TextFlow = _TextFlow().apply(init)

inline fun Manager<Node>.textFlow(init: (@LayoutDsl _TextFlow).() -> Unit): TextFlow = ktfx.layouts.textFlow(init).add()