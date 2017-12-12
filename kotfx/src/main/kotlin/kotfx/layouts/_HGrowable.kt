package kotfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Priority
import kotfx.internal.ChildManager

internal interface _HGrowable : ChildManager {

    infix fun <T : Node> T.hgrow(priority: Priority): T

    val Node.hgrow2: Priority
}