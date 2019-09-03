@file:Suppress("NOTHING_TO_INLINE")

package ktfx.print

import javafx.print.JobSettings
import javafx.print.Printer
import javafx.print.PrinterJob

inline val defaultPrinter: Printer
    get() = checkNotNull(Printer.getDefaultPrinter())

fun Printer.createJob(
    name: String? = null,
    settings: JobSettings.() -> Unit = {
        if (name != null) jobName = name
        copies = 1
        setPageRanges(1 untilPage 1)
    }
): PrinterJob = PrinterJob.createPrinterJob(this).also { settings(it.jobSettings) }
