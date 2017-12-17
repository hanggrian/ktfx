package kotfx.layouts

import javafx.scene.Node

internal interface Constrained {
    fun <N : Node> N.reset(): N
}