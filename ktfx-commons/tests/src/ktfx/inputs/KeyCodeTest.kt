package ktfx.inputs

import javafx.scene.input.KeyCode
import kotlin.test.Test
import kotlin.test.assertTrue

class KeyCodeTest {

    @Test fun isDelete() {
        assertTrue(KeyCode.BACK_SPACE.isDelete())
        assertTrue(KeyCode.DELETE.isDelete())
    }

    @Test fun is0() {
        assertTrue(KeyCode.SOFTKEY_0.is0())
        assertTrue(KeyCode.NUMPAD0.is0())
    }

    @Test fun is1() {
        assertTrue(KeyCode.SOFTKEY_1.is1())
        assertTrue(KeyCode.NUMPAD1.is1())
    }

    @Test fun is2() {
        assertTrue(KeyCode.SOFTKEY_2.is2())
        assertTrue(KeyCode.NUMPAD2.is2())
    }

    @Test fun is3() {
        assertTrue(KeyCode.SOFTKEY_3.is3())
        assertTrue(KeyCode.NUMPAD3.is3())
    }

    @Test fun is4() {
        assertTrue(KeyCode.SOFTKEY_4.is4())
        assertTrue(KeyCode.NUMPAD4.is4())
    }

    @Test fun is5() {
        assertTrue(KeyCode.SOFTKEY_5.is5())
        assertTrue(KeyCode.NUMPAD5.is5())
    }

    @Test fun is6() {
        assertTrue(KeyCode.SOFTKEY_6.is6())
        assertTrue(KeyCode.NUMPAD6.is6())
    }

    @Test fun is7() {
        assertTrue(KeyCode.SOFTKEY_7.is7())
        assertTrue(KeyCode.NUMPAD7.is7())
    }

    @Test fun is8() {
        assertTrue(KeyCode.SOFTKEY_8.is8())
        assertTrue(KeyCode.NUMPAD8.is8())
    }

    @Test fun is9() {
        assertTrue(KeyCode.SOFTKEY_9.is9())
        assertTrue(KeyCode.NUMPAD9.is9())
    }
}