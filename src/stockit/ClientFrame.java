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
import org.jfree.chart.axis.*;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Nizar Maan
 */
public class ClientFrame extends javax.swing.JFrame {
    private static String name, username, companyName, accountId, accountType;

    /**
     * Creates new form MainFrame
     */
    public ClientFrame() {
        initComponents();
        setLabels();
        setUpTable();
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        StockInfoTable = new javax.swing.JTable();
        PerformanceBtn = new javax.swing.JButton();
        SelectedStockLabel = new javax.swing.JLabel();
        SelectedStockId = new javax.swing.JLabel();
        ChartContainer = new javax.swing.JPanel();
        TableTitle = new javax.swing.JLabel();
        ViewAccountBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Logout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stock It - ");
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setSize(new java.awt.Dimension(1000, 650));

        StockInfoTable.setAutoCreateRowSorter(true);
        StockInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Symbol", "Name", "Sector", "Quantity", "High", "Low", "Last", "Today's Change", "Currency", "Profit/Loss"
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
        StockInfoTable.setToolTipText("Your Stock Data");
        StockInfoTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        StockInfoTable.setName("Stocks"); // NOI18N
        StockInfoTable.setOpaque(false);
        StockInfoTable.setSelectionBackground(new java.awt.Color(0, 204, 204));
        StockInfoTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        StockInfoTable.getTableHeader().setResizingAllowed(false);
        StockInfoTable.getTableHeader().setReorderingAllowed(false);
        StockInfoTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                StockInfoTableMouseDragged(evt);
            }
        });
        StockInfoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StockInfoTableMouseClicked(evt);
            }
        });
        StockInfoTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                StockInfoTableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                StockInfoTableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(StockInfoTable);
        StockInfoTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        PerformanceBtn.setText("Check Performance");
        PerformanceBtn.setToolTipText("Select a Stock to view its performance");
        PerformanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerformanceBtnActionPerformed(evt);
            }
        });

        SelectedStockLabel.setText("Selected Stock:");

        SelectedStockId.setText("N/A");

        javax.swing.GroupLayout ChartContainerLayout = new javax.swing.GroupLayout(ChartContainer);
        ChartContainer.setLayout(ChartContainerLayout);
        ChartContainerLayout.setHorizontalGroup(
            ChartContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );
        ChartContainerLayout.setVerticalGroup(
            ChartContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        TableTitle.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        TableTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TableTitle.setText("Your Stocks");
        TableTitle.setFocusable(false);
        TableTitle.setMaximumSize(new java.awt.Dimension(598, 512));

        ViewAccountBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stockit/setting.png"))); // NOI18N
        ViewAccountBtn.setToolTipText("view account details");
        ViewAccountBtn.setBorder(null);
        ViewAccountBtn.setBorderPainted(false);
        ViewAccountBtn.setFocusPainted(false);
        ViewAccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewAccountBtnActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        Logout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jMenu1.add(Logout);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Options");

        jMenuItem1.setText("Account");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ViewAccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(454, 454, 454)
                                    .addComponent(TableTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(PerformanceBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(SelectedStockLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SelectedStockId))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(163, 163, 163)
                            .addComponent(ChartContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ViewAccountBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TableTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PerformanceBtn)
                    .addComponent(SelectedStockLabel)
                    .addComponent(SelectedStockId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ChartContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PerformanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerformanceBtnActionPerformed
        // TODO add your handling code here:
        createChart();
    }//GEN-LAST:event_PerformanceBtnActionPerformed

    private void StockInfoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockInfoTableMouseClicked
        setSelectedStock();
    }//GEN-LAST:event_StockInfoTableMouseClicked

    private void StockInfoTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StockInfoTableKeyPressed
        //up arrow (40), down arrow (38), enter-key (10)
        if (evt.getKeyCode() == 40 || evt.getKeyCode() == 38 || evt.getKeyCode() == 10) {
            setSelectedStock();
        }
    }//GEN-LAST:event_StockInfoTableKeyPressed

    private void StockInfoTableMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockInfoTableMouseDragged
        setSelectedStock();
    }//GEN-LAST:event_StockInfoTableMouseDragged

    private void StockInfoTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StockInfoTableKeyReleased
        //up arrow (40), down arrow (38), enter-key (10)
        if (evt.getKeyCode() == 40 || evt.getKeyCode() == 38 || evt.getKeyCode() == 10) {
            setSelectedStock();
        }
    }//GEN-LAST:event_StockInfoTableKeyReleased

    private void ViewAccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewAccountBtnActionPerformed
        ClientAccountInfo.main();
    }//GEN-LAST:event_ViewAccountBtnActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        dispose();
        String[] disposeString = new String[1];
        disposeString[0] = "Finished"; 
        mainScreen.main(disposeString);
    }//GEN-LAST:event_LogoutActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ClientAccountInfo.main();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        username = args[0];
        try {
            DBConnection dbcon = new DBConnection();
            dbcon.establishConnection();
            Statement stmt = dbcon.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT C.Name\n"
                    + "       FROM Client as C, Account as A\n"
                    + "       WHERE C.Client_SSN = A.Client_SSN and\n"
                    + "			A.username = \"" + username + "\"");
            while (rs.next()) {
                name = rs.getString("Name");
            }
            dbcon.con.close();
            //setUpTable();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientFrame().setVisible(true);
            }
        });
    }

    public static String getClientName(){
        return name;
    }
    
    public static String getCompanyName(){
        return companyName;
    }
    
    public static String getAccountId(){
        return accountId;
    }
    
    public static String getAccountType(){
        return accountType;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChartContainer;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JButton PerformanceBtn;
    private javax.swing.JLabel SelectedStockId;
    private javax.swing.JLabel SelectedStockLabel;
    private javax.swing.JTable StockInfoTable;
    private javax.swing.JLabel TableTitle;
    private javax.swing.JButton ViewAccountBtn;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    protected void swapPanel() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
    }

    private void setUpTable() {
        try {
            DBConnection dbcon = new DBConnection();
            dbcon.establishConnection();
            Statement stmt = dbcon.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT stock.stockID, stock.StockName, stock_sector.Sector, stock_daily_performance.Currency, stock_daily_performance.High, stock_daily_performance.Low, stock_daily_performance.Closing_Price, has_positions.Qty, (stock_daily_performance.Opening_Price - stock_daily_performance.Closing_Price) AS Today_Change, ((stock_daily_performance.Opening_Price - stock_daily_performance.Closing_Price) * has_positions.Qty) AS Profit\n"
                    + "FROM stock, stock_sector, stock_daily_performance, has_positions, account, client\n"
                    + "WHERE client.Name = '" + name + "'" + "AND client.Client_SSN = account.Client_SSN AND account.Account_ID = has_positions.Account_ID AND stock_daily_performance.StockID = has_positions.Stock_ID AND stock.StockID = has_positions.Stock_ID AND stock_sector.StockID = has_positions.Stock_ID AND Date IN\n"
                    + "( Select * from \n"
                    + "(\n"
                    + "SELECT max(Date) \n"
                    + "FROM stock_daily_performance, stock\n"
                    + "where stock_daily_performance.StockID=stock.StockID\n"
                    + "group by stock.StockID\n"
                    + "ORDER BY Date\n"
                    + ") temp_table)");
            DefaultTableModel model = (DefaultTableModel) StockInfoTable.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                //System.out.println(rs.getString("stockID") + "\t" + rs.getString("StockName") + "\t" + rs.getString("Sector") + "\t" + rs.getString("Currency") + "\t" + rs.getString("Closing_Price") + "\t" + rs.getString("Qty") + rs.getString("Today_Change"));
                model.addRow(new Object[]{rs.getString("stockID"), rs.getString("StockName"), rs.getString("Sector"), rs.getString("Qty"), rs.getString("High"), rs.getString("Low"), rs.getString("Closing_Price"), rs.getString("Today_Change"), rs.getString("Currency"), rs.getString("Profit")});
            }
            dbcon.con.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private void setSelectedStock() {
        int row = StockInfoTable.getSelectedRow();
        SelectedStockId.setText(getValueAt(row, 0).toString());
    }

    private void createChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int row = StockInfoTable.getSelectedRow();
        if (row != -1) {
            //dataset.setValue(, "", table.getValueAt(0,1).toString());
            String selectedStock = StockInfoTable.getValueAt(row, 0).toString();
            try {
                DBConnection dbcon = new DBConnection();
                dbcon.establishConnection();
                Statement stmt = dbcon.con.createStatement();
                ResultSet rs = stmt.executeQuery("Select stock_daily_performance.Closing_Price, stock_daily_performance.Date\n"
                        + "FROM stock_daily_performance, stock\n"
                        + "WHERE stock_daily_performance.StockID = stock.StockID AND stock.StockID = '" + selectedStock + "'" + "AND Date IN\n"
                        + "( Select * from\n"
                        + "(\n"
                        + "SELECT Date \n"
                        + "FROM stock_daily_performance \n"
                        + "WHERE StockID = stockID \n"
                        + "ORDER BY Date ASC\n"
                        + ") temp_table)\n"
                        + "            ");

                while (rs.next()) {

                    String formattedDate = rs.getString("Date");
                    int closing_price = rs.getInt("Closing_Price");
                    dataset.setValue(closing_price, "value", formattedDate);

                }
                dbcon.con.close();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
            String stockName = StockInfoTable.getValueAt(row, 1).toString();
            JFreeChart chart = ChartFactory.createBarChart3D(stockName + " Stock Performance",
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
            ChartContainer.setLayout(new java.awt.BorderLayout());
            ChartPanel chartPanel = new ChartPanel(chart);
            ChartContainer.removeAll();
            ChartContainer.add(chartPanel, BorderLayout.CENTER);
            ChartContainer.validate();
            ChartContainer.repaint();
        }
    }

    private void setLabels() {
        String traderSSN = " ";
        String traderCompanyId = " ";

        //setting Window title
        if (name != null) {
            setTitle(getTitle() + name);
        }
        
        //setting Account Type label
        try {
            DBConnection dbcon = new DBConnection();
            dbcon.establishConnection();
            Statement stmt = dbcon.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT a.Account_Type\n"
                    + "FROM account as a, client as c\n"
                    + "WHERE a.username = '" + username + "' and\n"
                    + "	  c.Name = '" + name + "'");

            while (rs.next()) {

                accountType = rs.getString("Account_Type");
            }
            
            //set Account ID label
            stmt = dbcon.con.createStatement();
            rs = stmt.executeQuery("SELECT a.Account_ID\n"
                    + "FROM account as a, client as c\n"
                    + "WHERE a.username = '" + username + "' and\n"
                    + "	  c.Name = '" + name + "'");

            while (rs.next()) {

                accountId = rs.getString("Account_ID");
            }
            
            //get SSN of trader handling client's account
            stmt = dbcon.con.createStatement();
            rs = stmt.executeQuery("SELECT a.Trader_SSN\n"
                    + "FROM account as a, client as c\n"
                    + "WHERE a.username = '" + username + "' and\n"
                    + "	  c.Name = '" + name + "'");

            while (rs.next()) {

                traderSSN = (rs.getString("Trader_SSN"));

            }
            
            //get companyId of company that trader handling client's account works for
            stmt = dbcon.con.createStatement();
            rs = stmt.executeQuery("SELECT t.Investment_Company_ID\n"
                    + "FROM trader as t\n"
                    + "WHERE t.Trader_SSN = '" + traderSSN + "'");

            while (rs.next()) {

                traderCompanyId = (rs.getString("Investment_Company_ID"));

            }
            
            //get company name that trader works for
            stmt = dbcon.con.createStatement();
            rs = stmt.executeQuery("SELECT c.name\n"
                    + "FROM investment_company as c\n"
                    + "WHERE c.Id = '" + traderCompanyId + "'");

            while (rs.next()) {

                companyName = rs.getString("name");
            }
            dbcon.con.close();
            
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }      
    }

    private Object getValueAt(int row, int column) {
        return StockInfoTable.getValueAt(row, column);
    }
}
