package com.example.rep_etiq_sidel.Model;

public class Model {
  String elemento, codigoSap, id, marca,numeroDeParte,cantidad,descripcionBreve,descripcionExtensa,enlaceImagen,nombreTecnico;

  public Model(String elemento, String codigoSap, String id, String marca, String numeroDeParte, String cantidad, String descripcionBreve, String descripcionExtensa, String enlaceImagen, String nombreTecnico) {
    this.elemento = elemento;
    this.codigoSap = codigoSap;
    this.id = id;
    this.marca = marca;
    this.numeroDeParte = numeroDeParte;
    this.cantidad = cantidad;
    this.descripcionBreve = descripcionBreve;
    this.descripcionExtensa = descripcionExtensa;
    this.enlaceImagen = enlaceImagen;
    this.nombreTecnico = nombreTecnico;
  }

  public Model() {

  }

  public String getElemento() {
    return elemento;
  }

  public void setElemento(String elemento) {
    this.elemento = elemento;
  }

  public String getCodigoSap() {
    return codigoSap;
  }

  public void setCodigoSap(String codigoSap) {
    this.codigoSap = codigoSap;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getNumeroDeParte() {
    return numeroDeParte;
  }

  public void setNumeroDeParte(String numeroDeParte) {
    this.numeroDeParte = numeroDeParte;
  }

  public String getCantidad() {
    return cantidad;
  }

  public void setCantidad(String cantidad) {
    this.cantidad = cantidad;
  }

  public String getDescripcionBreve() {
    return descripcionBreve;
  }

  public void setDescripcionBreve(String descripcionBreve) {
    this.descripcionBreve = descripcionBreve;
  }

  public String getDescripcionExtensa() {
    return descripcionExtensa;
  }

  public void setDescripcionExtensa(String descripcionExtensa) {
    this.descripcionExtensa = descripcionExtensa;
  }

  public String getEnlaceImagen() {
    return enlaceImagen;
  }

  public void setEnlaceImagen(String enlaceImagen) {
    this.enlaceImagen = enlaceImagen;
  }

  public String getNombreTecnico() {
    return nombreTecnico;
  }

  public void setNombreTecnico(String nombreTecnico) {
    this.nombreTecnico = nombreTecnico;
  }
}