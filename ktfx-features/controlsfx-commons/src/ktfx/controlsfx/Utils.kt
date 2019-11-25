@file:JvmName("ControlsFxUtilsKt")

package ktfx.controlsfx

import org.controlsfx.tools.Utils

/** Return a letter (just like Excel) associated with the number. */
val Int.excelLetter: String get() = Utils.getExcelLetterFromNumber(this)
