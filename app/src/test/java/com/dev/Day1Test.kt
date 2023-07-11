package com.dev

import org.junit.Test

class Day1Test {

    @Test
    fun test() {

        val map = hashMapOf(
            "key" to "wwe"
        )
        map["key"] = "Roman"

        println("value: ${map["key"]}")
    }

    /**
     * LinkedHashMap 也是通过 散列表 和 链表 组合在一起实现的。
     * 实际上，它不仅支持按照插入顺序遍历数据，还支持按照访问顺序来遍历数据。
     */
    @Test
    fun test1() {
        val map: HashMap<String, Int> = LinkedHashMap()
        map["3"] = 11
        map["1"] = 12
        map["5"] = 23
        map["2"] = 22
        map.forEach { (key, _) ->
            print("$key ")
        }
    }

    @Test
    fun test2() {
        // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        val map: HashMap<String, Int> = LinkedHashMap(10, 0.75f, true)

        /** 每次调用 put() 函数，往 LinkedHashMap 中添加数据的时候，都会将数据添加到链表的尾部 */
        map["3"] = 11
        map["1"] = 12
        map["5"] = 23
        map["2"] = 22

        /** 先查找这个键是否已经有了，然后，再将已经存在的 (3,11) 删除，并且将新的 (3,26) 放到链表的尾部。 */
        map["3"] = 26

        /** 访问到 key 为 5 的数据的时候，我们将被访问到的数据移动到链表的尾部。 */
        map["5"]

        map.forEach { (key, _) ->
            /** 最后打印出来的数据是 1，2，3，5 */
            print("$key ")
        }
    }
}