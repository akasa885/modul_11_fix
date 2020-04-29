package android.latihan.modul_11.api

import android.latihan.modul_11.model.Photo
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PhotosService {
    //inisialisasi link API yang ingin diakses.(disini menggunakan sample data online)
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val api: PhotosApi

    init{
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
                //disini setelah dibuat dan di convert data yang diambil, dimasukkan data tersebut
                //ke photosapi sebagai data
            .create(PhotosApi::class.java)
    }

    fun getPhotos() : Single<List<Photo>>{
        return api.getPhotos()
    }
}