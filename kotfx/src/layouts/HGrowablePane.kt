package kotfx

import javafx.scene.Node
import javafx.scene.layout.Priority

internal interface HGrowablePane : ConstrainedPane {
    infix fun <N : Node> N.hpriority(value: Priority): N
    val Node.hpriority: Priority
}