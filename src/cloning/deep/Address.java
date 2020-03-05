package cloning.deep;

import java.util.Objects;

public class Address implements Cloneable {
  private String city;
  private String state;
  private int pinCode;
  
  public Address(String city, String state, int pinCode) {
    this.city = city;
    this.state = state;
    this.pinCode = pinCode;
  }
  
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
  
  public String getCity() {
    return city;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public String getState() {
    return state;
  }
  
  public void setState(String state) {
    this.state = state;
  }
  
  public int getPinCode() {
    return pinCode;
  }
  
  public void setPinCode(int pinCode) {
    this.pinCode = pinCode;
  }
  
  @Override
  public String toString() {
    return "Address{" +
           "city='" + city + '\'' +
           ", state='" + state + '\'' +
           ", pinCode=" + pinCode +
           '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Address)) {
      return false;
    }
    Address address = (Address) o;
    return getPinCode() == address.getPinCode() &&
           Objects.equals(getCity(), address.getCity()) &&
           Objects.equals(getState(), address.getState());
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(getCity(), getState(), getPinCode());
  }
}
