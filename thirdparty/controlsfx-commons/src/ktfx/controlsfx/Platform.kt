@file:JvmName("ControlsFxPlatformKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx

import org.controlsfx.tools.Platform

/** Returns true if this is running on Windows OS. */
inline fun isPlatformWindows(): Boolean = Platform.getCurrent() == Platform.WINDOWS

/** Returns true if this is running on Mac OS. */
inline fun isPlatformOSX(): Boolean = Platform.getCurrent() == Platform.OSX

/** Returns true if this is running on Unix OS. */
inline fun isPlatformUnix(): Boolean = Platform.getCurrent() == Platform.UNIX
