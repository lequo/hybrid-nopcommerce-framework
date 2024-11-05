package practies_oop;

public class family_linh {
    String nghe_nghiep = "it";

   public void nghe(){
       String nghe_nghiep;
       nghe_nghiep = "ky su công nghệ thông tin";
       System.out.println(nghe_nghiep);
   }

    public static void main(String[] args) {
        people people = new people();
        people.ten = "Linh";
        System.out.println(people.ten);

        family_linh linh = new family_linh();
        linh.nghe();
    }
}
