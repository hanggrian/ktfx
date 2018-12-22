@file:Suppress("NOTHING_TO_INLINE")

package ktfx.print

import javafx.print.JobSettings
import javafx.print.PageLayout
import javafx.print.Printer
import javafx.print.PrinterJob
import javafx.scene.Node
import ktfx.scene.transform.scale

fun Node.print(
    printer: Printer = Printer.getDefaultPrinter(),
    layout: PageLayout = printer.defaultPageLayout,
    scaleX: Double = (layout.printableWidth - layout.rightMargin) / boundsInParent.width,
    scaleY: Double = (layout.printableHeight - layout.bottomMargin) / boundsInParent.height,
    settings: JobSettings.() -> Unit = {
        copies = 1
        setPageRanges(1 untilPage 1)
        pageLayout = layout
    }
): Boolean = printNewJob(printer, scaleX, scaleY, settings) {
    printPage(this@print)
}

fun Node.printDialog(
    printer: Printer = Printer.getDefaultPrinter(),
    layout: PageLayout = printer.defaultPageLayout,
    scaleX: Double = (layout.printableWidth - layout.rightMargin) / boundsInParent.width,
    scaleY: Double = (layout.printableHeight - layout.bottomMargin) / boundsInParent.height,
    settings: JobSettings.() -> Unit = {
        copies = 1
        setPageRanges(1 untilPage 1)
        pageLayout = layout
    }
): Boolean = printNewJob(printer, scaleX, scaleY, settings) {
    showPrintDialog(scene.window) && printPage(this@printDialog)
}

fun Node.printSetupDialog(
    printer: Printer = Printer.getDefaultPrinter(),
    layout: PageLayout = printer.defaultPageLayout,
    scaleX: Double = (layout.printableWidth - layout.rightMargin) / boundsInParent.width,
    scaleY: Double = (layout.printableHeight - layout.bottomMargin) / boundsInParent.height,
    settings: JobSettings.() -> Unit = {
        copies = 1
        setPageRanges(1 untilPage 1)
        pageLayout = layout
    }
): Boolean = printNewJob(printer, scaleX, scaleY, settings) {
    showPageSetupDialog(scene.window) && showPrintDialog(scene.window) && printPage(this@printSetupDialog)
}

private inline fun Node.printNewJob(
    printer: Printer,
    scaleX: Double,
    scaleY: Double,
    settings: JobSettings.() -> Unit,
    print: PrinterJob.() -> Boolean
): Boolean {
    val job = checkNotNull(PrinterJob.createPrinterJob(printer)) { "Unable to create printer job" }
    job.jobSettings.settings()
    val scale = scale(scaleX, scaleY)
    if (job.print()) {
        job.endJob()
        transforms -= scale
        return true
    }
    transforms -= scale
    return false
}