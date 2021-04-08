package soru;

public interface Exportable {
    void export();
    default void run(){
        System.out.println("run");
    }
}
