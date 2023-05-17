/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.openmarket.presentation;

import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.CategoryService;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import co.edu.unicauca.openmarket.infra.Messages;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author restr
 */
public class GUI extends javax.swing.JFrame {

    private ProductService productService;
    private CategoryService categoryService;

    /**
     * Creates new form GUI
     */
    public GUI(ProductService productService, CategoryService categoryService) {
        initComponents();
        this.productService = productService;
        this.categoryService = categoryService;
        initializeTableP();
        initializeTableC();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanelTop = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnProduct = new co.edu.unicauca.openmarket.presentation.ui.MyButton();
        btnCategory = new co.edu.unicauca.openmarket.presentation.ui.MyButton();
        jPanelCentral = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanelProduct = new javax.swing.JPanel();
        lblTitle3 = new javax.swing.JLabel();
        lblTitle4 = new javax.swing.JLabel();
        txtDescriptionP = new javax.swing.JTextField();
        lblTitle5 = new javax.swing.JLabel();
        lblTitle6 = new javax.swing.JLabel();
        txtIdP = new javax.swing.JTextField();
        txtSearchP = new javax.swing.JTextField();
        btnSearchAll = new co.edu.unicauca.openmarket.presentation.ui.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        lblTitle10 = new javax.swing.JLabel();
        rdoId = new javax.swing.JRadioButton();
        rdoName = new javax.swing.JRadioButton();
        txtNameP = new javax.swing.JTextField();
        btnCreateProduct1 = new co.edu.unicauca.openmarket.presentation.ui.MyButton();
        btnSearch = new co.edu.unicauca.openmarket.presentation.ui.MyButton();
        lblTitle11 = new javax.swing.JLabel();
        jPanelCategory = new javax.swing.JPanel();
        lblTitle8 = new javax.swing.JLabel();
        txtIdC = new javax.swing.JTextField();
        txtNameC = new javax.swing.JTextField();
        lblTitle9 = new javax.swing.JLabel();
        btnCreateCategory = new co.edu.unicauca.openmarket.presentation.ui.MyButton();
        lblTitle12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCategory = new javax.swing.JTable();
        lblTitle7 = new javax.swing.JLabel();
        rdoId1 = new javax.swing.JRadioButton();
        rdoName1 = new javax.swing.JRadioButton();
        txtSearchC = new javax.swing.JTextField();
        btnSearch1 = new co.edu.unicauca.openmarket.presentation.ui.MyButton();
        btnSearchAll1 = new co.edu.unicauca.openmarket.presentation.ui.MyButton();
        lblTitle13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD de Productos");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(848, 534));
        setMinimumSize(new java.awt.Dimension(848, 534));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelTop.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setText("CRUD de Productos y Categorias");

        btnProduct.setBackground(new java.awt.Color(251, 106, 0));
        btnProduct.setBorder(null);
        btnProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnProduct.setText("Productos");
        btnProduct.setBorderColor(new java.awt.Color(251, 106, 0));
        btnProduct.setBorderPainted(false);
        btnProduct.setColor(new java.awt.Color(251, 106, 0));
        btnProduct.setColorClick(new java.awt.Color(251, 186, 0));
        btnProduct.setColorOver(new java.awt.Color(251, 156, 0));
        btnProduct.setFocusable(false);
        btnProduct.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnProduct.setRadius(40);
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });

        btnCategory.setBackground(new java.awt.Color(251, 106, 0));
        btnCategory.setBorder(null);
        btnCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnCategory.setText("Categorias");
        btnCategory.setBorderColor(new java.awt.Color(251, 106, 0));
        btnCategory.setBorderPainted(false);
        btnCategory.setColor(new java.awt.Color(251, 106, 0));
        btnCategory.setColorClick(new java.awt.Color(251, 186, 0));
        btnCategory.setColorOver(new java.awt.Color(251, 156, 0));
        btnCategory.setFocusable(false);
        btnCategory.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCategory.setRadius(40);
        btnCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTopLayout = new javax.swing.GroupLayout(jPanelTop);
        jPanelTop.setLayout(jPanelTopLayout);
        jPanelTopLayout.setHorizontalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTopLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanelTopLayout.setVerticalGroup(
            jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTitle))
                .addGap(10, 10, 10))
        );

        jPanelPrincipal.add(jPanelTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 60));

        jPanelCentral.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCentral.setForeground(new java.awt.Color(204, 255, 204));
        jPanelCentral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelProduct.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProduct.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle3.setText("Buscar Por:");
        jPanelProduct.add(lblTitle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        lblTitle4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitle4.setToolTipText("");
        lblTitle4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanelProduct.add(lblTitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 168, 840, -1));

        txtDescriptionP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanelProduct.add(txtDescriptionP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 240, 30));

        lblTitle5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle5.setText("ID:");
        jPanelProduct.add(lblTitle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        lblTitle6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle6.setText("Nombre:");
        jPanelProduct.add(lblTitle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        txtIdP.setEditable(false);
        txtIdP.setBackground(new java.awt.Color(255, 255, 255));
        txtIdP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanelProduct.add(txtIdP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 240, 30));

        txtSearchP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanelProduct.add(txtSearchP, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 240, 30));

        btnSearchAll.setBackground(new java.awt.Color(251, 106, 0));
        btnSearchAll.setBorder(null);
        btnSearchAll.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchAll.setText("Buscar Todo");
        btnSearchAll.setBorderColor(new java.awt.Color(251, 106, 0));
        btnSearchAll.setBorderPainted(false);
        btnSearchAll.setColor(new java.awt.Color(251, 106, 0));
        btnSearchAll.setColorClick(new java.awt.Color(251, 186, 0));
        btnSearchAll.setColorOver(new java.awt.Color(251, 156, 0));
        btnSearchAll.setFocusable(false);
        btnSearchAll.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearchAll.setRadius(40);
        btnSearchAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAllActionPerformed(evt);
            }
        });
        jPanelProduct.add(btnSearchAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 96, 40));

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProducts);

        jPanelProduct.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 840, 250));

        lblTitle10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle10.setText("Descripcion:");
        jPanelProduct.add(lblTitle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        rdoId.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoId);
        rdoId.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdoId.setSelected(true);
        rdoId.setText("Id");
        jPanelProduct.add(rdoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        rdoName.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoName);
        rdoName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdoName.setText("Nombre del producto");
        jPanelProduct.add(rdoName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        txtNameP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanelProduct.add(txtNameP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 240, 30));

        btnCreateProduct1.setBackground(new java.awt.Color(251, 106, 0));
        btnCreateProduct1.setBorder(null);
        btnCreateProduct1.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateProduct1.setText("Crear");
        btnCreateProduct1.setBorderColor(new java.awt.Color(251, 106, 0));
        btnCreateProduct1.setBorderPainted(false);
        btnCreateProduct1.setColor(new java.awt.Color(251, 106, 0));
        btnCreateProduct1.setColorClick(new java.awt.Color(251, 186, 0));
        btnCreateProduct1.setColorOver(new java.awt.Color(251, 156, 0));
        btnCreateProduct1.setFocusable(false);
        btnCreateProduct1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCreateProduct1.setRadius(40);
        btnCreateProduct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateProduct1ActionPerformed(evt);
            }
        });
        jPanelProduct.add(btnCreateProduct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 96, 40));

        btnSearch.setBackground(new java.awt.Color(251, 106, 0));
        btnSearch.setBorder(null);
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Buscar");
        btnSearch.setBorderColor(new java.awt.Color(251, 106, 0));
        btnSearch.setBorderPainted(false);
        btnSearch.setColor(new java.awt.Color(251, 106, 0));
        btnSearch.setColorClick(new java.awt.Color(251, 186, 0));
        btnSearch.setColorOver(new java.awt.Color(251, 156, 0));
        btnSearch.setFocusable(false);
        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSearch.setRadius(40);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanelProduct.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 96, 40));

        lblTitle11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitle11.setText("Crear Productos");
        jPanelProduct.add(lblTitle11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jTabbedPane2.addTab("tab1", jPanelProduct);

        jPanelCategory.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCategory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle8.setText("ID:");
        jPanelCategory.add(lblTitle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        txtIdC.setEditable(false);
        txtIdC.setBackground(new java.awt.Color(255, 255, 255));
        txtIdC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanelCategory.add(txtIdC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 240, 30));

        txtNameC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanelCategory.add(txtNameC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 240, 30));

        lblTitle9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle9.setText("Nombre:");
        jPanelCategory.add(lblTitle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        btnCreateCategory.setBackground(new java.awt.Color(251, 106, 0));
        btnCreateCategory.setBorder(null);
        btnCreateCategory.setForeground(new java.awt.Color(255, 255, 255));
        btnCreateCategory.setText("Crear");
        btnCreateCategory.setBorderColor(new java.awt.Color(251, 106, 0));
        btnCreateCategory.setBorderPainted(false);
        btnCreateCategory.setColor(new java.awt.Color(251, 106, 0));
        btnCreateCategory.setColorClick(new java.awt.Color(251, 186, 0));
        btnCreateCategory.setColorOver(new java.awt.Color(251, 156, 0));
        btnCreateCategory.setFocusable(false);
        btnCreateCategory.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCreateCategory.setRadius(40);
        btnCreateCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCategoryActionPerformed(evt);
            }
        });
        jPanelCategory.add(btnCreateCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 96, 40));

        lblTitle12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitle12.setText("Crear Categoria");
        jPanelCategory.add(lblTitle12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        tblCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblCategory);

        jPanelCategory.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 840, 250));

        lblTitle7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle7.setText("Buscar Por:");
        jPanelCategory.add(lblTitle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        rdoId1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rdoId1);
        rdoId1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdoId1.setSelected(true);
        rdoId1.setText("Id");
        jPanelCategory.add(rdoId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, -1, -1));

        rdoName1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(rdoName1);
        rdoName1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        rdoName1.setText("Nombre Categoria");
        jPanelCategory.add(rdoName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        txtSearchC.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanelCategory.add(txtSearchC, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 240, 30));

        btnSearch1.setBackground(new java.awt.Color(251, 106, 0));
        btnSearch1.setBorder(null);
        btnSearch1.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch1.setText("Buscar");
        btnSearch1.setBorderColor(new java.awt.Color(251, 106, 0));
        btnSearch1.setBorderPainted(false);
        btnSearch1.setColor(new java.awt.Color(251, 106, 0));
        btnSearch1.setColorClick(new java.awt.Color(251, 186, 0));
        btnSearch1.setColorOver(new java.awt.Color(251, 156, 0));
        btnSearch1.setFocusable(false);
        btnSearch1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSearch1.setRadius(40);
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });
        jPanelCategory.add(btnSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 96, 40));

        btnSearchAll1.setBackground(new java.awt.Color(251, 106, 0));
        btnSearchAll1.setBorder(null);
        btnSearchAll1.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchAll1.setText("Buscar Todo");
        btnSearchAll1.setBorderColor(new java.awt.Color(251, 106, 0));
        btnSearchAll1.setBorderPainted(false);
        btnSearchAll1.setColor(new java.awt.Color(251, 106, 0));
        btnSearchAll1.setColorClick(new java.awt.Color(251, 186, 0));
        btnSearchAll1.setColorOver(new java.awt.Color(251, 156, 0));
        btnSearchAll1.setFocusable(false);
        btnSearchAll1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearchAll1.setRadius(40);
        btnSearchAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAll1ActionPerformed(evt);
            }
        });
        jPanelCategory.add(btnSearchAll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 96, 40));

        lblTitle13.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitle13.setToolTipText("");
        lblTitle13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanelCategory.add(lblTitle13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 840, -1));

        jTabbedPane2.addTab("tab2", jPanelCategory);

        jPanelCentral.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 880, 530));

        jPanelPrincipal.add(jPanelCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 57, 860, 490));

        getContentPane().add(jPanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_btnProductActionPerformed

    private void btnCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryActionPerformed
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_btnCategoryActionPerformed

    private void btnSearchAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAllActionPerformed
        fillTableP(productService.findAllProducts());
    }//GEN-LAST:event_btnSearchAllActionPerformed

    private void btnCreateCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCategoryActionPerformed
        if (emptySpaces(txtNameC.getText().trim())) {
            Messages.showMessageDialog("Hay espacios vacios", "Atención");
            return;
        }

        String name = txtNameC.getText().trim();

        if (categoryService.saveCategory(name)) {
            Messages.showMessageDialog("Se grabó con éxito la categoria", "Atención");
        } else {
            Messages.showMessageDialog("Error al grabar, lo siento mucho", "Atención");
        }
    }//GEN-LAST:event_btnCreateCategoryActionPerformed

    private void btnCreateProduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateProduct1ActionPerformed
        if (emptySpaces(txtNameP.getText().trim())) {
            Messages.showMessageDialog("Hay espacios vacios", "Atención");
            return;
        }

        String name = txtNameP.getText().trim();
        String description = txtDescriptionP.getText().trim();

        if (productService.saveProduct(name, description)) {
            Messages.showMessageDialog("Se grabó con éxito el producto", "Atención");
        } else {
            Messages.showMessageDialog("Error al grabar, lo siento mucho", "Atención");
        }
    }//GEN-LAST:event_btnCreateProduct1ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (emptySpaces(txtSearchP.getText().trim())) {
            Messages.showMessageDialog("Debe ingresar el id/nombre del producto a buscar", "Atención");
            txtSearchP.requestFocus();
            return;
        }

        ArrayList<Product> lista = new ArrayList<>();

        if (rdoId.isSelected()) {
            if (!correctFormatId(this.txtSearchP.getText())) {
                Messages.showMessageDialog("Debe ingresar un dato numerico", "Atención");
                return;
            }
            lista.add(productService.findProductById(Long.parseLong(this.txtSearchP.getText())));
            fillTableP(lista);
        } else {
            lista = (ArrayList) productService.findByName(this.txtSearchP.getText());
            fillTableP(lista);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        if (emptySpaces(txtSearchC.getText().trim())) {
            Messages.showMessageDialog("Debe ingresar el id/nombre de la categoria", "Atención");
            txtSearchC.requestFocus();
            return;
        }

        ArrayList<Category> lista = new ArrayList<>();

        if (rdoId1.isSelected()) {
            if (!correctFormatId(this.txtSearchC.getText())) {
                Messages.showMessageDialog("Debe ingresar un dato numerico", "Atención");
                return;
            }
            lista.add(categoryService.findCategoryById(Long.parseLong(this.txtSearchC.getText())));
            fillTableC(lista);
        } else {
            lista = (ArrayList) categoryService.findCategoryByName(this.txtSearchC.getText());
            fillTableC(lista);
        }
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnSearchAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAll1ActionPerformed
        fillTableC(categoryService.findAllCategory());
    }//GEN-LAST:event_btnSearchAll1ActionPerformed

    private void fillTableP(List<Product> listProducts) {
        if (listIsNull(listProducts)) {
            Messages.showMessageDialog("No hay datos para mostrar", "Atención");
            initializeTableP();
            return;
        }

        initializeTableP();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

        Object rowData[] = new Object[3];//No columnas
        for (int i = 0; i < listProducts.size(); i++) {
            rowData[0] = listProducts.get(i).getProductId();
            rowData[1] = listProducts.get(i).getName();
            rowData[2] = listProducts.get(i).getDescription();

            model.addRow(rowData);
        }
    }

    private void fillTableC(List<Category> listCategory) {
        if (listIsNull(listCategory)) {
            Messages.showMessageDialog("No hay datos para mostrar", "Atención");
            initializeTableC();
            return;
        }

        initializeTableC();
        DefaultTableModel model = (DefaultTableModel) tblCategory.getModel();

        Object rowData[] = new Object[2];//No columnas
        for (int i = 0; i < listCategory.size(); i++) {
            rowData[0] = listCategory.get(i).getCategoryId();
            rowData[1] = listCategory.get(i).getName();

            model.addRow(rowData);
        }
    }

    private void initializeTableP() {
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Nombre", "Descripción"
                }
        ));
    }

    private void initializeTableC() {
        tblCategory.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Nombre"
                }
        ));
    }

    private boolean emptySpaces(String aux) {
        return aux.equals("");
    }

    private boolean correctFormatId(String id) {
        for (int i = 0; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private <T> boolean listIsNull(List<T> list) {
        return list == null || list.size() == 0 || list.get(0) == null;
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private co.edu.unicauca.openmarket.presentation.ui.MyButton btnCategory;
    private co.edu.unicauca.openmarket.presentation.ui.MyButton btnCreateCategory;
    private co.edu.unicauca.openmarket.presentation.ui.MyButton btnCreateProduct1;
    private co.edu.unicauca.openmarket.presentation.ui.MyButton btnProduct;
    private co.edu.unicauca.openmarket.presentation.ui.MyButton btnSearch;
    private co.edu.unicauca.openmarket.presentation.ui.MyButton btnSearch1;
    private co.edu.unicauca.openmarket.presentation.ui.MyButton btnSearchAll;
    private co.edu.unicauca.openmarket.presentation.ui.MyButton btnSearchAll1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel jPanelCategory;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelProduct;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle10;
    private javax.swing.JLabel lblTitle11;
    private javax.swing.JLabel lblTitle12;
    private javax.swing.JLabel lblTitle13;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JLabel lblTitle5;
    private javax.swing.JLabel lblTitle6;
    private javax.swing.JLabel lblTitle7;
    private javax.swing.JLabel lblTitle8;
    private javax.swing.JLabel lblTitle9;
    private javax.swing.JRadioButton rdoId;
    private javax.swing.JRadioButton rdoId1;
    private javax.swing.JRadioButton rdoName;
    private javax.swing.JRadioButton rdoName1;
    private javax.swing.JTable tblCategory;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtDescriptionP;
    private javax.swing.JTextField txtIdC;
    private javax.swing.JTextField txtIdP;
    private javax.swing.JTextField txtNameC;
    private javax.swing.JTextField txtNameP;
    private javax.swing.JTextField txtSearchC;
    private javax.swing.JTextField txtSearchP;
    // End of variables declaration//GEN-END:variables
}
