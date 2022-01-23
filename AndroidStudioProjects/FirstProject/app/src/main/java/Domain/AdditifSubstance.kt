package Domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class AdditifSubstance(override val nom: String) :Substance, Parcelable{

}