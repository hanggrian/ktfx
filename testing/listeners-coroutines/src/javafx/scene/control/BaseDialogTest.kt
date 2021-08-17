package com.hendraanggrian.ktfx.test

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseDialogTest : ApplicationTest() {
    private lateinit var dialog: Dialog<String>

    abstract fun <E> Dialog<E>.callOnCloseRequest(action: (DialogEvent) -> Unit)
    abstract fun <E> Dialog<E>.callOnShowing(action: (DialogEvent) -> Unit)
    abstract fun <E> Dialog<E>.callOnShown(action: (DialogEvent) -> Unit)
    abstract fun <E> Dialog<E>.callOnHiding(action: (DialogEvent) -> Unit)
    abstract fun <E> Dialog<E>.callOnHidden(action: (DialogEvent) -> Unit)

    override fun start(stage: Stage) {
        stage.testScene<Dialog<*>>()
        dialog = Dialog()
    }

    @Test
    fun onCloseRequest() {
        dialog.callOnCloseRequest {
            assertEquals(dialog, it.source)
            assertEquals(DialogEvent.DIALOG_CLOSE_REQUEST, it.eventType)
        }
        dialog.onCloseRequest.handle(DialogEvent(dialog, DialogEvent.DIALOG_CLOSE_REQUEST))
    }

    @Test
    fun onShowing() {
        dialog.callOnShowing {
            assertEquals(dialog, it.source)
            assertEquals(DialogEvent.DIALOG_SHOWING, it.eventType)
        }
        dialog.onShowing.handle(DialogEvent(dialog, DialogEvent.DIALOG_SHOWING))
    }

    @Test
    fun onShown() {
        dialog.callOnShown {
            assertEquals(dialog, it.source)
            assertEquals(DialogEvent.DIALOG_SHOWN, it.eventType)
        }
        dialog.onShown.handle(DialogEvent(dialog, DialogEvent.DIALOG_SHOWN))
    }

    @Test
    fun onHiding() {
        dialog.callOnHiding {
            assertEquals(dialog, it.source)
            assertEquals(DialogEvent.DIALOG_HIDING, it.eventType)
        }
        dialog.onHiding.handle(DialogEvent(dialog, DialogEvent.DIALOG_HIDING))
    }

    @Test
    fun onHidden() {
        dialog.callOnHidden {
            assertEquals(dialog, it.source)
            assertEquals(DialogEvent.DIALOG_HIDDEN, it.eventType)
        }
        dialog.onHidden.handle(DialogEvent(dialog, DialogEvent.DIALOG_HIDDEN))
    }
}