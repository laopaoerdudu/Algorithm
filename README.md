### 原地排序算法

特指空间复杂度是 O(1) 的排序算法。

### 稳定的排序算法

如果待排序的序列中存在值相等的元素，经过排序之后，相等元素之间原有的先后顺序不变。

### 冒泡排序（Bubble Sort）

冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。
如果不满足就让它俩互换。一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。

>冒泡的过程只涉及相邻数据的交换操作，只需要常量级的临时空间，所以它的空间复杂度为 O(1)，是一个原地排序算法。
当有相邻的两个元素大小相等的时候，我们不做交换，相同大小的数据在排序前后不会改变顺序，所以冒泡排序是稳定的排序算法。
最好情况下，要排序的数据已经是有序的了，我们只需要进行一次冒泡操作，就可以结束了，所以最好情况时间复杂度是 O(n)。
而最坏的情况是，要排序的数据刚好是倒序排列的，我们需要进行 n 次冒泡操作，所以最坏情况时间复杂度为 O(n2)。

### 插入排序（Insertion Sort）

一个有序的数组，我们往里面添加一个新的数据后，如何继续保持数据有序呢？很简单，我们只要遍历数组，找到数据应该插入的位置将其插入即可。

那插入排序具体是如何借助上面的思想来实现排序的呢？

我们将数组中的数据分为两个区间，已排序区间和未排序区间。
初始已排序区间只有一个元素，就是数组的第一个元素。
插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
重复这个过程，直到未排序区间中元素为空，算法结束。

插入排序也包含两种操作，一种是元素的比较，一种是元素的移动。

- 从下标为 1 开始，左边为已排序，右边为待排序

