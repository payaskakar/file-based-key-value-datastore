package assessment.keyvaluestore.model;

import java.io.Serializable;

public class User implements Serializable {
    private String key;
    private String Name;
    private long Salary;

    public User(String key, String name, long salary) {
        this.key = key;
        Name = name;
        Salary = salary;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getSalary() {
        return Salary;
    }

    public void setSalary(long salary) {
        Salary = salary;
    }
}
