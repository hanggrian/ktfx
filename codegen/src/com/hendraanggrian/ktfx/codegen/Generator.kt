package com.hendraanggrian.ktfx.codegen

import com.hendraanggrian.ktfx.codegen.layouts.ControlsFx
import com.hendraanggrian.ktfx.codegen.layouts.JFoenix
import com.hendraanggrian.ktfx.codegen.layouts.JavaFx
import com.hendraanggrian.ktfx.codegen.layouts.LayoutsFactory
import com.hendraanggrian.ktfx.codegen.layouts.LayoutsWriter
import com.hendraanggrian.ktfx.codegen.listeners.ControlsFx
import com.hendraanggrian.ktfx.codegen.listeners.CoroutinesFactory
import com.hendraanggrian.ktfx.codegen.listeners.JFoenix
import com.hendraanggrian.ktfx.codegen.listeners.JavaFx
import com.hendraanggrian.ktfx.codegen.listeners.ListenersFactory
import com.hendraanggrian.ktfx.codegen.listeners.ListenersWriter

object Generator {

    @JvmStatic
    fun main(args: Array<String>) {
        if (true) {
            LayoutsWriter.write(LayoutsFactory.JavaFx)
            LayoutsWriter.write(LayoutsFactory.ControlsFx)
            LayoutsWriter.write(LayoutsFactory.JFoenix)
        }
        if (true) {
            ListenersWriter.write(ListenersFactory.JavaFx)
            ListenersWriter.write(CoroutinesFactory.JavaFx)
            ListenersWriter.write(ListenersFactory.ControlsFx)
            ListenersWriter.write(CoroutinesFactory.ControlsFx)
            ListenersWriter.write(ListenersFactory.JFoenix)
            ListenersWriter.write(CoroutinesFactory.JFoenix)
        }
    }
}