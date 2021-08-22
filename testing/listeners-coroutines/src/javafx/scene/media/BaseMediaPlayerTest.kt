package com.hendraanggrian.ktfx.test

import javafx.scene.media.Media
import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

abstract class BaseMediaPlayerTest {
    private lateinit var player: MediaPlayer

    abstract fun MediaPlayer.callOnError(action: () -> Unit)
    abstract fun MediaPlayer.callOnMarker(action: (MediaMarkerEvent) -> Unit)
    abstract fun MediaPlayer.callOnEndOfMedia(action: () -> Unit)
    abstract fun MediaPlayer.callOnReady(action: () -> Unit)
    abstract fun MediaPlayer.callOnPlaying(action: () -> Unit)
    abstract fun MediaPlayer.callOnPaused(action: () -> Unit)
    abstract fun MediaPlayer.callOnStopped(action: () -> Unit)
    abstract fun MediaPlayer.callOnHalted(action: () -> Unit)
    abstract fun MediaPlayer.callOnRepeat(action: () -> Unit)
    abstract fun MediaPlayer.callOnStalled(action: () -> Unit)

    @BeforeTest
    fun start() {
        initToolkit()
        player = MediaPlayer(Media(javaClass.classLoader.getResource("sample.flv")!!.toString()))
    }

    @Test
    fun onError() {
        var isCalled = false
        player.callOnError { assertTrue(isCalled) }
        isCalled = true
        player.onError.run()
    }

    @Test
    fun onMarker() {
        // TODO: create fake event
        // player.callOnMarker { assertFakeMediaMarkerEvent(it) }
        // player.onMarker.handle(fakeMediaMarkerEventOf())
    }

    @Test
    fun onEndOfMedia() {
        var isCalled = false
        player.callOnEndOfMedia { assertTrue(isCalled) }
        isCalled = true
        player.onEndOfMedia.run()
    }

    @Test
    fun onReady() {
        var isCalled = false
        player.callOnReady { assertTrue(isCalled) }
        isCalled = true
        player.onReady.run()
    }

    @Test
    fun onPlaying() {
        var isCalled = false
        player.callOnPlaying { assertTrue(isCalled) }
        isCalled = true
        player.onPlaying.run()
    }

    @Test
    fun onPaused() {
        var isCalled = false
        player.callOnPaused { assertTrue(isCalled) }
        isCalled = true
        player.onPaused.run()
    }

    @Test
    fun onStopped() {
        var isCalled = false
        player.callOnStopped { assertTrue(isCalled) }
        isCalled = true
        player.onStopped.run()
    }

    @Test
    fun onHalted() {
        var isCalled = false
        player.callOnHalted { assertTrue(isCalled) }
        isCalled = true
        player.onHalted.run()
    }

    @Test
    fun onRepeat() {
        var isCalled = false
        player.callOnRepeat { assertTrue(isCalled) }
        isCalled = true
        player.onRepeat.run()
    }

    @Test
    fun onStalled() {
        var isCalled = false
        player.callOnStalled { assertTrue(isCalled) }
        isCalled = true
        player.onStalled.run()
    }
}