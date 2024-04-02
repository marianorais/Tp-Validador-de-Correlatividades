package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materias = new ArrayList<>();
    }

    public void agregarMaterias(Materia materias) {
        Collections.addAll(this.materias, materias);
    }

    public boolean materiaAprobada(Materia materia) {
        return this.alumno.aproboCorrelativas(materia);
    }

    public boolean aprobada() {
        return this.materias.stream().allMatch(materia -> this.materiaAprobada(materia));
    }
}
