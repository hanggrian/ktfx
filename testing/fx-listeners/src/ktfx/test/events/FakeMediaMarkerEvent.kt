package javafx.scene.media

import javafx.util.Duration
import javafx.util.Pair
import kotlin.test.assertEquals

private val MARKER = Pair("Hello world", Duration.ONE)

fun assertFakeMediaMarkerEvent(actual: MediaMarkerEvent) {
    assertEquals(MARKER, actual.marker)
}

fun fakeMediaMarkerEventOf() = MediaMarkerEvent(MARKER)