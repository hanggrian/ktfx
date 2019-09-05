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

    @Test
    fun padding() {
        region.updatePadding(bottom = 20.0, top = 20.0)
        assertEquals(20.0, region.paddingTop)
        assertEquals(0.0, region.paddingLeft)
        assertEquals(0.0, region.paddingRight)
        assertEquals(20.0, region.paddingBottom)
        region.paddingAll = 10.0
        assertEquals(10.0, region.paddingTop)
        assertEquals(10.0, region.paddingLeft)
        assertEquals(10.0, region.paddingRight)
        assertEquals(10.0, region.paddingBottom)
        region.paddingTop = 15.0
        assertEquals(15.0, region.paddingTop)
        region.paddingLeft = 20.0
        assertEquals(20.0, region.paddingLeft)
        region.paddingRight = 25.0
        assertEquals(25.0, region.paddingRight)
        region.paddingBottom = 30.0
        assertEquals(30.0, region.paddingBottom)
    }
}