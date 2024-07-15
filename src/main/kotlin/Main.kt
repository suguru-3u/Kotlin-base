package org.example

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