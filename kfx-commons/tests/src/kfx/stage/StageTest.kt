package kfx.stage

import javafx.stage.Stage
import kfx.application.later
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.assertEquals

class StageTest : ApplicationTest() {

    lateinit var stage: Stage

    override fun start(stage: Stage) {
        stage.show()
        this.stage = stage
    }

    @Test fun min() = later {
        stage.widthMin = 50
        assertEquals(stage.minWidth, 50.0)
        stage.heightMin = 25
        assertEquals(stage.minHeight, 25.0)
        stage.setSizeMin(100, 50)
        assertEquals(stage.minWidth, 100.0)
        assertEquals(stage.minHeight, 50.0)
        stage.sizeMin = 75
        assertEquals(stage.minWidth, 75.0)
        assertEquals(stage.minHeight, 75.0)
    }

    @Test fun max() = later {
        stage.widthMax = 50
        assertEquals(stage.maxWidth, 50.0)
        stage.heightMax = 25
        assertEquals(stage.maxHeight, 25.0)
        stage.setSizeMax(100, 50)
        assertEquals(stage.maxWidth, 100.0)
        assertEquals(stage.maxHeight, 50.0)
        stage.sizeMax = 75
        assertEquals(stage.maxWidth, 75.0)
        assertEquals(stage.maxHeight, 75.0)
    }

    @Test fun size() = later {
        stage.setSize(500, 250)
        assertEquals(stage.width, 500.0)
        assertEquals(stage.height, 250.0)
        stage.size = 750
        assertEquals(stage.width, 750.0)
        assertEquals(stage.height, 750.0)
    }
}