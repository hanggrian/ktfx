package ktfx.layouts.scene.canvas

import ktfx.layouts.NodeManager
import ktfx.layouts.KtfxPane
import ktfx.layouts.canvas
import ktfx.testing.LayoutToolkitTest
import kotlin.test.assertEquals

class CanvasTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        val canvas = canvas(10.0, 20.0)
        assertEquals(canvas.width, 10.0)
        assertEquals(canvas.height, 20.0)
    }
}