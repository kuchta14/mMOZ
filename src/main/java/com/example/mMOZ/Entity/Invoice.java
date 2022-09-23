package com.example.mMOZ.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    private int id;
    private Long order_number;
    @NotBlank
    @Size(max = 80)
    private String firstname;
    @Size(max = 80)
    private String lastname;
    @Size(max = 80)
    private String street;
    @Size(max = 10)
    private String no;
    @Size(max = 80)
    private String town;
    @Pattern(regexp = "^\\d{2}-\\d{3}$", message = "Błędny format kodu pocztowego XX-XXX")
    private String code;
    private int status;
    private String create_data;
    @NIP
    private String nip;
}
