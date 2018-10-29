package localizacaoapp.com.br.localizacaoapp.cdn

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices
import localizacaoapp.com.br.localizacaoapp.permissoes.Permissoes

class Localizacao : GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{
    var context : Context ?= null
   constructor(context: Context){
       this.context = context
       //callConnection(context)
       setLocalizacao(context)
   }

    @SuppressLint("MissingPermission")
    private fun setLocalizacao(context: Context){
        if(!Permissoes.solicitarPermissoes(context)){
            return;
        }
        var locationManager  = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        if (location == null){
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        }


    }
    @Synchronized
    private fun callConnection(context: Context){
        googleApiClient = GoogleApiClient.Builder(context)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build()
        googleApiClient?.connect()
    }

    @SuppressLint("MissingPermission")
    override fun onConnected(p0: Bundle?) {
        location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient)
    }

    override fun onConnectionSuspended(p0: Int) {
       Log.e("LogAPP", p0.toString())
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        Log.e("LogAPP", p0.toString())
    }

    private var googleApiClient: GoogleApiClient ?= null
    private var location : Location ?= null

    @SuppressLint("MissingPermission")
    fun getLocalizacao() : Location? {
        return  location
    }

    fun getLatitude(): Double {
        return  if (location == null) {0.0} else {location!!.latitude}
    }

    fun getLogitude(): Double{
        return if (location == null) {0.0} else{location!!.longitude}
    }
}