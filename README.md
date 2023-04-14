### 往数组里插数据

数据往后移动，所以 i = 终点 count
scope: (count) -> index + 1
注意这里是 count, 不是 capacity。

```
(count downTo index + 1).forEach {
    data[it] = data[it - 1]
}
    data[index] = value
    ++count
```

### 往数组里删除数据

数据往前移动，所以 i = index + 1
scope: (index + 1) -> capacity
注意这里是 capacity, 不是 count。

```
(index + 1 until capacity).forEach {
    data[it - 1] = data[it]
}
    --count
```