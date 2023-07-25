package com.example.insuranceapplication.repository.carRepository;

import com.example.insuranceapplication.entity.car.CarYearOfIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarYearOfIssueRepository extends JpaRepository<CarYearOfIssue, Integer> {

    /**
     * Finds an CarYearOfIssue entity from database by carFirstRegistr
     * @param carFirstRegistr The Integer carFirstRegistr of the CarYearOfIssue
     * @return CarYearOfIssue entity from database that was found by the carFirstRegistr of the CarYearOfIssue
     */
    CarYearOfIssue getYearOfIssueByCarFirstRegistr(Integer carFirstRegistr);


    /**
     * Finds coefficient from database by specified CarYearOfIssue carFirstRegistr
     * @param carFirstRegistr The Integer carFirstRegistr of the CarYearOfIssue
     * @return The coefficient from database that was found by the carFirstRegistr of the CarYearOfIssue
     */
    @Query(value = "SELECT " +
            " carYearOfIssue.coefficient" +
            " FROM CarYearOfIssue carYearOfIssue" +
            " where carYearOfIssue.carFirstRegistr = :carFirstRegistr ")
    double getCoefficientCarYearOfIssue(@Param("carFirstRegistr") Integer carFirstRegistr);
}
