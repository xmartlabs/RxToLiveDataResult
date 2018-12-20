package com.xmartlabs.sample.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.xmartlabs.rxtolivedataresult.Result
import com.xmartlabs.sample.R
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_list_trending.*
import javax.inject.Inject

class ListTrendingReposActivity : AppCompatActivity(), HasSupportFragmentInjector {
  @Inject
  lateinit var viewModel: ListTrendingReposViewModel

  private val listTrendingReposAdapter = ListTrendingReposAdapter()
  @Inject
  lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

  override fun supportFragmentInjector() = dispatchingAndroidInjector

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list_trending)
    recycler_view.adapter = listTrendingReposAdapter
    recycler_view.layoutManager = LinearLayoutManager(baseContext)

    swipe_refresh_layout.setOnRefreshListener { viewModel.refreshData() }

    viewModel.trendingRepositories.observe(this, Observer {
      when (it) {
        is Result.Loading -> swipe_refresh_layout.isRefreshing = true
        is Result.Success -> {
          swipe_refresh_layout.isRefreshing = false
          listTrendingReposAdapter.repos = it.data
          listTrendingReposAdapter.notifyDataSetChanged()
        }
        is Result.Error -> {
          swipe_refresh_layout.isRefreshing = false
          Toast.makeText(baseContext, R.string.error_message, Toast.LENGTH_LONG).show()
        }
      }
    })
  }
}
