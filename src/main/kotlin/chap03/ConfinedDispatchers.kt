package chap03

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.newSingleThreadContext

val dispatcher: CoroutineDispatcher = newSingleThreadContext(name = "Single~")

val multiThreadDispatcher: CoroutineDispatcher = newFixedThreadPoolContext(
    nThreads = 2,
    name = "multiThread",
)
