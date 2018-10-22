package localizacaoapp.com.br.localizacaoapp.servico

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log

class ServicoAlarme : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var isAlarmeAtivo = (PendingIntent.getBroadcast(this, 0,  Intent(this, ServicoEnviarCordenadas().javaClass), PendingIntent.FLAG_NO_CREATE) != null);
        if(isAlarmeAtivo) {
            criarAlarme(ConverteMiliSegundos.converteHoras(1))
        }
        return (START_NOT_STICKY)
    }

    private fun cancelarAlarme() {
        //boolean isAlarmeAtivo = (PendingIntent.getBroadcast(this, 0, new Intent(this, ServicoEnviarCordenadas().javaClass), PendingIntent.FLAG_NO_CREATE) != null);
        //if(isAlarmeAtivo) {
        val intent1 = Intent(this, ServicoEnviarCordenadas().javaClass)
        val p = PendingIntent.getBroadcast(this, 0, intent1, 0)

        val alarme = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        alarme.cancel(p)
        Log.e("Scripit", "Alarme cancelado")
        //}

    }

    private fun criarAlarme(timeAlarme: Long) {

        Log.e("Scripit", "tempo de alarme: $timeAlarme")

        val intent1 = Intent(this, ServicoEnviarCordenadas().javaClass)
        val p = PendingIntent.getBroadcast(this, 0, intent1, 0)
        val alarme = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val horaSistema = SystemClock.elapsedRealtime()
        alarme.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, timeAlarme + horaSistema, timeAlarme, p)
        Log.e("Scripit", "Alarme criado")

    }
}