package com.atlantis.persistance_API;

import javax.persistence.*;

@Entity
@Table(name = "user_device", schema = "metrics_db")
public class User_Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "device_id")
    private int deviceId;

    @Column(name = "user_id")
    private int userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User_Device{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", userId=" + userId +
                '}';
    }
}
