package ktfx.jfoenix.controls

import com.jfoenix.utils.JFXNodeUtils
import javafx.scene.paint.Color
import kotlin.test.Test
import kotlin.test.assertEquals

class JFXNodeUtilsTest {

    @Test fun toHex() = assertEquals(Color.BLUE.toHex(), JFXNodeUtils.colorToHex(Color.BLUE))
}