package javaAdvanced;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;

public class ObjectToXmlTest {
    public static void main(String[] args) {
        TestObjectForXML testVo = new TestObjectForXML();
        testVo.setTest111("Test1111");
        testVo.setTest222("WOWOWO222");
        testVo.setTest333("WOWOWO333");

        try {
            System.out.println("----------------------------");

            JAXBContext jaxbContext = JAXBContext.newInstance(TestObjectForXML.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            QName qName = new QName("javaAdvanced","testObjectForXML");
            JAXBElement<TestObjectForXML> root = new JAXBElement<>(qName, TestObjectForXML.class,testVo);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(root, sw);
            System.out.println("**************************");
            System.out.println(sw.toString());

        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}
