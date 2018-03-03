package kotfx.css

import javafx.scene.Cursor
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.effect.BlendMode
import javafx.scene.layout.BorderPane
import javafx.stage.Stage
import org.junit.Assert.assertEquals
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest

class AppTest : ApplicationTest() {

    private lateinit var label: Label

    override fun start(stage: Stage) {
        label = Label()
        stage.scene = Scene(BorderPane(label))
        stage.show()
    }

    @Test fun asd() {
        label.style = nodeStyle {
            blendMode = BlendMode.GREEN
            cursor = Cursor.DISAPPEAR
        }
        label.applyCss()
        label.layout()

        //assertEquals(label.blendMode, BlendMode.GREEN)
        assertEquals(label.cursor, Cursor.DISAPPEAR)
    }
}