package ktfx.print

import javafx.print.Printer
import kotlin.test.Test
import kotlin.test.assertEquals

class PrinterTest {

    @Test
    fun createJob() {
        Printer.getDefaultPrinter()?.run {
            val job = createJob {
                copies = 2
                setPageRanges(1 untilPage 3)
            }
            assertEquals(2, job.jobSettings.copies)
            assertEquals(1, job.jobSettings.pageRanges.first().startPage)
            assertEquals(3, job.jobSettings.pageRanges.first().endPage)
        }
    }
}
