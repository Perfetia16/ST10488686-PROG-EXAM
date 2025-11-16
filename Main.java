import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame {

    private JButton LoadProductData;
    private JButton SaveProductData;

   private JTextArea ProductSalesData;

    private JLabel TotalSales;
    private JLabel AverageSales;
    private JLabel OverLimit;
    private JLabel UnderLimit;
    private JLabel Year;

    public Main(){
        setTitle("Product Sales Application");
        setSize(400,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea Area= new JTextArea();
        Area.setEditable(false);
        add(new JScrollPane(Area), BorderLayout.CENTER);

        JPanel button= new JPanel(new FlowLayout());
        LoadProductData=new JButton("Load Product Data");
        button.add(LoadProductData);
        SaveProductData=new JButton("Save Product Data ");
        button.add(SaveProductData);

        add(button, BorderLayout.NORTH);


        JPanel statsPanel = new JPanel(new GridLayout(5, 1));
        TotalSales = new JLabel("Total Sales: ");
        statsPanel.add(TotalSales);
        AverageSales = new JLabel("Average Sales: ");
        statsPanel.add(AverageSales);
        OverLimit = new JLabel("Sales over limit: ");
        statsPanel.add(OverLimit);
        UnderLimit = new JLabel("Sales under limit: ");
        statsPanel.add(UnderLimit);
         Year = new JLabel("Years Processed: 2");
         statsPanel.add(Year);

        add(statsPanel, BorderLayout.SOUTH);


        LoadProductData.addActionListener(e -> loadProductData());
        SaveProductData.addActionListener(e -> saveProductData());
    }


    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();


        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0)); // closes the app
        fileMenu.add(exitItem);


        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");


        loadItem.addActionListener(e -> loadProductData());
        saveItem.addActionListener(e -> saveProductData());
        clearItem.addActionListener(e -> clearData());

        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);


        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);


        setJMenuBar(menuBar);
    }


    private void loadProductData() {
        ProductSalesData.setText("Product Sales Data\n\n");
        ProductSalesData.append("Microphone: 300, 250\n");
        ProductSalesData.append("Speakers: 150, 200\n");
        ProductSalesData.append("Mixing Desk: 700, 600\n");

        TotalSales.setText("Total Sales: 2200");
        AverageSales.setText("Average Sales: 367");
        OverLimit.setText("Sales over limit: 2");
        UnderLimit.setText("Sales under limit: 4");
        Year.setText("Years Processed: 2");
    }


    private void saveProductData() {
        JOptionPane.showMessageDialog(this, "Product data saved successfully!");
    }


    private void clearData() {
        ProductSalesData.setText("");
        TotalSales.setText("Total Sales: ");
        AverageSales.setText("Average Sales: ");
        OverLimit.setText("Sales over limit: ");
        UnderLimit.setText("Sales under limit: ");
        Year.setText("Years Processed: ");
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));}}