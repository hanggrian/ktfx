package ktfx.controlsfx.controls

import javafx.geometry.Pos
import javafx.scene.image.ImageView
import ktfx.test.SampleImageView
import ktfx.test.initToolkit
import ktfx.util.seconds
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class NotificationsTest {
    private lateinit var sampleGraphic: ImageView

    @BeforeTest fun start() {
        initToolkit()
        sampleGraphic = SampleImageView()
    }

    @Test fun buildNotifications() {
        assertNotNull(buildNotifications {
            text = "Welcome"
            title = "Hi"
            graphic = sampleGraphic
            position = Pos.BOTTOM_RIGHT
            owner = this@NotificationsTest
            hideAfter = 10.seconds
            onAction { }
            darkStyle()
            hideCloseButton()
            actions()
            threshold(0) { }
        })
    }
}