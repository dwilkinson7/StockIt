/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ahmed
 */
public class Trader extends javax.swing.JFrame {
    private static String username;
    private static String companyName;
    private static String clientAccountID;
    /**
     * Creates new form Trader
     */
    public Trader() {
        initComponents();
        try{
            DefaultListModel demoList = new DefaultListModel();
            DBConnection dbcon = new DBConnection();
            dbcon.establishConnection();
            Statement stmt = dbcon.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT C.Name"
                    + "                       FROM client as C, trader as t, trader_account as tc, account as a"
                    + "                       WHERE C.Client_SSN = a.Client_SSN AND "
                    + "                       tc.Trader_SSN = t.Trader_SSN "
                    + "                       AND a.Trader_SSN = t.Trader_SSN "
                    + "                       AND tc.username = \""+username+"\"");
            while(rs.next()){
                 demoList.addElement(rs.getString("Name"));
                 
            }
            dbcon.con.close();
            listOfClients = new JList(demoList);
            jScrollPane3.setViewportView(listOfClients);
            //setUpTable();
        }catch(Exception ex){
            Logger.getLogger(clientLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private void setSelectedStock(){
        int row = table.getSelectedRow();
        variableStockChange.setText(table.getValueAt(row, 0).toString());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        displayBtn = new javax.swing.JButton();
        allStockBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        transactionBtn = new javax.swing.JButton();
        searchStock = new javax.swing.JLabel();
        transaction = new javax.swing.JLabel();
        trader = new javax.swing.JLabel();
        companyText = new javax.swing.JLabel();
        companyVariable = new javax.swing.JLabel();
        performanceBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listOfClients = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        searchClientBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        selectedStock = new javax.swing.JLabel();
        variableStockChange = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        flieMenuItem = new javax.swing.JMenu();
        logoutItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1050, 873));
        setSize(new java.awt.Dimension(1050, 873));

        jLabel1.setText("Trader:");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );

        displayBtn.setText("Stock Performance");
        displayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBtnActionPerformed(evt);
            }
        });

        allStockBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stockit/rsz_market-icon-3.png"))); // NOI18N
        allStockBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        allStockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allStockBtnActionPerformed(evt);
            }
        });

        transactionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stockit/rsz_4kcf4flghdlgbu3jaet9jtonae_mpyd4w0kbgz5sxue6ry9-iem85hz3mdx1-iufyzxn.png"))); // NOI18N
        transactionBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        transactionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionBtnActionPerformed(evt);
            }
        });

        searchStock.setText("Search Stocks");

        transaction.setText("Transaction");

        trader.setText(username);

        companyText.setText("Company Name:");

        companyVariable.setText(companyName);

        performanceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stockit/rsz_refresh.png"))); // NOI18N
        performanceBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        performanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performanceBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Refresh");

        listOfClients.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(listOfClients);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Symbol", "Name", "Sector", "Quantity", "High", "Low", "Last", "Today Change", "Currency", "Profit/Loss"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tableMouseDragged(evt);
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(2).setResizable(false);
        }

        searchClientBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stockit/rsz_search-icon-512.png"))); // NOI18N
        searchClientBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchClientBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchClientBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("View Client");

        selectedStock.setText("Selected Stock:");

        flieMenuItem.setText("File");

        logoutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        logoutItem.setText("Logout");
        logoutItem.setToolTipText("Click to Logout of Application");
        logoutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutItemActionPerformed(evt);
            }
        });
        flieMenuItem.add(logoutItem);

        jMenuBar1.add(flieMenuItem);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trader, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(480, 480, 480)
                        .addComponent(companyText)
                        .addGap(14, 14, 14)
                        .addComponent(companyVariable, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchClientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(allStockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(searchStock)))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(transaction)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(performanceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel7))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(displayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectedStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(variableStockChange, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(companyText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(companyVariable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchClientBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(allStockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(searchStock))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(transactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(transaction)
                            .addComponent(jLabel7)))
                    .addComponent(performanceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(displayBtn)
                            .addComponent(selectedStock))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(variableStockChange, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void displayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayBtnActionPerformed
        // TODO add your handling code here:
        //panel.removeAll();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int row = table.getSelectedRow();
        if(row != -1){
            //dataset.setValue(, "", table.getValueAt(0,1).toString());
            String selectedStock = table.getValueAt(row,0).toString();
            try{
                DBConnection dbcon = new DBConnection();
                dbcon.establishConnection();
                Statement stmt = dbcon.con.createStatement();
                ResultSet rs = stmt.executeQuery("Select stock_daily_performance.Closing_Price, stock_daily_performance.Date\n" +
                "FROM stock_daily_performance, stock\n" +
                "WHERE stock_daily_performance.StockID = stock.StockID AND stock.StockID = '" + selectedStock + "'" +"AND Date IN\n" +
                "( Select * from\n" +
                "(\n" +
                "SELECT Date \n" +
                "FROM stock_daily_performance \n" +
                "WHERE StockID = stockID \n" +
                "ORDER BY Date ASC\n" +
                ") temp_table)\n" +
                "            ");
                
                while(rs.next()){
                        
                        String formattedDate = rs.getString("Date");
                        int closing_price = rs.getInt("Closing_Price");
                        System.out.println("Closing Price: "+closing_price);
                        System.out.println("Date: "+formattedDate);
                        dataset.setValue(closing_price, "value", formattedDate);
                        
                }
                dbcon.con.close();
            }catch(Exception ex){
                Logger.getLogger(clientLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            String stockName = table.getValueAt(row,1).toString();
            JFreeChart chart = ChartFactory.createBarChart3D(stockName+" Stock Performance", 
                    "Date", 
                    "Value", 
                    dataset, 
                    PlotOrientation.VERTICAL, 
                    false, 
                    false, 
                    false);
            Color c = new Color(240, 240, 240, 0);
            chart.setBackgroundPaint(c);
            CategoryPlot catPlot = chart.getCategoryPlot();
            catPlot.setRangeGridlinePaint(Color.BLACK);
            //set interval of Y-axis ticks (tick every 5 units)
            NumberAxis yAxis = (NumberAxis) catPlot.getRangeAxis();
            yAxis.setTickUnit(new NumberTickUnit(5));
            
            //set y-axis labels as currency types ($)
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            yAxis.setNumberFormatOverride(currency);
            
            //setting number of lines an x-axis label is displayed on
            CategoryAxis categoryAxis = catPlot.getDomainAxis();
            categoryAxis.setMaximumCategoryLabelLines(4);
            panel.setLayout(new java.awt.BorderLayout());
            ChartPanel chartPanel = new ChartPanel(chart);
            panel.removeAll();
            panel.add(chartPanel, BorderLayout.CENTER);        
            panel.validate();
            panel.repaint();
        }
    }//GEN-LAST:event_displayBtnActionPerformed

    private void logoutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutItemActionPerformed
        // TODO add your handling code here:
        dispose();
        String X[] = {"Returning From Trader Main Screen"};
        mainScreen.main(X);
    }//GEN-LAST:event_logoutItemActionPerformed

    private void allStockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allStockBtnActionPerformed
        // TODO add your handling code here:
        System.out.println("Shit is here");
        String[] array = new String[1];
        array[0] = username;
        allStocks.main(array);
    }//GEN-LAST:event_allStockBtnActionPerformed

    private void searchClientBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchClientBtnActionPerformed
        // TODO add your handling code here:
        String selectedClient = listOfClients.getSelectedValue();
        System.out.println(selectedClient);
        try{
            DBConnection dbcon = new DBConnection();
            dbcon.establishConnection();
            Statement stmt = dbcon.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT stock.stockID, stock.StockName, stock_sector.Sector, stock_daily_performance.Currency, stock_daily_performance.High, stock_daily_performance.Low, stock_daily_performance.Closing_Price, has_positions.Qty, (stock_daily_performance.Opening_Price - stock_daily_performance.Closing_Price) AS Today_Change, ((stock_daily_performance.Opening_Price - stock_daily_performance.Closing_Price) * has_positions.Qty) AS Profit\n" +
"FROM stock, stock_sector, stock_daily_performance, has_positions, account, client\n" +
"WHERE client.Name = '" + selectedClient + "'" + "AND client.Client_SSN = account.Client_SSN AND account.Account_ID = has_positions.Account_ID AND stock_daily_performance.StockID = has_positions.Stock_ID AND stock.StockID = has_positions.Stock_ID AND stock_sector.StockID = has_positions.Stock_ID AND Date IN\n" +
"( Select * from \n" +
"(\n" +
"SELECT max(Date) \n" +
"FROM stock_daily_performance, stock\n" +
"where stock_daily_performance.StockID=stock.StockID\n" +
"group by stock.StockID\n" +
"ORDER BY Date\n" +
") temp_table)");
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            while(rs.next()){
                System.out.println(rs.getString("stockID")+ "\t" + rs.getString("StockName")+"\t"+rs.getString("Sector")+"\t"+rs.getString("Currency")+"\t"+rs.getString("Closing_Price")+"\t"+rs.getString("Qty")+rs.getString("Today_Change"));
                model.addRow(new Object[]{rs.getString("stockID"), rs.getString("StockName"), rs.getString("Sector"), rs.getString("Qty"), rs.getString("High"), rs.getString("Low"), rs.getString("Closing_Price"), rs.getString("Today_Change"),rs.getString("Currency"), rs.getString("Profit")});
            }
            dbcon.con.close();
        }catch(Exception ex){
            Logger.getLogger(clientLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchClientBtnActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        setSelectedStock();
    }//GEN-LAST:event_tableMouseClicked

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        // TODO add your handling code here:
        //up arrow (40), down arrow (38), enter-key (10)
        if(evt.getKeyCode() == 40 || evt.getKeyCode() == 38 || evt.getKeyCode() == 10){
            setSelectedStock();
        }
    }//GEN-LAST:event_tableKeyPressed

    private void tableMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseDragged
        // TODO add your handling code here:
        setSelectedStock();
    }//GEN-LAST:event_tableMouseDragged

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        // TODO add your handling code here:
        //up arrow (40), down arrow (38), enter-key (10)
        if(evt.getKeyCode() == 40 || evt.getKeyCode() == 38 || evt.getKeyCode() == 10){
            setSelectedStock();
            //System.out.println("after: " + StockInfoTable.getSelectedRow());
        }
    }//GEN-LAST:event_tableKeyReleased

    private void transactionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionBtnActionPerformed
        // TODO add your handling code here:
        if(listOfClients.isSelectionEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Please Select a Client", "Transaction Error", JOptionPane.ERROR_MESSAGE);
        }else{
            String selectedClient = listOfClients.getSelectedValue();
            String[] array = new String[1];
            array[0] = selectedClient;
            transactionFrame.main(array);
            
        }
    }//GEN-LAST:event_transactionBtnActionPerformed

    private void performanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performanceBtnActionPerformed
        // TODO add your handling code here:
        String[] array = new String[2];
        array[0] = username;
        array[1] = companyName;
        dispose();
        Trader.main(array);
    }//GEN-LAST:event_performanceBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Trader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        username = args[0];
        companyName = args[1];
        System.out.println("Trader main: "+username);
        System.out.println("Trader Company: "+companyName);
        java.awt.EventQueue.invokeLater(() -> {
            new Trader().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allStockBtn;
    private javax.swing.JLabel companyText;
    private javax.swing.JLabel companyVariable;
    private javax.swing.JButton displayBtn;
    private javax.swing.JMenu flieMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> listOfClients;
    private javax.swing.JMenuItem logoutItem;
    private javax.swing.JPanel panel;
    private javax.swing.JButton performanceBtn;
    private javax.swing.JButton searchClientBtn;
    private javax.swing.JLabel searchStock;
    private javax.swing.JLabel selectedStock;
    private javax.swing.JTable table;
    private javax.swing.JLabel trader;
    private javax.swing.JLabel transaction;
    private javax.swing.JButton transactionBtn;
    private javax.swing.JLabel variableStockChange;
    // End of variables declaration//GEN-END:variables
}
