/*
 * Copyright 2020 komamj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.koma.authlibrary.login

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.observe
import androidx.lifecycle.ViewModelProvider
import com.koma.authlibrary.R
import com.koma.authlibrary.ViewModelFactory
import com.koma.authlibrary.databinding.FragmentLoginBinding
import com.koma.authlibrary.di.AuthRepositoryModule
import com.koma.authlibrary.di.DaggerAuthComponent
import com.koma.commonlibrary.base.BaseFragment
import timber.log.Timber
import javax.inject.Inject

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: LoginViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerAuthComponent.builder()
            .authRepositoryModule(AuthRepositoryModule())
            .build()
            .inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)

        Timber.d("onAttach viewModel:$viewModel")
    }

    override fun getLayoutId() = R.layout.fragment_login

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.isLoading.observe(viewLifecycleOwner){

        }
    }
}
