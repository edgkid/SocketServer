/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketserver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
/**
 *
 * @author Edgar
 */
public class ViewServerSocketFrame extends javax.swing.JFrame {
    
    Toolkit t;
    Dimension screenSize;
    
    /**
     * Creates new form ViewServerSocketFrame
     */
    public ViewServerSocketFrame() {
        initComponents();
        
        t = Toolkit.getDefaultToolkit();
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        jPanel.setSize(screenSize.width, screenSize.height);
        
        this.setSize(screenSize.width, screenSize.height);
        this.setLayout(new java.awt.BorderLayout());
        
        this.jButtonClose.setBackground(java.awt.Color.white);
        this.jButtonClose.setBorder(null);
        this.jButtonMinimize.setBackground(java.awt.Color.white);
        this.jButtonMinimize.setBorder(null);
        
        this.jLabelAv.setLocation(screenSize.width - this.jLabelAv.getWidth(), screenSize.height - this.jLabelAv.getHeight());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jButtonClose = new javax.swing.JButton();
        jButtonMinimize = new javax.swing.JButton();
        jLabelAv = new javax.swing.JLabel();
        jLabelTagAv = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel.setBackground(new java.awt.Color(255, 255, 255));

        jButtonClose.setBackground(new java.awt.Color(255, 255, 255));
        jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonClose.png"))); // NOI18N
        jButtonClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCloseMouseClicked(evt);
            }
        });

        jButtonMinimize.setBackground(new java.awt.Color(255, 255, 255));
        jButtonMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buttonMinimize.png"))); // NOI18N
        jButtonMinimize.setActionCommand("jButtonMinimize");
        jButtonMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMinimizeMouseClicked(evt);
            }
        });

        jLabelAv.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabelAv.setText("0");

        jLabelTagAv.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabelTagAv.setText("AV:");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonClose)
                    .addComponent(jButtonMinimize))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(438, Short.MAX_VALUE)
                .addComponent(jLabelTagAv)
                .addGap(18, 18, 18)
                .addComponent(jLabelAv, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonClose)
                .addGap(18, 18, 18)
                .addComponent(jButtonMinimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAv, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTagAv, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCloseMouseClicked
       
        System.exit(0);
        
    }//GEN-LAST:event_jButtonCloseMouseClicked

    private void jButtonMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMinimizeMouseClicked
        
        this.setExtendedState(ICONIFIED);
        
    }//GEN-LAST:event_jButtonMinimizeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewServerSocketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewServerSocketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewServerSocketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewServerSocketFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewServerSocketFrame().setVisible(true);
            }
        });
        
    }

    public JLabel getjLabelAv() {
        return jLabelAv;
    }

    public void setjLabelAv(JLabel jLabelAv) {
        this.jLabelAv = jLabelAv;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonMinimize;
    private javax.swing.JLabel jLabelAv;
    private javax.swing.JLabel jLabelTagAv;
    private static javax.swing.JPanel jPanel;
    // End of variables declaration//GEN-END:variables
}
