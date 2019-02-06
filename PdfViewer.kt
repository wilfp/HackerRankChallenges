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
* The "Designer PDF Viewer" Challenge on HackerRank
*/

// Complete the designerPdfViewer function below.
fun designerPdfViewer(h: Array<Int>, word: String): Int {

// all the letters
val alphabet = "abcdefghijklmnopqrstuvwxyz"

val height = word.chars() // get word as stream
.mapToObj{ alphabet.indexOf(Character.toChars(it)[0]) } // get index in alphabet
.mapToInt{ h[it] } // get char height
.max() // get height
.asInt

// return area
return word.length * height

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val h = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val word = scan.nextLine()

    val result = designerPdfViewer(h, word)

    println(result)
}
