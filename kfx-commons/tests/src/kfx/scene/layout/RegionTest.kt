package kfx.scene.layout

import javafx.scene.Scene
import javafx.scene.layout.Region
import javafx.stage.Stage
import kfx.stage.setSize
import kfx.stage.size
import org.junit.Test
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.assertEquals

class RegionTest : ApplicationTest() {

    lateinit var region: Region

    override fun start(stage: Stage) {
        region = Region()
        stage.run {
            scene = Scene(region)
            show()
        }
    }

    @Test fun sizeMin() {
        region.widthMin = 50
        assertEquals(region.minWidth, 50.0)
        region.heightMin = 25
        assertEquals(region.minHeight, 25.0)
        region.setSizeMin(100, 50)
        assertEquals(region.minWidth, 100.0)
        assertEquals(region.minHeight, 50.0)
        region.sizeMin = 75
        assertEquals(region.minWidth, 75.0)
        assertEquals(region.minHeight, 75.0)
    }

    @Test fun sizePref() {
        region.widthPref = 50
        assertEquals(region.prefWidth, 50.0)
        region.heightPref = 25
        assertEquals(region.prefHeight, 25.0)
        region.setSizePref(100, 50)
        assertEquals(region.prefWidth, 100.0)
        assertEquals(region.prefHeight, 50.0)
        region.sizePref = 75
        assertEquals(region.prefWidth, 75.0)
        assertEquals(region.prefHeight, 75.0)
    }

    @Test fun sizeMax() {
        region.widthMax = 50
        assertEquals(region.maxWidth, 50.0)
        region.heightMax = 25
        assertEquals(region.maxHeight, 25.0)
        region.setSizeMax(100, 50)
        assertEquals(region.maxWidth, 100.0)
        assertEquals(region.maxHeight, 50.0)
        region.sizeMax = 75
        assertEquals(region.maxWidth, 75.0)
        assertEquals(region.maxHeight, 75.0)
    }

    @Test fun size() {
        region.setSize(500, 250)
        assertEquals(region.minWidth, 500.0)
        assertEquals(region.prefWidth, 500.0)
        assertEquals(region.maxWidth, 500.0)
        assertEquals(region.minHeight, 250.0)
        assertEquals(region.prefHeight, 250.0)
        assertEquals(region.maxHeight, 250.0)
        region.size = 750
        assertEquals(region.minWidth, 750.0)
        assertEquals(region.prefWidth, 750.0)
        assertEquals(region.maxWidth, 750.0)
        assertEquals(region.minHeight, 750.0)
        assertEquals(region.prefHeight, 750.0)
        assertEquals(region.maxHeight, 750.0)
    }

    @Test fun padding() {
        region.paddings = 10
        assertEquals(region.paddingTop, 10)
        assertEquals(region.paddingLeft, 10)
        assertEquals(region.paddingRight, 10)
        assertEquals(region.paddingBottom, 10)
        region.updatePadding(bottom = 20, top = 20)
        assertEquals(region.paddingTop, 20)
        assertEquals(region.paddingLeft, 10)
        assertEquals(region.paddingRight, 10)
        assertEquals(region.paddingBottom, 20)
    }
}