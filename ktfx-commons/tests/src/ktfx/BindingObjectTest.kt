package ktfx

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingObjectTest {

    @Test fun eq() {
        assertFalse((property<Car>() eq property(Car("Honda"))).value)
        assertTrue((property(Car("Toyota")) eq property(Car("Toyota"))).value)
    }

    @Test fun neq() {
        assertTrue((property<Car>() neq property(Car("Honda"))).value)
        assertFalse((property(Car("Toyota")) neq property(Car("Toyota"))).value)
    }

    data class Car(val maker: String)
}