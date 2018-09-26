package ktfx.scene.input

import javafx.scene.input.KeyCode.BACK_SPACE
import javafx.scene.input.KeyCode.DELETE
import org.junit.Test
import kotlin.test.assertTrue

class KeyCodeTest {

    @Test fun isDelete() {
        assertTrue(BACK_SPACE.isDelete())
        assertTrue(DELETE.isDelete())
    }
}