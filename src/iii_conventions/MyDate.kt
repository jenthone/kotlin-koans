package iii_conventions

import iv_properties.toMillis

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)

operator fun MyDate.compareTo(other: MyDate) = toMillis().compareTo(other.toMillis())

operator fun DateRange.contains(value: MyDate) = value >= start && value <= endInclusive

operator fun DateRange.iterator() = object : Iterator<MyDate> {
    private var current = start
    override fun hasNext() = current <= endInclusive

    override fun next(): MyDate {
        val next = current
        current = current.nextDay()
        return next
    }
}

operator fun MyDate.plus(time: TimeInterval) = addTimeIntervals(time, 1)

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval) =
        addTimeIntervals(repeatedTimeInterval.ti, repeatedTimeInterval.n)

class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)

operator fun TimeInterval.times(i: Int) = RepeatedTimeInterval(this, i)