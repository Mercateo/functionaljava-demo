package com.mercateo.demo.functionaljava

import java.util.*

object KotlinBenchmark {

    fun filterPositiveNumbers(data: BenchmarkData) {
        val list = data.arrayList
        val result = list.filter({ x -> x > 5 })
    }

    fun processNumbers(data: BenchmarkData) {
        val array = data.arrayList

        val result = array.map { it.toLong() }.fold(0L, { sum, value -> sum + value })
    }

    fun listAppendSingle(data: BenchmarkData) {
        val list = data.linkedList
        val array = LinkedList(list)

        list.forEach { array.add(it) }
    }

    fun listAppendImmutableSingle(data: BenchmarkData) {
        val list = data.linkedList.toList()

        val result = list.fold(list, { list, element -> list + element })
    }

    fun listAppend(data: BenchmarkData) {
        val list = data.linkedList

        val linkedList = LinkedList(list)

        linkedList.addAll(list)
    }

    fun arrayAppendSingle(data: BenchmarkData) {
        val list = data.arrayList

        val array = ArrayList(list)

        list.forEach { array.add(it) }
    }

    fun arrayAppendImmutableSingle(data: BenchmarkData) {
        val array = data.arrayList.toArray()

        val result = array.fold(array, { array, element -> array + element })
    }

    fun arrayAppend(data: BenchmarkData) {
        val list = data.arrayList
        val array = ArrayList(list)
        array.addAll(list)
    }

    fun mapPutSingle(data: BenchmarkData) {
        val array = data.arrayList

        var map = mutableMapOf<String, Int>()
        for (integer in array) {
            map.put(integer.toString(), integer)
        }
    }

    fun mapPutImmutableSingle(data: BenchmarkData) {
        val array = data.arrayList

        var map = emptyMap<String, Int>()
        for (integer in array) {
            map = map + Pair(integer.toString(), integer)
        }
    }
}
