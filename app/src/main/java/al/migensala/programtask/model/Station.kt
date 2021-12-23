package al.migensala.programtask.model

data class Station(
    var name: String? = null,
    var programs: List<Program> = listOf()
)
