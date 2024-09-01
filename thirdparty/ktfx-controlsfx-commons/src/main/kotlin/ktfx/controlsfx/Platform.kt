@file:JvmName("ControlsfxPlatformKt")

package ktfx.controlsfx

import org.controlsfx.tools.Platform

/** Returns true if this is running on Windows. */
public fun isPlatformWindows(): Boolean = Platform.getCurrent() == Platform.WINDOWS

/** Returns true if this is running on OSX. */
public fun isPlatformOsx(): Boolean = Platform.getCurrent() == Platform.OSX

/** Returns true if this is running on Unix. */
public fun isPlatformUnix(): Boolean = Platform.getCurrent() == Platform.UNIX
