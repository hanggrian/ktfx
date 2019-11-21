package ktfx.bindings

import ktfx.booleanProperty
import kotlin.test.Test

class BindingCustomTest {

    @Test fun boolean() {
        val dependency = booleanProperty()
        booleanBindingOf(dependency) { false }
        dependency.toBooleanBinding { it }
    }
}