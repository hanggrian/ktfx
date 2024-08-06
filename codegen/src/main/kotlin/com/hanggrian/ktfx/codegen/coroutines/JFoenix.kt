package com.hanggrian.ktfx.codegen.coroutines

import com.hanggrian.kotlinpoet.name
import com.hanggrian.ktfx.codegen.T
import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.JFXDecorator
import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXAutoCompleteEvent
import com.jfoenix.controls.events.JFXDialogEvent
import com.jfoenix.controls.events.JFXDrawerEvent
import com.jfoenix.transitions.JFXAnimationTimer
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy

val CoroutinesFactory.Companion.JFoenix: CoroutinesFactory
    get() =
        CoroutinesFactory(
            "thirdparty/ktfx-jfoenix-coroutines/src/main/kotlin",
            "ktfx.jfoenix.coroutines",
            "JfoenixCoroutinesKt",
        ).apply { initJFoenix() }

fun ListenerFactory.initJFoenix() {
    // com.jfoenix.controls
    (JFXAutoCompletePopup::class.name.parameterizedBy(T)) {
        "setSelectionHandler" {
            action(JFXAutoCompleteEvent::class.name.parameterizedBy(T))
        }
    }
    JFXDecorator::class { "setOnCloseButtonAction" { action(*emptyArray()) } }
    JFXDialog::class {
        "setOnDialogClosed" { action<JFXDialogEvent>() }
        "setOnDialogOpened" { action<JFXDialogEvent>() }
    }
    JFXDrawer::class {
        "setOnDrawerClosed" { action<JFXDrawerEvent>() }
        "setOnDrawerClosing" { action<JFXDrawerEvent>() }
        "setOnDrawerOpened" { action<JFXDrawerEvent>() }
        "setOnDrawerOpening" { action<JFXDrawerEvent>() }
    }
    // com.jfoenix.transitions
    JFXAnimationTimer::class { "setOnFinished" { action(*emptyArray()) } }
}
