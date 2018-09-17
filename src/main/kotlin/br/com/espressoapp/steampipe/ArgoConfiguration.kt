package br.com.espressoapp.steampipe

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller

@Configuration
class ArgoConfiguration {

    @Bean
    fun marshaller(): Jaxb2Marshaller {
        val marshaller = Jaxb2Marshaller()
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.contextPath = "argo.wsdl"
        return marshaller
    }

    @Bean
    fun argoClient(marshaller: Jaxb2Marshaller): ArgoClient {
        val client = ArgoClient()
        client.defaultUri = "http://www.argoit.com.br/btmviagens/ws/interface4"
        client.marshaller = marshaller
        client.unmarshaller = marshaller
        return client
    }

}