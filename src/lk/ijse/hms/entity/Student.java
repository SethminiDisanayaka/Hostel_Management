package lk.ijse.hms.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Student {
    @Id
    private String id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String address;
    private String contact_no;
    @Column(columnDefinition = "DATE")
    private String dob;
    private String gender;

}
