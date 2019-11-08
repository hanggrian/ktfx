package ktfx.windows

import javafx.stage.Stage
import ktfx.testing.AppTest
import kotlin.test.Test
import kotlin.test.assertEquals

class StageTest : AppTest() {
    private lateinit var stage: Stage

    override fun start(stage: Stage) {
        this.stage = stage
    }

    @Test fun minSize() {
        stage.minSize = 10.0
        assertEquals(10.0, stage.minWidth)
        assertEquals(10.0, stage.minHeight)
    }

    @Test fun setMinSize() {
        stage.setMinSize(10.0, 20.0)
        assertEquals(10.0, stage.minWidth)
        assertEquals(20.0, stage.minHeight)
    }

    @Test fun size() {
        stage.size = 10.0
        assertEquals(10.0, stage.width)
        assertEquals(10.0, stage.height)
    }

    @Test fun setSize() {
        stage.setSize(10.0, 20.0)
        assertEquals(10.0, stage.width)
        assertEquals(20.0, stage.height)
    }

    @Test fun maxSize() {
        stage.maxSize = 10.0
        assertEquals(10.0, stage.maxWidth)
        assertEquals(10.0, stage.maxHeight)
    }

    @Test fun setMaxSize() {
        stage.setMaxSize(10.0, 20.0)
        assertEquals(10.0, stage.maxWidth)
        assertEquals(20.0, stage.maxHeight)
    }
}