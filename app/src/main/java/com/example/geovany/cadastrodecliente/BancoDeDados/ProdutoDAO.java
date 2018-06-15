package com.example.geovany.cadastrodecliente.BancoDeDados;
import com.example.geovany.cadastrodecliente.Produto;

import java.util.List;

/**
 * Created by aluno on 21/05/2015.
 */
public interface ProdutoDAO {

    public Produto inserir(Produto p) throws Exception;
    public void excluir(Produto p) throws Exception;
    public void excluir(long id) throws Exception;
    public List<Produto> listarTodos() throws Exception;
    public Produto buscar(int id) throws Exception;
    public boolean alterar(Produto p) throws Exception;
}
