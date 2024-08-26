package com.example.demo;
import java.time.LocalDate;


public class citas {
    private int id;
    private paciente paciente;
    private String medico;
    private LocalDate fecha;


    public citas(int id, paciente paciente, String medico, LocalDate fecha) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
    }

    public int getId() 

    { return id; 
    
    }

    public paciente getPaciente() 

    { return paciente; 
    }
    public String getMedico() 
    { return medico;
     }
    public LocalDate getfecha()
     { return fecha;
    
    }
}