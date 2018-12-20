package com.xmartlabs.sample.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.xmartlabs.sample.R
import com.xmartlabs.sample.model.Repo
import kotlinx.android.synthetic.main.item_repo.*
import java.util.Objects


class ListTrendingReposAdapter : RecyclerView.Adapter<ListTrendingReposAdapter.RepoViewHolder>() {
  var repos: List<Repo>? = null

  override fun onCreateViewHolder(parent: ViewGroup, type: Int)= RepoViewHolder.create(parent)
  override fun getItemCount()= repos?.size ?: 0

  override fun onBindViewHolder(holder: RepoViewHolder, position: Int) = holder.bind(repos!![position])

  class RepoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val stars = view.findViewById<TextView>(R.id.stars)
    private val name = view.findViewById<TextView>(R.id.name)
    private val description = view.findViewById<TextView>(R.id.description)


    companion object {
      fun create(parent: ViewGroup): RepoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repo, parent, false)
        return RepoViewHolder(view)
      }
    }

    fun bind(repo: Repo) {
      stars.text = itemView.resources.getQuantityString(R.plurals.starCount, repo.stargazersCount, repo.stargazersCount)
      name.text = repo.name
      description.text = repo.description
    }
  }
}
