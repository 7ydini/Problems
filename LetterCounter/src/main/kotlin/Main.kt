package main.kotlin

fun main(){
    //in
    //AAAAAAAAASSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDWWWWWWWWWEEETTTTTTTTTAAAAAAAABBVBBBQWEQWQQQEEWQWAAABBD
    //out
    //A9S16D16W9E3T9A8B2VB3QWEQWQ3E2WQWA3B2D
    println(LetterCounter("AAAAAAAAASSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDWWWWWWWWWEEETTTTTTTTTAAAAAAAABBVBBBQWEQWQQQEEWQWAAABBD"))
}

fun LetterCounter(str: String): String{
    var count: Int = 1
    var list: String = ""
    var i: Int = 0
    while (i < str.length - 1){
        if(str[i] != str[i+1]){
            list += if (count != 1) {
                "${str[i]}$count"
            }else "${str[i]}"
            count = 0
        }
        count++
        i++
    }
    list += if(str[i] == str[i - 1]){
        "${str[i - 1]}${count}"
    }else "${str[i]}"

    return list
}
