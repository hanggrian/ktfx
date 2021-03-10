package io.github.hendraanggrian.ktfx.test

import javafx.event.EventDispatchChain
import javafx.event.EventTarget

object FakeEventTarget : EventTarget {

    override fun buildEventDispatchChain(tail: EventDispatchChain) = throw UnsupportedOperationException()
}