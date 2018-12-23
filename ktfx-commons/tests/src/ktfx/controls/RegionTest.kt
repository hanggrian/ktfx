package ktfx.controls

import javafx.scene.Scene
import javafx.scene.layout.Region
import javafx.stage.Stage
import ktfx.test.AppTest
import org.junit.Test
import kotlin.test.assertEquals

class RegionTest : AppTest() {

    private lateinit var region: Region

    override fun start(stage: Stage) {
        region = Region()
        stage.run {
            scene = Scene(region)
            show()
        }
    }

    @Test fun padding() {
        region.updatePadding(bottom = 20.0, top = 20.0)
        assertEquals(region.paddingTop, 20.0)
        assertEquals(region.paddingLeft, 0.0)
        assertEquals(region.paddingRight, 0.0)
        assertEquals(region.paddingBottom, 20.0)
        region.paddingAll = 10.0
        assertEquals(region.paddingTop, 10.0)
        assertEquals(region.paddingLeft, 10.0)
        assertEquals(region.paddingRight, 10.0)
        assertEquals(region.paddingBottom, 10.0)
        region.paddingTop = 15.0
        assertEquals(region.paddingTop, 15.0)
        region.paddingLeft = 20.0
        assertEquals(region.paddingLeft, 20.0)
        region.paddingRight = 25.0
        assertEquals(region.paddingRight, 25.0)
        region.paddingBottom = 30.0
        assertEquals(region.paddingBottom, 30.0)
    }
}