package com.example.customviewtutorial.customview

interface UniversityBottomSheetView {
    fun isBottomSheetVisible(): Boolean
    fun showBottomSheet(universityBottomSheetViewState: UniversityBottomSheetViewState)
}