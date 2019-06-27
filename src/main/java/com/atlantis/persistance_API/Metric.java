package com.atlantis.persistance_API;

import javax.persistence.*;

@Entity
@Table(name = "metrics", schema = "metrics_db")
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sensorId")
    private Integer sensorId;

    @Column(name = "data")
    private String data;

    @Column(name = "data_type")
    private String data_type;

    @Column(name = "unit")
    private String unit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "id=" + id +
                ", sensorId='" + sensorId + '\'' +
                ", data=" + data +
                ", data_type='" + data_type + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
