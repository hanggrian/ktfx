package kotfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Priority

internal interface VGrowable : Constrained {
    infix fun <N : Node> N.vGrow(value: Priority): N
    val Node.vGrow: Priority
}