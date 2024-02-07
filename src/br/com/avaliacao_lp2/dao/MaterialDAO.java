package br.com.avaliacao_lp2.dao;

import br.com.avaliacao_lp2.dto.MaterialDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class MaterialDAO {
    private Connection connection;

    public MaterialDAO() {
       
    }

    private ResultSet rs = null;
    private Statement stmt = null;
    
   public boolean cadastrarMaterial(MaterialDTO materialDTO) {
    try {
        ConexaoDAO.ConnectDB();

        stmt = ConexaoDAO.con.createStatement();

        String comando = "INSERT INTO material (titulo, descricao, curso) VALUES ('"
                + materialDTO.getTitulo() + "' , '"
                + materialDTO.getDescricao() + "' , '"
                + materialDTO.getCurso() + "')";

        stmt.execute(comando.toUpperCase());
        ConexaoDAO.con.commit();
        stmt.close();

        return true;
    } catch (Exception erro) {
        System.out.println("Problema ao cadastrar no Banco de Dados: " + erro.getMessage());
        return false;
    } finally {
        ConexaoDAO.CloseDB();
    }
}


    public ResultSet pesquisarMaterial(MaterialDTO materialDTO, int tipoPesquisa) {
    try {
        ConexaoDAO.ConnectDB();
        stmt = ConexaoDAO.con.createStatement();

        String comando = "";
        switch (tipoPesquisa) {
            case 1:
                comando = "SELECT * FROM material WHERE titulo LIKE '%" + materialDTO.getTitulo() + "%'";
                break;
            case 2:
                comando = "SELECT * FROM material WHERE idMaterial = " + materialDTO.getIdMaterial();
                break;
        }

        rs = stmt.executeQuery(comando.toUpperCase());
        return rs;
    } catch (Exception erro) {
        System.out.println("Erro ao pesquisar material no Banco de Dados: " + erro.getMessage());
        return null;
    }
}

public boolean excluirMaterial(MaterialDTO materialDTO) {
    try {
        ConexaoDAO.ConnectDB();
        stmt = ConexaoDAO.con.createStatement();
        String comando = "DELETE FROM material WHERE idMaterial = " + materialDTO.getIdMaterial();

        stmt.execute(comando);
        ConexaoDAO.con.commit();
        stmt.close();

        return true;
    } catch (Exception erro) {
        System.out.println("Problema ao excluir material no Banco de Dados: " + erro.getMessage());
        return false;
    } finally {
        ConexaoDAO.CloseDB();
    }
}

public List<MaterialDTO> listarMateriais() {
    List<MaterialDTO> materiais = new ArrayList<>();
    String sql = "SELECT * FROM material";

    try {
        ConexaoDAO.ConnectDB();
        stmt = ConexaoDAO.con.createStatement();
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            MaterialDTO materialDTO = new MaterialDTO();
            materialDTO.setIdMaterial(rs.getInt("idMaterial"));
            materialDTO.setTitulo(rs.getString("titulo"));
            materialDTO.setDescricao(rs.getString("descricao"));
            materialDTO.setCurso(rs.getString("curso"));

            materiais.add(materialDTO);
        }

        return materiais;
    } catch (Exception erro) {
        System.out.println("Erro ao listar materiais no Banco de Dados: " + erro.getMessage());
        return materiais;
    } finally {
        ConexaoDAO.CloseDB();
    }
}

public boolean alterarMaterial(MaterialDTO materialDTO){
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Update material set "
                    + "titulo = '" + materialDTO.getTitulo() + "' ,"
                    + "descricao = '" + materialDTO.getDescricao() + "' ,"
                    + "curso = '" + materialDTO.getCurso() + "' "
                    + "where idMaterial = " + materialDTO.getIdMaterial();

            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            
            return true;
        } catch (Exception erro) {
            System.out.println("Problema ao alterar no Banco de Dados." + 
                    erro.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

}
