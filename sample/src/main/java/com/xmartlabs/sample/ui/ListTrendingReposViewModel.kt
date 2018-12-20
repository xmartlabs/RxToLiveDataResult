package com.xmartlabs.sample.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.xmartlabs.rxtolivedataresult.toResult
import com.xmartlabs.sample.repository.RepoRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mirland on 20/12/18.
 */
@Singleton
class ListTrendingReposViewModel @Inject constructor(
    private val repoRepository: RepoRepository
): ViewModel() {
  private val refresh: MutableLiveData<Any> = MutableLiveData()

  val trendingRepositories = Transformations.switchMap(refresh){
    repoRepository.getTrendingRepositories()
        .toResult()
  }

  init {
    refreshData()
  }

  fun refreshData() {
    refresh.value = true
  }
}