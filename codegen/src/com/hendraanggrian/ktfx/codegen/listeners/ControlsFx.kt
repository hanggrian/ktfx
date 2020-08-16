package com.hendraanggrian.ktfx.codegen.listeners

import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.hendraanggrian.ktfx.codegen.T
import javafx.event.ActionEvent
import javafx.event.Event
import org.controlsfx.control.BreadCrumbBar
import org.controlsfx.control.HyperlinkLabel
import org.controlsfx.control.NotificationPane
import org.controlsfx.control.PlusMinusSlider

val ListenersFactory.Companion.ControlsFx: ListenersFactory
    get() = ListenersFactory(
        "features/controlsfx-listeners/src",
        "ktfx.controlsfx.listeners",
        "ControlsFxListenersKt",
    ).apply { initControlsFx() }

val CoroutinesFactory.Companion.ControlsFx: CoroutinesFactory
    get() = CoroutinesFactory(
        "features/controlsfx-coroutines/src",
        "ktfx.controlsfx.coroutines",
        "ControlsFxCoroutinesKt",
    ).apply { initControlsFx() }

fun BaseListenersFactory.initControlsFx() {
    // org.controlsfx.control
    (BreadCrumbBar::class.parameterizedBy(T)) {
        "setOnCrumbAction" { action(BreadCrumbBar.BreadCrumbActionEvent::class.parameterizedBy(T)) }
    }
    HyperlinkLabel::class { "setOnAction" { action<ActionEvent>() } }
    NotificationPane::class {
        "setOnShowing" { action<Event>() }
        "setOnShown" { action<Event>() }
        "setOnHiding" { action<Event>() }
        "setOnHidden" { action<Event>() }
    }
    PlusMinusSlider::class { "setOnValueChanged" { action<PlusMinusSlider.PlusMinusEvent>() } }
}