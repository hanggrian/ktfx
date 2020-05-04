package com.hendraanggrian.ktfx.codegen

import com.hendraanggrian.ktfx.codegen.layouts.ControlsFx
import com.hendraanggrian.ktfx.codegen.layouts.JavaFx
import com.hendraanggrian.ktfx.codegen.layouts.Jfoenix
import com.hendraanggrian.ktfx.codegen.layouts.LayoutsFactory
import com.hendraanggrian.ktfx.codegen.layouts.LayoutsWriter

object Generator {

    @JvmStatic fun main(args: Array<String>) {
        LayoutsWriter.write(LayoutsFactory.JavaFx)
        LayoutsWriter.write(LayoutsFactory.ControlsFx)
        LayoutsWriter.write(LayoutsFactory.Jfoenix)
    }
}