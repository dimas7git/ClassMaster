/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.avaliacao_lp2.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import br.com.avaliacao_lp2.dto.MaterialDTO;
import br.com.avaliacao_lp2.ctr.MaterialCTR;

public class MaterialVIEW extends javax.swing.JInternalFrame {

    /**
     * Creates new form MaterialVIEW
     */
    MaterialDTO materialDTO = new MaterialDTO();
    MaterialCTR materialCTR = new MaterialCTR();
    int gravar_alterar;
    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_material;

    public MaterialVIEW() {
        initComponents();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, false);
        limpaCampos();
        preencheTabela("");
        nomeMaterial.requestFocus();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Materiais");
        setResizable(false);
        setVisible(true);
        modelo_jtl_consultar_material = (DefaultTableModel) jtl_consultar_material.getModel();

    }

    public void setPosicao() {
        Dimension d = this.getParent().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    private void gravar() {
        try {
            MaterialDTO materialDTO = new MaterialDTO(); // Instanciação do objeto MaterialDTO
            materialDTO.setTitulo(nomeMaterial.getText());
            materialDTO.setDescricao(descricao.getText());
            materialDTO.setCurso((String) comboCurso.getSelectedItem());

            JOptionPane.showMessageDialog(null, materialCTR.cadastrarMaterial(materialDTO));
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar." + e.getMessage());
        }
    }

    private void alterar() {
        try {
            materialDTO.setTitulo(nomeMaterial.getText());
            materialDTO.setDescricao(descricao.getText());
            materialDTO.setCurso((String) comboCurso.getSelectedItem());
            JOptionPane.showMessageDialog(null, materialCTR.alterarMaterial(materialDTO));
        } catch (Exception e) {
            System.out.println("Erro ao Alterar" + e.getMessage());
        }
    }
    private void excluir() {
        if (JOptionPane.showConfirmDialog(null, "Deseja EXCLUIR o cadastro?", "Aviso",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, materialCTR.excluirMaterial(materialDTO));
        }
    }

    private void liberaCampos(boolean a) {
        nomeMaterial.setEnabled(a);
        descricao.setEnabled(a);
        comboCurso.setEnabled(a);
    }

    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }

    private void limpaCampos() {
        nomeMaterial.setText("");
        descricao.setText("");
        comboCurso.setSelectedIndex(0);
    }

    private void preencheTabela(String nomeMaterial) {
        try {
            modelo_jtl_consultar_material.setNumRows(0);
            materialDTO.setTitulo(nomeMaterial);
            rs = materialCTR.pesquisarMaterial(materialDTO, 1);
            if (!rs.next()) {
                System.out.println("Nenhum resultado encontrado.");
            } else {
                do {
                    modelo_jtl_consultar_material.addRow(new Object[]{
                        rs.getString("idMaterial"),
                        rs.getString("curso") // Correção: usar a coluna correta "titulo" em vez de "nomeMaterial"
                    });
                } while (rs.next());
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab.getMessage());
        } finally {
            materialCTR.CloseDB();
        }
    }

    private void preencheCampos(int idMaterial) {
        try {
            materialDTO.setIdMaterial(idMaterial);
            rs = materialCTR.pesquisarMaterial(materialDTO, 2); // 2 é a pesquisa no id na classe DAO
            if (rs.next()) {
                limpaCampos();

                nomeMaterial.setText(rs.getString("titulo"));
                descricao.setText(rs.getString("descricao"));
                comboCurso.setSelectedItem(rs.getString("curso"));

                gravar_alterar = 2;
                liberaCampos(true);
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL." + erTab);
        } finally {
            materialCTR.CloseDB();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nomeMaterial = new javax.swing.JTextField();
        Descrição = new javax.swing.JLabel();
        btnNovo = new javax.swing.JToggleButton();
        btnSalvar = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JToggleButton();
        btnExcluir = new javax.swing.JToggleButton();
        btnSair = new javax.swing.JToggleButton();
        comboCurso = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descricao = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnpesquisa = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_material = new javax.swing.JTable();
        pesquisa_material = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("Nome Comunicado");

        Descrição.setText("Descrição");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        btnExcluir.setText("Excluir");

        btnSair.setText("Sair");

        comboCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matemática 1", "Matemática 2", "Matemática 3", "Física 1", "Física 2" }));

        jLabel3.setText("Curso");

        descricao.setColumns(20);
        descricao.setRows(5);
        jScrollPane2.setViewportView(descricao);

        jLabel5.setText("COMUNICADOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Nome");

        btnpesquisa.setText("Pesquisar Comunicado");
        btnpesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisaActionPerformed(evt);
            }
        });

        jtl_consultar_material.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_consultar_material.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_materialMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtl_consultar_material);
        if (jtl_consultar_material.getColumnModel().getColumnCount() > 0) {
            jtl_consultar_material.getColumnModel().getColumn(0).setResizable(false);
            jtl_consultar_material.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setText("PESQUISAR COMUNICADO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pesquisa_material, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnpesquisa)
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel2)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnpesquisa)
                    .addComponent(pesquisa_material, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Descrição)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(29, 29, 29)
                                .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addGap(37, 37, 37)
                                .addComponent(btnSalvar)
                                .addGap(26, 26, 26)
                                .addComponent(btnCancelar)
                                .addGap(27, 27, 27)
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnSair))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomeMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Descrição)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, false, true);
        gravar_alterar = 1;
        btnNovo.setSelected(false);

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
         if(gravar_alterar == 1){
            gravar();
        gravar_alterar = 0;
        }
        else{
            if(gravar_alterar == 2){
                alterar();
                gravar_alterar = 0;
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro no Sistema!!!");
                }
        }
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
        btnSalvar.setSelected(false);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnpesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisaActionPerformed
        System.out.println("Botão de pesquisa clicado!");
        preencheTabela(pesquisa_material.getText());

    }//GEN-LAST:event_btnpesquisaActionPerformed

    private void jtl_consultar_materialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_materialMouseClicked
        preencheCampos(Integer.parseInt((String.valueOf(
                jtl_consultar_material.getValueAt(jtl_consultar_material.getSelectedRow(), 0)))));
        liberaBotoes(false, true, true, true, true);    }//GEN-LAST:event_jtl_consultar_materialMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descrição;
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnExcluir;
    private javax.swing.JToggleButton btnNovo;
    private javax.swing.JToggleButton btnSair;
    private javax.swing.JToggleButton btnSalvar;
    private javax.swing.JToggleButton btnpesquisa;
    private javax.swing.JComboBox<String> comboCurso;
    private javax.swing.JTextArea descricao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtl_consultar_material;
    private javax.swing.JTextField nomeMaterial;
    private javax.swing.JTextField pesquisa_material;
    // End of variables declaration//GEN-END:variables
}
