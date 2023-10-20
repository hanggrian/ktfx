package ktfx.print

import javafx.print.JobSettings
import javafx.print.Printer
import javafx.print.PrinterJob

/** Create a new printer job with specified job settings. */
inline fun Printer.createJob(
    settingsAction: JobSettings.() -> Unit = {
        copies = 1
        setPageRanges(1 untilPage 1)
    },
): PrinterJob = PrinterJob.createPrinterJob(this).also { it.jobSettings.settingsAction() }
