@file:OptIn(ExperimentalContracts::class)

package ktfx.print

import javafx.print.JobSettings
import javafx.print.Printer
import javafx.print.PrinterJob
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a new printer job with specified job settings. */
public inline fun Printer.createJob(
    configuration: JobSettings.() -> Unit = {
        copies = 1
        setPageRanges(1 untilPage 1)
    },
): PrinterJob {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return PrinterJob.createPrinterJob(this).also { it.jobSettings.configuration() }
}
