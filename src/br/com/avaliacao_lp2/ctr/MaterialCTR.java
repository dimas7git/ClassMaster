package br.com.avaliacao_lp2.ctr;

import br.com.avaliacao_lp2.dao.ConexaoDAO;
import br.com.avaliacao_lp2.dao.MaterialDAO;
import br.com.avaliacao_lp2.dto.MaterialDTO;
import java.util.List;
import java.sql.ResultSet;

public class MaterialCTR {
    private MaterialDAO materialDAO;

    public MaterialCTR() {
        this.materialDAO = new MaterialDAO();
    }

    public String cadastrarMaterial(MaterialDTO materialDTO) {
        try {
            if (materialDAO.cadastrarMaterial(materialDTO)) {
                return "Material cadastrado.";
            } else {
                return "Material NÃO cadastrado.";
            }
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
            return "Erro ao cadastrar material.";
        }   
    }

    public List<MaterialDTO> listarMateriais() {
        return materialDAO.listarMateriais();
    }

    public boolean excluirMaterial(MaterialDTO materialDTO) {
        try {
            if (materialDAO.excluirMaterial(materialDTO)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception erro) {
            System.out.println(erro.getMessage());
            return false;
        }
    }

    public ResultSet pesquisarMaterial(MaterialDTO materialDTO, int tipoPesquisa) {
        ResultSet rs = null;
        rs = materialDAO.pesquisarMaterial(materialDTO, tipoPesquisa);
        return rs;

    }
    
    public String alterarMaterial(MaterialDTO materialDTO) {
        try {
            if (materialDAO.alterarMaterial(materialDTO)) {
                return "Cadastro alterado.";
            } else {
                return "Cadastro NÃO alterado.";
            }
        }
        catch (Exception erro) {
            System.out.println(erro.getMessage());
            return "Erro ao alterar.";
        }
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
