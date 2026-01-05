package api.soap.hello;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getHelloStatusResponse", namespace = "http://api/soap/hello")
public class GetHelloStatusResponse {

    private String greetStatus;

    public String getGreetStatus() {
        return greetStatus;
    }

    public void setGreetStatus(String greetStatus) {
        this.greetStatus = greetStatus;
    }
}