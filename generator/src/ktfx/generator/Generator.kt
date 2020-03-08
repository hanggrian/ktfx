package ktfx.generator

import ktfx.generator.layouts.JavaFxEntries
import ktfx.generator.layouts.LayoutsGenerator

object Generator {

    @JvmStatic fun main(args: Array<String>) {
        LayoutsGenerator.generate(JavaFxEntries)
    }
}