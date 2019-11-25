package ktfx.print

import javafx.print.JobSettings
import javafx.print.Printer
import javafx.print.PrinterJob

/** Get default printer, throwing exception when no default printer is found. */
val defaultPrinter: Printer get() = checkNotNull(Printer.getDefaultPrinter()) { "Default printer not is found." }

/** Create a new printer job with specified job settings. */
fun Printer.createJob(
    settings: JobSettings.() -> Unit = {
        copies = 1
        setPageRanges(1 untilPage 1)
    }
): PrinterJob = PrinterJob.createPrinterJob(this).also { it.jobSettings.settings() }
