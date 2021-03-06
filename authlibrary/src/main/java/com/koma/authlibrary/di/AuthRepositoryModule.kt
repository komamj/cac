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

package com.koma.authlibrary.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.koma.authlibrary.data.source.AuthRepository
import com.koma.authlibrary.data.source.AuthRepositoryImp
import dagger.Module
import dagger.Provides

@Module
class AuthRepositoryModule {
    @AuthScoped
    @Provides
    fun provideAuthRepository(repository: AuthRepositoryImp): AuthRepository = repository

    @AuthScoped
    @Provides
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @AuthScoped
    @Provides
    fun provideFirebaseDatabase() = FirebaseDatabase.getInstance().reference
}
