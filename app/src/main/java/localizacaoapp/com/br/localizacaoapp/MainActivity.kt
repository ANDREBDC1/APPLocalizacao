package localizacaoapp.com.br.localizacaoapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import localizacaoapp.com.br.localizacaoapp.cdn.Localizacao
import localizacaoapp.com.br.localizacaoapp.permissoes.Permissoes
import localizacaoapp.com.br.localizacaoapp.servico.ServicoAlarme
import localizacaoapp.com.br.localizacaoapp.servico.ServicoEnviarCordenadas
import localizacaoapp.com.br.localizacaoapp.ws_conexao.WsConexao
import java.security.Permissions

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Permissoes.solicitarPermissoes(this)
        var intent = Intent(this, ServicoAlarme().javaClass)
        startService(intent)

        var localizacao = Localizacao(this).getLocalizacao()
        txtLatitude.text =  "Latitude: ${localizacao?.latitude}"
        txtLongitude.text =  "Longitude ${localizacao?.longitude}"


    }
}
