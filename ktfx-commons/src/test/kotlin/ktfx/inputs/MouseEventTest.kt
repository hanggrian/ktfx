package ktfx.inputs

import com.hendraanggrian.ktfx.test.InputTest
import javafx.scene.input.MouseButton.MIDDLE
import javafx.scene.input.MouseButton.PRIMARY
import javafx.scene.input.MouseButton.SECONDARY
import javafx.scene.input.MouseEvent.MOUSE_CLICKED
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertTrue

@Ignore
class MouseEventTest : InputTest() {
    @Test
    fun isLeftClick() =
        assertTrue {
            mouseEventOf(MOUSE_CLICKED, sceneMouseX, sceneMouseY, PRIMARY, 1).isLeftClick()
        }

    @Test
    fun isRightClick() =
        assertTrue {
            mouseEventOf(MOUSE_CLICKED, sceneMouseX, sceneMouseY, SECONDARY, 1).isRightClick()
        }

    @Test
    fun isMiddleClick() =
        assertTrue {
            mouseEventOf(MOUSE_CLICKED, sceneMouseX, sceneMouseY, MIDDLE, 1).isMiddleClick()
        }

    @Test
    fun isDoubleClick() =
        assertTrue {
            mouseEventOf(MOUSE_CLICKED, sceneMouseX, sceneMouseY, PRIMARY, 2).isDoubleClick()
        }
}
