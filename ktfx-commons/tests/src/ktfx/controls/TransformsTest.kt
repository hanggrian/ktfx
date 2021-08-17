package ktfx.controls

import javafx.scene.control.Label
import com.hendraanggrian.ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TransformsTest {

    @BeforeTest fun start() = initToolkit()

    @Test
    fun affine() {
        val transformation = Label().affineTransformation {
            mxx = 1.0
            mxy = 2.0
            mxz = 3.0
        }
        assertEquals(1.0, transformation.mxx)
        assertEquals(2.0, transformation.mxy)
        assertEquals(3.0, transformation.mxz)
    }

    @Test
    fun rotate() {
        val transformation = Label().rotateTransformation {
            pivotX = 1.0
            pivotY = 2.0
            pivotZ = 3.0
        }
        assertEquals(1.0, transformation.pivotX)
        assertEquals(2.0, transformation.pivotY)
        assertEquals(3.0, transformation.pivotZ)
    }

    @Test
    fun scale() {
        val transformation = Label().scaleTransformation {
            pivotX = 1.0
            pivotY = 2.0
            pivotZ = 3.0
        }
        assertEquals(1.0, transformation.pivotX)
        assertEquals(2.0, transformation.pivotY)
        assertEquals(3.0, transformation.pivotZ)
    }

    @Test
    fun shear() {
        val transformation = Label().shearTransformation {
            pivotX = 1.0
            pivotY = 2.0
        }
        assertEquals(1.0, transformation.pivotX)
        assertEquals(2.0, transformation.pivotY)
    }

    @Test
    fun translate() {
        val transformation = Label().translateTransformation {
            x = 1.0
            y = 2.0
            z = 3.0
        }
        assertEquals(1.0, transformation.x)
        assertEquals(2.0, transformation.y)
        assertEquals(3.0, transformation.z)
    }
}
