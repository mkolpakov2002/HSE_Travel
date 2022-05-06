package com.example.hsetravel.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.hsetravel.Constants.Companion.EXCURSION_TABLE_NAME

@Entity(tableName = EXCURSION_TABLE_NAME)
data class ExcursionObject(
    // это свойства
    @PrimaryKey
    var id: Int,
    var title: String?,
    var subtitle: String?
) : Parcelable{
    //private lateinit var banner: Drawable
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(subtitle)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExcursionObject> {
        override fun createFromParcel(parcel: Parcel): ExcursionObject {
            return ExcursionObject(parcel)
        }

        override fun newArray(size: Int): Array<ExcursionObject?> {
            return arrayOfNulls(size)
        }
    }

}