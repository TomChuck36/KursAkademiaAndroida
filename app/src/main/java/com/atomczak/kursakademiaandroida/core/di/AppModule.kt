package com.atomczak.kursakademiaandroida.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.exception.ErrorMapper
import com.atomczak.kursakademiaandroida.core.exception.ErrorMapperImpl
import com.atomczak.kursakademiaandroida.core.exception.ErrorWrapper
import com.atomczak.kursakademiaandroida.core.exception.ErrorWrapperImpl
import com.atomczak.kursakademiaandroida.core.navigation.FragmentNavigator
import com.atomczak.kursakademiaandroida.core.navigation.FragmentNavigatorImpl
import com.atomczak.kursakademiaandroida.core.network.NetworkStateProvider
import com.atomczak.kursakademiaandroida.core.network.NetworkStateProviderImpl
import com.atomczak.kursakademiaandroida.core.provider.ActivityProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory { LinearLayoutManager(androidContext()) }
    factory { GridLayoutManager(androidContext(), 2) }
    factory { DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL) }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
    factory<ErrorWrapper> { ErrorWrapperImpl() }
    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }
    single(createdAtStart = true) { ActivityProvider(androidApplication()) }
    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostFragmentRes = R.id.nav_host_fragment_activity_main,
            homeDestinationRes = R.id.characters_screen
        )
    }
}