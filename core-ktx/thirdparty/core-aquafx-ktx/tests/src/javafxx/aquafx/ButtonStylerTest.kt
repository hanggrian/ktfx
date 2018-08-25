package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.ButtonType.RIGHT_PILL
import com.aquafx_project.controls.skin.styles.ControlSizeVariant.REGULAR
import javafx.scene.control.Button
import javafxx.application.later
import org.junit.Test

class ButtonStylerTest : StylerTest<Button>() {

    override fun creator(): Button = Button("Hello world")

    @Test fun button() = later {
        control.aquafx { it type RIGHT_PILL size REGULAR }
    }
}