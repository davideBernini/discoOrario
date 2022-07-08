package it.uninsubria.primaapp.discoorario

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Vibrator
import android.widget.Toast

class myBroadcastReceiverA: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val vibrator: Vibrator = context!!.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator;
        vibrator.vibrate(4000);
        if (intent!!.action.equals("com.tester.alarmmanager")) {
            var b = intent.extras
            Toast.makeText(context, "disco orario in scadenza", Toast.LENGTH_LONG).show();
        }
        var alarmUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        if (alarmUri == null)
        {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        var ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();


    }
}
