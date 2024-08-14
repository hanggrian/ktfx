package com.hanggrian.ktfx.test

import javafx.css.Styleable
import kotlin.test.Test
import kotlin.test.assertEquals

/** Extra tests for a style-able control. */
abstract class LayoutsStyledTest<M : Any, C : Styleable> : LayoutsTest<M, C>() {
    abstract fun child3(): C

    abstract fun M.child4(): C

    @Test
    fun createStyledChild() {
        val child = child3()
        assertEquals("style", child.styleClass.last())
        child.testDefaultValues()
        assertEquals(0, manager.childCount())
    }

    @Test
    fun addStyledChild() {
        val child = manager.child4()
        assertEquals("style", child.styleClass.last())
        child.testDefaultValues()
        assertEquals(1, manager.childCount())
    }
}
