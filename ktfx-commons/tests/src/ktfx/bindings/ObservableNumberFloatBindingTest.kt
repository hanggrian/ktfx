package ktfx.bindings

import ktfx.doublePropertyOf
import ktfx.floatPropertyOf
import ktfx.intPropertyOf
import ktfx.longPropertyOf
import kotlin.test.Test
import kotlin.test.assertEquals

class ObservableNumberFloatBindingTest {

    @Test fun doublePlus() {
        assertEquals(3.0, (1.0 + doublePropertyOf(2.0)).value)
        assertEquals(3.0, (doublePropertyOf(1.0) + doublePropertyOf(2.0)).value)
        assertEquals(3.0, (doublePropertyOf(1.0) + 2.0).value)
        assertEquals(3.0, (doublePropertyOf(1.0) + 2f).value)
        assertEquals(3.0, (doublePropertyOf(1.0) + 2L).value)
        assertEquals(3.0, (doublePropertyOf(1.0) + 2).value)
    }

    /*@Test*/ fun floatPlus() {
        //assertEquals(3f, (1f + doubleProperty(2.0)).value)
        assertEquals(3f, (floatPropertyOf(1f) + doublePropertyOf(2.0)).value)
        assertEquals(3.0, (floatPropertyOf(1f) + 2.0).value)
        assertEquals(3f, (floatPropertyOf(1f) + 2F).value)
        assertEquals(3f, (floatPropertyOf(1f) + 2L).value)
        assertEquals(3f, (floatPropertyOf(1f) + 2).value)
    }

    /*@Test*/ fun longPlus() {
        //assertEquals(3L, (1L + doubleProperty(2.0)).value)
        assertEquals(3L, (longPropertyOf(1L) + doublePropertyOf(2.0)).value)
        assertEquals(3.0, (longPropertyOf(1L) + 2.0).value)
        assertEquals(3f, (longPropertyOf(1L) + 2F).value)
        assertEquals(3L, (longPropertyOf(1L) + 2L).value)
        assertEquals(3L, (longPropertyOf(1L) + 2).value)
    }

    /*@Test*/ fun intPlus() {
        //assertEquals(3, (1 + doubleProperty(2.0)).value)
        assertEquals(3, (intPropertyOf(1) + doublePropertyOf(2.0)).value)
        assertEquals(3.0, (intPropertyOf(1) + 2.0).value)
        assertEquals(3f, (intPropertyOf(1) + 2F).value)
        assertEquals(3, (intPropertyOf(1) + 2L).value)
        assertEquals(3, (intPropertyOf(1) + 2).value)
    }
}
