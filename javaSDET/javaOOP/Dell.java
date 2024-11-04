package javaOOP;

public class Dell implements Computer {

    @Override
    public void cpu() {
        System.out.println("cpu core i9");
    }

    @Override
    public void ssd() {
        System.out.println("256 ssd");
    }

    @Override
    public void ram() {
        System.out.println("125gb");
    }

}
