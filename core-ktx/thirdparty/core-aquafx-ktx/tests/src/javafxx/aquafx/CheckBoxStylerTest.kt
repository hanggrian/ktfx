package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.ControlSizeVariant.MINI
import javafx.scene.control.CheckBox
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test

class CheckBoxStylerTest : StylerTest<CheckBox>() {

    override fun creator(): CheckBox = CheckBox("Hello world")

    @Test fun button() {
        runBlocking(JavaFx) {
            control.aquafx { it size MINI }
            delay(1000)
        }
    }
}