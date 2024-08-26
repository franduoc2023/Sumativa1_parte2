package com.example.demo;

public class paciente {
    private int id;
    private String nombreCompleto;
    private int telefono;

    public paciente(int id, String nombreCompleto,int telefono)
    {
        this.id = id ;
        this.nombreCompleto = nombreCompleto;
        this.telefono=telefono;



    }
    


    public int getId()  {
        return id;
    
    }

    public String getnombreCompleto()  {
        return nombreCompleto;
    
    }
    public int gettelefono()  {
        return telefono;
    
    }

}
