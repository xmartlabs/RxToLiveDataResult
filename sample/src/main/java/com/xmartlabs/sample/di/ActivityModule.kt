package com.xmartlabs.sample.di

import com.xmartlabs.sample.ui.ListTrendingReposActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModule {
  @ContributesAndroidInjector
  abstract fun contributeListUsersActivity(): ListTrendingReposActivity
}
