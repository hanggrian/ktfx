package javafx.scene

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.layout.Region
import ktfx.layouts.region
import ktfx.layouts.subScene
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertIs

class SubSceneTest {
    @BeforeTest
    fun start() = initToolkit()

    @Test
    fun add() {
        subScene {
            region()
            assertIs<Region>(root)
        }
    }
}
