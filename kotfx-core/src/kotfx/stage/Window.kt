package kotfx.stage

import javafx.stage.Window

fun Window.size(width: Number = this.width, height: Number = this.height) {
    this.width = width.toDouble()
    this.height = height.toDouble()
}