package ktfx

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BindingOperatorObjectTest {

    @Test fun eq() {
        assertFalse((propertyOf<Car>() eq propertyOf(Car("Honda"))).value)
        assertTrue((propertyOf(Car("Toyota")) eq propertyOf(Car("Toyota"))).value)
    }

    @Test fun neq() {
        assertTrue((propertyOf<Car>() neq propertyOf(Car("Honda"))).value)
        assertFalse((propertyOf(Car("Toyota")) neq propertyOf(Car("Toyota"))).value)
    }

    data class Car(val maker: String)
}