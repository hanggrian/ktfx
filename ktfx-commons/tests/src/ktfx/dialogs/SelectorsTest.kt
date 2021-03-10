package ktfx.dialogs

import io.github.hendraanggrian.ktfx.test.DialogShowingTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class SelectorsTest : DialogShowingTest() {

    @Test fun selector() {
        interact {
            assertEquals(
                "Jump off bridge",
                selector<String>(
                    "Selector", sampleGraphic,
                    listOf("Jump off bridge", "Live a happy life"), "Live a happy life"
                ) {
                    closeOnShow(this)
                    assertEquals("Selector", headerText)
                    assertEquals(sampleGraphic, graphic)
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
                    "Selector", sampleGraphic,
                    "Jump off bridge", "Live a happy life", prefill = "Live a happy life"
                ) {
                    closeOnShow(this)
                    assertEquals("Selector", headerText)
                    assertEquals(sampleGraphic, graphic)
                    assertEquals("Live a happy life", defaultChoice)
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
