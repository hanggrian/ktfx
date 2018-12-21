package ktfx.print

import javafx.print.JobSettings
import javafx.print.PageLayout
import javafx.print.Printer
import javafx.print.PrinterJob
import javafx.scene.Node
import javafx.scene.transform.Scale
import ktfx.internal.Experimental

enum class DialogOption {
    NONE,
    DEFAULT,
    COMPLETE
}

@Experimental
fun Printer.print(
    node: Node,
    layout: PageLayout = defaultPageLayout,
    scale: Scale = Scale(
        (layout.printableWidth - layout.leftMargin - layout.rightMargin) / node.boundsInParent.width,
        (layout.printableHeight - layout.bottomMargin) / node.boundsInParent.height
    ),
    option: DialogOption = DialogOption.DEFAULT,
    settings: JobSettings.() -> Unit = {
        copies = 1
        setPageRanges(1 untilPage 1)
        pageLayout = layout
    }
): Boolean {
    val job = checkNotNull(PrinterJob.createPrinterJob(this)) { "Unable to create printer job" }
    job.jobSettings.settings()
    node.transforms += scale
    if (when (option) {
            DialogOption.NONE -> job.printPage(node)
            DialogOption.DEFAULT -> job.showPrintDialog(node.scene.window) && job.printPage(node)
            DialogOption.COMPLETE -> job.showPageSetupDialog(node.scene.window) &&
                job.showPrintDialog(node.scene.window) &&
                job.printPage(node)
        }
    ) {
        job.endJob()
        node.transforms -= scale
        return true
    }
    node.transforms -= scale
    return false
}