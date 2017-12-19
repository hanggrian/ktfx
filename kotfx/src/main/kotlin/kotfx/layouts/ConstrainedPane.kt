package kotfx

import javafx.scene.Node

internal interface ConstrainedPane {
    fun <N : Node> N.reset(): N
}