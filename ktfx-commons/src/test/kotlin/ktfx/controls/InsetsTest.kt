package ktfx.controls

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.layout.Region
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class InsetsTest {
    @BeforeTest
    fun start() = initToolkit()

    @Test
    fun insetsOf() {
        val region = Region()

        region.padding = ktfx.controls.insetsOf()
        assertEquals(0.0, region.padding.top)
        assertEquals(0.0, region.padding.right)
        assertEquals(0.0, region.padding.bottom)
        assertEquals(0.0, region.padding.left)

        region.padding = insetsOf(5)
        assertEquals(5.0, region.padding.top)
        assertEquals(5.0, region.padding.right)
        assertEquals(5.0, region.padding.bottom)
        assertEquals(5.0, region.padding.left)

        region.padding = insetsOf(10L)
        assertEquals(10.0, region.padding.top)
        assertEquals(10.0, region.padding.right)
        assertEquals(10.0, region.padding.bottom)
        assertEquals(10.0, region.padding.left)

        region.padding = insetsOf(horizontal = 15, vertical = 20)
        assertEquals(20.0, region.padding.top)
        assertEquals(15.0, region.padding.right)
        assertEquals(20.0, region.padding.bottom)
        assertEquals(15.0, region.padding.left)

        region.padding = insetsOf(horizontal = 25L, vertical = 30L)
        assertEquals(30.0, region.padding.top)
        assertEquals(25.0, region.padding.right)
        assertEquals(30.0, region.padding.bottom)
        assertEquals(25.0, region.padding.left)

        region.padding = insetsOf(top = 35, right = 40, bottom = 45, left = 50)
        assertEquals(35.0, region.padding.top)
        assertEquals(40.0, region.padding.right)
        assertEquals(45.0, region.padding.bottom)
        assertEquals(50.0, region.padding.left)

        region.padding = insetsOf(top = 55L, right = 60L, bottom = 65L, left = 70L)
        assertEquals(55.0, region.padding.top)
        assertEquals(60.0, region.padding.right)
        assertEquals(65.0, region.padding.bottom)
        assertEquals(70.0, region.padding.left)
    }
}
