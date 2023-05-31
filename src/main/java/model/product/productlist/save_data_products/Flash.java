package model.product.productlist.save_data_products;

public class Flash extends SaveData {
    private int usbVersion;

    public Flash(String name, long price, int weight, int dimensions, int capacity, int usbVersion,int availableProducts) {
        super(name, price,  weight, dimensions, capacity,availableProducts);
        this.usbVersion = usbVersion;
    }
    @Override
    public String toString () {
        String string = super.toString()+"\nusb Version : "+usbVersion;
        return string;
    }
}
