package al.migensala.programtask.ui.main

import al.migensala.programtask.model.Program
import al.migensala.programtask.model.Station
import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StationViewModel : ViewModel() {

    val stationOne: MutableLiveData<Station> by lazy {
        MutableLiveData<Station>()
    }

    val stationTwo: MutableLiveData<Station> by lazy {
        MutableLiveData<Station>()
    }

    init {
        stationOne.value = Station(
            name = "Stacioni_1",
            programs = listOf(
                Program("A", 90, Color.GREEN),
                Program("C", 100, Color.BLUE),
                Program("D", 10, Color.YELLOW),
                Program("E", 85, Color.GREEN),
                Program("F", 120, Color.BLUE),
                Program("Gj", 58, Color.YELLOW),
                Program("I", 79, Color.LTGRAY),
                Program("K", 150, Color.MAGENTA),
                Program("LL", 91, Color.RED)
            )
        )

        stationTwo.value = Station(
            name = "Stacioni_2",
            programs = listOf(
                Program("B", 35, Color.GRAY),
                Program("Ç", 130, Color.RED),
                Program("Dh", 80, Color.CYAN),
                Program("Ë", 100, Color.GRAY),
                Program("G", 72, Color.MAGENTA),
                Program("H", 76, Color.RED),
                Program("J", 200, Color.BLUE),
                Program("L", 90, Color.DKGRAY),
            )
        )
    }
}