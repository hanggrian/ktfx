package ktfx.stage

import javafx.stage.Stage
import ktfx.test.AppTest
import org.junit.Test
import kotlin.test.assertEquals

class StageTest : AppTest() {

    private lateinit var stage: Stage

    override fun start(stage: Stage) {
        this.stage = stage("Title") {
        }
    }

    @Test fun stage() {
        assertEquals("Title", stage.title)
    }
}