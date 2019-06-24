package com.nnlightctl.request;


import org.hibernate.validator.constraints.NotBlank;

/**
 * 灯杆信息
 */
public class LamppostRequest extends BaseRequest{

    private Long id;

    @NotBlank(message = "灯杆的型号不能为空")
    private String lamppostModel;

    @NotBlank(message = "灯杆的名字不能为空")
    private String lampostName;

    private Double high;


    private Integer lampheadNumber;

    private String longitude;

    private String latitude;

    private String materima;

    private Integer land;

    private  String lampheadColor;

    private String mem;

    @NotBlank(message = "灯杆的设备编码不能为空")
    private String equipmentNumber;

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLamppostModel() {
        return lamppostModel;
    }

    public void setLamppostModel(String lamppostModel) {
        this.lamppostModel = lamppostModel;
    }

    public String getLampostName() {
        return lampostName;
    }

    public void setLampostName(String lampostName) {
        this.lampostName = lampostName;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Integer getLampheadNumber() {
        return lampheadNumber;
    }

    public void setLampheadNumber(Integer lampheadNumber) {
        this.lampheadNumber = lampheadNumber;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getMaterima() {
        return materima;
    }

    public void setMaterima(String materima) {
        this.materima = materima;
    }

    public Integer getLand() {
        return land;
    }

    public void setLand(Integer land) {
        this.land = land;
    }

    public String getLampheadColor() {
        return lampheadColor;
    }

    public void setLampheadColor(String lampheadColor) {
        this.lampheadColor = lampheadColor;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public String getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(String equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }
}
