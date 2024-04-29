// Clase abstracta Shipment
public abstract class Shipment {
    protected double weight;
    protected Dimension dimensions;
    protected boolean fragile;
    protected ServiceType serviceType;

    public Shipment(double weight, Dimension dimensions, boolean fragile, ServiceType serviceType) {
        this.weight = weight;
        this.dimensions = dimensions;
        this.fragile = fragile;
        this.serviceType = serviceType;
    }

    public abstract double calculateCost();

    public double getWeight() {
        return weight;
    }

    public Dimension getDimensions() {
        return dimensions;
    }

    public boolean isFragile() {
        return fragile;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }
}

// Clase Dimension
public class Dimension {
    private int length;
    private int width;
    private int height;

    public Dimension(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

// Enum ServiceType
public enum ServiceType {
    STANDARD,
    URGENT,
    FRAGILE,
    SPECIAL,
}

// Clase StandardShipment
public class StandardShipment extends Shipment {
    public StandardShipment(double weight, Dimension dimensions, boolean fragile) {
        super(weight, dimensions, fragile, ServiceType.STANDARD);
    }

    @Override
    public double calculateCost() {
        // Cálculo del costo del envío estándar
        return weight * 0.5 + dimensions.getLength() * 0.2 + dimensions.getWidth() * 0.2 + dimensions.getHeight() * 0.2;
    }
}

// Clase UrgentDocumentShipment
public class UrgentDocumentShipment extends Shipment {
    public UrgentDocumentShipment(double weight, Dimension dimensions) {
        super(weight, dimensions, false, ServiceType.URGENT);
    }

    @Override
    public double calculateCost() {
        // Cálculo del costo del envío de documentos urgentes
        return weight * 1.0 + dimensions.getLength() * 0.5 + dimensions.getWidth() * 0.5 + dimensions.getHeight() * 0.5;
    }
}

// Clase FragileShipment
public class FragileShipment extends Shipment {
    public FragileShipment(double weight, Dimension dimensions) {
        super(weight, dimensions, true, ServiceType.FRAGILE);
    }

    @Override
    public double calculateCost() {
        // Cálculo del costo del envío de artículos frágiles
        return weight * 1.5 + dimensions.getLength() * 0.5 + dimensions.getWidth() * 0.5 + dimensions.getHeight() * 0.5;
    }
}

// Clase SpecialShipment
public class SpecialShipment extends Shipment {
    public SpecialShipment(double weight, Dimension dimensions) {
        super(weight, dimensions, false, ServiceType.SPECIAL);
    }

    @Override
    public double calculateCost() {
        // Cálculo del costo del envío especial
        return weight * 2.0 + dimensions.getLength() * 1.0 + dimensions.getWidth() * 1.0 + dimensions.getHeight() * 1.0;
    }
}

// Clase ShipmentCalculator
public class ShipmentCalculator {
    public double calculateCost(Shipment shipment) {
        return shipment.calculateCost();
    }
}

// Ejemplo de uso
    public static void main(String[]args) {
        Dimension dimensions = new Dimension(30, 20, 10);
        Shipment shipment = new StandardShipment(2, dimensions, false);
        ShipmentCalculator calculator = new ShipmentCalculator();
        double cost = calculator.calculateCost(shipment);
        System.out.println("Costo del envío: " + cost);
}