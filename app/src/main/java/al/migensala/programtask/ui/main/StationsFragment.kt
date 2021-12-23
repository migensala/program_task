package al.migensala.programtask.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import al.migensala.programtask.R
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StationsFragment : Fragment() {

    companion object {
        fun newInstance() = StationsFragment()
    }

    private val programAdapterOne: ProgramAdapter by lazy {
        ProgramAdapter()
    }

    private val programAdapterTwo: ProgramAdapter by lazy {
        ProgramAdapter()
    }

    private lateinit var viewModel: StationViewModel
    private lateinit var rvStation1: RecyclerView
    private lateinit var rvStation2: RecyclerView
    private lateinit var tvStationOneLabel: TextView
    private lateinit var tvStationTwoLabel: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvStationOneLabel = view.findViewById(R.id.tv_station_1)
        tvStationTwoLabel = view.findViewById(R.id.tv_station_2)
        viewModel = ViewModelProvider(this)[StationViewModel::class.java]
        observeStationsData(view)
    }

    private fun initializeStationOneRecyclerView(view: View) {
        rvStation1 = view.findViewById(R.id.rv_station_1)

        rvStation1.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
            adapter = programAdapterOne
        }
    }

    private fun initializeStationTwoRecyclerView(view: View) {
        rvStation2 = view.findViewById(R.id.rv_station_2)

        rvStation2.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
            adapter = programAdapterTwo
        }
    }

    private fun observeStationsData(view: View) {
        viewModel.stationOne.observe(viewLifecycleOwner, Observer {
            tvStationOneLabel.text = it.name
            programAdapterOne.addAll(it.programs)
            initializeStationOneRecyclerView(view)
        }
        )
        viewModel.stationTwo.observe(viewLifecycleOwner, Observer {
            tvStationTwoLabel.text = it.name
            programAdapterTwo.addAll(it.programs)
            initializeStationTwoRecyclerView(view)
        }
        )
    }

}