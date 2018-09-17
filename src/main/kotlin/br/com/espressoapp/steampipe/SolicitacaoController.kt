package br.com.espressoapp.steampipe

import argo.wsdl.ListarSolicitacaoResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping("solicitacoes")
class SolicitacaoController {
    @Autowired
    protected val client: ArgoClient = ArgoClient()

    @GetMapping
    @ResponseBody
    fun list(): List<ListarSolicitacaoResponse> {
        val solicitacao = client.getSolicitacao()
        return listOf(solicitacao)
    }
}