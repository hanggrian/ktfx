package javafx.scene

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.layout.Region
import ktfx.layouts.region
import ktfx.layouts.scene
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertIs

class SceneTest {
    @BeforeTest
    fun start() = initToolkit()

    @Test
    fun add() {
        scene {
            region()
            assertIs<Region>(root)
        }
    }
}
