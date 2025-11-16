public class ProductSales implements IProductSales{

    private int SalesLimit=500;
    private  String[] product={"Microphone", "Speakers", "Mixing Desk"};
    private int[][]SalesData={{300,150,700}, {250,200,600}};

    @Override
    public String[] getProductSales() {
         return product;
    }

    @Override
    public int[][] getTotalSales() {
        return SalesData;
    }

    @Override
    public int getOverLimitSales() {
        int count = 0;
        for (int[] yearlySales : SalesData) {
            for (int sale : yearlySales) {
                if (sale >= SalesLimit)
                    count++;
            }
        }
        return count;
    }

    @Override
    public int getUnderLimitSales() {
        int count = 0;
        for (int[] yearlySales : SalesData) {
            for (int sale : yearlySales) {
                if (sale < SalesLimit)
                    count++;
            }
        }
        return count;
    }
    @Override
    public int getProductProcessed() {
        return 0;
    }

    @Override
    public double getAverageSales() {
        return 0;
    }

    public int SalesLimit(){
        return SalesLimit;

    }

    public int calculateTotalSales() {
        int total = 0;
        for (int[] yearlySales : SalesData) {
            for (int sale : yearlySales) {
                total += sale;
            }
        }
        return total;
    }

    public double calculateAverageSales() {
        int total = calculateTotalSales();
        int count = SalesData.length * SalesData[0].length;
        return (double) total / count;
    }


    // --- Display product sales as text ---
    public String getSalesReportText() {
        StringBuilder sb = new StringBuilder("Product Sales Data\n\n");

        for (int i = 0; i < product.length; i++) {
            sb.append(product[i]).append(":\t");
            for (int j = 0; j < SalesData[i].length; j++) {
                sb.append(SalesData[i][j]).append("\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
