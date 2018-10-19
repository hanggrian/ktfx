@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.concurrency.JFXUtilities

inline fun runFx(noinline block: () -> Unit): Unit = JFXUtilities.runInFX(block)

inline fun runAndWaitFx(noinline block: () -> Unit): Unit = JFXUtilities.runInFXAndWait(block)