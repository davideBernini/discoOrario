package it.uninsubria.primaapp.discoorario

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.pop_time_a.*

class popTimeA: DialogFragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var myView= inflater!!.inflate(R.layout.pop_time_a,container,false)


        var buDone2=myView.findViewById(R.id.buDone2) as Button
        var tp2=myView.findViewById(R.id.tp2) as TimePicker

        buDone2.setOnClickListener {
            val ma= activity as MainActivity
            if(Build.VERSION.SDK_INT>=23) {
                ma.SetTime2(tp2.hour, tp2.minute)
            }else{
                ma.SetTime2(tp2.currentHour, tp2.currentMinute)
            }

            this.dismiss()
        }


        return myView
    }


}
