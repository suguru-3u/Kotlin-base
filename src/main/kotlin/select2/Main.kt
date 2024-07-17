package select2

// データクラスの作り方
data class User7(val id:Int, var name:String)

// コンストラクタにもデフォルト設定が可能
data class User76(val id:Int,val name:String = "Default Name")

data class User77(val id:Int,val name:String = "Default Name", val age:Int)

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

// 続きは関数型と高階関数 7.17
