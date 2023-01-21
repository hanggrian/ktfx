package ktfx.jfoenix.controls

import com.hendraanggrian.ktfx.test.initToolkit
import com.jfoenix.utils.JFXNodeUtils
import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color.BLACK
import javafx.scene.paint.Color.BLUE
import javafx.scene.paint.Color.RED
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class JfxNodeUtilsTest {
    @BeforeTest
    fun start() = initToolkit()

    @Test
    fun updateBackground() {
        val node = Label("Hello world")
        val placeholderBackground =
            Background(BackgroundFill(BLUE, CornerRadii.EMPTY, Insets.EMPTY))

        node.updateBackground(placeholderBackground)
        assertEquals(BLACK, node.background.fills.first().fill)

        node.updateBackground(placeholderBackground, RED)
        assertEquals(RED, node.background.fills.first().fill)
    }

    @Test
    fun toHex() = assertEquals(BLUE.toHex(), JFXNodeUtils.colorToHex(BLUE))
}
