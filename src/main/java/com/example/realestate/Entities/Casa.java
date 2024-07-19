package com.example.realestate.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Casa 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String pais;
    private String ciudad;
    private double precio;
    private String description;
    private String urlImagen;


    public Long getId() 
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }


    public String getPais() 
    {
        return pais;
    }

    public void setPais(String pais) 
    {
        this.pais = pais;
    }


    public String getCiudad() 
    {
        return ciudad;
    }

    public void setCiudad(String ciudad) 
    {
        this.ciudad = ciudad;
    }


    public double getPrecio() 
    {
        return precio;
    }

    public void setPrecio(double precio) 
    {
        this.precio = precio;
    }
    

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getUrlImagen() {
        return urlImagen;
    }
    
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
    

}