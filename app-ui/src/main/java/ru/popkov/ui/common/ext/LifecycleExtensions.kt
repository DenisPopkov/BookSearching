package ru.popkov.ui.common.ext

import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

@FlowPreview
@ExperimentalCoroutinesApi
fun TextInputEditText.createUserRequestWithDelay(): Flow<Unit> = callbackFlow {
    addTextChangedListener {
        trySend(Unit)
    }
    awaitClose { setOnClickListener(null) }
}

fun <T> LifecycleOwner.onDestroyNullable(): ReadWriteProperty<LifecycleOwner, T> =
    object : ReadWriteProperty<LifecycleOwner, T>, DefaultLifecycleObserver {

        private var value: T? = null

        init {
            this@onDestroyNullable
                .lifecycle
                .addObserver(this)
        }

        override fun onDestroy(owner: LifecycleOwner) {
            value = null
            this@onDestroyNullable
                .lifecycle
                .removeObserver(this)
            super.onDestroy(owner)
        }

        override fun setValue(thisRef: LifecycleOwner, property: KProperty<*>, value: T) {
            this.value = value
        }

        override fun getValue(thisRef: LifecycleOwner, property: KProperty<*>): T {
            return value!!
        }
    }