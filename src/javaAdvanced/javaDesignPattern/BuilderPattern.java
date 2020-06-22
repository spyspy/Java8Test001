package javaOldAdvanced.javaDesignPattern;

// Builder Pattern

public class BuilderPattern {
    public static void main(String[] args) {
        Product product = Product.getBuilder()
                .setAttr1("A")
                .setAttr2("B")
                .setAttr3("C")
                .setAttr3("CCCC")
                .setAttr4("DDD")
                .setAttr5("EEEEEEEEE")
                .build();

        System.out.println(product);
    }
}
