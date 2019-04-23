package com.l.marc.proyecto_1.Recicler;


import com.l.marc.proyecto_1.R;

import java.util.Arrays;
import java.util.List;

/**
 * Creado por Hermosa Programación.
 */
public class Courses {
    private static Course[] courses = {
            new Course("Curso Online De Seo Para Principiantes",
                    "Aprende prácticas para optimizar tanto internos como externos de tu sitio " +
                            "web con el fin de recibir mas tráfico desde los motores de búsqueda\n" +
                            "\n" +
                            "Más de 30 clases \n" +
                            "12 horas de contenido", "Carlos Villa",
                    3f, 4340, 22, R.drawable.ic_launcher_background),
            new Course("La ciencia del Marketing Online",
                    "Obtén este curso y aprende paso a paso como crear un negocio que genere" +
                            " ingresos constantes lo más pronto posible.\n" +
                            "\n" +
                            "20 excelentes clases\n" +
                            "\n" +
                            "Plantillas para inexpertos\n", "Elena Maiguel",
                    5f, 220, 24, R.drawable.ic_launcher_background),
            new Course("Publicidad Rápida y Furiosa",
                    "Con este curso obtendrás todos los secretos para generar campañas " +
                            "publicitarias que tus clientes no puedan resistirse.\n" +
                            "\n" +
                            "45 clases didácticas\n" +
                            "\n" +
                            "Desarrolla tu creatividad y asertividad comercial\n", "PricePart",
                    4.4f, 34235, 32, R.drawable.ic_launcher_background),
            new Course("Aumentando el control de mis finanzas",
                    "Curso introductorio sobre finanzas personales. " +
                            "Aprende a gestionar tus recursos financieros a " +
                            "través de una estrategia de planificación sencilla y probada.\n" +
                            "\n" +
                            "¡Más de 13 clases y 20 horas de contenido!\n" +
                            "\n" +
                            "Satisfacción garantizada", "Academia Money",
                    3.4f, 11245, 35, R.drawable.ic_launcher_background),
            new Course("Coaching Extremo",
                    "Aprende a conseguir resultados, alcanzar metas, cooperar " +
                            "con otras personas y a motivar su entorno.\n" +
                            "\n" +
                            "23 clases dividas en 10 horas \n" +
                            "Ejemplo prácticos", "Internaut Perri",
                    4.0f, 122, 45, R.drawable.ic_launcher_background),
            new Course("¿Cómo sacar máximo provecho a las redes sociales?",
                    "Aprende a gestionar y manejar eficazmente las comunidades " +
                            "sociales. Automatiza tareas, crea contenidos " +
                            "interesantes y saca el mejor provecho de las análiticas.\n" +
                            "\n" +
                            "Plantillas descargables para planificación.\n" +
                            "21 Infografías potentes para simplificar tu acción",
                    "Milo Alino", 3.2f, 2503, 34, R.drawable.ic_launcher_background),
    };

    /**
     * Obtiene como lista todos los cursos de prueba
     *
     * @return Lista de cursos
     */
    public static List<Course> getCourses() {
        return Arrays.asList(courses);
    }

    /**
     * Obtiene un curso basado en la posición del array
     *
     * @param position Posición en el array
     * @return Curso seleccioando
     */
    public static Course getCourseByPosition(int position) {
        return courses[position];
    }

}
