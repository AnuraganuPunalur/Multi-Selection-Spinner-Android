package com.anurag.multiselectspinnerdemo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.anurag.multiselectionspinner.MultiSelectionSpinnerDialog
import com.anurag.multiselectionspinner.MultiSpinner

class MainActivity : AppCompatActivity(),
    MultiSelectionSpinnerDialog.OnMultiSpinnerSelectionListener {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val multiSpinner : MultiSpinner = findViewById(R.id.spinnerMultiSpinner)

        //List for storing image URL's for displaying it in the Spinner.
        val urlList : MutableList<String> = ArrayList()
        urlList.add("https://cdn.pixabay.com/photo/2015/06/24/01/15/morning-819362_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2017/05/12/08/29/coffee-2306471_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2016/03/26/13/09/cup-of-coffee-1280537_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2013/08/11/19/46/coffee-171653_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2015/10/12/14/54/coffee-983955_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2016/03/30/21/59/coffee-1291656_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2018/02/16/10/52/beverage-3157395_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2017/09/04/18/39/coffee-2714970_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2017/05/19/06/22/desktop-2325627_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2016/03/26/13/09/notebook-1280538_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2016/03/26/13/09/notebook-1280538_960_720.jpg")
        urlList.add("https://cdn.pixabay.com/photo/2016/03/26/13/09/notebook-1280538_960_720.jpg")


        //List for storing text content for displaying it in the Spinner.
        val contentList : MutableList<String> = ArrayList()
        contentList.add("One")
        contentList.add("Two")
        contentList.add("Three")
        contentList.add("Four")
        contentList.add("Five")
        contentList.add("Six")
        contentList.add("Seven")
        contentList.add("Eight")
        contentList.add("Nine")
        contentList.add("Ten")
        contentList.add("Eleven")
        contentList.add("Twelve")
        contentList.add("Thirteen")
        contentList.add("Fourteen")

        //Setting Multi Selection Spinner with image.
        multiSpinner.setAdapterWithImage(this,urlList,contentList,this)

        //Setting Multi Selection Spinner with out image.
        //multiSpinner.setAdapterWithOutImage(this,contentList,this)
        multiSpinner.initMultiSpinner(this,multiSpinner)

    }

    override fun OnMultiSpinnerItemSelected(chosenItems: MutableList<String>?) {

        //This is where you get all your items selected from the Multi Selection Spinner :)
        for (i in chosenItems!!.indices){

            Log.e("chosenItems",chosenItems[i])
        }
    }
}

