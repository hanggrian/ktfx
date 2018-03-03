package kotfx.css

import javafx.scene.Cursor
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.effect.BlendMode
import javafx.stage.Stage
import kotfx.css.experimental.style
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.assertEquals

class AppTest : ApplicationTest() {

    private lateinit var label: Label

    override fun start(stage: Stage) {
        label = Label()
        stage.scene = Scene(label)
        stage.show()
    }

    @Test fun asd() {
        label.style = style {
            blendMode = BlendMode.RED
            cursor = Cursor.DISAPPEAR
            opacity = 0.5
        }
        label.applyCss()
        label.layout()

        //assertEquals(label.blendMode, BlendMode.RED)
        assertEquals(label.cursor, Cursor.DISAPPEAR)
        assertEquals(label.opacity, 0.5)
    }
}