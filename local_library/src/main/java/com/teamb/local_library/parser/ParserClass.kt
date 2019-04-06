package com.teamb.local_library.parser

open class ParserClass {

    var path = ""

    fun isImage(filename: String) = filename.toLowerCase().matches(".*\\.(jpg|jpeg|bmp|gif|png|webp)$".toRegex())
}
