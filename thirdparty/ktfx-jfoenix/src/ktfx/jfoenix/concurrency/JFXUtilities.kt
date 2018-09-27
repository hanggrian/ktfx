@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.concurrency.JFXUtilities

inline fun runFx(noinline block: () -> Unit) = JFXUtilities.runInFX(block)

inline fun runAndWaitFx(noinline block: () -> Unit) = JFXUtilities.runInFXAndWait(block)