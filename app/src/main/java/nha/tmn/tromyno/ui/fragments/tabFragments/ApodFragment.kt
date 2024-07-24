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
import nha.tmn.tromyno.api.RetrofitInstance
import nha.tmn.tromyno.models.ApodResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        setUpApodRv()

        getApods()
    }

    private fun setUpApodRv(){
        apodRv.apply {
            adapter = apodAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    fun getApods(){
//        RetrofitInstance.apodApi.getApod("2024-07-20", "2024-07-24")

        RetrofitInstance.apodApi.getApod("2024-07-20", "2024-07-24").enqueue(object : Callback<List<ApodResponse>> {
            override fun onResponse(call: Call<List<ApodResponse>>, response: Response<List<ApodResponse>>) {
                if (response.isSuccessful) {
                    val apodList = response.body()

                    apodAdapter.differ.submitList(apodList)
//                    // Hiển thị dữ liệu từ API trong UI
//                    apodList?.forEach { apod ->
//
//                    }
                }
            }

            override fun onFailure(call: Call<List<ApodResponse>>, t: Throwable) {
                // Xử lý lỗi khi gọi API thất bại
            }
        })
    }
}