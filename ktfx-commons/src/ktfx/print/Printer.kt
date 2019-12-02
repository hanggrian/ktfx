package ktfx.print

import javafx.print.JobSettings
import javafx.print.Printer
import javafx.print.PrinterJob

/** Create a new printer job with specified job settings. */
fun Printer.createJob(
    settingsBuilderAction: JobSettings.() -> Unit = {
        copies = 1
        setPageRanges(1 untilPage 1)
    }
): PrinterJob = PrinterJob.createPrinterJob(this).also { it.jobSettings.settingsBuilderAction() }
