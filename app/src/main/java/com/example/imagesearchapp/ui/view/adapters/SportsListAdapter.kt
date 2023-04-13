package com.example.imagesearchapp.ui.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.imagesearchapp.databinding.ListItemsSportsBinding

import com.example.imagesearchapp.ui.utils.ImageUtil
import com.example.imagesearchapp.localdomain.model.SportsItemBM

class SportsListAdapter(val ls: ArrayList<SportsItemBM>, var mListener: (SportsItemBM) -> Unit) :
    RecyclerView.Adapter<SportsListAdapter.MovieListViewHolder>(), Filterable {

    private var sportList = ls
    private var filterList = ls

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val mView =
            ListItemsSportsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieListViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bindData(filterList[position])
        holder.itemView.setOnClickListener { mListener(ls[position]) }
    }

    fun getMovieList(): List<SportsItemBM> {
        return filterList
    }

    class MovieListViewHolder(itemView: ListItemsSportsBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val binding = itemView

        fun bindData(sportsItemBM: SportsItemBM) {
            binding.imgMovie.setImageResource(
                ImageUtil.getImageIdFromName(
                    context = itemView.context,
                    sportsItemBM.movieImage!!
                )
            )
            binding.tvMovieName.text = sportsItemBM.movieName
            binding.tvMovieDesc.text = sportsItemBM.movieDesc
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint.toString()
                if (charString.isEmpty()) {
                    filterList = sportList
                } else {
                    val fList: ArrayList<SportsItemBM> = ArrayList()
                    sportList.forEach {
                        if (it.movieName!!.lowercase().contains(charString.lowercase())) {
                            fList.add(it)
                        }
                    }
                    filterList = fList
                }
                val filterResults = FilterResults()
                filterResults.values = filterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterList = results!!.values as ArrayList<SportsItemBM>
                notifyDataSetChanged()
            }
        }
    }


}