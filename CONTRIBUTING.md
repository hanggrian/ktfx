Contributing
============

> A work in progress, check back for more.

This is a rather large project so any help would be appreciated.
There are just a few small guidelines you need to follow.

How Can I Contribute?
---------------------

#### Report Bugs

Try `ktfx` yourself, explore untouched corners and report misbehavior to [Issues](https://github.com/hendraanggrian/ktfx/issues).
When doing so, always try to provide relevant information so we can start from there.

#### Feature Request

Always check for existing requests/issues before opening new ones.
If the request involves core extensions, make sure to follow general rule of [Android KTX](https://github.com/android/android-ktx).

> The goal of Android KTX is to make Android development with Kotlin more concise, pleasant, 
and idiomatic by leveraging the features of the language such as extension functions/properties, lambdas, 
named parameters, and parameter defaults.
It is an explicit goal of this project to not add any new features to the existing Android APIs.

#### Pull Request 

Once you are confident an enhancement should be implemented, create a PR with good reasons why it belongs here.
It doesn't have to be an essay-long, attach examples whenever possible.
Any changes in PR must meet [Style Guides](#style-guides) requirement.

Style Guides
------------

#### Code Style

Refer to [ktlint recommended IDEA settings](https://github.com/shyiko/ktlint) to build successfully.

#### When to Inline

Quoting from [Jake Wharton](https://github.com/android/android-ktx/issues/322):

> This is a general question not specific to this library so I would recommend seeking guidance in a more general forum.
For this library, most things are inline as they're aliases to existing public APIs you could otherwise call directly.
Anything non-inline is likely due to the desire to not bloat the code when the implementation is sufficiently complex.