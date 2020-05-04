package com.hendraanggrian.ktfx.test

import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseFontTest<T> {
    private var fontContainer: T? = null

    abstract fun getContainer(): T

    abstract fun T.set(font: Font)

    abstract var T.family: String
    abstract var T.weight: FontWeight
    abstract var T.posture: FontPosture
    abstract var T.size: Double

    @BeforeTest fun init() {
        initToolkit()
        fontContainer = getContainer()
        fontContainer!!.set(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 18.0))
    }

    @Test fun fontFamily() {
        fontContainer!!.family = "Verdana"
        assertEquals("Verdana", fontContainer!!.family)
        assertEquals(FontWeight.BOLD, fontContainer!!.weight)
        assertEquals(FontPosture.ITALIC, fontContainer!!.posture)
        assertEquals(18.0, fontContainer!!.size)
    }

    @Test fun fontWeight() {
        fontContainer!!.weight = FontWeight.NORMAL
        assertEquals("Arial", fontContainer!!.family)
        assertEquals(FontWeight.NORMAL, fontContainer!!.weight)
        assertEquals(FontPosture.ITALIC, fontContainer!!.posture)
        assertEquals(18.0, fontContainer!!.size)
    }

    @Test fun fontPosture() {
        fontContainer!!.posture = FontPosture.REGULAR
        assertEquals("Arial", fontContainer!!.family)
        assertEquals(FontWeight.BOLD, fontContainer!!.weight)
        assertEquals(FontPosture.REGULAR, fontContainer!!.posture)
        assertEquals(18.0, fontContainer!!.size)
    }

    @Test fun fontSize() {
        fontContainer!!.size = 21.0
        assertEquals("Arial", fontContainer!!.family)
        assertEquals(FontWeight.BOLD, fontContainer!!.weight)
        assertEquals(FontPosture.ITALIC, fontContainer!!.posture)
        assertEquals(21.0, fontContainer!!.size)
    }
}