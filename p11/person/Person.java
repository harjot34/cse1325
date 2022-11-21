package person;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Person {
  protected String name;
  protected String phone;

  public Person(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  public Person(BufferedReader in) throws IOException {
    this.name = in.readLine();
    this.phone = in.readLine();

  }

  public void save(BufferedWriter out) throws IOException {
    out.write(name + '\n');
    out.write(phone + '\n');
  }

  @Override
  public String toString() {
    return getName() + " " + getPhone();
  }

  @Override
  public boolean equals(Object rhs) {
    if (rhs == this)
      return true;
    if (rhs == null)
      return false;
    if (!(rhs instanceof Person))
      return false;
    Person obj = (Person) rhs;
    if (this.getName() == obj.getName() && this.getPhone() == obj.getPhone())
      return Boolean.TRUE;
    else
      return Boolean.FALSE;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((phone == null) ? 0 : phone.hashCode());
    return result;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }
}
