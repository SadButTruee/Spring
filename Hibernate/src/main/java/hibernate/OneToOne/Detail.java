package hibernate.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "details")
@NoArgsConstructor
public class Detail {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="city")
    private String city;

    @Column(name="phone_number")
    private String phone_number;

    @Column(name="email")
    private String email;

    @OneToOne(mappedBy = "detail", cascade = CascadeType.ALL)
    private Employee employee;

    public Detail(String city, String phone_number, String email) {
        this.city = city;
        this.phone_number = phone_number;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
