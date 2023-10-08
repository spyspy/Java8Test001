package javaAdvanced;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class TestObjectForXML {
    private String test111;
    private String test222;
    private String test333;

    public String getTest111() {
        return test111;
    }

    public void setTest111(String test111) {
        this.test111 = test111;
    }

    public String getTest222() {
        return test222;
    }

    public void setTest222(String test222) {
        this.test222 = test222;
    }

    public String getTest333() {
        return test333;
    }

    public void setTest333(String test333) {
        this.test333 = test333;
    }
}