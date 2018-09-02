package com.rg.egen.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class Reading {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(columnDefinition = "VARCHAR(20)")
    private String vin;

    @Column(columnDefinition = "DATETIME(6)")
    private Timestamp timeStamp;

    @Column(columnDefinition = "DECIMAL(10)")
    private double latitude;

    @Column(columnDefinition = "DECIMAL(10)")
    private double longitude;

    @Column(columnDefinition = "DECIMAL(3)")
    private double fuelVolume;

    @Column(columnDefinition = "DECIMAL(3)")
    private double speed;

    @Column(columnDefinition = "INT(5)")
    private int engineHp;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean checkEngineLightOn;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean engineCoolantLow;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean cruiseControlOn;

    @Column(columnDefinition = "INT(5)")
    private int rpm;

    @OneToOne(fetch= FetchType.LAZY)
    private Tires tires;

    public Reading() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", rpm=" + rpm +
                ", tires=" + tires +
                '}';
    }
}
