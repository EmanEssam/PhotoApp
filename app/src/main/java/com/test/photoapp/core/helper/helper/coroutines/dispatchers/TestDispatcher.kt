package com.test.photoapp.core.helper.helper.coroutines.dispatchers

import com.test.photoapp.core.helper.helper.coroutines.dispatchers.BaseCoroutineDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class TestDispatcher : BaseCoroutineDispatcher {
    override fun main(): CoroutineDispatcher {
        return Dispatchers.Unconfined
    }

    override fun io(): CoroutineDispatcher {
        return Dispatchers.Unconfined
    }
}