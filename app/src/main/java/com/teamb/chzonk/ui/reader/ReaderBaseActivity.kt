package com.teamb.chzonk.ui.reader

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.teamb.chzonk.Constants
import com.teamb.chzonk.R
import com.teamb.chzonk.ui.base.BaseActivity

@SuppressLint("Registered")
open class ReaderBaseActivity : BaseActivity() {
    // Skeleton for things that would go in a base activity and could be extended in the future
    // bindview stuff here, internal vars, helper functions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reader)
        currentBook = intent.getParcelableExtra(Constants.ARG_BOOK)
       // title = viewModel.currentBook.value!!.title
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        title = viewModel.currentBook.value!!.title
    }


    protected open fun setImage() {
        // override in children
    }

    protected fun overlayImage() {
        // glide function
    }

    protected open fun setButtons() {
        // override in children
    }

    private fun setProgress() {
        // based off of current page #
    }

    protected fun setPageNumberText() {
        // set the page number text bindview
    }
}
