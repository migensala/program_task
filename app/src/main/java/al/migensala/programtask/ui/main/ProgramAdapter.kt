package al.migensala.programtask.ui.main

import al.migensala.programtask.R
import al.migensala.programtask.model.Program
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class ProgramAdapter(
    private val programs: ArrayList<Program> = arrayListOf(),
) :
    RecyclerView.Adapter<ProgramAdapter.ViewHolder>() {

    companion object {
        var COMMERCIAL_TIME = 2
        var PIXEL_PER_MINUTE = 12
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val mcvProgram: MaterialCardView = view.findViewById(R.id.mcv_program)
        val tvName: TextView = view.findViewById(R.id.tv_program_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_program, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val param = holder.mcvProgram.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(6, 0, 6, COMMERCIAL_TIME * PIXEL_PER_MINUTE)
        param.height = programs[position].length!! * PIXEL_PER_MINUTE
        holder.mcvProgram.setCardBackgroundColor(programs[position].color!!)
        holder.tvName.text = programs[position].name!!
    }

    override fun getItemCount(): Int {
        return programs.size
    }

    private fun add(item: Program) {
        if (!programs.contains(item)) {
            programs.add(item)
        }
        notifyItemInserted(programs.size - 1)
        notifyDataSetChanged()
    }

    fun addAll(items: List<Program>) {
        items.forEach { item ->
            add(item)
        }
    }

}