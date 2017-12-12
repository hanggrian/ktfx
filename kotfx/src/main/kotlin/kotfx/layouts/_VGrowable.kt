package kotfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Priority
import kotfx.internal.ChildManager

internal interface _VGrowable : ChildManager {

    infix fun <T : Node> T.vgrow(priority: Priority): T

    val Node.vgrow2: Priority
}