package ktfx.controls

import com.hendraanggrian.ktfx.test.initToolkit
import javafx.scene.layout.Region
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class InsetsTest {

    @BeforeTest fun start() = initToolkit()

    @Test
    fun insetsOf() {
        val region = Region()
        region.padding = insetsOf(10)
        assertEquals(10.0, region.padding.top)
        assertEquals(10.0, region.padding.right)
        assertEquals(10.0, region.padding.bottom)
        assertEquals(10.0, region.padding.left)
        region.padding = insetsOf(top = 15)
        assertEquals(15.0, region.padding.top)
        region.padding = insetsOf(left = 20)
        assertEquals(20.0, region.padding.left)
        region.padding = insetsOf(right = 25)
        assertEquals(25.0, region.padding.right)
        region.padding = insetsOf(bottom = 30)
        assertEquals(30.0, region.padding.bottom)
        region.padding = insetsOf(horizontal = 35)
        assertEquals(35.0, region.padding.left)
        assertEquals(35.0, region.padding.right)
        region.padding = insetsOf(vertical = 40)
        assertEquals(40.0, region.padding.top)
        assertEquals(40.0, region.padding.bottom)
    }
}
