package ktfx.layouts.scene.shape

import javafx.scene.shape.ClosePath
import ktfx.layouts.KtfxPath
import ktfx.layouts.LayoutTest
import ktfx.layouts.PathElementManager
import ktfx.layouts.closePath

class ClosePathTest : LayoutTest<PathElementManager, ClosePath>() {

    override fun createManager() = KtfxPath()
    override fun create() = closePath { }
    override fun PathElementManager.add() = closePath()
    override fun PathElementManager.addWithBuilder() = closePath { }
}