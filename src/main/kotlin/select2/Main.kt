package select2

// データクラスの作り方
data class User7(val id:Int, var name:String)

// コンストラクタにもデフォルト設定が可能
data class User76(val id:Int,val name:String = "Default Name")

data class User77(val id:Int,val name:String = "Default Name", val age:Int)

data class User88(val id:Int,var name:String,var address:String){

    fun getUser(id:Int):User88{
        return User88(id, "USer88", "Tokyo")
    }
    fun updateUser88(id:Int, newName:String, newAddress:String){
        val user88 = getUser(id).apply{
            this.name = newName
            this.address = newAddress
        }
        println(user88)
    }
}

data class Num(val value: Int){
    operator fun plus(num: Num):Num {
        return Num(value + num.value)
    }
    operator fun compareTo(num:Num):Int{
        return value.compareTo(num.value)
    }
}

// 続きは9デリケートで冗長な処理を移譲できるから 7.20

fun main(){
    printOddOrEventNumberText(1)
    printOddOrEventNumberTextKt(2)
    printOddOrEventNumberTextKt2(3)
    println(printOddOrEventNumberTextKt3(4))

    // 明示的にSetterとGetterを書いていないが、内部処理ではSetter,Getterの仕組みを利用している
    val user1 = User1()
    user1.name = "パリピ孔明"
    println(user1.name)

    val user4 = User4()
    user4.name = "Hero"
    println(user4.isVaildName)
    println(user4.name)
    user4.name = ""
    println(user4.name)

    val userA = User6()
    val userB = User6()

    println(userA.toString())
    println(userB.toString())

    println(userA.hashCode())
    println(userB.hashCode())

    println(userA === userB)

    val set = hashSetOf(userA)
    println(set.contains(userB))

    val user7 = User7(1,"Use7")
    user7.name = "User7"
    println(user7.name)

    val userT = User7(1,"User7")
    val userY = User7(1,"User7")
    val userZ = User7(2,"User7")

    println(userT == userY)
    println(userT == userZ)

    println("user=${userT.hashCode()}")
    println("user=${userY.hashCode()}")
    println("user=${userZ.hashCode()}")

    val setT = hashSetOf(userT)
    println(setT.contains(userY))
    println(setT.contains(userZ))

    println(userT.toString())

    // 新しいメソッドcomponentN(プロパティの順番どうおりの取得することができる)
    println(userT.component1())
    println(userT.component2())

    // copyすることができるメソッド
    val updated = userT.copy(1,"Copy User7")
    println(updated.toString())

    printUserInfo(1)

    val user76 = User76(1)
    println(user76.toString())

    val user77 = User77(id = 1, age = 99)
    println(user77.toString())

    println(calc(1,2))

    println(printCalcResult(10,20, { num1, num2 -> num1 + num2}))
    println(printCalcResult(10,20, { num1, num2 -> num1 * num2}))

    // スコープ関数
    // with,run,let,apply,alsoがある

    // with(thisを省略可能）
    val list = mutableListOf<Int>()
    for(i in 1..10){
        if(i % 2 == 1) list.add(i)
    }

    val oddNumbers = list.joinToString(separator = " ")
    println(oddNumbers)

    val oddNumbers2 = with(mutableListOf<Int>()){
        for(i in 1..10){
            if(i % 2 == 0) this.add(i)
        }
        this.joinToString(separator = " ")
    }

    println(oddNumbers2)

    // run(thisを省略可能）
    val oddNUmbers3 = mutableListOf<Int>().run {
        for(i in 1..10){
            if(i % 3 == 0) this.add(i)
        }
        this.joinToString(separator = " ")
    }
    println(oddNUmbers3)

    // let
    val oddNumbers4 = mutableListOf<Int>().let { list ->
        for(i in 1..10){
            if(i % 4 == 0) list.add(i)
        }
        list.joinToString(separator = " ")
    }
    println(oddNumbers4)

    // 続きはapply7.18
    val oddNumbers5 = mutableListOf<Int>().apply {
        for(i in 1..10){
            if(i % 2 == 1)this.add(i)
        }
        this.joinToString(separator = " ")
    }
    println(oddNumbers5)

    val num = Num(5) + Num(1)
    println(num)

    val greaterThen = Num(5) > Num(1)
    println(greaterThen)
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

// アクセスメソッドを独自に作成することもできる
class User4{
    var name:String =""
        set(value) {
            field = if(value == "") "名無し" else value
        }
    val isVaildName:Boolean
        get() = name != ""
}


// Kotlinではequlas,toString,hasCodeが標準に備わっているが、きちんと動くようにするにはオーバーライドが必要
class User6{
    val id:Int = 1
    val name:String = "Kotlin"

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(javaClass != other?.javaClass) return false

        other as User6

        if(id != other.id) return false
        if(name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return 31 * name.hashCode() + id
    }

    override fun toString(): String {
        return "User6(id=$id,name=$name)"
    }
}

// 関数にデフォルト引数を設定することができる
fun printUserInfo(id:Int ,name:String ="Default Name"){
    println("id=$id name=$name")
}

// 関数型の定義
val calc: (Int, Int) -> Int = { num1: Int, num2: Int -> num1 + num2 }

// 引数の方を省略することも可能
val calc2: (Int, Int) -> Int = { num1 , num2 -> num1 + num2}

// 引数が一つの場合、引数の名前も省略することが可能
val calc3:(Int) -> Int = { it * it}

// 別な書き方として無名関数の書き方も存在する
val calc4:(Int) -> Int = fun(num:Int):Int { return num * num}

// 高階関数
fun printCalcResult(num1: Int, num2:Int, calc:(Int, Int) -> Int):Int{
    val result = calc(num1,num2)
    return result
}

// 型の定義も行うことができる TypeScriptみたい
typealias Calc = (Int, Int) -> Int

fun printCalcResult2(num1:Int, num2:Int, calc:Calc): Int {
    val result = calc(num1,num2)
    return result
}

// 拡張関数
//fun square(num:Int):Int = num * num
//
//fun Int.square():Int = this * this


// スコープ関数 runの応用編
data class User10(var name: String){
    fun getUserString(user: User10?, newName:String):String?{
        return user?.run{
            name = newName
            toString()
        }
    }
}




