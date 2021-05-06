package com.chyngyz.task2.servicelocator

import com.chyngyz.task2.data.network.RetrofitClient
import com.chyngyz.task2.data.repositories.ExampleRepository
import com.chyngyz.task2.ui.fragments.home.HomeViewModel
import com.chyngyz.task2.ui.fragments.order.OrderViewModel
import com.chyngyz.task2.ui.fragments.profile.ProfileViewModel
import com.chyngyz.task2.ui.fragments.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { HomeViewModel() }
    viewModel { SearchViewModel() }
    viewModel { OrderViewModel() }
    viewModel { ProfileViewModel() }
}

val repositoriesModule = module {
    factory { ExampleRepository(get()) }
}

val networkModule = module {
    single {RetrofitClient().provideExampleApiService()}
}