package io.github.hendraanggrian.ktfx.test

import javafx.scene.control.Dialog
import javafx.scene.image.ImageView
import javafx.scene.input.KeyCode
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest

/**
 * Showing dialogs with [Dialog.showAndWait] forces the test to wait for user input.
 * Instead, quickly hit enter whenever dialogs are showing.
 */
open class DialogShowingTest : ApplicationTest() {

    lateinit var stage: Stage
    lateinit var sampleGraphic: ImageView

    override fun start(stage: Stage) {
        this.stage = stage
        stage.testScene<Dialog<*>>()
        sampleGraphic = SampleImageView()
    }

    fun closeOnShow(dialog: Dialog<*>) = dialog.setOnShown { push(KeyCode.ENTER) }
}