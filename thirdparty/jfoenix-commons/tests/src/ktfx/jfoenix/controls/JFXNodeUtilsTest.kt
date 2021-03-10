package ktfx.jfoenix.controls

import com.jfoenix.utils.JFXNodeUtils
import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import io.github.hendraanggrian.ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class JFXNodeUtilsTest {

    @BeforeTest fun start() = initToolkit()

    @Test fun updateBackground() {
        val node = Label("Hello world")
        val placeholderBackground = Background(BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY))

        node.updateBackground(placeholderBackground)
        assertEquals(Color.BLACK, node.background.fills.first().fill)

        node.updateBackground(placeholderBackground, Color.RED)
        assertEquals(Color.RED, node.background.fills.first().fill)
    }

    @Test fun toHex() = assertEquals(Color.BLUE.toHex(), JFXNodeUtils.colorToHex(Color.BLUE))
}