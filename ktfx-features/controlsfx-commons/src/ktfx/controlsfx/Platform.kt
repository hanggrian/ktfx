@file:JvmName("ControlsFxPlatformKt")

package ktfx.controlsfx

import org.controlsfx.tools.Platform

/** Returns true if this is running on Windows OS. */
fun isWindows(): Boolean =
    Platform.getCurrent() == Platform.WINDOWS

/** Returns true if this is running on Mac OS. */
fun isOSX(): Boolean =
    Platform.getCurrent() == Platform.OSX

/** Returns true if this is running on Unix OS. */
fun isUnix(): Boolean =
    Platform.getCurrent() == Platform.UNIX
