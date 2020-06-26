package com.li.org.entity;


import lombok.*;


@ToString
@EqualsAndHashCode
public class MenuBean {
    private int functionId;//主键
    private String functionCode;//功能代码
    private String functionName;//功能名称
    private String functionType;//功能类型
    private int parentFunctionId;
    private String parentFunctionCode;
    private int moduleId;
    private int descriptionId;
    private String icon;//图标
    private int sequence;//排序
    private int serviceId;//
    private String router;//路由路径

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public int getFunctionId() {
        return functionId;
    }

    public void setFunctionId(int functionId) {
        this.functionId = functionId;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public int getParentFunctionId() {
        return parentFunctionId;
    }

    public void setParentFunctionId(int parentFunctionId) {
        this.parentFunctionId = parentFunctionId;
    }

    public String getParentFunctionCode() {
        return parentFunctionCode;
    }

    public void setParentFunctionCode(String parentFunctionCode) {
        this.parentFunctionCode = parentFunctionCode;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public MenuBean(int functionId, String functionCode, String functionName, String functionType, int parentFunctionId, String parentFunctionCode, int moduleId, int descriptionId, String icon, int sequence, int serviceId, String router) {
        this.functionId = functionId;
        this.functionCode = functionCode;
        this.functionName = functionName;
        this.functionType = functionType;
        this.parentFunctionId = parentFunctionId;
        this.parentFunctionCode = parentFunctionCode;
        this.moduleId = moduleId;
        this.descriptionId = descriptionId;
        this.icon = icon;
        this.sequence = sequence;
        this.serviceId = serviceId;
        this.router = router;
    }

    public MenuBean() {
    }
}
