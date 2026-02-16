package lt.esdc.designpatterns.model;

public interface DessertInterface {
    String getCommand();
    default String getType() { return "unknown"; }
}