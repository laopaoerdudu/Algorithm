package com.dev

data class NodeLink(
    val value: String?,
    var prev: NodeLink? = null,
    var next: NodeLink? = null
)