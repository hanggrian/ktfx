package ktfx.controls

import javafx.scene.control.Label
import ktfx.test.ToolkitTest
import kotlin.test.Test
import kotlin.test.assertEquals

class NodeTransformsTest : ToolkitTest {

    @Test fun affine() {
        val transformation = Label().affine {
            mxx = 1.0
            mxy = 2.0
            mxz = 3.0
        }
        assertEquals(1.0, transformation.mxx)
        assertEquals(2.0, transformation.mxy)
        assertEquals(3.0, transformation.mxz)
    }

    @Test fun rotate() {
        val transformation = Label().rotate {
            pivotX = 1.0
            pivotY = 2.0
            pivotZ = 3.0
        }
        assertEquals(1.0, transformation.pivotX)
        assertEquals(2.0, transformation.pivotY)
        assertEquals(3.0, transformation.pivotZ)
    }

    @Test fun scale() {
        val transformation = Label().scale {
            pivotX = 1.0
            pivotY = 2.0
            pivotZ = 3.0
        }
        assertEquals(1.0, transformation.pivotX)
        assertEquals(2.0, transformation.pivotY)
        assertEquals(3.0, transformation.pivotZ)
    }

    @Test fun shear() {
        val transformation = Label().shear {
            pivotX = 1.0
            pivotY = 2.0
        }
        assertEquals(1.0, transformation.pivotX)
        assertEquals(2.0, transformation.pivotY)
    }

    @Test fun translate() {
        val transformation = Label().translate {
            x = 1.0
            y = 2.0
            z = 3.0
        }
        assertEquals(1.0, transformation.x)
        assertEquals(2.0, transformation.y)
        assertEquals(3.0, transformation.z)
    }
}