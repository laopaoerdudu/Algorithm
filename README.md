
针对链表的插入和删除操作，我们只需要考虑相邻结点的指针改变，所以对应的时间复杂度是 O(1)。

单链表，尾结点指向一个空地址 NULL，表示这是链表上最后一个结点。

循环链表，尾结点指针是指向链表的头结点。它像一个环一样首尾相连，所以叫作“循环”链表。

双向链表尽管比较费内存，但还是比单链表的应用更加广泛的原因。如果你熟悉 Java 语言，你肯定用过 LinkedHashMap 这个容器。
如果你深入研究 LinkedHashMap 的实现原理，就会发现其中就用到了双向链表这种数据结构。

那就是用空间换时间的设计思想。当内存空间充足的时候，如果我们更加追求代码的执行速度，我们就可以选择空间复杂度相对较高、但时间复杂度相对很低的算法或者数据结构。
相反，如果内存比较紧缺，比如代码跑在手机或者单片机上，这个时候，就要反过来用时间换空间的设计思路。

缓存实际上就是利用了空间换时间的设计思想。如果我们把数据存储在硬盘上，会比较节省内存，但每次查找数据都要询问一次硬盘，会比较慢。
但如果我们通过缓存技术，事先将数据加载在内存中，虽然会比较耗费内存空间，但是每次数据查询的速度就大大提高了。

数组和链表的对比，并不能局限于时间复杂度。而且，在实际的软件开发中，不能仅仅利用复杂度分析就决定使用哪个数据结构来存储数据。

链表本身没有大小的限制，天然地支持动态扩容，我觉得这也是它与数组最大的区别。

如果你的代码对内存的使用非常苛刻，那数组就更适合你。
因为链表中的每个结点都需要消耗额外的存储空间去存储一份指向下一个结点的指针，所以内存消耗会翻倍。
而且，对链表进行频繁的插入、删除操作，还会导致频繁的内存申请和释放，容易造成内存碎片，如果是 Java 语言，
就有可能会导致频繁的 GC（Garbage Collection，垃圾回收）。

如何基于链表实现 LRU 缓存淘汰算法？

缓存的大小有限，当缓存被用满时，哪些数据应该被清理出去，哪些数据应该被保留。
最近最少使用策略 LRU（Least Recently Used）。

我经常用来检查链表代码是否正确的边界条件有这样几个：

1，如果链表为空时，代码是否能正常工作？

2，如果链表只包含一个结点时，代码是否能正常工作？

3，如果链表只包含两个结点时，代码是否能正常工作？

4，代码逻辑在处理头结点和尾结点的时候，是否能正常工作？




























