package com.teamb.local_library.parser

import java.io.File
import java.io.InputStream

class ParserZip : ParserClass(), ParserInterface {

    override fun parse(file: File) {
        TODO("not implemented")
    }

    override fun getPage(num: Int): InputStream {
        TODO("not implemented")
    }

    override fun numPages(): Int {
        TODO("not implemented")
    }

    override fun destroy() {
        TODO("not implemented")
    }
}
