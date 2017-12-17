package kotfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Priority

internal interface VGrowable : Constrained {
    infix fun <N : Node> N.vpriority(value: Priority): N
    val Node.vpriority: Priority
}