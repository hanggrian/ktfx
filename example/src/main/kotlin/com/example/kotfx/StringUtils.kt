@file:Suppress("NOTHING_TO_INLINE")

package com.example.kotfx

inline fun String.substringBeforeOneOf(delimiters: Array<String>): String? {
    delimiters.forEach { delimiter -> if (contains(delimiter)) return substringBefore(delimiter) }
    return null
}

inline fun String.substringAfterOneOf(delimiters: Array<String>): String? {
    delimiters.forEach { delimiter -> if (contains(delimiter)) return substringAfter(delimiter) }
    return null
}