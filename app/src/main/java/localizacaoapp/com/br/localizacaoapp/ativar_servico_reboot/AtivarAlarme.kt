package localizacaoapp.com.br.localizacaoapp.ativar_servico_reboot
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import localizacaoapp.com.br.localizacaoapp.servico.ServicoAlarme
import localizacaoapp.com.br.localizacaoapp.servico.ServicoEnviarCordenadas

class AtivarAlarme : BroadcastReceiver() {
    override fun onReceive(context: Context?, it: Intent?) {
        if(ConstantesAtivarServico().BOOT_COMPLETED.equals(it?.action)) {
            var intent = Intent(context, ServicoAlarme().javaClass)
            context?.startService(intent)
        }
    }

}