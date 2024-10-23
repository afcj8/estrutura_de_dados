public class Teste {
    public static void main(String[] argas) {
        ArvoreRN arn = new ArvoreRN(40);
        System.out.println(arn.getRaiz().getElement());
        System.out.println(arn.getRaiz().getCor());
        System.out.println(arn.isRoot(arn.getRaiz()));
        System.out.println(arn.isExternal(arn.getRaiz()));
        System.out.println(arn.isInternal(arn.getRaiz()));
    }
}