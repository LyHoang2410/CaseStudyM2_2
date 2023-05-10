package service;

public interface Manager <E>{
    E create();
    E update();
    E delete();
    E getById();
    void displayAll();
}
