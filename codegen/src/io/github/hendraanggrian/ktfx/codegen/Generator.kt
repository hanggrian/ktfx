package io.github.hendraanggrian.ktfx.codegen

import io.github.hendraanggrian.ktfx.codegen.commons.Strings
import io.github.hendraanggrian.ktfx.codegen.commons.StringsFactory
import io.github.hendraanggrian.ktfx.codegen.commons.StringsJVM
import io.github.hendraanggrian.ktfx.codegen.commons.StringsWriter
import io.github.hendraanggrian.ktfx.codegen.layouts.ControlsFx
import io.github.hendraanggrian.ktfx.codegen.layouts.JFoenix
import io.github.hendraanggrian.ktfx.codegen.layouts.JavaFx
import io.github.hendraanggrian.ktfx.codegen.layouts.LayoutsFactory
import io.github.hendraanggrian.ktfx.codegen.layouts.LayoutsWriter
import io.github.hendraanggrian.ktfx.codegen.listeners.ControlsFx
import io.github.hendraanggrian.ktfx.codegen.listeners.CoroutinesFactory
import io.github.hendraanggrian.ktfx.codegen.listeners.JFoenix
import io.github.hendraanggrian.ktfx.codegen.listeners.JavaFx
import io.github.hendraanggrian.ktfx.codegen.listeners.ListenersFactory
import io.github.hendraanggrian.ktfx.codegen.listeners.ListenersWriter

object Generator {

    @JvmStatic fun main(args: Array<String>) {
        if (true) {
            StringsWriter.write(StringsFactory.Strings)
            StringsWriter.write(StringsFactory.StringsJVM)
        }
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