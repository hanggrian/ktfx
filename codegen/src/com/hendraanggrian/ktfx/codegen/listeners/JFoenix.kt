package com.hendraanggrian.ktfx.codegen.listeners

import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.hendraanggrian.ktfx.codegen.T
import com.jfoenix.controls.JFXAutoCompletePopup
import com.jfoenix.controls.JFXDecorator
import com.jfoenix.controls.JFXDialog
import com.jfoenix.controls.JFXDrawer
import com.jfoenix.controls.events.JFXAutoCompleteEvent
import com.jfoenix.controls.events.JFXDialogEvent
import com.jfoenix.controls.events.JFXDrawerEvent
import com.jfoenix.transitions.JFXAnimationTimer

val ListenersFactory.Companion.JFoenix: ListenersFactory
    get() = ListenersFactory(
        "thirdparty/jfoenix-listeners/src",
        "ktfx.jfoenix.listeners",
        "JFoenixListenersKt",
    ).apply { initJFoenix() }

val CoroutinesFactory.Companion.JFoenix: CoroutinesFactory
    get() = CoroutinesFactory(
        "thirdparty/jfoenix-coroutines/src",
        "ktfx.jfoenix.coroutines",
        "JFoenixCoroutinesKt",
    ).apply { initJFoenix() }

fun BaseListenersFactory.initJFoenix() {
    // com.jfoenix.controls
    (JFXAutoCompletePopup::class.parameterizedBy(T)) {
        "setSelectionHandler" { action(JFXAutoCompleteEvent::class.parameterizedBy(T)) }
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