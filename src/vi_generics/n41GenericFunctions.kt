package vi_generics

import util.TODO
import java.util.*

fun task41(): Nothing = TODO(
        """
        Task41.
        Add a 'partitionTo' function that splits a collection into two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is a 'partition()' function in the standard library that always returns two newly created lists.
        You should write a function that splits the collection into two collections given as arguments.
        The signature of the 'toCollection()' function from the standard library may help you.
    """,
        references = { l: List<Int> ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
    return partitionTo(this) { s -> !s.contains(" ") }
}

fun partitionTo(arrayList: List<String>, any: (String) -> Boolean): Pair<List<String>, List<String>> {
    val p = mutableListOf<String>()
    val p2 = mutableListOf<String>()

    arrayList.forEach {
        if (any(it)) {
            p.add(it)
        } else {
            p2.add(it)
        }
    }
    return Pair(p, p2)
}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
    return partitionTo(this) { c -> c in 'a'..'z' || c in 'A'..'Z'}
}

fun partitionTo(set: Set<Char>, any: (Char) -> Boolean): Pair<Set<Char>, Set<Char>> {
    val p = mutableSetOf<Char>()
    val p2 = mutableSetOf<Char>()

    set.forEach {
        if (any(it)) {
            p.add(it)
        } else {
            p2.add(it)
        }
    }
    return Pair(p, p2)
}