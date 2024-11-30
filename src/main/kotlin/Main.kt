/*Дан массив целых чисел nums и целое число target, вернуть индексы двух чисел, чтобы их сумма давала target.
Предполагается, что каждый вход будет иметь ровно одно решение, и нельзя использовать один и тот же элемент дважды.
Вы можете возвращать ответ в любом порядке. Результат вернуть в виде массива*/

import kotlin.system.measureTimeMillis

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            println("nums[${map[complement]!!}] + nums[$i] == $target.")
            return intArrayOf(map[complement]!!,1)
        }
        map[nums[i]] = i
    }
    throw IllegalArgumentException("Нет решения с двумя суммами")
}

fun readInt(): IntArray {
    return readLine()?.split(Regex("[,\\s]+"))?.map { it.toInt() }?.toIntArray() ?: intArrayOf()
}

fun main() {
    print("Введите массив: ")
    val nums = readInt()
    print("Введите целое число: ")
    val target = readLine()?.toInt()

    testSum(nums, target!!)
}

fun testSum(nums: IntArray, target: Int) {
    val startTime = System.currentTimeMillis()
    val result = twoSum(nums, target)
    val endTime = System.currentTimeMillis()
    val time = endTime - startTime
    println("Вывод: ${result.contentToString()}, Время: $time мс")
}