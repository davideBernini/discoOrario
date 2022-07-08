package it.uninsubria.primaapp.discoorario

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val saveData=SaveData(applicationContext)

        tvShowTime.text= saveData.getHour().toString() + ":" + saveData.getMinute().toString()
        bottone2.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)

                mostra_tempo.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), true
            ).show()

        }

    }
    fun BuSetTime(view: View){
        val popTime= PopTime()
        val fm=supportFragmentManager
        popTime.show(fm,"Select time")

    }
    fun SetTime(Hours:Int,Minute:Int){

        tvShowTime.text= "$Hours:$Minute"

        val saveData=SaveData(applicationContext)
        saveData.SaveData(Hours,Minute)
        saveData.setAlarm()


    }

}