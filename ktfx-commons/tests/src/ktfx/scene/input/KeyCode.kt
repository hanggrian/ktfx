package ktfx.scene.input

import javafx.scene.input.KeyCode.BACK_SPACE
import javafx.scene.input.KeyCode.DELETE
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertTrue

@RunWith(JUnitPlatform::class)
object KeyCodeSpec : Spek({

    given("some keycodes") {
        it("backspace and delete should qualify as delete") {
            assertTrue(BACK_SPACE.isDelete())
            assertTrue(DELETE.isDelete())
        }
    }
})