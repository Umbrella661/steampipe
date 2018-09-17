package br.com.espressoapp.steampipe

import org.springframework.ws.soap.client.core.SoapActionCallback
import org.springframework.ws.client.core.support.WebServiceGatewaySupport

import argo.wsdl.ListarSolicitacao
import argo.wsdl.ListarSolicitacaoResponse
import org.slf4j.LoggerFactory

class ArgoClient : WebServiceGatewaySupport() {

    fun getSolicitacao(): ListarSolicitacaoResponse {

        val request = ListarSolicitacao()
        request.login = "oi"
        request.senha = "tudobom"
        request.urlCliente = "/btmviagens/ws/espressoapp"

        log.info("Requesting location for")

        return webServiceTemplate
                .marshalSendAndReceive("http://www.argoit.com.br/btmviagens/ws/interface4", request,
                        SoapActionCallback(
                                "http://www.argoit.com.br/listarSolicitacao")) as ListarSolicitacaoResponse
    }

    companion object {

        private val log = LoggerFactory.getLogger(ArgoClient::class.java)
    }

}