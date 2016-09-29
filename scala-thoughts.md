
# Scala Thoughts

### Instructions

After completing the exercises, take about 20 minutes to collect and write
about your initial impressions of Scala.  Write about them in
scala-thoughts.md Some possible topics include:

---

### Questions

#### 1. What's easy to do in Scala? What's not?

It is easy to write code that feels like python's functional programming.
It was very easy to chain methods and compose different chunks of code.
It was a little harder / less elegant to write imperitive code, but definitely
still possible.

From reading the scala documentation intro, it became clear that support for
DSLs is a key feature, under the extensibility section. This can be seein in
the ability to customize the syntax for specific domains, the freedom of
function call syntax (infix or postfix, curried vs uncurried,
and zero argument vs no argument).

---

#### 2. What is/are your favorite language design choice(s) that the designers of
Scala made? Why?

I really like how Scala's language designers did not seem to be forcing their
preferred paradigm upon users.  For example, the use of a functional style,
while well supported, is not the only way to write ones code.

This was encouraging, especially comparing it to Haskell, which is very
strict to ensure an exclusively functional style, to the point that the
code executed by the machine is difficult to predict based only on the
source code, and the order of execution may be unclear to the programmer.

I think this was part of the testing suite rather than a Scala design
decision, but I really liked the way the testing suite reported how the
code result differed from an expected value.  For example, we have
`"A person named[:] Jack" vs "A person named[] Jack"`, allowing us
to determine that we are filling in the correct name, but we are
forgetting to add the colon, rather than just seeing that the test
failed, and having to debug the cause.

---

#### 3. What is/are your least favorite language design choice(s)?
Why? And why do you think the designers made that / those choice(s)?

I don't like the fact that every function and piece of data has to be inside
a class or object, it gives me flashbacks of Java.  I suppose I like the
way it avoids the grossly overloaded `static` keyword in other languages,
like in `C++`.  I think the implementers likely decided on this for consistency
with Java and to fit into the idea of encapsulation.

I also found the type system and error reporting somewhat confusing. For
example, when I had a tuple of homogenous types (returned by partition),
and I wanted to convert it to a list, I tried to use `ProductIterator.ToList`,
but this lost type information (since tuples need not be homogenous).

When I tried to convert to a list using the list constructor, i.e.:

`Function.tupled(List)(the_tuple)`

which gave me the following error message:
```
[error]   [a1, a2, a3, a4, a5, b](f: (a1, a2, a3, a4, a5) => b)((a1, a2, a3, a4, a5)) => b <and>
[error]   [a1, a2, a3, a4, b](f: (a1, a2, a3, a4) => b)((a1, a2, a3, a4)) => b <and>
[error]   [a1, a2, a3, b](f: (a1, a2, a3) => b)((a1, a2, a3)) => b <and>
[error]   [a1, a2, b](f: (a1, a2) => b)((a1, a2)) => b
[error]  cannot be applied to (scala.collection.immutable.List.type)
```
It seemed strange that it was not able to determine which version I wanted given
the length of the tuple it was being applied to.

(I ended up just pattern matching the values out of the tuple and making a list
 out of them, which did not seem very elegant, but got the job done.)

---

#### 4. What Scala features would you like to learn more about?

I definitely want to learn more about traits.  It seems that they are similar
to generics or templates, but it also seems that there could be a number of
_gotchas_ when using these, especially in the context of inheritance, since
this can complicate the rules of the type system.

I also want to learn more about the type system, exactly how covariants and
contravariants relate to subtypes and supertypes.

I want to learn more about `for` comprehensions.  I didn't really do much to
learn about them because I was short for time and they were not necessary
for the assignment, but I saw a couple of snippets mentioning them on the
neophyte's guide to scala part 5.

---

