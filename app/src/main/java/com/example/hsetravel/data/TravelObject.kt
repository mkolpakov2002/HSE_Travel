package com.example.hsetravel.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hsetravel.Constants

@Entity(tableName = Constants.TRAVEL_TABLE_NAME)
class TravelObject (
    // это свойства
    @PrimaryKey
    var id: Int,
    var title: String?,
    var subtitle: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(subtitle)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TravelObject> {
        override fun createFromParcel(parcel: Parcel): TravelObject {
            return TravelObject(parcel)
        }

        override fun newArray(size: Int): Array<TravelObject?> {
            return arrayOfNulls(size)
        }
    }

}