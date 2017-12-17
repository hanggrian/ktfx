package kotfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Priority

internal interface HGrowable : Constrained {
    infix fun <N : Node> N.hpriority(value: Priority): N
    val Node.hpriority: Priority
}