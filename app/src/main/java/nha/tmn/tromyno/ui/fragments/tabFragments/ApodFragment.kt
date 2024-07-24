package nha.tmn.tromyno.ui.fragments.tabFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import nha.tmn.tromyno.R
import nha.tmn.tromyno.adapters.ApodAdapter

class ApodFragment : Fragment() {

    val apodAdapter = ApodAdapter()
    lateinit var apodRv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_apod, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apodRv = view.findViewById(R.id.apodRv)
    }

    private fun setUpApodRv(){
        apodRv.apply {
            adapter = apodAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}