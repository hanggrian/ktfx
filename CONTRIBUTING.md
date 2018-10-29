Contributing
============

Any help would be much appreciated, there are just a few small guidelines you need to follow.

How can I contribute?
---------------------

#### Report bugs

Try `ktfx` yourself, explore untouched corners and report misbehavior to [Issues](https://github.com/hendraanggrian/ktfx/issues).
When doing so, always try to provide relevant information so we can start from there.

#### Feature request

Always check for existing requests/issues before opening new ones.

#### Pull request 

Once you are confident an enhancement should be implemented, create a PR with good reasons why it belongs here.
It doesn't have to be an essay-long, attach examples whenever possible.
Any changes in PR must meet [Style Guides](#style-guides) requirement.

Style guides
------------

#### Code style

Refer to [ktlint recommended IDEA settings](https://github.com/shyiko/ktlint) to build successfully.

#### When to inline

Quoting from [Jake Wharton](https://github.com/android/android-ktx/issues/322):

> This is a general question not specific to this library so I would recommend seeking guidance in a more general forum.
For this library, most things are inline as they're aliases to existing public APIs you could otherwise call directly.
Anything non-inline is likely due to the desire to not bloat the code when the implementation is sufficiently complex.