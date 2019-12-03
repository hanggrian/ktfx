package ktfx.dialogs

import javafx.scene.image.ImageView
import ktfx.test.DialogApplicationTest
import ktfx.test.assertInstance
import kotlin.test.Test
import kotlin.test.assertEquals

class SelectorTest : DialogApplicationTest() {

    @Test fun selector() {
        interact {
            assertEquals(
                "Jump off bridge",
                selector<String>(
                    "Choice dialog",
                    ImageView("file:icon.png"),
                    listOf("Jump off bridge", "Live a happy life"),
                    "Live a happy life"
                ) {
                    closeOnShow()
                    assertEquals("Choice dialog", headerText)
                    assertInstance<ImageView>(graphic)
                    assertEquals("Live a happy life", defaultChoice)
                    selectedItem = "Jump off bridge"
                }.get()
            )
            assertEquals(
                "Jump off bridge",
                selector<String>(listOf("Jump off bridge", "Live a happy life"), "Live a happy life") {
                    closeOnShow()
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
                    closeOnShow()
                    selectedItem = "Jump off bridge"
                }.get()
            )
            assertEquals(
                "Jump off bridge",
                selector("Jump off bridge", "Live a happy life", prefill = "Live a happy life") {
                    closeOnShow()
                    selectedItem = "Jump off bridge"
                }.get()
            )
        }
    }
}