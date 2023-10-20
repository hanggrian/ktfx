package com.hendraanggrian.ktfx.codegen

import com.hendraanggrian.ktfx.codegen.coroutines.ControlsFx
import com.hendraanggrian.ktfx.codegen.coroutines.CoroutinesFactory
import com.hendraanggrian.ktfx.codegen.coroutines.CoroutinesWriter
import com.hendraanggrian.ktfx.codegen.coroutines.JFoenix
import com.hendraanggrian.ktfx.codegen.coroutines.JavaFx
import com.hendraanggrian.ktfx.codegen.layouts.ControlsFx
import com.hendraanggrian.ktfx.codegen.layouts.JFoenix
import com.hendraanggrian.ktfx.codegen.layouts.JavaFx
import com.hendraanggrian.ktfx.codegen.layouts.LayoutsFactory
import com.hendraanggrian.ktfx.codegen.layouts.LayoutsWriter

object Generator {
    @JvmStatic
    fun main(args: Array<String>) {
        if (true) {
            LayoutsWriter.write(LayoutsFactory.JavaFx)
            LayoutsWriter.write(LayoutsFactory.ControlsFx)
            LayoutsWriter.write(LayoutsFactory.JFoenix)
        }
        if (true) {
            CoroutinesWriter.write(CoroutinesFactory.JavaFx)
            CoroutinesWriter.write(CoroutinesFactory.ControlsFx)
            CoroutinesWriter.write(CoroutinesFactory.JFoenix)
        }
    }
}
