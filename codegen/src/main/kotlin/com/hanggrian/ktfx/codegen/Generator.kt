package com.hanggrian.ktfx.codegen

import com.hanggrian.ktfx.codegen.layouts.ControlsFx
import com.hanggrian.ktfx.codegen.layouts.JFoenix
import com.hanggrian.ktfx.codegen.layouts.JavaFx
import com.hanggrian.ktfx.codegen.layouts.LayoutsFactory
import com.hanggrian.ktfx.codegen.layouts.LayoutsWriter

object Generator {
    @JvmStatic
    fun main(args: Array<String>) {
        LayoutsWriter.write(LayoutsFactory.JavaFx)
        LayoutsWriter.write(LayoutsFactory.ControlsFx)
        LayoutsWriter.write(LayoutsFactory.JFoenix)
        // CoroutinesWriter.write(CoroutinesFactory.JavaFx)
        // CoroutinesWriter.write(CoroutinesFactory.ControlsFx)
        // CoroutinesWriter.write(CoroutinesFactory.JFoenix)
    }
}
