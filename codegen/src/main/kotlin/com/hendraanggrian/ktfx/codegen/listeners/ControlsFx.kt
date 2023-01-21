package com.hendraanggrian.ktfx.codegen.listeners

import com.hendraanggrian.ktfx.codegen.T
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.asClassName
import javafx.event.ActionEvent
import javafx.event.Event
import org.controlsfx.control.BreadCrumbBar
import org.controlsfx.control.HyperlinkLabel
import org.controlsfx.control.NotificationPane
import org.controlsfx.control.PlusMinusSlider

val ListenersFactory.Companion.ControlsFx: ListenersFactory
    get() = ListenersFactory(
        "thirdparty/controlsfx-listeners/src/main/kotlin",
        "ktfx.controlsfx.listeners",
        "ControlsFxListenersKt",
    ).apply { initControlsFx() }

val CoroutinesFactory.Companion.ControlsFx: CoroutinesFactory
    get() = CoroutinesFactory(
        "thirdparty/controlsfx-coroutines/src/main/kotlin",
        "ktfx.controlsfx.coroutines",
        "ControlsFxCoroutinesKt",
    ).apply { initControlsFx() }

fun BaseListenersFactory.initControlsFx() {
    // org.controlsfx.control
    (BreadCrumbBar::class.asClassName().parameterizedBy(T)) {
        "setOnCrumbAction" {
            action(BreadCrumbBar.BreadCrumbActionEvent::class.asClassName().parameterizedBy(T))
        }
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
