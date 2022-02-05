package com.test.photoapp.core.helper.helper.coroutines.dispatchers

import com.test.photoapp.core.helper.helper.coroutines.dispatchers.BaseCoroutineDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class RuntimeDispatcher @Inject constructor() : BaseCoroutineDispatcher {
    override fun main(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun io(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}