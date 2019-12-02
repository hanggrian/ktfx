package ktfx.dialogs

import com.google.common.truth.Truth
import javafx.scene.control.ChoiceDialog
import javafx.scene.image.ImageView
import javafx.scene.input.KeyCode
import ktfx.test.assertInstance
import org.junit.Ignore
import kotlin.test.assertEquals

@Ignore("Error when executed from terminal, test manually instead")
class SelectorTest : ShowDialogTest() {
    private val selectorsWithTitle = mutableListOf<ChoiceDialog<String>>()
    private val selectors = mutableListOf<ChoiceDialog<String>>()
    private val selectorResults = mutableSetOf<String>()

    override fun show() {
        selectorResults += selector<String>(
            "Choice dialog",
            ImageView("file:icon.png"),
            listOf("Jump off bridge", "Live a happy life"),
            "Live a happy life"
        ) {
            selectorsWithTitle += this
            selectedItem = "Jump off bridge"
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        selectorResults += selector<String>(listOf("Jump off bridge", "Live a happy life"), "Live a happy life") {
            selectors += this
            selectedItem = "Jump off bridge"
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        selectorResults += selector<String>(
            "Choice dialog",
            ImageView("file:icon.png"),
            "Jump off bridge",
            "Live a happy life",
            prefill = "Live a happy life"
        ) {
            selectorsWithTitle += this
            selectedItem = "Jump off bridge"
            setOnShown { push(KeyCode.ENTER) }
        }.get()
        selectorResults += selector("Jump off bridge", "Live a happy life", prefill = "Live a happy life") {
            selectors += this
            selectedItem = "Jump off bridge"
            setOnShown { push(KeyCode.ENTER) }
        }.get()
    }

    override fun test() {
        selectorsWithTitle.forEach {
            assertEquals("Choice dialog", it.headerText)
            assertInstance<ImageView>(it.graphic)
            assertEquals("Live a happy life", it.defaultChoice)
        }
        selectors.forEach {
            assertEquals("Live a happy life", it.defaultChoice)
        }
        Truth.assertThat(selectorResults).containsExactly("Jump off bridge")
    }
}