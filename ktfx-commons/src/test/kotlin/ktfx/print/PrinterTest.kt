package ktfx.print

import javafx.print.Printer
import kotlin.test.Test
import kotlin.test.assertEquals

class PrinterTest {
    @Test
    fun createJob() {
        Printer.getDefaultPrinter()?.run {
            val job =
                createJob {
                    copies = 2
                    setPageRanges(1 untilPage 3)
                }
            assertEquals(2, job.jobSettings.copies)
            job.jobSettings.pageRanges.single().let {
                assertEquals(1, it.startPage)
                assertEquals(3, it.endPage)
            }
        }
    }
}
