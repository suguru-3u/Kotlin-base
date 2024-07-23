package select3

import select3.HelloByjava
import java.time.LocalDateTime
import java.util.UUID

/**
 * Javaのファイルの呼び出し方法
 */

fun main(){
    val hello = HelloByjava()
    hello.printHello()

    val uuid:UUID = UUID.randomUUID()
    println(uuid.toString())

    val nowTime = Time(LocalDateTime.now())
    println(nowTime.main())

    val dog = DogKotlin()
    dog.cry()

    val helloInterface = GreeterImpKotlin()
    helloInterface.hello()

    // SAM変換機能(関数の引数としても使用できる）
    val function = CalcJava { num1, num2 -> num1 + num2 }
    println(function.calc(1,5))

    executeCalc(1,4, CalcJava{ num1, num2 -> num1 + num2 })
}

fun executeCalc(num1:Int, num2:Int, function:CalcJava){
    println(function.calc(num1, num2))
}