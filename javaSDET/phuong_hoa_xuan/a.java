package phuong_hoa_xuan;

public class a {
    // variable
    //co access modifier laf private thif chi duoc dung trong class

    private String caphe;
    //method// function

    //setter la set gia tri
    //con getter la lay gia tri

    public void setCaphe(String caphe){
        this.caphe = caphe;
    }

    public String getCaphe(){
        return caphe;
    }

    //default la cung packet voi cung class moi dung duoc
    String capuchino;

    void setcapuchino(String capuchino){
        this.capuchino = capuchino;
    }

    String getcapuchino(){
        return capuchino;
    }

    //protected
    protected String cherry ="1";

    protected void setCherry(String cherry){
        this.cherry = cherry;
    }

    protected String getcherry(){
        return cherry;
    }


    public static void main(String[] args){
        a A = new a();
        A.caphe = "arabica";
        System.out.println(A.getCaphe());

        A.setcapuchino("capuchino");
        System.out.println(A.getcapuchino());

        A.setCherry("cherry");
        System.out.println(A.getcherry());
    }
}
