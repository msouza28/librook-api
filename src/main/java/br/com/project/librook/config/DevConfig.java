package br.com.project.librook.config;

import br.com.project.librook.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevConfig { // configuration chama o metodo que foi instanciado pela injeção de dependecia
                        // e popula o DB
    @Autowired
    private DBService dbService;

    @Bean
    public void intanciaBancoDeDados(){
        dbService.instanciaBaseDeDados();
    }

}
