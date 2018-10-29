package localizacaoapp.com.br.localizacaoapp.ativar_servico_reboot

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import localizacaoapp.com.br.localizacaoapp.servico.ServicoEnviarCordenadas

class AtivarServicoEnviar : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var int = Intent(context, ServicoEnviarCordenadas().javaClass)
        context?.startService(int)
    }
}