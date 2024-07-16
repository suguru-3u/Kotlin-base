package select2

fun main(){
    printOddOrEventNumberText(1)
    printOddOrEventNumberTextKt(2)
    printOddOrEventNumberTextKt2(3)
    println(printOddOrEventNumberTextKt3(4))

    // 明示的にSetterとGetterを書いていないが、内部処理ではSetter,Getterの仕組みを利用している
    val user1 = User1()
    user1.name = "パリピ孔明"
    println(user1.name)
}

fun printOddOrEventNumberText(num:Int){
    var text = ""
    if(num % 2 == 1){
        text = "奇数"
    }else{
        text = "偶数"
    }

    println(text)
}

// 上の関数を以下のように書くことができる
fun printOddOrEventNumberTextKt(num:Int){
    val text = if(num % 2 ==1){
        "奇数"
    }else{
        "偶数"
    }

    println(text)
}

// こんな書き方も可能
fun printOddOrEventNumberTextKt2(num:Int){
    val text = if(num % 2 ==1) "奇数" else "偶数"
    println(text)
}

// こんな書き方も可能
fun printOddOrEventNumberTextKt3(num:Int):String{
    return if(num % 2 ==1) "奇数" else "偶数"
}

// アクセスメソッドについて
class User1{
    // varではSetter,Getterを作成してくれるが
    // valでは不変のため、Getterしか作成されない
    var name:String = ""
}