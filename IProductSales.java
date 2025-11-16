public interface IProductSales {
    String[] getProductSales();
    int[][] getTotalSales();
    int getOverLimitSales();
    int getUnderLimitSales();
    int getProductProcessed();
    double getAverageSales();
}
