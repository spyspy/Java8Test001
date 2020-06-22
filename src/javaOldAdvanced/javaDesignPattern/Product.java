package javaOldAdvanced.javaDesignPattern;

public class Product {

    private String attr1;
    private String attr2;
    private String attr3;
    private String attr4;
    private String attr5;

    // getters and setters...

    public Product (Builder builder) {
        this.attr1 = builder.attr1;
        this.attr2 = builder.attr2;
        this.attr3 = builder.attr3;
        this.attr4 = builder.attr4;
        this.attr5 = builder.attr5;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private String attr1;
        private String attr2;
        private String attr3;
        private String attr4;
        private String attr5;

        public Builder setAttr1(String attr1) {
            this.attr1 = attr1;
            return this;
        }

        public Builder setAttr2(String attr2) {
            this.attr2 = attr2;
            return this;
        }

        public Builder setAttr3(String attr3) {
            this.attr3 = attr3;
            return this;
        }

        public Builder setAttr4(String attr4) {
            this.attr4 = attr4;
            return this;
        }

        public Builder setAttr5(String attr5) {
            this.attr5 = attr5;
            return this;
        }

        public Product build() {
            System.out.println("build product...");
            return new Product(this);
        }

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                + ":{"
                + "attr1:" + attr1 + ","
                + "attr2:" + attr2 + ","
                + "attr3:" + attr3 + ","
                + "attr4:" + attr4 + ","
                + "attr5:" + attr5
                + "}";
    }
}