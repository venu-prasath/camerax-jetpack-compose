package xyz.venuprasath.objectdetection.presentation

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import xyz.venuprasath.objectdetection.domain.Classification
import xyz.venuprasath.objectdetection.domain.LandmarkClassifier

class LandmarkImageAnalyzer(
    val classifier: LandmarkClassifier,
    val onResults: (List<Classification>) -> Unit
): ImageAnalysis.Analyzer {

    private var frameSkipCounter: Int = 0

    override fun analyze(image: ImageProxy) {
        if(frameSkipCounter % 60 == 0) {
            val rotationDegrees = image.imageInfo.rotationDegrees
            val bitmap = image
                .toBitmap()
                .centerCrop(321, 321)

            val results = classifier.classify(bitmap, rotationDegrees)
            onResults(results)
        }
        frameSkipCounter++
        image.close()
    }
}