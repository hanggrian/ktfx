package kotfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Priority

internal interface HGrowable : Constrained {
    infix fun <N : Node> N.hGrow(value: Priority): N
    val Node.hGrow: Priority
}