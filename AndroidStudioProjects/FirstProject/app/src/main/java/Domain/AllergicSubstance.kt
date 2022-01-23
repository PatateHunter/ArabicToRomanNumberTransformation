package Domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class AllergicSubstance(override val nom: String) : Substance,Parcelable {

}