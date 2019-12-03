package ktfx.inputs

import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import ktfx.test.InputApplicationTest
import kotlin.test.Test
import kotlin.test.assertTrue

class MouseEventTest : InputApplicationTest() {

    @Test fun isLeftClick() = assertTrue {
        mouseEventOf(MouseEvent.MOUSE_CLICKED, sceneMouseX, sceneMouseY, MouseButton.PRIMARY, 1).isLeftClick()
    }

    @Test fun isRightClick() = assertTrue {
        mouseEventOf(MouseEvent.MOUSE_CLICKED, sceneMouseX, sceneMouseY, MouseButton.SECONDARY, 1).isRightClick()
    }

    @Test fun isMiddleClick() = assertTrue {
        mouseEventOf(MouseEvent.MOUSE_CLICKED, sceneMouseX, sceneMouseY, MouseButton.MIDDLE, 1).isMiddleClick()
    }

    @Test fun isDoubleClick() = assertTrue {
        mouseEventOf(MouseEvent.MOUSE_CLICKED, sceneMouseX, sceneMouseY, MouseButton.PRIMARY, 2).isDoubleClick()
    }
}