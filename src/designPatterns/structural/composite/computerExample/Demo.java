package designPatterns.structural.composite.computerExample;

/**
 * Composite pattern defines class hierarchies consisting of individual objects
 * and composite objects.
 * <p>
 * Assemble a computer consisting a cabinet and peripheral:
 * -> Cabinet contains HDD and motherboard.
 * -> MotherBoard contains CPU and RAM.
 * -> Peripheral consists of monitor and Mouse
 */
public class Demo {
  
  public static void main(String[] args) {
    Component hdd = new Leaf("Hard Drive", 4000);
    Component ram = new Leaf("RAM", 3000);
    Component mouse = new Leaf("Mouse", 500);
    Component monitor = new Leaf("Monitor", 8000);
    Component cpu = new Leaf("CPU", 9000);
    
    Composite peripheral = new Composite("peripheral");
    Composite motherBoard = new Composite("Mother Board");
    Composite cabinet = new Composite("cabinet");
    Composite computer = new Composite("Computer");
    
    peripheral.addComponent(monitor);
    peripheral.addComponent(mouse);
    
    motherBoard.addComponent(ram);
    motherBoard.addComponent(cpu);
    
    cabinet.addComponent(hdd);
    cabinet.addComponent(motherBoard);
    
    computer.addComponent(cabinet);
    computer.addComponent(peripheral);
    
    computer.showPrice();
  }
}
;
