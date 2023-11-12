package com.hendraanggrian.ktfx.codegen.coroutines

import com.hendraanggrian.kotlinpoet.name
import com.hendraanggrian.ktfx.codegen.T
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import javafx.event.ActionEvent
import javafx.event.Event
import org.controlsfx.control.BreadCrumbBar
import org.controlsfx.control.HyperlinkLabel
import org.controlsfx.control.NotificationPane
import org.controlsfx.control.PlusMinusSlider

val CoroutinesFactory.Companion.ControlsFx: CoroutinesFactory
    get() =
        CoroutinesFactory(
            "thirdparty/controlsfx-coroutines/src/main/kotlin",
            "ktfx.controlsfx.coroutines",
            "ControlsfxCoroutinesKt",
        ).apply { initControlsFx() }

fun ListenerFactory.initControlsFx() {
    // org.controlsfx.control
    (BreadCrumbBar::class.name.parameterizedBy(T)) {
        "setOnCrumbAction" {
            action(BreadCrumbBar.BreadCrumbActionEvent::class.name.parameterizedBy(T))
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
