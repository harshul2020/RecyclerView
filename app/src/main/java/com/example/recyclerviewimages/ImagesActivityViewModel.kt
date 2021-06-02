package com.example.recyclerviewimages

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class ImagesActivityViewModel {
    fun getImagesList() : Observable<List<String>> {
        return ImagesService.imagesInstance.getImages("Test", 20, 400, 400)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}