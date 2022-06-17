package com.hendraanggrian.ktfx.test

import javafx.application.Platform
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException

/**
 * A test rule that ensures that JavaFX tests run on the main UI thread.
 *
 * @see <a href="http://andrewtill.blogspot.com/2012/10/junit-rule-for-javafx-controller-testing.html">WONTFIX: JUnit
 * Rule for JavaFX Controller Testing</a>
 */
class JavaFXThreadRule : TestRule {

    override fun apply(statement: Statement, description: Description?): Statement? {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                val statementFuture = CompletableFuture<Void?>()
                Platform.runLater {
                    try {
                        statement.evaluate()
                        statementFuture.complete(null)
                    } catch (throwable: Throwable) {
                        statementFuture.completeExceptionally(throwable)
                    }
                }
                try {
                    statementFuture.get()
                } catch (e: ExecutionException) {
                    throw e.cause!!
                }
            }
        }
    }
}
