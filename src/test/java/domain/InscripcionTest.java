package domain;

import org.junit.Assert;
import org.junit.Test;

public class InscripcionTest {
    @Test
    public void inscripcionMateriaNoCorrelativaAceptada(){
        //El alumno se inscribe a una materia sin correlativa correctamente
        Materia materia = new Materia("Matematica Discreta");
        Alumno alumno = new Alumno(1727760);
        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMaterias(materia);

        Assert.assertTrue(inscripcion.aprobada());
    }
    @Test
    public void inscripcionMateriaCorrelativaAceptada(){
        //El alumno se inscribe a una materia con correlativa correctamente
        Materia discreta = new Materia("Matematica Discreta");
        Materia diseño = new Materia("Diseño de sistemas");
        Alumno alumno = new Alumno(1727760);
        diseño.agregarMateriasCorrelativas(discreta);

        alumno.agregarMateriasAprobadas(discreta);

        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMaterias(diseño);

        Assert.assertTrue(inscripcion.aprobada());
    }
    @Test
    public void inscripcionMateriaCorrelativaRechazada() {
        //El alumno se inscribe a una materia con correlativa y es rechazada
        Alumno alumno = new Alumno(1234567);
        Materia discreta = new Materia("Matematica Discreta");
        Materia diseño = new Materia("Diseño de Sistemas");
        diseño.agregarMateriasCorrelativas(discreta);
        Inscripcion inscripcion = new Inscripcion(alumno);
        inscripcion.agregarMaterias(diseño);

        Assert.assertFalse(inscripcion.aprobada());
    }
}
