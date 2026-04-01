// Classe Hello para gerar objetos ''Hello's'' com método de printar 'Hello World'"

public class Hello {
    public static void main(String[] args) {
        if(args.length < 2) return;

        String lang = args[1];

        if(lang == "pt-br") {
            System.out.println("Olá" + args[0] + "!");
        }
        else {
            System.out.println("Hello " + args[0] + "!");
        }
    }
}
