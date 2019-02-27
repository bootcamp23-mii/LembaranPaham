/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.RegionController;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Region;
import tools.DBConnection;

/**
 *
 * @author AdhityaWP
 */
public class RegionView extends javax.swing.JInternalFrame {

    List<Region> listdata = new ArrayList<Region>();
    int x = 0;
    DefaultTableModel model = new DefaultTableModel();
    DBConnection connection = new DBConnection();
    RegionController rc = new RegionController(connection.getConnection());

    public RegionView() {
        initComponents();
        TampilData(rc.getAllData());
    }

    private void TampilData(List<Region> listdata) {
        Object[] columnNames = {"No", "Id", "Nama"};
        Object[][] data = new Object[listdata.size()][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = (i + 1);
            data[i][1] = listdata.get(i).getId();
            data[i][2] = listdata.get(i).getName();
        }
        model = new DefaultTableModel(data, columnNames);
        tbRegion.setModel(model);
    }

    private boolean konfirmasi() {
        if (tfId.getText().equals("") || tfNama.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            return false;
        }
        return true;
    }

    private boolean isEmpty() {
        if (rc.getById(tfId.getText()).equals("")) {
            return true;
        }
        return false;
    }

    private void filterhuruf(KeyEvent a) {
        if (Character.isAlphabetic(a.getKeyChar())) {
            a.consume();
            JOptionPane.showMessageDialog(null, "Hanya Bisa Memasukan Karakter Angka");
        }
    }

    private void clearing() {
        tfId.setEnabled(true);
        tfId.setText("");
        btDelete.setEnabled(false);
        tfNama.setText("");
        tfSearch.setText("");
        chbById.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        pnTop = new javax.swing.JPanel();
        lblIdl = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        pnButton = new javax.swing.JPanel();
        btClear = new javax.swing.JButton();
        btInsert = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        pnTableRegion = new javax.swing.JPanel();
        scpTabelRegion = new javax.swing.JScrollPane();
        tbRegion = new javax.swing.JTable();
        pnSearch = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        chbById = new javax.swing.JCheckBox();
        btSearch = new javax.swing.JButton();

        setClosable(true);

        pnTop.setLayout(new java.awt.GridLayout(2, 2, 0, 5));

        lblIdl.setText("Id");
        pnTop.add(lblIdl);
        pnTop.add(tfId);

        lblNama.setText("Nama");
        pnTop.add(lblNama);
        pnTop.add(tfNama);

        btClear.setText("Clear");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        btInsert.setText("Save");
        btInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsertActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnButtonLayout = new javax.swing.GroupLayout(pnButton);
        pnButton.setLayout(pnButtonLayout);
        pnButtonLayout.setHorizontalGroup(
            pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btClear)
                .addGap(18, 18, 18)
                .addComponent(btInsert)
                .addGap(28, 28, 28)
                .addComponent(btDelete)
                .addGap(33, 33, 33))
        );
        pnButtonLayout.setVerticalGroup(
            pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnButtonLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btInsert)
                    .addComponent(btClear)
                    .addComponent(btDelete)))
        );

        tbRegion.setModel(new javax.swing.table.DefaultTableModel(
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
        tbRegion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRegionMouseClicked(evt);
            }
        });
        scpTabelRegion.setViewportView(tbRegion);

        javax.swing.GroupLayout pnTableRegionLayout = new javax.swing.GroupLayout(pnTableRegion);
        pnTableRegion.setLayout(pnTableRegionLayout);
        pnTableRegionLayout.setHorizontalGroup(
            pnTableRegionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTableRegionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scpTabelRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnTableRegionLayout.setVerticalGroup(
            pnTableRegionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTableRegionLayout.createSequentialGroup()
                .addComponent(scpTabelRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        pnSearch.setLayout(new javax.swing.BoxLayout(pnSearch, javax.swing.BoxLayout.LINE_AXIS));

        lblSearch.setText("Search");
        pnSearch.add(lblSearch);
        pnSearch.add(tfSearch);

        chbById.setText("by Id");
        chbById.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbByIdActionPerformed(evt);
            }
        });
        pnSearch.add(chbById);

        btSearch.setText("search");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });
        pnSearch.add(btSearch);

        javax.swing.GroupLayout pnMainLayout = new javax.swing.GroupLayout(pnMain);
        pnMain.setLayout(pnMainLayout);
        pnMainLayout.setHorizontalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addComponent(pnTop, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnTableRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnMainLayout.createSequentialGroup()
                    .addComponent(pnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnMainLayout.setVerticalGroup(
            pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMainLayout.createSequentialGroup()
                .addComponent(pnTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(pnTableRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMainLayout.createSequentialGroup()
                    .addContainerGap(111, Short.MAX_VALUE)
                    .addComponent(pnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(153, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        clearing();
        TampilData(rc.getAllData());
    }//GEN-LAST:event_btClearActionPerformed

    private void btInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsertActionPerformed
        if (konfirmasi()) {
            if (isEmpty()) {
                JOptionPane.showMessageDialog(null, rc.insert(tfId.getText(), tfNama.getText()));
            } else {
                try {
                    int reply = JOptionPane.showConfirmDialog(null,
                            "Anda yakin akan melakukan perubahan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
                    );
                    if (reply == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, rc.update(tfId.getText(), tfNama.getText()));
                        TampilData(rc.getAllData());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            TampilData(rc.getAllData());
        }
    }//GEN-LAST:event_btInsertActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Anda Yakin?", "", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            rc.delete(tfId.getText().toString());
            TampilData(rc.getAllData());
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void tbRegionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRegionMouseClicked
        if (tbRegion.getSelectedColumnCount() == 1) {
            btDelete.setEnabled(true);
            int row = tbRegion.getSelectedRow();
            tfId.setText(tbRegion.getValueAt(row, 1).toString());
            tfNama.setText(tbRegion.getValueAt(row, 2).toString());
            tfId.setEnabled(false);
        }
    }//GEN-LAST:event_tbRegionMouseClicked

    private void chbByIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbByIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbByIdActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        // TODO add your handling code here:
        String key = tfSearch.getText().toString();
        boolean cb = chbById.isSelected();
        if (!cb) {

            TampilData(rc.searchBy(key));
        } else {
            Region tampungan = rc.getById(key);
            tfId.setText(tampungan.getId() + "");
            tfNama.setText(tampungan.getName());
        }
        btDelete.setEnabled(true);
        tfId.setEnabled(false);
    }//GEN-LAST:event_btSearchActionPerformed

    private void idTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idTextFieldKeyTyped
        // TODO add your handling code here:
        filterhuruf(evt);
    }//GEN-LAST:event_idTextFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btInsert;
    private javax.swing.JButton btSearch;
    private javax.swing.JCheckBox chbById;
    private javax.swing.JLabel lblIdl;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JPanel pnButton;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnSearch;
    private javax.swing.JPanel pnTableRegion;
    private javax.swing.JPanel pnTop;
    private javax.swing.JScrollPane scpTabelRegion;
    private javax.swing.JTable tbRegion;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
