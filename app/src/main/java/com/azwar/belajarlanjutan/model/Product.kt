package com.azwar.belajarlanjutan.model

import android.os.Parcel
import android.os.Parcelable

data class Product(
    val brand: String?,
    val category: String?,
    val description: String?,
    val discountPercentage: Double?,
    val id: Int?,
    val images: List<String>?,
    val price: Int?,
    val rating: Double?,
    val stock: Int?,
    val thumbnail: String?,
    val title: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.createStringArrayList(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(brand)
        parcel.writeString(category)
        parcel.writeString(description)
        parcel.writeValue(discountPercentage)
        parcel.writeValue(id)
        parcel.writeStringList(images)
        parcel.writeValue(price)
        parcel.writeValue(rating)
        parcel.writeValue(stock)
        parcel.writeString(thumbnail)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}