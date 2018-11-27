package localizacaoapp.com.br.localizacaoapp.servico

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import localizacaoapp.com.br.localizacaoapp.cdn.ServicoCordenadas
import localizacaoapp.com.br.localizacaoapp.ws_conexao.WsConexao

class ServicoEnviarCordenadas : IntentService {

    constructor() : super("ServicoThaed"){
        Log.e("Script", "ServicoEnviarCordenadas")
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.e("Script", "Enviando cordenadas")
        WsConexao().salvarCordenadasWs(this)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}