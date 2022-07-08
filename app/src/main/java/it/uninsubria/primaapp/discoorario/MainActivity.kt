package it.uninsubria.primaapp.discoorario

import android.app.ProgressDialog.show
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val saveData=SaveData(applicationContext)

        tvShowTime.text= saveData.getHour().toString() + ":" + saveData.getMinute().toString()
        buSetTime1.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)

                time.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), false).show()

        }
        posizione.setOnClickListener {
            intent = Intent(this,posizioneGPS::class.java)
        startActivity(intent)
    }
        maps.setOnClickListener {
            intent = Intent(this,MapsActivity::class.java)
            startActivity(intent)
        }
    }
    fun BuSetTime(view: View){
        val popTime= PopTime()
        val fm=supportFragmentManager
        popTime.show(fm,"Select time")

    }
    fun SetTime(Hours:Int,Minute:Int){

        tvShowTime.text= Hours.toString() + ":" + Minute.toString()

        val saveData=SaveData(applicationContext)
        saveData.SaveData(Hours,Minute)
        saveData.setAlarm()


    }
    fun BuSetTime2(view: View){
        val popTimeA = popTimeA()
        val fm2= supportFragmentManager
        popTimeA.show(fm2,"Select time")

    }
    fun SetTime2(Hours:Int,Minute:Int){
        tvShowTime2.text= Hours.toString() + ":" + Minute.toString()
        val saveData=SaveDataA(applicationContext)
        saveData.SaveDataA(Hours,Minute)
        saveData.setAlarmA()


    }

}