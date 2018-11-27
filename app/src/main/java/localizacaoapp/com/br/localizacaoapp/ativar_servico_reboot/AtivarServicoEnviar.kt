package localizacaoapp.com.br.localizacaoapp.ativar_servico_reboot

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import localizacaoapp.com.br.localizacaoapp.servico.ServicoEnviarCordenadas

class AtivarServicoEnviar : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var int = Intent(context, ServicoEnviarCordenadas().javaClass)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context?.startForegroundService(int)
        }else{
            context?.startService(int)
        }
    }
}