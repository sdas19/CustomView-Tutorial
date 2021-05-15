package com.example.customviewtutorial.customview

sealed class UniversityBottomSheetViewState {
    class UniversitySuccessState(val universityList: List<University>) :
        UniversityBottomSheetViewState()
}