package ktfx.scene

import javafx.scene.Node
import javafx.scene.layout.Pane
import javafx.scene.layout.Region

fun Node.asRegion(): Region = this as? Region ?: Pane(this)