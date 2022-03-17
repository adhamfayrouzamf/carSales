/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author AdhamFayrouz
 */
public class carPanel extends javax.swing.JPanel {

    public static int cardCount =0;

    /**
     * Creates new form carPanel
     */
    
    public carPanel() {
        initComponents();
        buyButton.setVisible(false);
        buyerPanel.setVisible(false);
        this.setName(""+cardCount);
        buttonsPanel.setName(""+cardCount);
        cardCount++;
    }
    public carPanel(String manufacture_type, String model_name, String year_manufacture, String price,String colors, String imgfile) {
        initComponents();
        String es[]={manufacture_type,model_name,year_manufacture,price,colors,imgfile};
        setCardData(es);
        buyButton.setVisible(false);
        buyerPanel.setVisible(false);
        this.setName(""+cardCount);
        buttonsPanel.setName(""+cardCount);
        cardCount++;
    }
    
    public void setCardData(String[] es){
        manufLabel.setText(es[0]);
        modelLabel.setText(es[1]);
        yearLabel.setText(es[2]);
        priceLabel.setText(es[3]);
        colorsLabel.setText(es[4]);
    }
    public void setBuyer(String email, int year_purchase){
        buyer.setText(email);
        this.year_purchase.setText(String.valueOf(year_purchase));
    }
    public void setImage(byte[] bytes){
        ImageIcon imgIcon = new ImageIcon(bytes);
        Image image = imgIcon.getImage().getScaledInstance(425,160,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        imgLabel.setIcon(scaledIcon);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imgPanel = new javax.swing.JPanel();
        imgLabel = new javax.swing.JLabel();
        dataPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        manufLabel = new javax.swing.JLabel();
        modelLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        colorsLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buyerPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        year_purchase = new javax.swing.JLabel();
        buyer = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        gridPanel = new javax.swing.JPanel();
        buyButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 102));
        setPreferredSize(new java.awt.Dimension(422, 500));

        imgPanel.setLayout(new java.awt.GridLayout(1, 0));

        imgLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        imgLabel.setForeground(new java.awt.Color(240, 240, 240));
        imgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLabel.setMaximumSize(new java.awt.Dimension(1000, 1000));
        imgLabel.setPreferredSize(new java.awt.Dimension(331, 144));
        imgPanel.add(imgLabel);

        dataPanel.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Manufacture Type :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Model Name :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Year of Manufacture :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Price :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Colors :");

        manufLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manufLabel.setForeground(new java.awt.Color(240, 240, 240));
        manufLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        manufLabel.setText("manufacture");

        modelLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        modelLabel.setForeground(new java.awt.Color(240, 240, 240));
        modelLabel.setText("model");

        yearLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        yearLabel.setForeground(new java.awt.Color(240, 240, 240));
        yearLabel.setText("year");

        priceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(240, 240, 240));
        priceLabel.setText("price");

        colorsLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        colorsLabel.setForeground(new java.awt.Color(240, 240, 240));
        colorsLabel.setText("Colors");

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dataPanelLayout.createSequentialGroup()
                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dataPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(modelLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(dataPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(manufLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))))
                    .addGroup(dataPanelLayout.createSequentialGroup()
                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(colorsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(dataPanelLayout.createSequentialGroup()
                                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceLabel)
                                    .addComponent(yearLabel))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manufLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(colorsLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 100));

        buyerPanel.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Buyer :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Year Of Purchase :");

        year_purchase.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        year_purchase.setForeground(new java.awt.Color(240, 240, 240));
        year_purchase.setText("year");

        buyer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buyer.setForeground(new java.awt.Color(240, 240, 240));
        buyer.setText("email");

        javax.swing.GroupLayout buyerPanelLayout = new javax.swing.GroupLayout(buyerPanel);
        buyerPanel.setLayout(buyerPanelLayout);
        buyerPanelLayout.setHorizontalGroup(
            buyerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buyerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buyerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addGap(28, 28, 28)
                .addGroup(buyerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buyerPanelLayout.createSequentialGroup()
                        .addComponent(year_purchase)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buyer, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addContainerGap())
        );
        buyerPanelLayout.setVerticalGroup(
            buyerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buyerPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(buyerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyer, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buyerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(year_purchase)
                    .addComponent(jLabel11)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buyerPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buyerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        buttonsPanel.setOpaque(false);

        gridPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gridPanel.setOpaque(false);
        gridPanel.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        buyButton.setBackground(new java.awt.Color(153, 0, 51));
        buyButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buyButton.setForeground(new java.awt.Color(240, 240, 240));
        buyButton.setText("Buy Now");
        buyButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buyButton.setHideActionText(true);
        buyButton.setPreferredSize(new java.awt.Dimension(100, 50));
        gridPanel.add(buyButton);

        editButton.setBackground(new java.awt.Color(153, 0, 51));
        editButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(240, 240, 240));
        editButton.setText("Edit");
        editButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        editButton.setPreferredSize(new java.awt.Dimension(100, 50));
        gridPanel.add(editButton);

        deleteButton.setBackground(new java.awt.Color(153, 0, 51));
        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(240, 240, 240));
        deleteButton.setText("Delete");
        deleteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        deleteButton.setPreferredSize(new java.awt.Dimension(100, 50));
        gridPanel.add(deleteButton);

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gridPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addComponent(gridPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonsPanel;
    public javax.swing.JButton buyButton;
    private javax.swing.JLabel buyer;
    public javax.swing.JPanel buyerPanel;
    private javax.swing.JLabel colorsLabel;
    private javax.swing.JPanel dataPanel;
    public javax.swing.JButton deleteButton;
    public javax.swing.JButton editButton;
    private javax.swing.JPanel gridPanel;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JPanel imgPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel manufLabel;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JLabel year_purchase;
    // End of variables declaration//GEN-END:variables
}
