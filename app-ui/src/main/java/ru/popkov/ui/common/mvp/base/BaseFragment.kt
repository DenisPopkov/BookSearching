package ru.popkov.ui.common.mvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import moxy.MvpAppCompatFragment
import ru.popkov.ui.common.ext.onDestroyNullable

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: (
        inflater: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ) -> VB
) : MvpAppCompatFragment(), BaseView {

    protected abstract fun initViews()

    protected var binding by onDestroyNullable<VB>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }
}