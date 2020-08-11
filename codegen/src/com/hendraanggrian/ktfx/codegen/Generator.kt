package com.hendraanggrian.ktfx.codegen

import com.hendraanggrian.ktfx.codegen.commons.Strings
import com.hendraanggrian.ktfx.codegen.commons.StringsFactory
import com.hendraanggrian.ktfx.codegen.commons.StringsJVM
import com.hendraanggrian.ktfx.codegen.commons.StringsWriter
import com.hendraanggrian.ktfx.codegen.layouts.ControlsFx
import com.hendraanggrian.ktfx.codegen.layouts.JavaFx
import com.hendraanggrian.ktfx.codegen.layouts.Jfoenix
import com.hendraanggrian.ktfx.codegen.layouts.LayoutsFactory
import com.hendraanggrian.ktfx.codegen.layouts.LayoutsWriter

object Generator {

    @JvmStatic fun main(args: Array<String>) {
        StringsWriter.write(StringsFactory.Strings)
        StringsWriter.write(StringsFactory.StringsJVM)

        LayoutsWriter.write(LayoutsFactory.JavaFx)
        LayoutsWriter.write(LayoutsFactory.ControlsFx)
        LayoutsWriter.write(LayoutsFactory.Jfoenix)
    }
}