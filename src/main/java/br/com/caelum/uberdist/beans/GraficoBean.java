package br.com.caelum.uberdist.beans;

import br.com.caelum.uberdist.dao.GraficoDao;
import br.com.caelum.uberdist.modelo.QuantidadePorProduto;
import org.primefaces.model.chart.PieChartModel;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * Created by nando on 17/02/17.
 */
@Model
public class GraficoBean {

    @Inject
    private GraficoDao dao;


    public PieChartModel getGrafico(){
        PieChartModel model = new PieChartModel();

        model.setTitle("Quantidade de vendas por Produtos");
        model.setLegendPosition("w");
        model.setShowDataLabels(true);

        List<QuantidadePorProduto> quantidadesPorProdutos = dao.relatorioQuantidadePorProduto();

        Map<String, Number> mapaDeValores = quantidadesPorProdutos.
                                            stream()
                                                .collect(toMap( QuantidadePorProduto::getTitulo,
                                                                QuantidadePorProduto::getQuantidade));
        model.setData(mapaDeValores);

        return model;
    }
}
