package github.mikey;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello, World!");
        Transfer x = new Transfer();
        String result = "";

        result = x.toBinary("3.14");
        System.out.println(result);
        result = x.toOct("3.14");
        System.out.println(result);
        result = x.toHex("3.14");
        System.out.println(result);
        result = x.toOrigin(16, "3.23D70A3D70A3E");
        System.out.println(result);
    }
}
