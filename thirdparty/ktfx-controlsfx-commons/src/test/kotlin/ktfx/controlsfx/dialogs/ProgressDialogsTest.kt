package ktfx.controlsfx.dialogs

import com.hanggrian.ktfx.test.DialogShowingTest
import javafx.concurrent.Service
import javafx.stage.Stage
import ktfx.buildService
import ktfx.dialogs.graphicIcon
import ktfx.dialogs.headerTitle
import ktfx.dialogs.icon
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

@Ignore
class ProgressDialogsTest : DialogShowingTest() {
    private lateinit var helloWorldService: Service<String>

    override fun start(stage: Stage) {
        super.start(stage)
        helloWorldService = buildService { call { "Hello world" } }
    }

    @Test
    fun exceptionDialog() {
        interact {
            progressDialog(helloWorldService) {
                headerTitle = "Progress dialog"
                graphicIcon = sampleGraphic

                closeOnShow(this)
                assertEquals("Progress dialog", headerText)
                assertEquals("Progress dialog", title)
                assertEquals(sampleGraphic, graphic)
                assertEquals(sampleGraphic.image, icon)
            }.get()
        }
    }
}
