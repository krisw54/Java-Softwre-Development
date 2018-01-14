package stationery_shop;

public class Item
{
    private String name;
    private double costPrice;
    private double sellingPrice;
    private int numberInStock;
    private int numberItemsSold;
    private int numberItemsBought;
    
    public Item(String name, double costPrice, double sellingPrice)
    {
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        numberInStock = 0;
        numberItemsSold = 0;
    }

    public String getName()
    {
        return name;
    }

    public double getCostPrice()
    {
        return costPrice;
    }

    public double getSellingPrice()
    {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice)
    {
        this.sellingPrice = sellingPrice;
    }
    
    public boolean sellStock(int numberOfItems)
    {
        boolean itemsSold = false;
        
        if (numberOfItems <= numberInStock)
        {
            numberInStock -= numberOfItems;
            numberItemsSold += numberOfItems;
            itemsSold = true;
        }
        
        return itemsSold;
    }
    
    public void addStock(int numberOfItems)
    {
        numberInStock += numberOfItems;
        numberItemsBought += numberOfItems;
    }
    
    public int getNumberInStock()
    {
        return numberInStock;
    }
    
    public int getNumberBought()
    {
        return numberItemsBought;
    }
    
    public int getNumberSold()
    {
        return numberItemsSold;
    }
    
    public double getProfit()
    {
        return (numberItemsSold * sellingPrice) - (numberItemsBought * costPrice);
    }
}