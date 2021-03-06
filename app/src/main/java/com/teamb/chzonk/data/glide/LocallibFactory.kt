package com.teamb.chzonk.data.glide

import com.bumptech.glide.load.Options
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import com.bumptech.glide.signature.ObjectKey
import com.teamb.chzonk.data.model.GlideModel
import timber.log.Timber
import java.io.InputStream

internal class LocallibFactory : ModelLoader<GlideModel, InputStream> {
    override fun handles(model: GlideModel): Boolean {
        return true
    }

    override fun buildLoadData(
        model: GlideModel,
        width: Int,
        height: Int,
        options: Options
    ): ModelLoader.LoadData<InputStream>? {
        val key = ObjectKey("${model.book.filePath}:${model.position}")
        return ModelLoader.LoadData(key, LocallibDataFetcher(model))
    }
    internal class Factory : ModelLoaderFactory<GlideModel, InputStream> {
        override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<GlideModel, InputStream> {
            Timber.log(1, "Hit")
            return LocallibFactory()
        }

        override fun teardown() {
            // Not needed
        }
    }
}
