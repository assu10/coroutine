package chap05

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking<Unit >{
    println("[${Thread.currentThread().name}] runBlocking 블록 실행~")

//    withContext(context = Dispatchers.IO) {
//        println("[${Thread.currentThread().name}] withContext 블록 실행~")
//    }

    async(context = Dispatchers.IO) {
        println("[${Thread.currentThread().name}] async-await  블록 실행~")
    }.await()
    println("[${Thread.currentThread().name}] runBlocking 블록 실행~")
}