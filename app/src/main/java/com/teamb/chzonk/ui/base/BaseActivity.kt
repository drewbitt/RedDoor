package com.teamb.chzonk.ui.base

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.teamb.chzonk.Constants
import com.teamb.chzonk.data.ViewModel
import com.teamb.chzonk.data.model.Book
import com.teamb.chzonk.data.model.ReadingData
import com.teamb.chzonk.data.room.FileDao
import com.teamb.chzonk.ui.reader.ReaderComicActivity
import com.teamb.chzonk.util.SharedPrefsHelper
import org.jetbrains.anko.toast
import timber.log.Timber
import javax.inject.Inject

@SuppressLint("Registered")
open class BaseActivity : NewDaggerActivity() {

    @Inject
    lateinit var sharedPrefsHelper: SharedPrefsHelper
    @Inject
    lateinit var viewModel: ViewModel
    @Inject
    lateinit var fileDao: FileDao // TESTING

    lateinit var currentBook: Book

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        initIntent(intent)
    }

    private fun initIntent(intent: Intent) = intent.apply {
        currentBook = getParcelableExtra(Constants.ARG_BOOK) ?: Book()
    }

    internal fun startReader(readingData: ReadingData) {

        when (readingData.book.fileExists()) {
            true -> startReaderActivity(readingData)
            false -> try {
                toast("File does not exist")
            } catch (e: Exception) {
                Timber.d("Couldn't toast")
            }
        }
    }

    /*private fun startReaderActivity(readingData: ReadingData) {
        readingData.apply {
            when (book.isValidComicExtension()) {
                true -> {
                    val intent1 = Intent(this@BaseActivity, ReaderComicActivity::class.java)
                    intent1.putExtra(Constants.ARG_BOOK, book)
                    viewModel.setCurrentBook(readingData.book)
                    intent = intent1
                }
                false -> toast("File extension not supported") // may check earlier
            }

            this@BaseActivity.startActivity(intent)
        }
    }
    */

    private fun startReaderActivity(readingData: ReadingData) {
        readingData.apply {
            when (book.isValidComicExtension()) {
                true -> {
                    val intent1 = Intent(this@BaseActivity, ReaderComicActivity::class.java)
                    intent1.putExtra(Constants.ARG_BOOK, book)
                    intent = intent1
                }
                false -> toast("File extension not supported") // may check earlier
            }

            this@BaseActivity.startActivity(intent)
        }
    }
}
