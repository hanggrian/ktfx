package ktfx.generator

import ktfx.generator.layouts.ControlsFx
import ktfx.generator.layouts.JavaFx
import ktfx.generator.layouts.Jfoenix
import ktfx.generator.layouts.LayoutsFactory
import ktfx.generator.layouts.LayoutsWriter

object Generator {

    @JvmStatic fun main(args: Array<String>) {
        LayoutsWriter.write(LayoutsFactory.JavaFx)
        LayoutsWriter.write(LayoutsFactory.ControlsFx)
        LayoutsWriter.write(LayoutsFactory.Jfoenix)
    }
}