package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private int custId;

    private String custName;

    private String custAddress;

    private long custContactNo;

    private double custAccBal;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date custDOB;

}
