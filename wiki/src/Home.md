_This wiki is a work in progress, and parts of it may still be under construction._

[Kotlin] extensions for JavaFX app development and more. Written in spirit of [android-ktx] and [anko].

Consists of several parts:
 * *KtFX Commons*: full of helpers for common JavaFX application logic.
 * *KtFX Layouts*: dynamic JavaFX layout with Kotlin DSL.
 * *KtFX Listeners*: write common JavaFX listeners with Kotlin DSL.
 * *KtFX Coroutines*: utilities based on the experimental [kotlinx.coroutines] library.
 * *KtFX Styles*: type-safe inline CSS styling.

Download
--------
All artifacts are hosted on [jcenter].
To download all of them, use KtFX main library (see `version` in [releases]):

```gradle
dependencies {
    compile 'com.hendraanggrian.ktfx:ktfx:$version'
}
```

Or download separate library if only specific feature is desired:

```gradle
dependencies {
    compile 'com.hendraanggrian.ktfx:ktfx-commons:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-layouts:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-listeners:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-coroutines:$version'
    compile 'com.hendraanggrian.ktfx:ktfx-styles:$version'
}
```

License
-------
    Copyright 2018 Hendra Anggrian

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[Kotlin]: https://kotlinlang.org/
[android-ktx]: https://github.com/android/android-ktx
[anko]: https://github.com/Kotlin/anko
[kotlinx.coroutines]: https://github.com/Kotlin/kotlinx.coroutines
[releases]: https://github.com/hendraanggrian/ktfx/releases
[jcenter]: https://bintray.com/hendraanggrian/ktfx