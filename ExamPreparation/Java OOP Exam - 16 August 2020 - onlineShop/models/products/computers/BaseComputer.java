package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class BaseComputer extends BaseProduct implements Computer {

    private List<Component> components;
    private List<Peripheral> peripherals;


    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();

    }

    @Override
    public double getOverallPerformance() {

        double componentOverallPerformance = 0;
        if (!components.isEmpty()) {
            for (Component component : components) {
                componentOverallPerformance += component.getOverallPerformance();
            }
            return (componentOverallPerformance / components.size()) + super.getOverallPerformance();
        } else {
            return super.getOverallPerformance();
        }
//        double componentsPerformance =                                            //second option with stream
//                components.stream()
//                        .mapToDouble(Component::getOverallPerformance)
//                        .average()
//                        .orElse(0);
//
//        return super.getOverallPerformance() + componentsPerformance;
    }


    @Override
    public double getPrice() {
        
        return (super.getPrice() + components.stream().mapToDouble(Component::getPrice).sum()
                + peripherals.stream().mapToDouble(Peripheral::getPrice).sum());
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        for (Component c : components) {
            if (c.equals(component)) {
                throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(),
                        this.getClass().getSimpleName(), this.getId()));
            }
        }
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (components.isEmpty() || components.stream().noneMatch(c -> c.getClass().getSimpleName().equals(componentType))) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType,
                    this.getClass().getSimpleName(), this.getId()));
        }
        int removed = 0;
        for (int i = 0; i < components.size(); i++) {
            Component component = components.get(i);
            if (component.getClass().getSimpleName().equals(componentType)) {
                removed = i;

                break;
            }

        }
        return components.remove(removed);
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        for (Peripheral p : peripherals) {
            if (p.equals(peripheral)) {
                throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(),
                        this.getClass().getSimpleName(), this.getId()));
            }
        }
        peripherals.add(peripheral);

    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (peripherals.isEmpty() || peripherals.stream().noneMatch(c -> c.getClass().getSimpleName().equals(peripheralType))) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType,
                    this.getClass().getSimpleName(), this.getId()));
        }
        int removed = 0;
        for (int i = 0; i < peripherals.size(); i++) {
            Peripheral peripheral = peripherals.get(i);
            if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                removed = i;

                break;
            }

        }
        return peripherals.remove(removed);
    }

    @Override
    public String toString() {

        StringBuilder build = new StringBuilder();

        build.append(String.format(PRODUCT_TO_STRING, getOverallPerformance(), getPrice()
                , this.getClass().getSimpleName(), getManufacturer(), getModel()
                , getId())).append("\n");
        build.append(String.format(COMPUTER_COMPONENTS_TO_STRING, components.size())).append("\n");

        for (Component c : components) {
            build.append("  ").append(c).append("\n");
        }

        double averagePerformance = peripherals.stream()
                .mapToDouble(Peripheral::getOverallPerformance).average().orElse(0);

        build.append(String.format(COMPUTER_PERIPHERALS_TO_STRING, peripherals.size(), averagePerformance)).append("\n");
        for (Peripheral p : peripherals) {
            build.append(p).append("\n");
        }
        return build.toString().trim();
    }
}


