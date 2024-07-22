package select2.collection

data class User(
    val id: Int,
    val teamId: Int,
    val name: String
)

fun main() {
    val lists = listOf(1, 2, 3)
    lists.forEach { num -> print(num) }

    println("")

    // 上記の変数名の省略版
    lists.forEach { print(it) }

    println("")

    // map:新しいListを作成することができる
    val mapLists = lists.map { it * 2 }
    mapLists.forEach { print(it) }

    println("")

    val userLists = listOf(
        User(1, 100, "user1"),
        User(2, 200, "User2"),
        User(2, 200, "User2"),
        User(3, 300, "User3")
    )
    val userIdLists = userLists.map { it.id }
    userIdLists.forEach { print(it) }

    println("")

    // filter
    val userFilterLists =
        userLists.filter { it.teamId == 100 }
    userFilterLists.forEach { print(it) }

    println("")

    // first,last:条件に最初 or 最後にマッチする要素を抽出する
    // ()中に条件を書くこともできる
    // firstOrNUll,lastOrNUllもあり、こちらは要素が存在しなかった場合、NULLを返却す
    println(userLists.first())
    println(userLists.last())

    println("")

    // distinct:重複を排除したListを生成することができる
    val numLists = listOf(1, 2, 1, 3, 2, 4, 5)
    val distinctNumLists = numLists.distinct()
    distinctNumLists.forEach { print(it) }

    println("")

    // associateBy,assoxiateWith:コレクションからMapを作成する
    // 任意の値をKeyにして、コレクション要素をvalueとしてMapを作成する
    val newMap = userLists.associateBy { it.id }
    print(newMap)

    println("")

    val newMap2 =
        userLists.associateWith { it.id }
    print(newMap2)

    println("")

    // groupBy: key毎に要素をまとめたMapを生成
    // 以下の例ではTeamId毎にグループを分けて、グループ毎に配列化している
    val groupUserLists =
        userLists.groupBy { it.teamId }
    print(groupUserLists)

    println("")

    // count:条件に該当する要素の数を取得
    println(userLists.count { it.teamId == 200 })

    println("")

    // chunked:指定の要素数毎に分割したListを生成
    val chunkedList = userLists.chunked(2)
    println(chunkedList)

    println("")

    // reduce:要素を畳み込む
    // acc:現在までの処理された合算の結果の値
    // i:順番に取り出している現在の要素の値
    val reduceLists = numLists.reduce { acc, i ->
        println("$acc + $i")
        acc + i
    }
    print(reduceLists)

    println("")

    // 文字列も対応することが可能
    val strLists = listOf("a", "c", "b", "e", "d")
    val resuceStrLists =
        strLists.reduce { line, str -> line + str }
    print(resuceStrLists)

    println("")
}