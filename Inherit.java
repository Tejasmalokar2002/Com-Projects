class Bike {
    private String brand;

    public Bike(String brand) {
        this.brand = brand;
    }

    public void PrintBikeBrand(int price) {
        System.out.println(brand + " " + price);
    }
}

class Car extends Bike {
    private String carBrand;

    public Car(String bikeBrand, String carBrand) {
        super(bikeBrand); 
        this.carBrand = carBrand;
    }

    public void printCarBrand(int price) {
        System.out.println(carBrand + " " + price);
    }
}

public class Inherit {
    public static void main(String[] args) {
        Car cr = new Car("TVS", "Hyundai");
        
        cr.PrintBikeBrand(1000);  
        
        cr.printCarBrand(15000);  
    }
}

