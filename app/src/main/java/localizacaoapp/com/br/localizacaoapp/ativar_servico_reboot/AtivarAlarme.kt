package localizacaoapp.com.br.localizacaoapp.ativar_servico_reboot
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import localizacaoapp.com.br.localizacaoapp.servico.ServicoAlarme
import localizacaoapp.com.br.localizacaoapp.servico.ServicoEnviarCordenadas

class AtivarAlarme : BroadcastReceiver() {
    override fun onReceive(context: Context?, it: Intent?) {
        if(ConstantesAtivarServico().BOOT_COMPLETED.equals(it?.action)) {
            var intent = Intent(context, ServicoAlarme().javaClass)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context?.startForegroundService(intent)
            }else{
                context?.startService(intent)
            }
        }
    }

}