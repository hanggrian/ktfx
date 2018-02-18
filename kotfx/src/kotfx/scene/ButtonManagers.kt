@file:JvmMultifileClass
@file:JvmName("ManagersKt")

package kotfx.scene

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ButtonBar

interface ButtonManager {

    fun getButtons(): ObservableList<Node>

    fun <T : Node> T.add(): T = apply { getButtons().add(this) }
}

class _ButtonBar(buttonOrder: String? = null) : ButtonBar(buttonOrder), ButtonManager