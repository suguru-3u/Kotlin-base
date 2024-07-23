package select2.coroutines

import kotlinx.coroutines.*

/**
 * コルーチンで非同期処理を導入する際は、依存関係の追加が必要になる
 * implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
 *
 */


fun main() {
    // 非同処理を実行するには、コルーチンスコープの中でコルーチンビルダーを使用する必要があります
    // コルーチン：GlobalScope
    // コルーチンビルダー：launch(いろいろとメソッドがあるみたい）
//    GlobalScope.launch {
//        delay(1000L)
//        println("Naoto.")
//    }

    // コルーチンスコープはコルーチンビルダーを使用することでも構築することができます
//    runBlocking {
//        launch {
//            delay(1000L) // サスペンド関数：処理を中断することができる
//            println("Naoto.")
//        }
//    }
//
//    println("My name is")
//    Thread.sleep(2000L)

//    runBlocking{
//        launch { printName() }
//        println("My name is")
//    }

    // asyncでの並列処理
    // ラムダ式で書いた処理の結果を受け取ることができる
    runBlocking{
        val result = async {
            delay(2000L)
            var sum = 0
            for(i in 1..10){
                sum += i
            }
            sum
        }
        println("計算中")
        println("sum=${result.await()}")
    }
}

// サスペンド関数として定義
suspend fun printName(){
    delay(1000L)
    println("Naoto.")
}
