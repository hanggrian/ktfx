@file:JvmName("ControlsfxPlatformKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx

import org.controlsfx.tools.Platform

/** Returns true if this is running on Windows. */
public inline fun isPlatformWindows(): Boolean = Platform.getCurrent() == Platform.WINDOWS

/** Returns true if this is running on OSX. */
public inline fun isPlatformOsx(): Boolean = Platform.getCurrent() == Platform.OSX

/** Returns true if this is running on Unix. */
public inline fun isPlatformUnix(): Boolean = Platform.getCurrent() == Platform.UNIX
