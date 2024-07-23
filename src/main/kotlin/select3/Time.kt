package select3

import java.time.LocalDateTime

class Time(val time: LocalDateTime) {
    fun main(){
        val now = Time(LocalDateTime.now())
        println(now.time)
    }
}