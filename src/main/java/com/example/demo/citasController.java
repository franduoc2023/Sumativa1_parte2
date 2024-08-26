package com.example.demo;
//mapea solicitudes HTTP GET a un método en un controlador //
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
// Ese import trae controladores y maneja la logica de las solicitudes//
import java.util.ArrayList;
import java.util.HashMap;
//Un arreglo //
import java.util.List;
import java.util.Map;





@RestController
public class citasController {
    private List<citas> citas = new ArrayList<>();
    private Map<String, List<LocalDate>> fechasDisponibles = new HashMap<>();

    public citasController() {
        paciente paciente1 = new paciente(1, "juan carlos pablo plabas", 955554);
        paciente paciente2 = new paciente(2, "ana maria garcia urruita", 94444414);

        citas.add(new citas(1, paciente1, "Cardiologo", LocalDate.of(2024, 8, 25)));
        citas.add(new citas(2, paciente2, "Psiquiatra", LocalDate.of(2024, 8, 26)));

       
        fechasDisponibles.put("Cardiologo", new ArrayList<>(List.of(
                LocalDate.of(2024, 8, 25),
                LocalDate.of(2024, 8, 26),
                LocalDate.of(2024, 8, 27)
        )));
        fechasDisponibles.put("Psiquiatra", new ArrayList<>(List.of(
                LocalDate.of(2024, 8, 26),
                LocalDate.of(2024, 8, 27),
                LocalDate.of(2024, 8, 28)
        )));
    }




@GetMapping("/citas")
public List<citas> getCitas() {
    return citas;
}

@GetMapping("/citas/{id}")
public citas getCitaById(@PathVariable int id) {
    for (citas cita : citas) {
        if (cita.getId() == id) {
            return cita;    }
        }
    return null;}
    @GetMapping("/citas/fechasdisponibles")
    public Map<String, List<LocalDate>> getFechasDisponibles() {
        LocalDate hoy = LocalDate.now();
        Map<String, List<LocalDate>> fechasFuturasPorMedico = new HashMap<>();
        
        fechasDisponibles.forEach((medico, fechas) -> {
            List<LocalDate> fechasFuturas = new ArrayList<>();
            fechas.stream()
                  .filter(fecha -> !fecha.isBefore(hoy))
                  .forEach(fechasFuturas::add);
            fechasFuturasPorMedico.put(medico, fechasFuturas);
        });

        return fechasFuturasPorMedico;
    }}