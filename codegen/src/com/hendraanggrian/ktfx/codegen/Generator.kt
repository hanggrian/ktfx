package com.hendraanggrian.ktfx.codegen

import com.hendraanggrian.ktfx.codegen.commons.Strings
import com.hendraanggrian.ktfx.codegen.commons.StringsFactory
import com.hendraanggrian.ktfx.codegen.commons.StringsJVM
import com.hendraanggrian.ktfx.codegen.commons.StringsWriter

object Generator {

    @JvmStatic fun main(args: Array<String>) {
        StringsWriter.write(StringsFactory.Strings)
        StringsWriter.write(StringsFactory.StringsJVM)

        /*LayoutsWriter.write(LayoutsFactory.JavaFx)
        LayoutsWriter.write(LayoutsFactory.ControlsFx)
        LayoutsWriter.write(LayoutsFactory.Jfoenix)*/
    }
}