@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.geometry.Orientation
import javafx.scene.Node
import javafx.scene.control.SplitPane

class _SplitPane(vararg items: Node) : SplitPane(*items), _Control<SplitPane> {
    override val node: SplitPane get() = this

    fun orientation(value:Orientation)=setOrientation(value)
    //fun dividerPosition()
}