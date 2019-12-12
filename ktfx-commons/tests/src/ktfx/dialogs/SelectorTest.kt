package ktfx.dialogs

import javafx.scene.image.ImageView
import ktfx.test.DialogShowingTest
import ktfx.test.assertInstance
import org.testfx.api.FxRobot
import kotlin.test.Test
import kotlin.test.assertEquals

class SelectorTest : DialogShowingTest() {

    @Test fun FxRobot.selector() {
        interact {
            assertEquals(
                "Jump off bridge",
                selector<String>(
                    "Choice dialog",
                    ImageView("file:icon.png"),
                    listOf("Jump off bridge", "Live a happy life"),
                    "Live a happy life"
                ) {
                    closeOnShow(this)
                    assertEquals("Choice dialog", headerText)
                    assertInstance<ImageView>(graphic)
                    assertEquals("Live a happy life", defaultChoice)
                    selectedItem = "Jump off bridge"
                }.get()
            )
            assertEquals(
                "Jump off bridge",
                selector<String>(listOf("Jump off bridge", "Live a happy life"), "Live a happy life") {
                    closeOnShow(this)
                    assertEquals("Live a happy life", defaultChoice)
                    selectedItem = "Jump off bridge"
                }.get()
            )
            assertEquals(
                "Jump off bridge",
                selector<String>(
                    "Choice dialog",
                    ImageView("file:icon.png"),
                    "Jump off bridge",
                    "Live a happy life",
                    prefill = "Live a happy life"
                ) {
                    closeOnShow(this)
                    selectedItem = "Jump off bridge"
                }.get()
            )
            assertEquals(
                "Jump off bridge",
                selector("Jump off bridge", "Live a happy life", prefill = "Live a happy life") {
                    closeOnShow(this)
                    selectedItem = "Jump off bridge"
                }.get()
            )
        }
    }
}