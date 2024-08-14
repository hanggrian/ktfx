package com.hanggrian.ktfx.test

import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

/** There are several ways to create a control, this class test each of them. */
abstract class LayoutsTest<M : Any, C> {
    protected lateinit var manager: M

    @BeforeTest
    open fun onCreate() {
        initToolkit()
        manager = manager()
    }

    abstract fun manager(): M

    abstract fun M.childCount(): Int

    abstract fun child1(): C

    abstract fun M.child2(): C

    /** Override to test default values. */
    open fun C.testDefaultValues() {
    }

    @Test
    fun createChild() {
        val child = child1()
        child.testDefaultValues()
        assertEquals(0, manager.childCount())
    }

    @Test
    fun addChild() {
        val child = manager.child2()
        child.testDefaultValues()
        assertEquals(1, manager.childCount())
    }
}
