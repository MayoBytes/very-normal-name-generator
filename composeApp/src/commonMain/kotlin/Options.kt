import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf

data class Options(
    var first: Boolean = true,
    var last: Boolean = true,
    var gender: Gender = Gender.MASC
) {
    fun toggleFirst(): Options {
        return this.copy(first = !first, last = last, gender = gender)
    }

    fun toggleLast(): Options {
        return this.copy(first = first, last = !last, gender = gender)
    }

    fun setGender(gender: Gender): Options {
        return this.copy(first = first, last = last, gender = gender)
    }
}

enum class Gender(val gender: Byte) {
    MASC(0x01),
    FEM(0x02),
    NEUT(0x03)

}

class OptionsViewModel {

    var options: MutableState<Options> = mutableStateOf(Options())
}