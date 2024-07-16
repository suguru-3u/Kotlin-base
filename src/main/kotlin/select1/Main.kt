package org.example.select1

//TIP コードを<b>実行</b>するには、<shortcut actionId="Run"/> を押すか
// ガターの <icon src="AllIcons.Actions.Execute"/> アイコンをクリックします。
fun main() {
    // valは定数
    val id = 100

    // 可変変数
    var name = "Takehata"

    // 明示的に型を推論することが可能
    val userId: Int = 100

    for (i in 1..10){
        println("i is $i")
    }

    for(i in 1 until 10 step 2){
        println("i is $i")
    }

    val human = Human(name)
    human.showName()


    // コレクション(型推論が効いてくれる)
    // Listは不変
    val intList:List<Int> = listOf<Int>(1,2,3)
    println(intList[1])

    // mutableListは可変
    val mutableList: MutableList<Int> = mutableListOf(1,2,3)
    mutableList.add(4)

    // mapも不変
    val map:Map<Int,String> = mapOf(1 to "one",2 to "two")
    println(map)
    println(map[2])
    // 値が存在するのか判定してくれる
    println(map.containsKey(1))
    println(map.containsKey(5))

    // mutableMapを可変
    val immutableMap:MutableMap<Int,String> = mutableMapOf(3 to "three",4 to "hour")
    immutableMap[5] = "five"
    println(immutableMap)

    // setは不変
    val set = setOf("one","two","three")
    println(set)
    println(set.contains("one"))
    println(set.contains("five"))

    // mutableSetは可変
    val mutableSet = mutableSetOf("one","two","three")
    mutableSet.add("five")
    println(mutableSet)
}

fun countLengther(str:String):Int{
    return str.length
}

class Human(val name:String){
    fun showName(){
        println(name)
    }
}

// 続きは継承のところから7.15
// 継承するにはopenをつける。関数も一緒。openがない関数は継承されない
open class Animal(val name:String){
    fun showName() = println("name is $name")
    open fun cries() = println("")
}

class Dog(name:String,age:Int): Animal(name){
    override fun cries() = println("bowwow")
}

// 継承の制限、sealedをつけると継承できなくなる(同一ファイル内で定義されたクラスでは継承することが可能)
sealed class Platform{
    abstract  fun showName()
}

// interface
interface Greeter{
    fun hello()
}

class GreeterImpl: Greeter {
    override fun hello(){
        println("Hello.")
    }
}



