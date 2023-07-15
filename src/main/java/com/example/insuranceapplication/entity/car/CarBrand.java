package com.example.insuranceapplication.entity.car;

import com.example.insuranceapplication.entity.Coefficient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "carBrand")
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "carBrandName", length = 30)
    private String carBrandName;

    @Basic(optional = false)
    @Column(name = "coefficient")
    private Double coefficient;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "finished_at")
    private Timestamp finishedAt;

    @OneToMany(mappedBy = "carBrand")
    @JsonIgnore
    private List<Coefficient> coefficients;


//    public CarBrand(Integer id, String carBrandName, Double coefficient, Timestamp createdAt, Timestamp finishedAt, List<Coefficient> coefficients) {
//        this.id = id;
//        this.carBrandName = carBrandName;
//        this.coefficient = coefficient;
//        this.createdAt = createdAt;
//        this.finishedAt = finishedAt;
//        this.coefficients = coefficients;
//    }
//
//    public CarBrand() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getCarBrandName() {
//        return carBrandName;
//    }
//
//    public void setCarBrandName(String carBrandName) {
//        this.carBrandName = carBrandName;
//    }
//
//    public Double getCoefficient() {
//        return coefficient;
//    }
//
//    public void setCoefficient(Double coefficient) {
//        this.coefficient = coefficient;
//    }
//
//    public Timestamp getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Timestamp createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Timestamp getFinishedAt() {
//        return finishedAt;
//    }
//
//    public void setFinishedAt(Timestamp finishedAt) {
//        this.finishedAt = finishedAt;
//    }
//
//    public List<Coefficient> getCoefficients() {
//        return coefficients;
//    }
//
//    public void setCoefficients(List<Coefficient> coefficients) {
//        this.coefficients = coefficients;
//    }
}
