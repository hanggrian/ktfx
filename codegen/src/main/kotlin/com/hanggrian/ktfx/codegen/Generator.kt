package com.hanggrian.ktfx.codegen

import com.hanggrian.ktfx.codegen.coroutines.ControlsFx
import com.hanggrian.ktfx.codegen.coroutines.CoroutinesFactory
import com.hanggrian.ktfx.codegen.coroutines.CoroutinesWriter
import com.hanggrian.ktfx.codegen.coroutines.JFoenix
import com.hanggrian.ktfx.codegen.coroutines.JavaFx

object Generator {
    @JvmStatic
    fun main(args: Array<String>) {
        // LayoutsWriter.write(LayoutsFactory.JavaFx)
        // LayoutsWriter.write(LayoutsFactory.ControlsFx)
        // LayoutsWriter.write(LayoutsFactory.JFoenix)
        CoroutinesWriter.write(CoroutinesFactory.JavaFx)
        CoroutinesWriter.write(CoroutinesFactory.ControlsFx)
        CoroutinesWriter.write(CoroutinesFactory.JFoenix)
    }
}
