package com.hendraanggrian.kotfx.dialogs

import javafx.scene.control.ButtonType
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class DialogsTest {

    @Test
    fun alert() {
        val alert1 = alert("Here's an alert.")
        assertEquals(alert1.contentText, "Here's an alert.")
        alert1.close()

        val alert2 = alert({
            title = "Title"
            headerText = "Title"
            contentText = "Here's another"
        })
        assertEquals(alert2.title, "Title")
        assertEquals(alert2.headerText, "Title")
        assertEquals(alert2.contentText, "Here's another")
        alert2.close()

        confirmAlert("Click yes") { buttonType ->
            if (buttonType != ButtonType.OK) throw IllegalStateException()
        }
    }

    @Test
    fun dialog() {

    }
}