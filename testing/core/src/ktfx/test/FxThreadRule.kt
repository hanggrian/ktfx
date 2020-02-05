package ktfx.test

import javafx.application.Platform
import javafx.embed.swing.JFXPanel
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.concurrent.CountDownLatch
import javax.swing.SwingUtilities

/**
 * A JUnit [Rule] for running tests on the JavaFX thread and performing
 * JavaFX initialisation.  To include in your test case, add the following code:
 *
 * <pre>
 * @Rule
 * public JavaFXThreadingRule jfxRule = new JavaFXThreadingRule();
</pre> *
 * @author Andy Till
 */
class FxThreadRule : TestRule {

    private companion object {
        /**
         * Flag for setting up the JavaFX, we only need to do this once for all tests.
         */
        var jfxIsSetup = false
    }

    override fun apply(statement: Statement, description: Description?): Statement {
        return OnJFXThreadStatement(statement)
    }

    private class OnJFXThreadStatement(aStatement: Statement) : Statement() {
        private val statement: Statement
        private var rethrownException: Throwable? = null

        @Throws(Throwable::class) override fun evaluate() {
            if (!jfxIsSetup) {
                setupJavaFX()
                jfxIsSetup = true
            }
            val countDownLatch = CountDownLatch(1)
            Platform.runLater(Runnable {
                try {
                    statement.evaluate()
                } catch (e: Throwable) {
                    rethrownException = e
                }
                countDownLatch.countDown()
            })
            countDownLatch.await()
            // if an exception was thrown by the statement during evaluation,
            // then re-throw it to fail the test
            if (rethrownException != null) {
                throw rethrownException!!
            }
        }

        @Throws(InterruptedException::class) protected fun setupJavaFX() {
            val timeMillis = System.currentTimeMillis()
            val latch = CountDownLatch(1)
            SwingUtilities.invokeLater {
                // initializes JavaFX environment
                JFXPanel()
                latch.countDown()
            }
            println("javafx initialising...")
            latch.await()
            println("javafx is initialised in " + (System.currentTimeMillis() - timeMillis) + "ms")
        }

        init {
            statement = aStatement
        }
    }
}