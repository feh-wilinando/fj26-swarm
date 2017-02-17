package br.com.caelum.uberdist.util;

import javax.enterprise.inject.Produces;

/**
 * Created by nando on 17/02/17.
 */
public class EmailFactory {

    @Produces @EmailComercial
    private String emailComercial = "comercial@uberdist.com.br";

    @Produces @EmailFinanceiro
    private String emailFinanceiro = "financeiro@uberdist.com.br";

}
