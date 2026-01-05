package api.soap.hello;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getHelloStatusRequest", namespace = "http://api/soap/hello")
public class GetHelloStatusRequest {

    private String greetId;

    public String getGreetId() {
        return greetId;
    }

    public void setGreetId(String greetId) {
        this.greetId = greetId;
    }
}