package ktfx.inputs

import javafx.scene.input.KeyCode
import kotlin.test.Test
import kotlin.test.assertTrue

class KeyCodeTest {

    @Test fun isDelete() {
        assertTrue(KeyCode.BACK_SPACE.isDelete())
        assertTrue(KeyCode.DELETE.isDelete())
    }
}