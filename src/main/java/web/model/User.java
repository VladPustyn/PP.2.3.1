package web.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле 'name' не может быть пустым")
    @Size(min = 2, max = 20, message = "Длина имени должна быть от 2 до 20 букв")
    @Column(name = "name")
    private String name;

    @Min(value = 1, message = "Возраст должен быть больше 1")
    @Column (name = "age")
    private int age;

    @NotEmpty(message = "Поле 'phone number' не может быть пустым")
    @Size(min = 11, max = 12, message = "Допустимое количество цифр от 11 до 12 ")
    @Column(name = "phone_number")
    private String phoneNumber;

    public User() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
