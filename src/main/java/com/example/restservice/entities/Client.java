package com.example.restservice.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.tomcat.util.buf.StringUtils;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
    private static final long serialVersionUID = -8324803160729227553L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome é obrigatório")
    private String name;

    @NotBlank(message = "email é obrigatório")
    @Email
    private String email;

    @NotBlank(message = "CPF é obrigatório")
    @CPF
    private String cpf;

    @NotNull(message = "data de nascimento é obrigatório")
    @JsonFormat(pattern="dd/MM/yyyy", timezone = "UTC")
    private Date birthDate;

    public Client() {}

    public Client(String name, String email, String cpf, Date birthDate)
    {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public String validateClient(Client obj) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Client>> constraintViolations = validator.validate(obj);

        if (constraintViolations.size() > 0) {
            Set<String> violationMessages = new HashSet<String>();

            for (ConstraintViolation<Client> constraintViolation : constraintViolations) {
                violationMessages.add(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
            }

            return StringUtils.join(violationMessages, ',');
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getEmail().equals(client.getEmail()) && getCpf().equals(client.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getCpf());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
