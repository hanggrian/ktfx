package kotlinfx.layouts

import kotlinfx.application.initToolkit
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object LayoutSpec : Spek({

    given("a layout") {
        vbox {
            it("has a children") {
                label()
                assertEquals(children.size, 1)
            }
        }
    }
}) {
    init {
        initToolkit()
    }
}