package com.cesc

import android.util.Log
import androidx.lifecycle.ViewModel

class TestViewModel :ViewModel(){

    fun showName(name : String){
        Log.e("Test", name)
    }
}