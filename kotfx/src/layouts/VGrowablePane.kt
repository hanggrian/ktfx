package kotfx

import javafx.scene.Node
import javafx.scene.layout.Priority

internal interface VGrowablePane : ConstrainedPane {
    infix fun <N : Node> N.vpriority(value: Priority): N
    val Node.vpriority: Priority
}