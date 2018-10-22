package localizacaoapp.com.br.localizacaoapp.servico

import android.app.Service
import android.content.Intent
import android.os.IBinder
import localizacaoapp.com.br.localizacaoapp.cdn.ServicoCordenadas
import localizacaoapp.com.br.localizacaoapp.ws_conexao.WsConexao

class ServicoEnviarCordenadas : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        setThead()
        return (START_NOT_STICKY)

    }

    private fun setThead() {
        var thread = Thread{
            kotlin.run {
                WsConexao().salvarCordenadasWs(this)
            }
        }

        thread.start()
        onDestroy()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}