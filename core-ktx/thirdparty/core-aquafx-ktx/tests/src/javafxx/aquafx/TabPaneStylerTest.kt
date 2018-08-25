package javafxx.aquafx

import com.aquafx_project.controls.skin.styles.ControlSizeVariant
import com.aquafx_project.controls.skin.styles.TabPaneType
import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafxx.application.later
import org.junit.Test

class TabPaneStylerTest : StylerTest<TabPane>() {

    override fun creator(): TabPane = TabPane().apply {
        tabs += Tab("Hello")
        tabs += Tab("World")

    }

    @Test fun smallIcons() = later {
        control.aquafx { it type TabPaneType.SMALL_ICON_BUTTONS size ControlSizeVariant.REGULAR }
    }
}