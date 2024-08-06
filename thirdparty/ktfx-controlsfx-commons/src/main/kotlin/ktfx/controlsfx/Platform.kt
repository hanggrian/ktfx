@file:JvmName("ControlsfxPlatformKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx

import org.controlsfx.tools.Platform

/** Returns true if this is running on Windows. */
inline fun isPlatformWindows(): Boolean = Platform.getCurrent() == Platform.WINDOWS

/** Returns true if this is running on OSX. */
inline fun isPlatformOsx(): Boolean = Platform.getCurrent() == Platform.OSX

/** Returns true if this is running on Unix. */
inline fun isPlatformUnix(): Boolean = Platform.getCurrent() == Platform.UNIX
