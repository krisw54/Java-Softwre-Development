package stationery_shop;


public class StationeryShopApplication
{
    public static void main(String[] args)
    {
        Item[] items =
        {
            new Item("Diary", 12.34, 15.45),
            new Item("A4 pad", 2.50, 3.00),
            new Pen("Red ballpoint", 0.10, 0.45, "Red", "Ball"),
            new Pen("Black felt", 0.15, 0.65, "Black", "Felt")
        };

        items[0].addStock(12);
        items[1].addStock(8);
        items[2].addStock(10);
        items[3].addStock(10);

        items[0].sellStock(2);
        items[1].sellStock(12);
        items[2].sellStock(1);
        items[3].sellStock(3);

        printInventory(items);
    }

    public static void printInventory(Item[] items)
    {
        System.out.println("\nAll stock");
        System.out.printf("\t%-15s    %-10s    %10s    %8s    %13s    %11s    %10s\n", "Item", "Cost Price", "Sale price", "In stock", "Number bought", "Number sold", "Profit");
        System.out.printf("\t%-15s    %-10s    %10s    %8s    %13s    %11s    %10s\n", "===============", "==========", "==========", "========", "=============", "===========", "==========");

        for (Item item : items)
        {
            System.out.printf("\t%-15s    %10.2f    %10.2f    %8d    %13s    %11d    %10.2f\n",
                              item.getName(), 
                              item.getCostPrice(), 
                              item.getSellingPrice(), 
                              item.getNumberInStock(), 
                              item.getNumberBought(), 
                              item.getNumberSold(), 
                              item.getProfit());
        }
    }
}