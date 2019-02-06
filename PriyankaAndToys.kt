import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/**
* A solution to the "Priyanka and Toys" question on HackerRank
*/

// Complete the toys function below.
fun toys(w: Array<Int>): Int {

var min = Integer.MIN_VALUE // the smallest in the current container
var containerSum = 0 // the number of containers used

Arrays.sort(w) // sort in ascending order

for(it in w){ // for each toy

  if(it > min+4) { // if a new container is needed
    containerSum++ // new container recorded
    min = it // set new minimum
  }
}

// return the calculated sum
return containerSum
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val w = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = toys(w)

    println(result)
}
